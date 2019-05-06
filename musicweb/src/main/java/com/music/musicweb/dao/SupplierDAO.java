package com.music.musicweb.dao;

import java.util.List;

import com.music.musicweb.model.Supplier;

public interface SupplierDAO {
	
public boolean addSupplier(Supplier supplier);
	
	public boolean deleteSupplier(Supplier supplier);
	
	public boolean updateSupplier(Supplier supplier);
	
	public Supplier getSupplier(int ID);
	
	public List<Supplier> list();
	
		
	public List<Supplier> listSupplierByCategoryID(int categoryID);


}
