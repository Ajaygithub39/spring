package com.prashant.learning.spring.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prashant.learning.spring.model.Product;
import com.prashant.learning.spring.model.dto.ProductDto;
import com.prashant.learning.spring.service.ProductService;

@RestController
@RequestMapping("/v1/products")
public class ProductController {

	
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

	private ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<ArrayList<Product>> findAllProducts() {
		logger.info("Invoked controller : findAllProducts");
		return new ResponseEntity<ArrayList<Product>>(new ArrayList<Product>(productService.getAllProducts()),
				HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<ProductDto> save(@RequestBody ProductDto dto) {
		logger.info("Invoked controller : save for dto= {}  ", dto);
		return new ResponseEntity<ProductDto>(productService.saveProduct(dto), HttpStatus.CREATED);

	}

}
