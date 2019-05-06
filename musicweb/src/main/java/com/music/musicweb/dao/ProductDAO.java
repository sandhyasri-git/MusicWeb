package com.music.musicweb.dao;

import java.util.List;

import com.music.musicweb.model.Product;

public interface ProductDAO {
	
public boolean addProduct(Product product);
	
	public boolean updateProduct(Product product);
	
	public boolean deleteProduct(Product product);
	
	public Product getProduct(int productID);
	
	public List<Product> getProductsByCategoryID(int categoryID);
	public List<Product> listProducts();

}
