package com.example.demo.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CustomerDto;
import com.example.demo.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerController {

	@Autowired
	private CustomerService custService;
	
	@RequestMapping("/customer")
	List<CustomerDto> getAllCustomers() {
		return custService.getAllCustomers();
	}
	
	@RequestMapping(value = "/customer", method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE)
	void registerCustomer(@RequestBody CustomerDto customer) {
		custService.registerCustomer(customer);
	}
	
	@RequestMapping(value = "/customer/{id}", method = RequestMethod.PUT)
	void updateCustomerInfo(@PathVariable("id") Integer id, @RequestBody CustomerDto customer) {
		custService.updateCustomerInfo(id, customer);
	}
	
}
