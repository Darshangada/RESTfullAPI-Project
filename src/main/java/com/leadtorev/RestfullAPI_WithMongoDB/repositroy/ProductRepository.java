package com.leadtorev.RestfullAPI_WithMongoDB.repositroy;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.leadtorev.RestfullAPI_WithMongoDB.model.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

	 List<Product> findByNameContainingAndCategoriesContainingAndAttributesKeyAndAttributesValue(
	            String name, String category, String attributeKey, String attributeValue);
}
