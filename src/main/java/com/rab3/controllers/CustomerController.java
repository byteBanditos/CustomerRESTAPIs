package com.rab3.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rab3.dtos.CustomerDto;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@PostMapping
	public void createCustomer(@RequestBody CustomerDto dto) {
		
	}

}
