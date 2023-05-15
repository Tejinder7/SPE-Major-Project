package com.bawarchi.spemajor.Repository;

import com.bawarchi.spemajor.model.AllOrders;
import com.bawarchi.spemajor.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AllOrdersRepository extends JpaRepository<AllOrders, Integer> {

    List<AllOrders> findByRestaurantAndStatus(Restaurant restaurant, Boolean status);

    AllOrders findByOrderId(int orderId);

}
