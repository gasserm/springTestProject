package com.rakuten.products.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import com.rakuten.products.beans.Category;
import com.rakuten.products.beans.Manufacturer;
import com.rakuten.products.beans.Product;
import com.rakuten.products.dao.ProductDao;
import com.rakuten.products.dto.ProductDto;

/**
 * 
 * @author Gasser
 * 
 */
public class ProductDaoImpl implements ProductDao {

	@PersistenceContext(unitName = "manager1")
	private EntityManager entityManager;

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.rakuten.products.dao.ProductDao#getProductList(int, int)
	 */
	@Override
	public List<Product> getProductList(int start, int size) throws Exception {
		Query query = getEntityManager().createQuery("from Product");
		query.setFirstResult(start);
		query.setMaxResults(size);

		return query.getResultList();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.rakuten.products.dao.ProductDao#deleteProduct(long)
	 */
	@Override
	@Transactional
	public void deleteProduct(long prodId) throws Exception {
		Query query = getEntityManager().createQuery("delete from Product where productId =:prodId");
		query.setParameter("prodId", prodId);
		query.executeUpdate();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.rakuten.products.dao.ProductDao#getById(long)
	 */
	@Override
	public Product getById(long id) throws Exception {
		List<Product> prods = null;
		Query query = getEntityManager().createQuery("from Product where productId =:id");
		query.setParameter("id", id);
		prods = query.getResultList();

		if (prods.size() > 0)
			return prods.get(0);
		else
			return null;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.rakuten.products.dao.ProductDao#updateProduct(com.rakuten.products
	 * .dto.ProductDto)
	 */
	@Override
	public void updateProduct(ProductDto productDto) throws Exception {
		Product product = getById(productDto.getId());
		product.setProductName(productDto.getName());
		product.setPrice(productDto.getPrice());
		product.setGender(productDto.getGender());

		entityManager.merge(product);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.rakuten.products.dao.ProductDao#addProduct(com.rakuten.products.beans
	 * .Product)
	 */
	@Override
	public void addProduct(Product product) throws Exception {
		entityManager.persist(product);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.rakuten.products.dao.ProductDao#getAllCategories()
	 */
	@Override
	public List<Category> getAllCategories() throws Exception {
		Query query = getEntityManager().createQuery("from Category");
		return query.getResultList();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.rakuten.products.dao.ProductDao#getAllmanufacturers()
	 */
	@Override
	public List<Manufacturer> getAllmanufacturers() throws Exception {
		List<Manufacturer> manufacturers = new ArrayList<Manufacturer>();
		Query query = getEntityManager().createQuery("from Manufacturer");
		manufacturers = query.getResultList();

		return manufacturers;
	}

}
