package com.rakuten.products.beans;


import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Gasser
 * The Class ProductCategory.
 */
@Entity
@Table(name = "product_category")
public class ProductCategory implements java.io.Serializable {

	/** The id. */
	private Long id;
	
	/** The product. */
	private Product product;
	
	/** The category. */
	private Category category;

	/**
	 * Instantiates a new product category.
	 */
	public ProductCategory() {
	}

	/**
	 * Instantiates a new product category.
	 * 
	 * @param product
	 *            the product
	 * @param category
	 *            the category
	 */
	public ProductCategory(Product product, Category category) {
		this.product = product;
		this.category = category;
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
	 * Gets the product.
	 * 
	 * @return the product
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id", nullable = false)
	public Product getProduct() {
		return this.product;
	}

	/**
	 * Sets the product.
	 * 
	 * @param product
	 *            the new product
	 */
	public void setProduct(Product product) {
		this.product = product;
	}

	/**
	 * Gets the category.
	 * 
	 * @return the category
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id", nullable = false)
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

}
