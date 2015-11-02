package com.rakuten.products.service.product;

import java.util.ArrayList;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.rakuten.products.beans.Category;
import com.rakuten.products.beans.Manufacturer;
import com.rakuten.products.beans.Product;
import com.rakuten.products.dao.ProductDao;
import com.rakuten.products.dto.ProductDto;
import com.rakuten.products.exception.ServiceException;
import com.rakuten.products.utils.converters.ProductConverter;

/**
 * @author Gasser
 * 
 */
public class ProductServiceImpl implements ProductService {

	private ProductDao productDao;

	private ProductConverter productConverter;

	/**
	 * @return productConverter
	 */
	public ProductConverter getProductConverter() {
		return productConverter;
	}

	/**
	 * @param productConverter
	 */
	public void setProductConverter(ProductConverter productConverter) {
		this.productConverter = productConverter;
	}

	/**
	 * @param productDao
	 */
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	/**
	 * @return ProductDao
	 */
	public ProductDao getProductDao() {
		return productDao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.rakuten.products.service.product.ProductService#getProductList(int,
	 * int)
	 */
	@Override
	public List<ProductDto> getProductList(int start, int size) throws ServiceException {
		List<Product> productsObjects = new ArrayList<Product>();
		List<ProductDto> proDtos = new ArrayList<ProductDto>();
		try {
			//
			productsObjects = productDao.getProductList(start, size);
			for (Product product : productsObjects) {
				proDtos.add(productConverter.convertProductToProduDto(product));
			}
			return proDtos;
		} catch (Exception e) {
			throw new ServiceException("faild to get products data", e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.rakuten.products.service.product.ProductService#deleteProduct(long)
	 */
	@Override
	public void deleteProduct(long prodId) throws ServiceException {
		try {
			productDao.deleteProduct(prodId);
		} catch (Exception e) {
			throw new ServiceException("faild to get delete proudct : " + prodId, e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.rakuten.products.service.product.ProductService#getById(long)
	 */
	@Override
	public Product getById(long id) throws ServiceException {
		try {
			return productDao.getById(id);
		} catch (Exception e) {
			throw new ServiceException("faild to get proudct : " + id, e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.rakuten.products.service.product.ProductService#updateProduct(com
	 * .rakuten.products.dto.ProductDto)
	 */
	@Override
	@Transactional
	public void updateProduct(ProductDto productDto) throws ServiceException {
		try {
			productDao.updateProduct(productDto);
		} catch (Exception e) {
			throw new ServiceException("faild to update proudct : " + productDto.getId(), e);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.rakuten.products.service.product.ProductService#addProduct(com.rakuten
	 * .products.beans.Product)
	 */
	@Override
	@Transactional
	public void addProduct(Product product) throws ServiceException {
		try {
			productDao.addProduct(product);
		} catch (Exception e) {
			throw new ServiceException("faild to add new proudct", e);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.rakuten.products.service.product.ProductService#getAllCategories()
	 */
	@Override
	public List<Category> getAllCategories() throws ServiceException {
		try {
			return productDao.getAllCategories();
		} catch (Exception e) {
			throw new ServiceException("faild to get all categories", e);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.rakuten.products.service.product.ProductService#getAllmanufacturers()
	 */
	@Override
	public List<Manufacturer> getAllmanufacturers() throws ServiceException {
		try {
			return productDao.getAllmanufacturers();
		} catch (Exception e) {
			throw new ServiceException("faild to get all categories", e);
		}
	}

}
