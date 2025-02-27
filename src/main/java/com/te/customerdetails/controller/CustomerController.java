package com.te.customerdetails.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.te.customerdetails.dto.CustomerDto;
import com.te.customerdetails.dto.ResponseDto;
import com.te.customerdetails.service.CustomerService;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/register")
    public ResponseEntity<ResponseDto> register(@RequestBody CustomerDto customerDto) {
        return ResponseEntity
                .ok(new ResponseDto(false, "Customer Register Successfully...", customerService.register(customerDto)));
    }

    @GetMapping("/get-customers")
    public ResponseEntity<ResponseDto> getAllCustomer() {
        return ResponseEntity
                .ok(new ResponseDto(false, "Customers Fetched Successfully....", customerService.getAllCustomer()));
    }

    @GetMapping("/get-customer/{id}")
    public ResponseEntity<ResponseDto> getCustomer(@PathVariable("id") int id) {
        return ResponseEntity
                .ok(new ResponseDto(false, "Customer Fetched Successfully....", customerService.getCustomer(id)));
    }

    @DeleteMapping("/delete-customer/{id}")
    public ResponseEntity<ResponseDto> deleteCustomer(@PathVariable("id") int id) {
        return ResponseEntity
                .ok(new ResponseDto(false, "Customer Delete Successfully......", customerService.deleteCustomer(id)));
    }

}
