package com.bawarchi.spemajor.Service;

import com.bawarchi.spemajor.Exception.ResourceNotFoundException;
import com.bawarchi.spemajor.Repository.FoodCourtRepository;
import com.bawarchi.spemajor.model.FoodCourt;
import com.bawarchi.spemajor.model.Role;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodCourtService {

    private FoodCourtRepository foodCourtRepository;

    private SuperAuthService superAuthService;
    private PasswordEncoder passwordEncoder;

    public FoodCourtService(FoodCourtRepository foodCourtRepository, SuperAuthService superAuthService, PasswordEncoder passwordEncoder) {
        this.foodCourtRepository = foodCourtRepository;
        this.superAuthService = superAuthService;
        this.passwordEncoder = passwordEncoder;
    }

    public FoodCourt addFoodCourt(FoodCourt foodCourt) throws RuntimeException {
        superAuthService.checkIfUserIdExists(foodCourt.getUsername());

        foodCourt.setRole(Role.ROLE_FOOD_COURT);
        foodCourt.setPassword(passwordEncoder.encode(foodCourt.getPassword()));
        return foodCourtRepository.save(foodCourt);
    }

    public List<FoodCourt> fetchFoodCourts() throws RuntimeException{
        List<FoodCourt> foodCourtList = foodCourtRepository.findAll();

        return foodCourtList;
    }

    public void deleteFoodCourtById(int foodCourtId) throws RuntimeException{
        foodCourtRepository.deleteById(foodCourtId);
    }
    public FoodCourt updateFoodCourt(FoodCourt foodCourt, int foodCourtId){
        Optional<FoodCourt> foodCourtToUpdate = foodCourtRepository.findById(foodCourtId);

        if(foodCourtToUpdate.isEmpty()){
            throw new ResourceNotFoundException("No Food Court for the given id " + foodCourtId+ " found");
        }

        foodCourtToUpdate.get().setName(foodCourt.getName());
        foodCourtToUpdate.get().setAddress(foodCourt.getAddress());

        return foodCourtRepository.save(foodCourtToUpdate.get());
    }

}
