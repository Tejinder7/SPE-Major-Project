package com.bawarchi.spemajor.Service;

import com.bawarchi.spemajor.Repository.OrderedRepository;
import com.bawarchi.spemajor.Repository.RestaurantRepository;
import com.bawarchi.spemajor.model.Ordered;
import com.bawarchi.spemajor.model.Restaurant;
import jakarta.persistence.criteria.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderedService {

    private OrderedRepository orderedRepository;
    private RestaurantRepository restaurantRepository;

    public OrderedService(OrderedRepository orderedRepository, RestaurantRepository restaurantRepository){
        this.orderedRepository = orderedRepository;
        this.restaurantRepository = restaurantRepository;
    }


    public List<Ordered> fetchOrders(int restaurant_id) throws RuntimeException{
        Restaurant restaurant = restaurantRepository.findByRestaurantAuthId(restaurant_id);

        if(restaurant==null){
            System.out.println("Restaurant not found");
        }

        List<Ordered> orderList = orderedRepository.findByRestaurant(restaurant);

        return orderList;
    }

}
