package com.leadtorev.RestfullAPI_WithMongoDB.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.leadtorev.RestfullAPI_WithMongoDB.dao.ProductDAO;
import com.leadtorev.RestfullAPI_WithMongoDB.model.Product;
import com.leadtorev.RestfullAPI_WithMongoDB.repositroy.ProductRepository;

@RestController
public class ProductController {

	
	@Autowired
	private ProductDAO dao;

	
	 @PostMapping("/product/addProduct")
	 public Product addProduct(@RequestBody Product product) {
	    Product addedProduct = dao.addProduct(product);
	    return addedProduct;
	 	}
	 
	 
	 @GetMapping("/product/viewAll")
	    public List<Product> viewAllProduct() {
	        return dao.getAllProducts();
	    }
	 
	 
	 @DeleteMapping("/product/deleteProduct/{pID}")
		public String deleteBus(@PathVariable String pID) {
			int deleteStatus=dao.deleteProduct(pID);
			if(deleteStatus>0) {
				return "deleteSuccess";
				}
			else {
				return "deleteFailed";	
	
				}
	 	}
	 @PutMapping("/product/update/{id}")
	    public Product updateProduct(@PathVariable String id, @RequestBody Product product) {
	        return dao.updateProduct(id, product);
	    }
	 
	 @GetMapping("/product/search")
	    public List<Product> searchProducts(@RequestParam(required = false) String name,
	                                        @RequestParam(required = false) String category,
	                                        @RequestParam(required = false) String attributeKey,
	                                        @RequestParam(required = false) String attributeValue) {
	        return dao.searchProducts(name, category, attributeKey, attributeValue);
	    }
}
