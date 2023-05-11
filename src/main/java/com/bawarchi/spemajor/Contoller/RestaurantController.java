package com.bawarchi.spemajor.Contoller;

import com.bawarchi.spemajor.Service.DishService;
import com.bawarchi.spemajor.Service.OrderedService;
import com.bawarchi.spemajor.model.Dish;
import com.bawarchi.spemajor.model.Ordered;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    private DishService dishService;
    private OrderedService orderedService;


    public RestaurantController(DishService dishService, OrderedService orderedService){
        this.dishService = dishService;
        this.orderedService = orderedService;
    }

    @GetMapping("/{restaurant_id}/fetchDishes")
    public ResponseEntity<List<Dish>> fetchDishes(@PathVariable int restaurant_id){
        List<Dish> dishList = dishService.fetchDishes(restaurant_id);

        return ResponseEntity.of(Optional.of(dishList));
    }


    @PostMapping("/{restaurant_id}/addDish")
    public ResponseEntity<Dish> addDish(@PathVariable int restaurant_id, @RequestBody Dish dishIn){
        Dish dishOut = dishService.addDish(restaurant_id, dishIn);

        return ResponseEntity.of(Optional.of(dishOut));
    }

    @GetMapping("/{restaurant_id}/fetchPendingOrders")
    public ResponseEntity<List<Ordered>> fetchPendingOrders(@PathVariable int restaurant_id){
        List<Ordered> orderList = orderedService.fetchPendingOrders(restaurant_id);

        return ResponseEntity.of(Optional.of(orderList));
    }

}
