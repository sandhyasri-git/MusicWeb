package com.music.musicweb;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.music.musicweb.dao.CartDAO;
import com.music.musicweb.model.Cart;
import com.music.musicweb.model.Category;

public class CartTestCase {

	static CartDAO cartDAO;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext("com");
		cartDAO=(CartDAO)context.getBean("cartDAO");
	}
	@Test
	public void addCart()
	{
		Cart cart=new Cart();
		cart.setOrderId(1);
		cart.setPrice(1000);
		cart.setProductId(1);
		cart.setProductName("CDS");
		cart.setQuantity(2);
		cart.setStatus("P");
		cart.setUsername("user1");
		assertEquals("New cart cannot be created",true,cartDAO.addCartItem(cart));
		
	}
	  @Test
	   public void listCartItemsTest()
	   {
		List<Cart> listCart  =   cartDAO.listCartItems("user1");
		assertTrue("Problem in Listing Cart Items from DataBase",listCart.size()>0);
		
		for(Cart cart:listCart)
		{
			System.out.print(cart.getProductName()+ "   ");
			System.out.print(cart.getUsername()+ "   ");
			System.out.println(cart.getStatus()+" "+cart.getOrderId());
			
		}
	   
	   }
}












