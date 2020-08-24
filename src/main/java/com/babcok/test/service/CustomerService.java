package com.babcok.test.service;

import com.babcok.test.dto.CustomerDto;
import com.babcok.test.mapper.CustomerMapper;

import com.babcok.test.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<CustomerDto> getAllCustomers() {
        return customerRepository.findAll().stream().map(CustomerMapper::toDto)
                .collect(Collectors.toList());

    }

    public CustomerDto findCustomerByEmail(String email) {
        return customerRepository.findCustomerByEmail(email);
    }

    public void save(CustomerDto customerDto) {
        customerRepository.save(CustomerMapper.toEntry(customerDto));
    }
}
