package com.prashant.learning.spring.service.impl;


import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.prashant.learning.spring.model.Product;
import com.prashant.learning.spring.model.dto.ProductDto;
import com.prashant.learning.spring.service.ProductService;


@Service
public class ProductServiceImpl implements  ProductService {

	private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

	private static final Map<String, Product> repository = new HashMap<>();
	static {

		logger.info("Populating Dummy Records in Repository Map ");

		Product product1 = new Product(UUID.randomUUID().toString(), new BigDecimal("25000"), "Lenovo Laptop",
				Arrays.asList("Electronics", "Laptop", "Computer", "Learning"));

		Product product2 = new Product(UUID.randomUUID().toString(), new BigDecimal("13000"), "Bose Headsets",
				Arrays.asList("Electronics", "Entertainment", "Music", "Headsets"));

		Product product3 = new Product(UUID.randomUUID().toString(), new BigDecimal("45000"), "Sony Bravia LED TV",
				Arrays.asList("Electronics", "LED TV", "Home Entertainment", "Leisure"));

		Product product4 = new Product(UUID.randomUUID().toString(), new BigDecimal("120"), "Philips Hair Dryer",
				Arrays.asList("Electronics", "Gromming", "Hair Styling", "Dryer"));

		repository.put(product1.getId(), product1);
		repository.put(product2.getId(), product2);
		repository.put(product3.getId(), product3);
		repository.put(product4.getId(), product4);
		logger.info(" Respository Contents : {} ", repository);

	}

	/* (non-Javadoc)
	 * @see com.prashant.learning.spring.service.impl.ProductService#getAllProducts()
	 */
	@Override
	public Collection<Product> getAllProducts() {
		logger.info("getAllProducts Invoked");
		return repository.values();
	}

	/* (non-Javadoc)
	 * @see com.prashant.learning.spring.service.impl.ProductService#getAllProductsInDateRange(java.util.Date, java.util.Date)
	 */
	@Override
	public List<Product> getAllProductsInDateRange(Date expiredFrom, Date expiredTo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductDto saveProduct(ProductDto dto) {
		logger.info("saveProduct Invoked for:  {} ", dto);
		Product newProduct = new Product();
		newProduct.setId(UUID.randomUUID().toString());
		newProduct.setPrice(dto.getPrice());
		newProduct.setName(dto.getName());
		newProduct.setTags(dto.getTags());
		repository.put(newProduct.getId(), newProduct);
		logger.info("Added a new Product with product id = {} ", newProduct.getId());
		ProductDto newProductDto = ProductDto.builder().id(newProduct.getId()).price(newProduct.getPrice())
				.name(newProduct.getName()).tags(newProduct.getTags()).build();

		return newProductDto;

	}

}
