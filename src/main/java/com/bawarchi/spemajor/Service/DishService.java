package com.bawarchi.spemajor.Service;

import com.bawarchi.spemajor.Exception.ResourceNotFoundException;
import com.bawarchi.spemajor.Repository.DishRepository;
import com.bawarchi.spemajor.Repository.RestaurantRepository;
import com.bawarchi.spemajor.model.Dish;
import com.bawarchi.spemajor.model.FoodCourt;
import com.bawarchi.spemajor.model.Restaurant;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DishService {

    private DishRepository dishRepository;

    private RestaurantRepository restaurantRepository;

    public DishService(DishRepository dishRepository, RestaurantRepository restaurantRepository){
        this.dishRepository = dishRepository;
        this.restaurantRepository = restaurantRepository;
    }


    public List<Dish> fetchDishes(int restaurantId) throws RuntimeException{
        Optional<Restaurant> restaurant = restaurantRepository.findById(restaurantId);

        if(restaurant.isEmpty()){
            throw new ResourceNotFoundException("Restaurant not found");
        }
        List<Dish> dishList = dishRepository.findByRestaurant(restaurant.get());
        return dishList;
    }

    public Dish addDish(int restaurantId, Dish dish) throws RuntimeException{
        Optional<Restaurant> restaurant = restaurantRepository.findById(restaurantId);

        if(restaurant.isEmpty()){
            throw new ResourceNotFoundException("Restaurant not found");
        }

        dish.setRestaurant(restaurant.get());
        Dish savedDish;

        savedDish= dishRepository.save(dish);

        return savedDish;
    }
    public void deleteDishById(int dishId) throws RuntimeException{
        Optional<Dish> dishToUpdate = dishRepository.findById(dishId);

        if(dishToUpdate.isEmpty()){
            throw new ResourceNotFoundException("Dish not found");
        }

        dishRepository.deleteById(dishId);
    }
    public Dish updateDishById(Dish dish, int dishId){
        Optional<Dish> dishToUpdate = dishRepository.findById(dishId);

        if(dishToUpdate.isEmpty()){
            throw new ResourceNotFoundException("Dish not found");
        }

        dishToUpdate.get().setName(dish.getName());
        dishToUpdate.get().setPrice(dish.getPrice());
        dishToUpdate.get().setCategory(dish.getCategory());

        return dishRepository.save(dishToUpdate.get());
    }
}
