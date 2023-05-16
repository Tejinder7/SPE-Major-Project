package com.bawarchi.spemajor.Contoller;

import com.bawarchi.spemajor.Service.AllOrdersService;
import com.bawarchi.spemajor.model.AllOrders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    private AllOrdersService allOrdersService;

    public CustomerController(AllOrdersService allOrdersService) {
        this.allOrdersService = allOrdersService;
    }

    @PostMapping("/placeOrder/{userId}/{tableNumber}/{restaurantId}")
    public ResponseEntity<AllOrders> placeOrder(@RequestBody AllOrders order, @PathVariable int userId, @PathVariable int tableNumber, @PathVariable int restaurantId){
        AllOrders savedOrder;

        try{
            savedOrder = allOrdersService.addOrder(order, userId, tableNumber, restaurantId);
        }catch(RuntimeException exception){
            throw exception;
        }

        return ResponseEntity.of(Optional.of(savedOrder));

    }
}
