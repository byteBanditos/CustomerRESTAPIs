package com.rab3.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
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
		BeanUtils.copyProperties(dto, entity);
		entity.setCreatedDate(new Date());
		entity.setUpdateDate(new Date());

		AddressDto address = dto.getAddress();
		AddressEntity addressentity = new AddressEntity();
		BeanUtils.copyProperties(address, addressentity);
		addressentity.setCustomer(entity);

		entity.setAddress(addressentity);

		LoginDto login = dto.getLogin();
		LoginEntity loginentity = new LoginEntity();
		BeanUtils.copyProperties(login, loginentity);
		loginentity.setCreatedDate(new Date());
		loginentity.setUpdateDate(new Date());
		loginentity.setLastsession(new Date());
		loginentity.setCustomer(entity);

		entity.setLogin(loginentity);

		customerrepository.save(entity);
	}

	public CustomerDto getAllDataById(Integer customerId) {
		CustomerEntity entity = customerrepository.getById(customerId);
		CustomerDto dto = new CustomerDto();
		BeanUtils.copyProperties(entity, dto);

		AddressEntity aentity = entity.getAddress();
		AddressDto address = new AddressDto();
		BeanUtils.copyProperties(aentity, address);
		dto.setAddress(address);

		LoginEntity loginentity = entity.getLogin();
		LoginDto login = new LoginDto();
		BeanUtils.copyProperties(loginentity, login);
		dto.setLogin(login);

		return dto;

	}

	public void updateCustomer(CustomerDto dto, Integer id) {

		CustomerEntity entity = customerrepository.getById(id);
		BeanUtils.copyProperties(dto, entity);
		entity.setUpdateDate(new Date());

		AddressDto address = dto.getAddress();
		AddressEntity addressentity = entity.getAddress();
		BeanUtils.copyProperties(address, addressentity);
		addressentity.setCustomer(entity);

		entity.setAddress(addressentity);

		LoginDto login = dto.getLogin();
		LoginEntity loginentity = entity.getLogin();
		BeanUtils.copyProperties(login, loginentity);
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
			BeanUtils.copyProperties(cust, dto);

			AddressEntity addressentity = cust.getAddress();
			AddressDto addressDto = new AddressDto();
			BeanUtils.copyProperties(addressentity, addressDto);
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
			BeanUtils.copyProperties(customerentity, dto);

			AddressEntity addressentity = customerentity.getAddress();
			AddressDto addressDto = new AddressDto();
			BeanUtils.copyProperties(addressentity, addressDto);
			dto.setAddress(addressDto);

			LoginEntity loginentity = customerentity.getLogin();
			LoginDto login = new LoginDto();
			BeanUtils.copyProperties(loginentity, login);
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
		BeanUtils.copyProperties(address, addressentity);

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
