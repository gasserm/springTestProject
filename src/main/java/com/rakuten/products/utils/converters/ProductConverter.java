package com.rakuten.products.utils.converters;

import java.util.ResourceBundle;

import com.rakuten.products.beans.Product;
import com.rakuten.products.dto.ProductDto;

/**
 * This is a utility class to convert between Product to produtDto and vise
 * versa
 * 
 * @author Gasser
 * 
 */
public class ProductConverter {

	/**
	 * This method used to convert product to its Dto object
	 * 
	 * @param product
	 * @return
	 */
	public ProductDto convertProductToProduDto(Product product) {
		String gender;
		StringBuffer fullCategory;
		ProductDto productDto = new ProductDto();

		/*
		 * check the gender cases .. 1- if M then it is male 2- if F then it is
		 * femal 3- if empty assume that the product should match both genders
		 */
		gender = product.getGender();
		if (gender != null && gender.equalsIgnoreCase("m"))
			productDto.setGender(getBundle().getString("add.product.form.usedby.male"));
		else if (gender != null && gender.equalsIgnoreCase("f"))
			productDto.setGender(getBundle().getString("add.product.form.usedby.female"));
		else
			productDto.setGender(getBundle().getString("add.product.form.usedby.both"));

		productDto.setManufacturer(product.getManufacturer().getName());
		productDto.setDescription(product.getDescription());
		productDto.setPrice(product.getPrice());
		productDto.setName(product.getProductName());
		productDto.setId(product.getProductId());

		// set product path .. path should be the parent category if
		// exits then the current category
		fullCategory = new StringBuffer();
		if (product.getCategory().getCategory() != null) {
			fullCategory.append(product.getCategory().getCategory().getCategoryName());
			fullCategory.append(" / ");
		}

		fullCategory.append(product.getCategory().getCategoryName());
		productDto.setPath(fullCategory.toString());

		return productDto;
	}

	private ResourceBundle getBundle() {
		return ResourceBundle.getBundle("messages");
	}
}
