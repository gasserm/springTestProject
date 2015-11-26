package com.rakuten.products.dto;

/**
 * The Class ProductDto.
 * @author Gasser
 */
public class ProductDto {
	
	/** The id. */
	private long id;
	
	/** The name. */
	private String name;
	
	/** The path. */
	private String path;
	
	/** The gender. */
	private String gender;
	
	/** The manufacturer. */
	private String manufacturer;
	
	/** The price. */
	private float price;
	
	/** The description. */
	private String description;
	
	/** The username. */
	private String username;

	/**
	 * Sets the id.
	 * 
	 * @param id
	 *            the new id
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Gets the id.
	 * 
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * Instantiates a new product dto.
	 */
	public ProductDto() {
	}

	/**
	 * Gets the name.
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
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
	 * Gets the path.
	 * 
	 * @return the path
	 */
	public String getPath() {
		return path;
	}

	/**
	 * Sets the path.
	 * 
	 * @param path
	 *            the new path
	 */
	public void setPath(String path) {
		this.path = path;
	}

	/**
	 * Gets the gender.
	 * 
	 * @return the gender
	 */
	public String getGender() {
		return gender;
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
	 * Gets the manufacturer.
	 * 
	 * @return the manufacturer
	 */
	public String getManufacturer() {
		return manufacturer;
	}

	/**
	 * Sets the manufacturer.
	 * 
	 * @param manufacturer
	 *            the new manufacturer
	 */
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	/**
	 * Gets the price.
	 * 
	 * @return the price
	 */
	public float getPrice() {
		return price;
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
	public String getDescription() {
		return description;
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
	 * Gets the username.
	 * 
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

}
