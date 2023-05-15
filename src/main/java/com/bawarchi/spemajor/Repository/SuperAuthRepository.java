package com.bawarchi.spemajor.Repository;

import com.bawarchi.spemajor.model.SuperAuth;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SuperAuthRepository extends JpaRepository<SuperAuth, Integer> {

//    SuperAuth findByUsername(String username);

    Optional<SuperAuth> findByUsername(String username);

}
