package com.rab3.services;

import com.rab3.dtos.AddressDto;
import com.rab3.entities.AddressEntity;
import com.rab3.repositories.AddressRepository;
public class AddressService {


	private AddressRepository addressrepository;

	public void createAddress(AddressDto dto) {
		AddressEntity addentity = new AddressEntity();
		addentity.setAddress1(dto.getAddress1());
		addentity.setAddress2(dto.getAddress2());
		addentity.setCity(dto.getCity());
		addentity.setState(dto.getState());
		addentity.setZip(dto.getZip());

		addressrepository.save(addentity);

	}

}
