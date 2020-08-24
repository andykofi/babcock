package com.babcok.test.repository;

import com.babcok.test.dto.CustomerDto;
import com.babcok.test.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    CustomerDto findCustomerByEmail(String email);
}
