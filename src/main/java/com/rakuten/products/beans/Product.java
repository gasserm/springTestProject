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
 * The Class Product.
 */
@Entity
@Table(name = "product")
public class Product implements java.io.Serializable {

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", manufacturer=" + manufacturer + ", category=" + category
				+ ", productName=" + productName + ", gender=" + gender + ", price=" + price + ", description="
				+ description + "]";
	}

	/** The product id. */
	private Long productId;
	
	/** The manufacturer. */
	private Manufacturer manufacturer;
	
	/** The category. */
	private Category category;
	
	/** The product name. */
	private String productName;
	
	/** The gender. */
	private String gender;
	
	/** The price. */
	private float price;
	
	/** The description. */
	private String description;

	/**
	 * Instantiates a new product.
	 */
	public Product() {
	}

	/**
	 * Instantiates a new product.
	 * 
	 * @param manufacturer
	 *            the manufacturer
	 * @param category
	 *            the category
	 */
	public Product(Manufacturer manufacturer, Category category) {
		this.manufacturer = manufacturer;
		this.category = category;
	}

	/**
	 * Instantiates a new product.
	 * 
	 * @param manufacturer
	 *            the manufacturer
	 * @param category
	 *            the category
	 * @param productName
	 *            the product name
	 * @param gender
	 *            the gender
	 * @param price
	 *            the price
	 * @param description
	 *            the description
	 */
	public Product(Manufacturer manufacturer, Category category, String productName, String gender, Long price,
			String description) {
		this.manufacturer = manufacturer;
		this.category = category;
		this.productName = productName;
		this.gender = gender;
		this.price = price;
		this.description = description;
	}

	/**
	 * Gets the product id.
	 * 
	 * @return the product id
	 */
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "product_id", unique = true, nullable = false)
	public Long getProductId() {
		return this.productId;
	}

	/**
	 * Sets the product id.
	 * 
	 * @param productId
	 *            the new product id
	 */
	public void setProductId(Long productId) {
		this.productId = productId;
	}

	/**
	 * Gets the manufacturer.
	 * 
	 * @return the manufacturer
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "manufacturer_id", nullable = false)
	public Manufacturer getManufacturer() {
		return this.manufacturer;
	}

	/**
	 * Sets the manufacturer.
	 * 
	 * @param manufacturer
	 *            the new manufacturer
	 */
	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}

	/**
	 * Gets the category.
	 * 
	 * @return the category
	 */
	@ManyToOne(fetch = FetchType.EAGER)
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

	/**
	 * Gets the product name.
	 * 
	 * @return the product name
	 */
	@Column(name = "product_name", length = 45)
	public String getProductName() {
		return this.productName;
	}

	/**
	 * Sets the product name.
	 * 
	 * @param productName
	 *            the new product name
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * Gets the gender.
	 * 
	 * @return the gender
	 */
	@Column(name = "gender", length = 1)
	public String getGender() {
		return this.gender;
	}

	/**
	 * Sets the gender.
	 * 
	 * @param gender
	 *            the new gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * Gets the price.
	 * 
	 * @return the price
	 */
	@Column(name = "price", precision = 10, scale = 0)
	public float getPrice() {
		return this.price;
	}

	/**
	 * Sets the price.
	 * 
	 * @param price
	 *            the new price
	 */
	public void setPrice(float price) {
		this.price = price;
	}

	/**
	 * Gets the description.
	 * 
	 * @return the description
	 */
	@Column(name = "description", length = 65535)
	public String getDescription() {
		return this.description;
	}

	/**
	 * Sets the description.
	 * 
	 * @param description
	 *            the new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

}
