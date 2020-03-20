package com.rab3.repositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rab3.entities.LoginEntity;

@Repository
public class LoginRepository {

	private EntityManager entitymanager;

	@Transactional
	public LoginEntity getByUser(String username) {
		Query query = entitymanager.createQuery("Select l from LoginEntity l where l.user_name=:user_name");
		query.setParameter("user_name", username);
		return (LoginEntity) query.getResultList();

	}

	@PersistenceContext
	public void setEntitymanager(EntityManager entitymanager) {
		this.entitymanager = entitymanager;
	}

}
