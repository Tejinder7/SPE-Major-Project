package com.bawarchi.spemajor.Repository;

import com.bawarchi.spemajor.model.FoodCourt;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodCourtRepository extends JpaRepository<FoodCourt, Integer> {
}
