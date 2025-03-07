package com.te.customerdetails.service;

import java.util.List;

import com.te.customerdetails.dto.CustomerDto;

public interface CustomerService {

    public CustomerDto register(CustomerDto customerDto);

    public List<CustomerDto> getAllCustomer();

    public CustomerDto getCustomer(int id);

    public CustomerDto deleteCustomer(int id);

    public CustomerDto updateCustomer(int id, CustomerDto customerDto);

}
