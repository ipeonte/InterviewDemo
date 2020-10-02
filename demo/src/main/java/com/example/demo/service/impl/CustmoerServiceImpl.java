package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CustomerDto;
import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepo;
import com.example.demo.service.CustomerService;

@Service
public class CustmoerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepo cutomerRepo;
	
	@Override
	public List<CustomerDto> getAllCustomers() {
		List<CustomerDto> result  = new ArrayList<>();
		
		Iterable<Customer> list = cutomerRepo.findAll();
		
		for (Customer c: list)
			result.add(new CustomerDto(c.getId(), c.getName()));
		
		return result;
	}

	@Override
	public void registerCustomer(CustomerDto customer) {
		Customer c = new Customer(customer.getId(), customer.getName());
		cutomerRepo.save(c);
	}

	@Override
	public void updateCustomerInfo(int id, CustomerDto customer) {
		Customer c = new Customer(id, customer.getName());
		cutomerRepo.save(c);
	}
}
