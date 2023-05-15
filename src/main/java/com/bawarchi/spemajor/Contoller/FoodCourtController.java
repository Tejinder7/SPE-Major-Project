package com.bawarchi.spemajor.Contoller;

import com.bawarchi.spemajor.Service.RestaurantService;
import com.bawarchi.spemajor.model.FoodCourt;
import com.bawarchi.spemajor.model.Restaurant;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/foodCourt")
public class FoodCourtController {
    RestaurantService restaurantService;

    public FoodCourtController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @PostMapping("/addRestaurant/{foodCourtId}")
    public ResponseEntity<Restaurant> addRestaurant(@RequestBody Restaurant restaurant, @PathVariable int foodCourtId){
        Restaurant savedRestaurant;
        try{
            savedRestaurant= restaurantService.addRestaurant(restaurant, foodCourtId);
        }catch (RuntimeException exception){
            throw exception;
        }

        return ResponseEntity.of(Optional.of(savedRestaurant));
    }
    @GetMapping("/allRestaurants/{foodCourtId}")
    public ResponseEntity<List<Restaurant>> fetchRestaurants(@PathVariable int foodCourtId){
        List<Restaurant> restaurantList = restaurantService.fetchRestaurants(foodCourtId);

        return ResponseEntity.of(Optional.of(restaurantList));
    }

    @DeleteMapping("/deleteRestaurant/{restaurantId}")
    public void deleteRestaurantById(@PathVariable int restaurantId){
        try{
            restaurantService.deleteRestaurantById(restaurantId);
        }catch (RuntimeException exception){
            throw exception;
        }
    }
    @PutMapping("/updateRestaurant/{restaurantId}")
    public ResponseEntity<Restaurant> updateRestaurantById(@PathVariable int restaurantId, @RequestBody Restaurant restaurant){
        Restaurant updatedRestaurant;
        try{
            updatedRestaurant= restaurantService.updateRestaurant(restaurant, restaurantId);
        }
        catch(RuntimeException exception){
            throw exception;
        }
        return ResponseEntity.of(Optional.of(updatedRestaurant));
    }
}
