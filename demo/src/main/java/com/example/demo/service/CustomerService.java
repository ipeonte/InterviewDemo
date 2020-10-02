package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.CustomerDto;

public interface CustomerService {

	List<CustomerDto> getAllCustomers();
	
	void registerCustomer(CustomerDto customer);
	
	void updateCustomerInfo(int id, CustomerDto customer);

}
