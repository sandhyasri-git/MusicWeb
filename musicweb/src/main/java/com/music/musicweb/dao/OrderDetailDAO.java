package com.music.musicweb.dao;

import com.music.musicweb.model.OrderDetail;

public interface OrderDetailDAO {
	
	public boolean paymentProcess(OrderDetail order);
	public boolean updateCartItemStatus(String username,int orderId);

}
