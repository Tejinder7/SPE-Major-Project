package com.bawarchi.spemajor.Service;

import com.bawarchi.spemajor.Repository.FoodCourtRepository;
import com.bawarchi.spemajor.model.FoodCourt;
import com.bawarchi.spemajor.model.Role;
import org.springframework.stereotype.Service;

@Service
public class FoodCourtService {

    private FoodCourtRepository foodCourtRepository;

    public FoodCourtService(FoodCourtRepository foodCourtRepository){
        this.foodCourtRepository = foodCourtRepository;
    }

    public FoodCourt addFoodCourt(FoodCourt fc) throws RuntimeException {
        FoodCourt foodCourt = new FoodCourt();

        foodCourt.setUsername(fc.getUsername());
        foodCourt.setPassword(fc.getPassword());
        foodCourt.setRole(Role.ROLE_FOOD_COURT);
        foodCourt.setName(fc.getName());
        foodCourt.setAddress(fc.getAddress());

        foodCourt = foodCourtRepository.save(foodCourt);

        return foodCourt;
    }

}
