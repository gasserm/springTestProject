package com.rakuten.products.beans;


import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Gasser
 * The Class User.
 */
@Entity
@Table(name = "user_details")
public class User implements java.io.Serializable {

	/** The id. */
	private Long id;
	
	/** The first name. */
	private String firstName;
	
	/** The last name. */
	private String lastName;
	
	/** The username. */
	private String username;
	
	/** The password. */
	private String password;

	/**
	 * Instantiates a new user.
	 */
	public User() {
	}

	/**
	 * Instantiates a new user.
	 * 
	 * @param firstName
	 *            the first name
	 * @param lastName
	 *            the last name
	 * @param username
	 *            the username
	 * @param password
	 *            the password
	 */
	public User(String firstName, String lastName, String username, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
	}

	/**
	 * Gets the id.
	 * 
	 * @return the id
	 */
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	/**
	 * Sets the id.
	 * 
	 * @param id
	 *            the new id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets the first name.
	 * 
	 * @return the first name
	 */
	@Column(name = "first_name", length = 45)
	public String getFirstName() {
		return this.firstName;
	}

	/**
	 * Sets the first name.
	 * 
	 * @param firstName
	 *            the new first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the last name.
	 * 
	 * @return the last name
	 */
	@Column(name = "last_name", length = 45)
	public String getLastName() {
		return this.lastName;
	}

	/**
	 * Sets the last name.
	 * 
	 * @param lastName
	 *            the new last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets the username.
	 * 
	 * @return the username
	 */
	@Column(name = "username", length = 45)
	public String getUsername() {
		return this.username;
	}

	/**
	 * Sets the username.
	 * 
	 * @param username
	 *            the new username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Gets the password.
	 * 
	 * @return the password
	 */
	@Column(name = "password", length = 45)
	public String getPassword() {
		return this.password;
	}

	/**
	 * Sets the password.
	 * 
	 * @param password
	 *            the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
