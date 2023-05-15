package com.bawarchi.spemajor.Service;

import com.bawarchi.spemajor.Repository.RestaurantAuthRepository;
//import com.bawarchi.spemajor.model.RestaurantAuth;
import com.bawarchi.spemajor.model.SuperAuth;
import org.springframework.stereotype.Service;

@Service
public class RestaurantAuthService {

    private RestaurantAuthRepository restaurantAuthRepository;

    public RestaurantAuthService(RestaurantAuthRepository restaurantAuthRepository){
        this.restaurantAuthRepository = restaurantAuthRepository;
    }

//    public RestaurantAuth loginCheck(String username, String password, String role) throws RuntimeException{
//        RestaurantAuth restaurantAuth = restaurantAuthRepository.findByUsername(username);
//
//        if(restaurantAuth.getRole().equals(role) && restaurantAuth.getPassword().equals(password)){
//            return restaurantAuth;
//        }else {
//            System.out.println("Restaurant Login Failed");
//            throw new RuntimeException();
//        }
//    }

    public SuperAuth loginCheck(String username, String password, String role) throws RuntimeException{
        SuperAuth superAuth = restaurantAuthRepository.findByUsername(username);

        if(superAuth.getRole().equals(role) && superAuth.getPassword().equals(password)){
            return superAuth;
        }else {
            System.out.println("Restaurant Login Failed");
            throw new RuntimeException();
        }
    }

}
