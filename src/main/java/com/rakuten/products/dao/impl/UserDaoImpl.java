package com.rakuten.products.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.rakuten.products.beans.User;
import com.rakuten.products.dao.UserDao;

/**
 * The Class UserDaoImpl.
 * @author Gasser
 */
public class UserDaoImpl implements UserDao {

	/** The entity manager. */
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Sets the entity manager.
	 * 
	 * @param entityManager
	 *            the new entity manager
	 */
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	/**
	 * Gets the entity manager.
	 * 
	 * @return the entity manager
	 */
	public EntityManager getEntityManager() {
		return entityManager;
	}

	/*
	 * @see com.rakuten.products.dao.UserDao#getUser(java.lang.String)
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.rakuten.products.dao.UserDao#getUser(java.lang.String)
	 */
	@Override
	public User getUser(String username) {
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
	 * @see com.rakuten.products.dao.UserDao#authenticate(java.lang.String,
	 * java.lang.String)
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.rakuten.products.dao.UserDao#authenticate(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public boolean authenticate(String username, String password) {
		Query query = getEntityManager().createQuery("from User where username = :username and password = :password");
		query.setParameter("username", username);
		query.setParameter("password", password);

		List<User> users = query.getResultList();

		return (users.size() != 0) ? true : false;

	}

}
