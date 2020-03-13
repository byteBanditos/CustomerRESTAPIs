package com.rab3.repositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rab3.entities.AddressEntity;

@Repository
public class AddressRepository {

	private EntityManager entitymanager;

	@Transactional
	public void save(AddressEntity address) {
		entitymanager.persist(address);
	}

	@PersistenceContext
	public void setEntitymanager(EntityManager entitymanager) {
		this.entitymanager = entitymanager;
	}

}
