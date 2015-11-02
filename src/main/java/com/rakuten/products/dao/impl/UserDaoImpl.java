package com.rakuten.products.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.rakuten.products.beans.User;
import com.rakuten.products.dao.UserDao;

public class UserDaoImpl implements UserDao {

	@PersistenceContext(unitName = "manager1")
	private EntityManager entityManager;

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	/*
	 * @see com.rakuten.products.dao.UserDao#getUser(java.lang.String)
	 */
	@Override
	public User getUser(String username) throws Exception {
		List<User> users = new ArrayList<User>();
		Query query = getEntityManager().createQuery("from User where username=:username");
		query.setParameter("username", username);
		users = query.getResultList();

		if (users.size() == 0)
			return null;
		else 
			return users.get(0);
	}

	/* 
	 * @see com.rakuten.products.dao.UserDao#authenticate(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean authenticate(String username, String password) throws Exception {
		Query query = getEntityManager().createQuery("from User where username = :username and password = :password");
		query.setParameter("username", username);
		query.setParameter("password", password);

		List<User> users = query.getResultList();

		return (users.size() != 0) ? true : false;

	}

}
