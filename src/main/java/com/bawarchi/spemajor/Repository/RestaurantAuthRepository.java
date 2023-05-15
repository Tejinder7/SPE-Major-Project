package com.bawarchi.spemajor.Repository;

//import com.bawarchi.spemajor.model.RestaurantAuth;
import com.bawarchi.spemajor.model.SuperAuth;
import org.springframework.data.jpa.repository.JpaRepository;

//public interface RestaurantAuthRepository extends JpaRepository<RestaurantAuth, Integer> {
//
//    RestaurantAuth findByUsername(String username);
//
//}

public interface RestaurantAuthRepository extends JpaRepository<SuperAuth, Integer> {

    SuperAuth findByUsername(String username);

}