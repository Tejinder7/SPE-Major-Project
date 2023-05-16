package com.bawarchi.spemajor.Repository;

import com.bawarchi.spemajor.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
