package com.bawarchi.spemajor.Service;

import com.bawarchi.spemajor.Repository.CustomerRepository;
import com.bawarchi.spemajor.model.AllOrders;
import com.bawarchi.spemajor.model.Customer;
import com.bawarchi.spemajor.model.FoodCourt;
import com.bawarchi.spemajor.model.Role;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private SuperAuthService superAuthService;

    private PasswordEncoder passwordEncoder;

    private CustomerRepository customerRepository;

    public CustomerService(SuperAuthService superAuthService, PasswordEncoder passwordEncoder, CustomerRepository customerRepository) {
        this.superAuthService = superAuthService;
        this.passwordEncoder = passwordEncoder;
        this.customerRepository = customerRepository;
    }

    public Customer addCustomer(Customer customer) throws RuntimeException {
        superAuthService.checkIfUserIdExists(customer.getUsername());

        customer.setRole(Role.ROLE_CUSTOMER);
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        return customerRepository.save(customer);
    }
}
