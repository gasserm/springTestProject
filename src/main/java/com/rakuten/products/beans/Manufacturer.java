package com.rakuten.products.beans;

// Generated Oct 15, 2015 10:11:55 PM by Hibernate Tools 3.6.0

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
 * Manufacturer generated by hbm2java
 */
@Entity
@Table(name = "manufacturer")
public class Manufacturer implements java.io.Serializable {

	private Long manufacturerId;
	private String name;
	private Set<Product> products = new HashSet<Product>(0);

	public Manufacturer() {
	}

	public Manufacturer(String name, Set<Product> products) {
		this.name = name;
		this.products = products;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "manufacturer_id", unique = true, nullable = false)
	public Long getManufacturerId() {
		return this.manufacturerId;
	}

	public void setManufacturerId(Long manufacturerId) {
		this.manufacturerId = manufacturerId;
	}

	@Column(name = "name", length = 100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "manufacturer")
	public Set<Product> getProducts() {
		return this.products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

}
