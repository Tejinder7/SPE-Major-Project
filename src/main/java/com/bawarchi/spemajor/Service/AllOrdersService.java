package com.bawarchi.spemajor.Service;

import com.bawarchi.spemajor.Exception.ResourceNotFoundException;
import com.bawarchi.spemajor.Repository.AllOrdersRepository;
import com.bawarchi.spemajor.Repository.RestaurantRepository;
import com.bawarchi.spemajor.model.AllOrders;
import com.bawarchi.spemajor.model.Dish;
import com.bawarchi.spemajor.model.Restaurant;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class AllOrdersService {

    private AllOrdersRepository allOrdersRepository;
    private RestaurantRepository restaurantRepository;

    public AllOrdersService(AllOrdersRepository allOrdersRepository, RestaurantRepository restaurantRepository){
        this.allOrdersRepository = allOrdersRepository;
        this.restaurantRepository = restaurantRepository;
    }


    public List<AllOrders> fetchPendingOrders(int restaurantId) throws RuntimeException{
        Optional<Restaurant> restaurant = restaurantRepository.findById(restaurantId);

        if(restaurant.isEmpty()){
            throw new ResourceNotFoundException("Restaurant not found");
        }

        List<AllOrders> orderList = allOrdersRepository.findByRestaurantAndStatus(restaurant.get(), false);
        return orderList;
    }

    public AllOrders updateOrderStatus(int orderId) throws RuntimeException{
        Optional<AllOrders> order = allOrdersRepository.findById(orderId);

        if(order.isEmpty()){
            throw new ResourceNotFoundException("Order not found");
        }

        order.get().setStatus(true);

        return allOrdersRepository.save(order.get());
    }

    public AllOrders addOrder(AllOrders order, int userId, int tableNumber, int restaurantId){
        Optional<Restaurant> restaurant= restaurantRepository.findById(restaurantId);

        if(restaurant.isEmpty()){
            throw new ResourceNotFoundException("Restaurant not found");
        }

        order.setRestaurant(restaurant.get());
        order.setUserId(userId);
        order.setTableNumber(tableNumber);

        int totalPrice = 0;

        List<Dish> dishList = order.getDishList();

        for(int i=0; i<dishList.size(); i++){
            totalPrice+= dishList.get(i).getPrice();
        }

        order.setTotalPrice(totalPrice);
        order.setTimestamp(LocalDate.now().toString());

        return allOrdersRepository.save(order);
    }

    public List<AllOrders> fetchActiveOrder(int userId){
        List<AllOrders> activeOrder= allOrdersRepository.findByUserIdAndAndStatus(userId, false);

        return activeOrder;
    }
}
