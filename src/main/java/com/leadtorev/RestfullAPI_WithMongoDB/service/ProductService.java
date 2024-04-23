package com.leadtorev.RestfullAPI_WithMongoDB.service;

import java.util.List;


import com.leadtorev.RestfullAPI_WithMongoDB.model.Product;

public interface ProductService {

	public Product addProduct(Product product);
	public List<Product> getAllProducts();
	public Product updateProduct(String id, Product product);
	public int deleteProduct(String id);
	public List<Product> searchProducts(String name, String category, String attributeKey, String attributeValue);
	
}
