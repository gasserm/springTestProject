package com.rakuten.products.beans;


import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Gasser
 * The Class Manufacturer.
 */
@Entity
@Table(name = "manufacturer")
public class Manufacturer implements java.io.Serializable {

	/** The manufacturer id. */
	private Long manufacturerId;
	
	/** The name. */
	private String name;
	
	/** The products. */
	private Set<Product> products = new HashSet<Product>(0);

	/**
	 * Instantiates a new manufacturer.
	 */
	public Manufacturer() {
	}

	/**
	 * Instantiates a new manufacturer.
	 * 
	 * @param name
	 *            the name
	 * @param products
	 *            the products
	 */
	public Manufacturer(String name, Set<Product> products) {
		this.name = name;
		this.products = products;
	}

	/**
	 * Gets the manufacturer id.
	 * 
	 * @return the manufacturer id
	 */
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "manufacturer_id", unique = true, nullable = false)
	public Long getManufacturerId() {
		return this.manufacturerId;
	}

	/**
	 * Sets the manufacturer id.
	 * 
	 * @param manufacturerId
	 *            the new manufacturer id
	 */
	public void setManufacturerId(Long manufacturerId) {
		this.manufacturerId = manufacturerId;
	}

	/**
	 * Gets the name.
	 * 
	 * @return the name
	 */
	@Column(name = "name", length = 100)
	public String getName() {
		return this.name;
	}

	/**
	 * Sets the name.
	 * 
	 * @param name
	 *            the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the products.
	 * 
	 * @return the products
	 */
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "manufacturer")
	public Set<Product> getProducts() {
		return this.products;
	}

	/**
	 * Sets the products.
	 * 
	 * @param products
	 *            the new products
	 */
	public void setProducts(Set<Product> products) {
		this.products = products;
	}

}
