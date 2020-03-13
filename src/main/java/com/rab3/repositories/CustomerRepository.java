package com.rab3.repositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rab3.entities.CustomerEntity;

@Repository
public class CustomerRepository {

	private EntityManager entitymanager;

	@Transactional
	public void save(CustomerEntity customer) {
		entitymanager.persist(customer);
	}

	public CustomerEntity getById(int id) {
		return entitymanager.find(CustomerEntity.class, id);

	}

	@PersistenceContext
	public void setEntitymanager(EntityManager entitymanager) {
		this.entitymanager = entitymanager;
	}

}
