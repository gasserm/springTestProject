package com.rakuten.products;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rakuten.products.beans.Product;
import com.rakuten.products.service.product.ProductService;

/**
 * The Class ProductTest.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:META-INF/spring/mvc-dispatcher-servlet.xml",
		"classpath:META-INF/spring/spring-database.xml" })
public class ProductTest {

	/** The product service. */
	@Autowired
	private ProductService productService;

	/**
	 * Adds the product.
	 */
	@Test
	@Rollback
	public void addProduct() {
		try {
			Product product = createProduct();
			product = productService.addProduct(product);
		} catch (Exception e) {
			System.err.println("failed while testing adding new product");
		}

	}

	private Product createProduct() {
		Product productDto = new Product();
		productDto.setProductName("product1");
		productDto.setGender("m");
		productDto.setPrice(100l);

		return productDto;
	}
}
