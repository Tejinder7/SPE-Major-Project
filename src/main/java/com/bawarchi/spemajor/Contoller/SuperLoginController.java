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
    public ResponseEntity<SuperAuth> loginUser(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("role") String role){
        SuperAuth superAuth = superAuthService.loginCheck(username, password, role);

        return ResponseEntity.of(Optional.of(superAuth));
    }
}
