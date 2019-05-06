package com.music.musicweb;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.music.musicweb.dao.CategoryDAO;
import com.music.musicweb.dao.ProductDAO;
import com.music.musicweb.dao.SupplierDAO;
import com.music.musicweb.model.Category;
import com.music.musicweb.model.Product;
import com.music.musicweb.model.Supplier;

public class ProductTestCase {

static ProductDAO productDAO;
static CategoryDAO categoryDAO;
static SupplierDAO supplierDAO;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com");
		
		productDAO = (ProductDAO) context.getBean("productDAO");
		categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
		supplierDAO=(SupplierDAO)context.getBean("supplierDAO");
	}
	//@Ignore
	@Test
	public void addProduct()
	{
		Product product=new Product();
		product.setProductName("VideoCDs");
		product.setProductDesc("Music");
		product.setPrice(1200);
		product.setStock(30);
		Category category=categoryDAO.getCategory(2);
		product.setCategory(category);
		
		assertTrue("Problem in adding Product to Database",productDAO.addProduct(product));
	}
	@Ignore
	@Test
	public void updateProductTest()
	{
		Product product = productDAO.getProduct(1);
		Category category=categoryDAO.getCategory(1);
		product.setProductDesc("Classical Music");
		product.setCategory(category);
	
		assertTrue("Problem in updating Product to Database",productDAO.updateProduct(product));
		
	}
	@Ignore
	@Test
	public void deleteProductTest()
	{
		Product product = productDAO.getProduct(3);
		
		assertTrue("Problem in deleting Product from Database",productDAO.deleteProduct(product));
		
	}
}





