package com.rab3.repositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rab3.entities.LoginEntity;

@Repository
public class LoginRepository {

	private EntityManager entitymanager;

	@Transactional
	public void save(LoginEntity login) {
		entitymanager.persist(login);
	}

	@PersistenceContext
	public void setEntitymanager(EntityManager entitymanager) {
		this.entitymanager = entitymanager;
	}

}
