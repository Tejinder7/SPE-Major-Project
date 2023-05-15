package com.bawarchi.spemajor.Contoller;

import com.bawarchi.spemajor.Service.RestaurantAuthService;
import com.bawarchi.spemajor.Service.RestaurantService;
import com.bawarchi.spemajor.Service.SuperAuthService;
import com.bawarchi.spemajor.model.Restaurant;
//import com.bawarchi.spemajor.model.RestaurantAuth;
import com.bawarchi.spemajor.model.SuperAuth;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/rlogin")
public class RestaurantLoginController {

//    private RestaurantAuthService restaurantAuthService;

    private SuperAuthService superAuthService;
    private RestaurantService restaurantService;

//    public RestaurantLoginController(RestaurantAuthService restaurantAuthService, RestaurantService restaurantService){
//        this.restaurantAuthService = restaurantAuthService;
//        this.restaurantService = restaurantService;
//    }

    public RestaurantLoginController(SuperAuthService superAuthService, RestaurantService restaurantService) {
        this.superAuthService = superAuthService;
        this.restaurantService = restaurantService;
    }


//    @PostMapping("/")
//    public ResponseEntity<RestaurantAuth> loginUser(@RequestBody RestaurantAuth restaurantAuthIn){
//       RestaurantAuth restaurantAuthOut = restaurantAuthService.loginCheck(restaurantAuthIn.getUsername(), restaurantAuthIn.getPassword(), restaurantAuthIn.getRole());
//
//        return ResponseEntity.of(Optional.of(restaurantAuthOut));
//    }

    @PostMapping("/")
    public ResponseEntity<SuperAuth> loginUser(@RequestBody SuperAuth superAuth){
        SuperAuth restaurantAuthOut = superAuthService.loginCheck(superAuth.getUsername(), superAuth.getPassword(), superAuth.getRole().toString());

        return ResponseEntity.of(Optional.of(restaurantAuthOut));
    }

    @PostMapping("/addRestaurant")
    public ResponseEntity<Restaurant> addRestaurant(@RequestBody Restaurant restaurantIn){
        Restaurant restaurantOut = restaurantService.addRestaurant(restaurantIn);

        return ResponseEntity.of(Optional.of(restaurantOut));
    }

}
