package com.rab3.services;

import java.util.Date;

import com.rab3.dtos.LoginDto;
import com.rab3.entities.LoginEntity;
import com.rab3.repositories.LoginRepository;


public class LoginService {
	
	
    private LoginRepository loginrepository;
    
    public void createLogin(LoginDto dto) {
    	LoginEntity loginentity = new LoginEntity();
		loginentity.setUsername(dto.getUsername());
		loginentity.setPassword(dto.getPassword());
		loginentity.setCreatedDate(new Date());
		loginentity.setUpdateDate(new Date());
		loginentity.setLastsession(new Date());
		
		loginrepository.save(loginentity);
    }

}
