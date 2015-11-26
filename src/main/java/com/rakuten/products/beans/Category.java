package com.rakuten.products.beans;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * @author Gasser
 * The Class Category.
 */
@Entity
@Table(name = "category")
public class Category implements java.io.Serializable {

	/** The category id. */
	private Long categoryId;
	
	/** The category. */
	private Category category;
	
	/** The category name. */
	private String categoryName;
	
	/** The products. */
	private Set<Product> products = new HashSet<Product>(0);

	/**
	 * Instantiates a new category.
	 */
	public Category() {
	}

	/**
	 * Instantiates a new category.
	 * 
	 * @param category
	 *            the category
	 */
	public Category(Category category) {
		this.category = category;
	}

	/**
	 * Instantiates a new category.
	 * 
	 * @param category
	 *            the category
	 * @param categoryName
	 *            the category name
	 * @param products
	 *            the products
	 */
	public Category(Category category, String categoryName, Set<Product> products) {
		this.category = category;
		this.categoryName = categoryName;
		this.category = category;
		this.products = products;
	}

	/**
	 * Gets the category id.
	 * 
	 * @return the category id
	 */
	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "category"))
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "category_id", unique = true, nullable = false)
	public Long getCategoryId() {
		return this.categoryId;
	}

	/**
	 * Sets the category id.
	 * 
	 * @param categoryId
	 *            the new category id
	 */
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	/**
	 * Gets the category name.
	 * 
	 * @return the category name
	 */
	@Column(name = "category_name", length = 45)
	public String getCategoryName() {
		return this.categoryName;
	}

	/**
	 * Sets the category name.
	 * 
	 * @param categoryName
	 *            the new category name
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	/**
	 * Gets the category.
	 * 
	 * @return the category
	 */
	@ManyToOne
	@JoinColumn(name = "parent_category_id")
	public Category getCategory() {
		return this.category;
	}

	/**
	 * Sets the category.
	 * 
	 * @param category
	 *            the new category
	 */
	public void setCategory(Category category) {
		this.category = category;
	}

	/**
	 * Gets the products.
	 * 
	 * @return the products
	 */
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
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
