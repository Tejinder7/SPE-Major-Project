package com.bawarchi.spemajor.Repository;

import com.bawarchi.spemajor.model.Ordered;
import com.bawarchi.spemajor.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderedRepository extends JpaRepository<Ordered, Integer> {

    List<Ordered> findByRestaurantAndStatus(Restaurant restaurant, Boolean status);

    Ordered findByOrderId(int orderId);

}
