package com.prashant.learning.spring.service;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import com.prashant.learning.spring.model.Product;
import com.prashant.learning.spring.model.dto.ProductDto;

public interface ProductService {

	Collection<Product> getAllProducts();

	List<Product> getAllProductsInDateRange(Date expiredFrom, Date expiredTo);

	ProductDto saveProduct(ProductDto dto);

}