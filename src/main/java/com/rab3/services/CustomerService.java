package com.rab3.services;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rab3.dtos.AddressDto;
import com.rab3.dtos.CustomerDto;
import com.rab3.dtos.LoginDto;
import com.rab3.entities.AddressEntity;
import com.rab3.entities.CustomerEntity;
import com.rab3.entities.LoginEntity;
import com.rab3.repositories.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerrepository;

	public void createCustomer(CustomerDto dto) {
		CustomerEntity entity = new CustomerEntity();
		entity.setFname(dto.getFname());
		entity.setLname(dto.getLname());
		entity.setPhone(dto.getPhone());
		entity.setEmail(dto.getEmail());
		entity.setCreatedDate(new Date());
		entity.setUpdateDate(new Date());

		AddressDto address = dto.getAddress();
		AddressEntity ae = new AddressEntity();
		ae.setAddress1(address.getAddress1());
		ae.setAddress2(address.getAddress2());
		ae.setCity(address.getCity());
		ae.setState(address.getState());
		ae.setZip(address.getZip());
		ae.setCustomer(entity);
		
		entity.setAddress(ae);
		
		LoginDto login = dto.getLogin();
		LoginEntity le = new LoginEntity();
		le.setUsername(login.getUsername());
		le.setPassword(login.getPassword());
		le.setCreatedDate(new Date());
		le.setUpdateDate(new Date());
		le.setLastsession(new Date());
		le.setCustomer(entity);
		
		entity.setLogin(le);
		

		customerrepository.save(entity);
	}

	/*
	 * public void createAddressAndLogin(int customerId, AddressDto dto, LoginDto
	 * ldto) {
	 * 
	 * CustomerEntity customer = customerrepository.getById(customerId); if
	 * (customer == null) { System.out.println("customer doesnot exit"); } else {
	 * AddressEntity address = new AddressEntity();
	 * address.setAddress1(dto.getAddress1());
	 * address.setAddress2(dto.getAddress2()); address.setCity(dto.getCity());
	 * address.setState(dto.getState()); address.setZip(dto.getZip());
	 * 
	 * LoginEntity login = new LoginEntity(); login.setUsername(ldto.getUsername());
	 * login.setPassword(ldto.getPassword()); login.setCreatedDate(new Date());
	 * login.setUpdateDate(new Date()); login.setLastsession(new Date());
	 * 
	 * if (customer != null) { addressrepository.save(address);
	 * loginRepository.save(login); }
	 * 
	 * }
	 */

}
