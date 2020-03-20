package com.rab3.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rab3.entities.CustomerEntity;

@Repository
public class CustomerRepository {

	private EntityManager entitymanager;

	@PersistenceContext
	public void setEntitymanager(EntityManager entitymanager) {
		this.entitymanager = entitymanager;
	}

	@Transactional
	public void save(CustomerEntity customer) {
		entitymanager.persist(customer);
	}

	@Transactional
	public CustomerEntity getById(Integer customerId) {
		return entitymanager.find(CustomerEntity.class, customerId);

	}

	@Transactional
	public void update(CustomerEntity customer) {
		entitymanager.merge(customer);

	}

	@Transactional
	public List<CustomerEntity> getCustomerByLastName(String lastname) {
		Query query = (Query) entitymanager.createQuery("select c from CustomerEntity c where c.lname = :lname ");
		query.setParameter("lname", lastname);
		return query.getResultList();
	}

	@Transactional
	public List<CustomerEntity> getAllCustomer() {
		Query query = (Query) entitymanager.createQuery("from CustomerEntity");
		return query.list();
	}

}
