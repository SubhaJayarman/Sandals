package com.niit.dao;

import java.util.List;

import com.niit.model.Category;
import com.niit.model.Product;

public interface ProductDao {
	boolean saveProduct(Product product);
	boolean deleteProduct(int id);
	boolean updateProduct(Product product);
	Product getId(int id);
	public List<Product> getAllProduct();
	List<Category> getAllCategories();
}
