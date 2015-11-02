package com.rakuten.products.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rakuten.products.beans.Category;
import com.rakuten.products.beans.Manufacturer;
import com.rakuten.products.beans.Product;
import com.rakuten.products.dto.ProductDto;
import com.rakuten.products.exception.ServiceException;
import com.rakuten.products.service.product.ProductService;
import com.rakuten.products.service.security.RakutenUserDetails;

/**
 * This controller used to handle all requests related to product ex. add, edit,
 * delete
 * 
 * @author Gasser
 * 
 */
@Controller
public class ProductController {
	private static final String VIEW_INDEX = "/index";

	@Autowired
	private ProductService productService;

	/**
	 * Used to initiate the index or home page
	 * 
	 * @param model
	 * @param session
	 * @return
	 * @throws ServiceException
	 */
	@RequestMapping(value = { "/", "/index**" }, method = RequestMethod.GET)
	public String init(ModelMap model, HttpSession session) throws ServiceException {

		// check if user details object still exists ( still valide session)
		RakutenUserDetails rakutenUserDetails = getRakutenUserDetails();

		if (rakutenUserDetails == null)
			return "/login";
		else {
			session.setAttribute("rakutenUserDetails", rakutenUserDetails);
			List<Category> categories = productService.getAllCategories();

			Map<Long, String> categoryMap = new LinkedHashMap<Long, String>();
			for (Category category : categories) {
				categoryMap.put(category.getCategoryId(), category.getCategoryName());
			}

			List<Manufacturer> manufacturers = productService.getAllmanufacturers();
			Map<Long, String> manufacturersMap = new LinkedHashMap<Long, String>();
			for (Manufacturer manufacturer : manufacturers) {
				manufacturersMap.put(manufacturer.getManufacturerId(), manufacturer.getName());
			}
			session.setAttribute("categories", categoryMap);
			session.setAttribute("manufacturers", manufacturersMap);

			// the start and size attributes are used for paging the
			// database .. currently they are static values for simplicity
			model.addAttribute("products", getproducts());
		}

		return VIEW_INDEX;

	}

	/**
	 * used to initiate the add product page
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = { "/add" }, method = RequestMethod.GET)
	public String initAddPage(ModelMap model) {

		// check if user details object still exists ( still valide session)
		RakutenUserDetails rakutenUserDetails = getRakutenUserDetails();

		if (rakutenUserDetails == null)
			return "/login";

		model.addAttribute("product", new Product());
		return "addProduct";

	}

	/**
	 * used to handle add project action
	 * 
	 * @param model
	 * @param product
	 * @return
	 * @throws ServiceException
	 */
	@RequestMapping(value = { "/add" }, method = RequestMethod.POST)
	public String processAddProduct(ModelMap model, @ModelAttribute Product product) throws ServiceException {

		// check if user details object still exists ( still valide session)
		RakutenUserDetails rakutenUserDetails = getRakutenUserDetails();

		if (rakutenUserDetails == null)
			return "/login";

		productService.addProduct(product);
		return "redirect:/index";

	}

	/**
	 * used to delete product by accepting product id
	 * 
	 * @param model
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@RequestMapping(value = { "/delete/{id}" }, method = RequestMethod.GET)
	public String processDeleteProduct(ModelMap model, @PathVariable Long id) throws ServiceException {

		// check if user details object still exists ( still valide session)
		RakutenUserDetails rakutenUserDetails = getRakutenUserDetails();

		if (rakutenUserDetails == null)
			return "/login";

		productService.deleteProduct(id);

		model.addAttribute("products", getproducts());
		return "redirect:/index";

	}

	/**
	 * used to initiate the edit page for product
	 * 
	 * @param model
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@RequestMapping(value = { "/edit/{id}" }, method = RequestMethod.GET)
	public String initedit(ModelMap model, @PathVariable long id) throws ServiceException {

		// check if user details object still exists ( still valide session)
		RakutenUserDetails rakutenUserDetails = getRakutenUserDetails();

		if (rakutenUserDetails == null)
			return "/login";

		Product product = productService.getById(id);
		model.addAttribute("product", product);
		return "editProduct";

	}

	/**
	 * used to save the changes made while editing product
	 * 
	 * @param model
	 * @param request
	 * @return
	 * @throws ServiceException
	 */
	@RequestMapping(value = { "/edit" }, method = RequestMethod.POST)
	public String saveChanges(ModelMap model, HttpServletRequest request) throws ServiceException {

		// check if user details object still exists ( still valide session)
		RakutenUserDetails rakutenUserDetails = getRakutenUserDetails();

		if (rakutenUserDetails == null)
			return "/login";

		ProductDto productDto = new ProductDto();

		productDto.setName(request.getParameter("productName"));
		productDto.setGender(request.getParameter("gender"));
		productDto.setId(Long.parseLong(request.getParameter("productId")));

		try {
			productDto.setPrice(Long.parseLong(request.getParameter("price")));
		} catch (Exception e) {
			System.err.println("price isn't number");
		}

		productService.updateProduct(productDto);

		model.addAttribute("products", getproducts());
		return "redirect:/index";

	}

	/**
	 * Used to get list of products available
	 * 
	 * @return
	 * @throws ServiceException
	 */
	private List<ProductDto> getproducts() throws ServiceException {
		List<ProductDto> productDtos = productService.getProductList(0, 10);
		return productDtos;
	}

	/**
	 * Used to get RakutenUserDetails object from SecurityContextHolder
	 * 
	 * @return
	 */
	private RakutenUserDetails getRakutenUserDetails() {
		try {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			RakutenUserDetails rakutenUserDetails = (RakutenUserDetails) auth.getPrincipal();
			return rakutenUserDetails;
		} catch (Exception e) {
			return null;
		}

	}
}
