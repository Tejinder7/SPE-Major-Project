package com.bawarchi.spemajor.Contoller;

import com.bawarchi.spemajor.Service.DishService;
import com.bawarchi.spemajor.Service.AllOrdersService;
import com.bawarchi.spemajor.model.Dish;
import com.bawarchi.spemajor.model.AllOrders;
import com.bawarchi.spemajor.model.Restaurant;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    private DishService dishService;
    private AllOrdersService allOrdersService;


    public RestaurantController(DishService dishService, AllOrdersService allOrdersService){
        this.dishService = dishService;
        this.allOrdersService = allOrdersService;
    }

    @PostMapping("/{restaurantId}/addDish")
    public ResponseEntity<Dish> addDish(@RequestBody Dish dish, @PathVariable int restaurantId){
        Dish savedDish;
        try{
            savedDish = dishService.addDish(restaurantId, dish);
        }catch(RuntimeException exception){
            throw exception;
        }
        return ResponseEntity.of(Optional.of(savedDish));
    }
    @GetMapping("/{restaurantId}/fetchDishes")
    public ResponseEntity<List<Dish>> fetchDishes(@PathVariable int restaurantId){
        List<Dish> dishList = dishService.fetchDishes(restaurantId);

        return ResponseEntity.of(Optional.of(dishList));
    }

    @PutMapping("/updateDish/{dishId}")
    public ResponseEntity<Dish> updateDish(@RequestBody Dish dish, @PathVariable int dishId){
        Dish updatedDish;
        try{
            updatedDish= dishService.updateDishById(dish, dishId);
        }
        catch(RuntimeException exception){
            throw exception;
        }
        return ResponseEntity.of(Optional.of(updatedDish));
    }

    @DeleteMapping("/deleteDish/{dishId}")
    public void deleteDish(@PathVariable int dishId){
        try{
            dishService.deleteDishById(dishId);
        }catch (RuntimeException exception){
            throw exception;
        }
    }
    @GetMapping("/{restaurant_id}/fetchPendingOrders")
    public ResponseEntity<List<AllOrders>> fetchPendingOrders(@PathVariable int restaurant_id){
        List<AllOrders> orderList = allOrdersService.fetchPendingOrders(restaurant_id);

        return ResponseEntity.of(Optional.of(orderList));
    }

    @PutMapping("/markOrderComplete/{order_id}")
    public ResponseEntity<AllOrders> updateOrderStatus(@PathVariable int order_id){
        AllOrders allOrdersOut = allOrdersService.updateOrderStatus(order_id);

        return ResponseEntity.of(Optional.of(allOrdersOut));

    }

}