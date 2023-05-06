package com.bawarchi.spemajor.Repository;

import com.bawarchi.spemajor.model.Dish;
import com.bawarchi.spemajor.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DishRepository extends JpaRepository<Dish, Integer> {

    List<Dish> findByRestaurant(Restaurant restaurant);

}
