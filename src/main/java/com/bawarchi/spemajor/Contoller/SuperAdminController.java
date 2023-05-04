package com.bawarchi.spemajor.Contoller;

import com.bawarchi.spemajor.Service.FoodCourtService;
import com.bawarchi.spemajor.model.FoodCourt;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/superAdmin")
public class SuperAdminController {

    private FoodCourtService foodCourtService;

    public SuperAdminController(FoodCourtService foodCourtService){
        this.foodCourtService = foodCourtService;
    }

    @PostMapping("/addFoodCourt")
    public ResponseEntity<FoodCourt> addFoodCourt(@RequestBody FoodCourt foodCourtIn){
        FoodCourt foodCourtOut = foodCourtService.addFoodCourt(foodCourtIn);

        return ResponseEntity.of(Optional.of(foodCourtOut));
    }

}
