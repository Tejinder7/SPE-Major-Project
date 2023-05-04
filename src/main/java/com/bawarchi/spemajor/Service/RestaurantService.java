package com.bawarchi.spemajor.Service;

import com.bawarchi.spemajor.Repository.RestaurantRepository;
import com.bawarchi.spemajor.model.Restaurant;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class RestaurantService {

    private RestaurantRepository restaurantRepository;

    public RestaurantService(RestaurantRepository restaurantRepository){
        this.restaurantRepository = restaurantRepository;
    }

    public Restaurant addRestaurant(Restaurant restaurantIn) throws RuntimeException{
        Restaurant restaurantOut = new Restaurant();

        restaurantOut.setUsername(restaurantIn.getUsername());
        restaurantOut.setPassword(restaurantIn.getPassword());
        restaurantOut.setRole("ROLE_RESTAURANT");
        restaurantOut.setName(restaurantIn.getName());
        restaurantOut.setContact(restaurantIn.getContact());
        restaurantOut.setFoodCourtId(restaurantIn.getFoodCourtId());

        restaurantOut = restaurantRepository.save(restaurantOut);

        return restaurantOut;
    }

}
