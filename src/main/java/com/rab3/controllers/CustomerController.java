package com.rab3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
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
	/*
	 * @PostMapping(value = "/customerId") public void
	 * addAddressAndLogin(@RequestParam int customerId, @RequestBody AddressDto
	 * address,
	 * 
	 * @RequestBody LoginDto login) {
	 * customerservice.createAddressAndLogin(customerId, address, login); }
	 */

}
