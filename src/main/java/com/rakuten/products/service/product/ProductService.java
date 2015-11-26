package com.rakuten.products.service.product;

import java.util.List;

import com.rakuten.products.beans.Category;
import com.rakuten.products.beans.Manufacturer;
import com.rakuten.products.beans.Product;
import com.rakuten.products.dto.ProductDto;
import com.rakuten.products.exception.ServiceException;

/**
 * The Interface ProductService.
 * @author Gasser
 */
public interface ProductService {

	/**
	 * Gets the product list.
	 * 
	 * @param start
	 *            the start
	 * @param size
	 *            the size
	 * @return the product list
	 * @throws ServiceException
	 *             the service exception
	 */
	public List<ProductDto> getProductList(int start, int size) throws ServiceException;

	/**
	 * Delete product.
	 * 
	 * @param prodId
	 *            the prod id
	 * @throws ServiceException
	 *             the service exception
	 */
	public void deleteProduct(long prodId) throws ServiceException;

	/**
	 * Gets the by id.
	 * 
	 * @param id
	 *            the id
	 * @return the by id
	 * @throws ServiceException
	 *             the service exception
	 */
	public Product getById(long id) throws ServiceException;

	/**
	 * Update product.
	 * 
	 * @param productDto
	 *            the product dto
	 * @throws ServiceException
	 *             the service exception
	 */
	public void updateProduct(ProductDto productDto) throws ServiceException;

	/**
	 * Adds the product.
	 * 
	 * @param product
	 *            the product
	 * @return the product
	 * @throws ServiceException
	 *             the service exception
	 */
	public Product addProduct(Product product) throws ServiceException;

	/**
	 * Gets the all categories.
	 * 
	 * @return the all categories
	 * @throws ServiceException
	 *             the service exception
	 */
	public List<Category> getAllCategories() throws ServiceException;

	/**
	 * Gets the allmanufacturers.
	 * 
	 * @return the allmanufacturers
	 * @throws ServiceException
	 *             the service exception
	 */
	public List<Manufacturer> getAllmanufacturers() throws ServiceException;

}
