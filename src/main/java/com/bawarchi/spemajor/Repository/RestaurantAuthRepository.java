package com.bawarchi.spemajor.Repository;

import com.bawarchi.spemajor.model.RestaurantAuth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantAuthRepository extends JpaRepository<RestaurantAuth, Integer> {

    RestaurantAuth findByUsername(String username);

}
