package com.te.customerdetails.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.customerdetails.dto.CustomerDto;
import com.te.customerdetails.entity.Customer;
import com.te.customerdetails.exception.DataFoundException;
import com.te.customerdetails.exception.DataNotFoundException;
import com.te.customerdetails.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public CustomerDto register(CustomerDto customerDto) {
        Optional<Customer> optionalCustomer = customerRepository.findById(customerDto.getCusId());
        if (optionalCustomer.isEmpty()) {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto, customer);
            Customer newCustomerEntity = customerRepository.save(customer);
            customerDto.setCusId(newCustomerEntity.getCusId());
            BeanUtils.copyProperties(newCustomerEntity, customerDto);
            return customerDto;
        }
        throw new DataFoundException("Customer already present with this id:" + customerDto.getCusId());
    }

    @Override
    public List<CustomerDto> getAllCustomer() {
        List<Customer> customerList = customerRepository.findAll();
        if (customerList.isEmpty()) {
            throw new DataFoundException("customers not present.....");
        }
        List<CustomerDto> customerDtoList = new ArrayList<>();
        for (Customer customer : customerList) {
            CustomerDto customerDto = new CustomerDto();
            BeanUtils.copyProperties(customer, customerDto);
            customerDtoList.add(customerDto);
        }
        return customerDtoList;
    }

    @Override
    public CustomerDto getCustomer(int id) {
        Customer byCusId = customerRepository.findByCusId(id);
        if (byCusId == null) {
            throw new DataNotFoundException("Customer Not present.....");
        }
        CustomerDto customerDto = new CustomerDto();
        BeanUtils.copyProperties(byCusId, customerDto);
        return customerDto;
    }

    @Override
    public CustomerDto deleteCustomer(int id) {
        Customer byCusId = customerRepository.findByCusId(id);
        if (byCusId != null) {
            customerRepository.deleteById(id);
            CustomerDto customerDto = new CustomerDto();
            BeanUtils.copyProperties(byCusId, customerDto);
            return customerDto;
        }
        throw new DataNotFoundException("Customer not found with this id......");
    }

    @Override
    public CustomerDto updateCustomer(int id, CustomerDto customerDto) {
        Customer byCusId = customerRepository.findByCusId(id);
        if (byCusId != null) {
            BeanUtils.copyProperties(customerDto, byCusId);
            byCusId.setCusId(id);
            Customer save = customerRepository.save(byCusId);
            BeanUtils.copyProperties(save, customerDto);
            return customerDto;
        }
        throw new DataNotFoundException("Customer Not found with this id....");
    }

}
