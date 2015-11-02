package com.rakuten.products.dao;

import java.util.List;

import com.rakuten.products.beans.Category;
import com.rakuten.products.beans.Manufacturer;
import com.rakuten.products.beans.Product;
import com.rakuten.products.dto.ProductDto;

/**
 * ProductDao
 * 
 * @author Gasser
 *
 */
public interface ProductDao {
	/**
	 * This method used to get list of products from started index.
	 * 
	 * @param start
	 * @param size
	 * @return
	 */
	public List<Product> getProductList(int start, int size) throws Exception;

	/**
	 * This method used to delete product using prod id
	 * 
	 * @param prodId
	 */
	public void deleteProduct(long prodId) throws Exception;

	/**
	 * This method used to get Product by prodId
	 * 
	 * @param id
	 * @return
	 */
	public Product getById(long id) throws Exception;

	/**
	 * This methods used to update project when editing
	 * 
	 * @param productDto
	 */
	public void updateProduct(ProductDto productDto) throws Exception;

	/**
	 * This method used to add new product
	 * 
	 * @param product
	 */
	public void addProduct(Product product) throws Exception;

	/**
	 * This method used to get list of all categories - will be used on adding
	 * new prouct
	 * 
	 * @return
	 */
	public List<Category> getAllCategories() throws Exception;

	/**
	 * This method used to get list of all manufacturers - will be used on
	 * adding new prouct
	 * 
	 * @return
	 */
	public List<Manufacturer> getAllmanufacturers() throws Exception;

}