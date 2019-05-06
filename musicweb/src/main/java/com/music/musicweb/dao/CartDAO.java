package com.music.musicweb.dao;

import java.util.List;

import com.music.musicweb.model.Cart;

public interface CartDAO {
	
	public boolean addCartItem(Cart cartItem);
	public boolean deleteCartItem(Cart cartItem);
	public boolean updateCartItem(Cart cartItem);
	public Cart getCartItem(int cartItemId);
	public List<Cart> listCartItems(String username);

}
