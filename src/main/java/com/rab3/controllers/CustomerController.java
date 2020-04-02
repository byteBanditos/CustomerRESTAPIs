package com.rab3.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rab3.dtos.CustomerDto;
import com.rab3.services.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerservice;

	@PostMapping
	public void addCustomer(@RequestBody CustomerDto dto) {
		customerservice.createCustomer(dto);

	}

	@GetMapping(value = "/{customerId}")
	public CustomerDto getAllInformation(@PathVariable Integer customerId) {
		return customerservice.getAllDataById(customerId);

	}

	@PutMapping(value = "update/{id}")
	public void updateCustomer(@PathVariable Integer id, @RequestBody CustomerDto customer) {
		customerservice.updateCustomer(customer, id);

	}

	@PutMapping(value = "/{id}/address/{addressid}")
	public void updateAddress(@PathVariable Integer id, @RequestBody CustomerDto customer,
			@PathVariable int addressid) {
		customerservice.updateAddress(id, customer, addressid);

	}

	@GetMapping(value = "find/{lastname}")
	public List<CustomerDto> getByLastName(@PathVariable String lastname) {
		return customerservice.getCustomerByLastName(lastname);

	}

	@GetMapping
	public List<CustomerDto> displayAllCustomer() {
		return customerservice.getAllCustomer();
	}

	@PutMapping(value = "/update/login/{id}")
	public void changelogin(@PathVariable Integer id, @RequestBody CustomerDto customer) {
		customerservice.updateLogin(id, customer);

	}

}
