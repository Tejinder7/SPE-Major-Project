package com.bawarchi.spemajor.Contoller;

import com.bawarchi.spemajor.Security.Auth.AuthenticationService;
import com.bawarchi.spemajor.Security.Auth.JwtResponse;
import com.bawarchi.spemajor.Service.CustomerService;
import com.bawarchi.spemajor.Service.SuperAdminService;
import com.bawarchi.spemajor.model.Customer;
import com.bawarchi.spemajor.model.SuperAdmin;
import com.bawarchi.spemajor.model.SuperAuth;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {
    AuthenticationService authenticationService;
    SuperAdminService superAdminService;

    CustomerService customerService;

    public LoginController(AuthenticationService authenticationService, SuperAdminService superAdminService, CustomerService customerService) {
        this.authenticationService = authenticationService;
        this.superAdminService = superAdminService;
        this.customerService = customerService;
    }

    @PostMapping("/")
    public ResponseEntity<JwtResponse> loginUser(@RequestBody SuperAuth request){
        JwtResponse response;
        try{
            response= authenticationService.authenticate(request);
        }catch(Exception exception){
            throw exception;
        }

        return ResponseEntity.ok(response);
    }

    @PostMapping("/addSuperAdmin")
    public SuperAdmin addSuperAdmin(@RequestBody SuperAdmin superAdmin){
        SuperAdmin savedSuperAdmin;
        try{
            savedSuperAdmin = superAdminService.addSuperAdmin(superAdmin);
        }
        catch (Exception exception){
            throw exception;
        }
        return savedSuperAdmin;
    }

    @PostMapping("/addCustomer")
    public Customer addCustomer(@RequestBody Customer customer){
        Customer savedCustomer;
        try{
            savedCustomer = customerService.addCustomer(customer);
        }
        catch (Exception exception){
            throw exception;
        }

        return savedCustomer;
    }
}
