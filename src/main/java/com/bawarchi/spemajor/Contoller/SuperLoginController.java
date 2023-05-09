package com.bawarchi.spemajor.Contoller;

import com.bawarchi.spemajor.Service.SuperAdminService;
import com.bawarchi.spemajor.Service.SuperAuthService;
import com.bawarchi.spemajor.model.SuperAdmin;
import com.bawarchi.spemajor.model.SuperAuth;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/slogin")
@CrossOrigin("http://localhost:3000/")
public class SuperLoginController {

    private SuperAdminService superAdminService;

    private SuperAuthService superAuthService;

    public SuperLoginController(SuperAdminService superAdminService, SuperAuthService superAuthService){
        this.superAdminService = superAdminService;
        this.superAuthService = superAuthService;
    }

    @PostMapping("/addSuperAdmin")
    public ResponseEntity<SuperAdmin> addSuperAdmin(@RequestBody SuperAdmin superAdminIn){
        SuperAdmin superAdminOut = superAdminService.addSuperAdmin(superAdminIn);

        return ResponseEntity.of(Optional.of(superAdminOut));
    }


    @PostMapping("/")
    public ResponseEntity<SuperAuth> loginUser(@RequestBody SuperAuth superAuthIn){
        SuperAuth superAuth = superAuthService.loginCheck(superAuthIn.getUsername(), superAuthIn.getPassword(), superAuthIn.getRole().name());

        return ResponseEntity.of(Optional.of(superAuth));
    }
}
