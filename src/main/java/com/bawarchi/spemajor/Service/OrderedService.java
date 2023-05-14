package com.bawarchi.spemajor.Service;

import com.bawarchi.spemajor.Repository.OrderedRepository;
import com.bawarchi.spemajor.Repository.RestaurantRepository;
import com.bawarchi.spemajor.model.AllOrders;
import com.bawarchi.spemajor.model.Restaurant;
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


    public List<AllOrders> fetchPendingOrders(int restaurant_id) throws RuntimeException{
        Restaurant restaurant = restaurantRepository.findByRestaurantAuthId(restaurant_id);

        if(restaurant==null){
            System.out.println("Restaurant not found");
        }

        List<AllOrders> orderList = orderedRepository.findByRestaurantAndStatus(restaurant, false);

        return orderList;
    }

    public AllOrders updateOrderStatus(int orderId) throws RuntimeException{
        AllOrders order = orderedRepository.findByOrderId(orderId);

        if(order==null){
            System.out.println("Order not found");
        }

        order.setStatus(true);

        order = orderedRepository.save(order);

        return order;
    }
}
