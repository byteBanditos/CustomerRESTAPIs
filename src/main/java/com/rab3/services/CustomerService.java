package com.rab3.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

	public CustomerDto getAllDataById(Integer customerId) {
		CustomerEntity entity = customerrepository.getById(customerId);
		CustomerDto dto = new CustomerDto();
		dto.setFname(entity.getFname());
		dto.setLname(entity.getLname());
		dto.setEmail(entity.getEmail());
		dto.setPhone(entity.getPhone());

		AddressEntity aentity = entity.getAddress();
		AddressDto address = new AddressDto();
		address.setAddress1(aentity.getAddress1());
		address.setAddress2(aentity.getAddress2());
		address.setCity(aentity.getCity());
		address.setZip(aentity.getZip());

		dto.setAddress(address);

		LoginEntity loginentity = entity.getLogin();
		LoginDto login = new LoginDto();
		login.setUsername(loginentity.getUsername());
		login.setPassword(loginentity.getPassword());

		dto.setLogin(login);

		return dto;

	}

	public void updateCustomer(CustomerDto dto, Integer id) {

		CustomerEntity entity = customerrepository.getById(id);

		entity.setFname(dto.getFname());
		entity.setLname(dto.getLname());
		entity.setEmail(dto.getEmail());
		entity.setPhone(dto.getPhone());
		entity.setUpdateDate(new Date());

		AddressDto address = dto.getAddress();

		AddressEntity addressentity = entity.getAddress();
		addressentity.setAddress1(address.getAddress1());
		addressentity.setAddress2(address.getAddress2());
		addressentity.setCity(address.getCity());
		addressentity.setState(address.getState());
		addressentity.setZip(address.getZip());
		addressentity.setCustomer(entity);

		entity.setAddress(addressentity);

		LoginDto login = dto.getLogin();
		LoginEntity loginentity = entity.getLogin();
		loginentity.setUsername(login.getUsername());
		loginentity.setPassword(login.getPassword());
		loginentity.setUpdateDate(new Date());
		loginentity.setLastsession(new Date());
		loginentity.setCustomer(entity);

		entity.setLogin(loginentity);

		customerrepository.update(entity);

	}

	public List<CustomerDto> getCustomerByLastName(String lastname) {
		List<CustomerDto> customer = new ArrayList<CustomerDto>();
		List<CustomerEntity> entity = (List<CustomerEntity>) customerrepository.getCustomerByLastName(lastname);
		for (CustomerEntity cust : entity) {
			CustomerDto dto = new CustomerDto();
			dto.setCustomerId(cust.getCustomerId());
			dto.setFname(cust.getFname());
			dto.setLname(cust.getLname());
			dto.setEmail(cust.getEmail());
			dto.setPhone(cust.getPhone());

			AddressEntity addressentity = cust.getAddress();
			AddressDto addressDto = new AddressDto();
			addressDto.setAddress1(addressentity.getAddress1());
			addressDto.setAddress2(addressentity.getAddress2());
			addressDto.setCity(addressentity.getCity());
			addressDto.setState(addressentity.getState());
			addressDto.setZip(addressentity.getZip());

			dto.setAddress(addressDto);

			customer.add(dto);

		}
		return customer;

	}

	public List<CustomerDto> getAllCustomer() {
		List<CustomerDto> customer = new ArrayList<CustomerDto>();
		List<CustomerEntity> entity = customerrepository.getAllCustomer();

		for (CustomerEntity customerentity : entity) {
			CustomerDto dto = new CustomerDto();
			dto.setCustomerId(customerentity.getCustomerId());
			dto.setFname(customerentity.getFname());
			dto.setFname(customerentity.getLname());
			dto.setEmail(customerentity.getEmail());
			dto.setPhone(customerentity.getPhone());

			AddressEntity addressentity = customerentity.getAddress();
			AddressDto addressDto = new AddressDto();
			addressDto.setAddress1(addressentity.getAddress1());
			addressDto.setAddress2(addressentity.getAddress2());
			addressDto.setCity(addressentity.getCity());
			addressDto.setState(addressentity.getState());
			addressDto.setZip(addressentity.getZip());
			customerentity.setAddress(addressentity);

			dto.setAddress(addressDto);

			LoginEntity loginentity = customerentity.getLogin();
			LoginDto login = new LoginDto();
			login.setUsername(loginentity.getUsername());
			login.setPassword(loginentity.getPassword());
			customerentity.setLogin(loginentity);

			dto.setLogin(login);

			customer.add(dto);

		}
		return customer;
	}

	public void updateAddress(int id, CustomerDto dto, int addressid) {
		CustomerEntity entity = customerrepository.getById(id);

		AddressEntity addressentity = entity.getAddress();
		AddressDto address = dto.getAddress();
		addressentity.setId(addressid);
		addressentity.setAddress1(address.getAddress1());
		addressentity.setAddress2(address.getAddress2());
		addressentity.setCity(address.getCity());
		addressentity.setState(address.getState());
		addressentity.setZip(address.getZip());
		addressentity.setCustomer(entity);

		entity.setAddress(addressentity);

		customerrepository.update(entity);

	}

	public void updateLogin(int id, CustomerDto dto) {
		CustomerEntity entity = customerrepository.getById(id);
		LoginDto login = dto.getLogin();
		LoginEntity loginentity = entity.getLogin();
		loginentity.setUsername(login.getUsername());
		loginentity.setPassword(login.getPassword());
		loginentity.setUpdateDate(new Date());
		loginentity.setLastsession(new Date());
		loginentity.setCustomer(entity);

		entity.setLogin(loginentity);

		customerrepository.update(entity);

	}
}
