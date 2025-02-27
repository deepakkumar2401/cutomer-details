package com.te.customerdetails.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.te.customerdetails.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	Customer findByCusId(int cusId);
}
