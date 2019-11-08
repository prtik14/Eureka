package com.product.controller;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.product.model.Product;
import com.product.repository.ProductRepository;

@RestController
public class ProductController {

	private static final Logger LOG = Logger.getLogger(ProductController.class.getName());
	@Autowired
	private ProductRepository repository;
	
	
	@PostMapping("/addProduct")
	public String saveBook(@RequestBody Product product)
	{		
		repository.save(product);
		LOG.log(Level.INFO, "you called addProduct");
		return "Product is added with id " + product.getProdId();
		
	}
	
	
	@GetMapping("/findAllProducts")
	public List getProducts()
	{
		LOG.log(Level.INFO, "you called getAllProducts"); 
		
		return (List) repository.findAll();
	}
	
	

	@DeleteMapping("/delete/{id}")
	public String deleteProduct(@PathVariable String id)
	{
		repository.deleteById(id);
		LOG.log(Level.INFO, "you called deleteProduct");
		return "Product delete with id "+ id;
		
	}
	
//	@PutMapping("/updateUser")
//	public String updateUser(@RequestBody User user)
//	{
//		repository.save(user);
//		return "Updated";
//	}

}
	

