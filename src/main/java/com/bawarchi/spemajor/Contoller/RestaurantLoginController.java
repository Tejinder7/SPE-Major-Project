package com.bawarchi.spemajor.Contoller;

import com.bawarchi.spemajor.Service.RestaurantAuthService;
import com.bawarchi.spemajor.Service.RestaurantService;
import com.bawarchi.spemajor.model.Restaurant;
import com.bawarchi.spemajor.model.RestaurantAuth;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/rlogin")
public class RestaurantLoginController {

    private RestaurantAuthService restaurantAuthService;

    private RestaurantService restaurantService;

    public RestaurantLoginController(RestaurantAuthService restaurantAuthService, RestaurantService restaurantService){
        this.restaurantAuthService = restaurantAuthService;
        this.restaurantService = restaurantService;
    }

    @PostMapping("/")
    public ResponseEntity<RestaurantAuth> loginUser(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("role") String role){
       RestaurantAuth restaurantAuth = restaurantAuthService.loginCheck(username, password, role);

        return ResponseEntity.of(Optional.of(restaurantAuth));
    }

    @PostMapping("/addRestaurant")
    public ResponseEntity<Restaurant> addRestaurant(@RequestBody Restaurant restaurantIn){
        Restaurant restaurantOut = restaurantService.addRestaurant(restaurantIn);

        return ResponseEntity.of(Optional.of(restaurantOut));
    }

}
