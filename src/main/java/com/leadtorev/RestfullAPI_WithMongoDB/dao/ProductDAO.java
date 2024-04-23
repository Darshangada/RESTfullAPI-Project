package com.leadtorev.RestfullAPI_WithMongoDB.dao;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leadtorev.RestfullAPI_WithMongoDB.model.Product;
import com.leadtorev.RestfullAPI_WithMongoDB.repositroy.ProductRepository;
import com.leadtorev.RestfullAPI_WithMongoDB.service.ProductService;

@Service
public class ProductDAO implements ProductService {
	
	@Autowired
	private ProductRepository repository;

	@Override
	public Product addProduct(Product product) {
		// TODO Auto-generated method stub
		return repository.save(product);
	}

	
	public List<Product> getAllProducts() {
        List<Product> list = repository.findAll();
        return list;
    }

	@Override
	public Product updateProduct(String id, Product product) {
		 Product existingProduct = repository.findById(id).orElse(null);
	        if (existingProduct != null) {
	            product.setId(id);
	            return repository.save(product);
	        }
	        return null;
	}

	@Override
	public int deleteProduct(String id) {	
		repository.deleteById(id);
		return 1;
	}

	@Override
	 public List<Product> searchProducts(String name, String category, String attributeKey, String attributeValue) {
        return repository.findByNameContainingAndCategoriesContainingAndAttributesKeyAndAttributesValue(
                name, category, attributeKey, attributeValue);
    }

	
}
