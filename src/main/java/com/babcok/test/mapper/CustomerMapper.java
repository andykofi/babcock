package com.babcok.test.mapper;

import com.babcok.test.dto.CustomerDto;
import com.babcok.test.model.Customer;

public class CustomerMapper {

    public static CustomerDto toDto(Customer customer) {

        CustomerDto customerDto = new CustomerDto();

        customerDto.setId(customer.getId());
        customerDto.setFirstName(customer.getFirstName());
        customerDto.setLastName(customer.getLastName());
        customerDto.setEmail(customer.getEmail());
        customerDto.setPhone(customer.getTelephoneNumber());
        customerDto.setDateOfBirth(customer.getBirthDate());

        return  customerDto;
    }

    public static Customer toEntry(CustomerDto customerDto) {

        Customer customer = new Customer();

        customer.setId(customerDto.getId());
        customer.setFirstName(customerDto.getFirstName());
        customer.setLastName(customerDto.getLastName());
        customer.setEmail(customerDto.getEmail());
        customer.setTelephoneNumber(customerDto.getPhone());
        customer.setBirthDate(customerDto.getDateOfBirth());

        return customer;
    }
}
