package com.music.musicweb;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.music.musicweb.dao.SupplierDAO;
import com.music.musicweb.model.Category;
import com.music.musicweb.model.Supplier;
//import com.music.musicweb.model.Supplier;

public class SupplierrTestCase {
	
	static SupplierDAO supplierDAO;

	@BeforeClass
	public static void initalize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext("com");
		supplierDAO=(SupplierDAO)context.getBean("supplierDAO");
	}
	//@Ignore
	@Test
	public void insertSupplier()
	{
		
		Supplier supplier=new Supplier();
		
		supplier.setSuppliername("HMV");
		supplier.setSupplerstock(15);
		supplier.setCategoryid(2);
		assertEquals("Cannot Insert data",true,supplierDAO.addSupplier(supplier));
	}
	//@Ignore
	@Test
	public void listSuppliers()
	{
		List<Supplier> list  =   supplierDAO.list();
		assertTrue("Problem in Listing suppliers from DataBase",list.size()>0);
		
		for(Supplier supplier:list)
		{
			System.out.print(supplier.getSupplierid()+ "   ");
			System.out.print(supplier.getSuppliername()+ "   ");
			System.out.println(supplier.getCategoryid()+" "+supplier.getSupplerstock());
			
		}
	}
	
	//@Ignore
		@Test
		public void listSuppliersByCategory()
		{
			List<Supplier> list  =   supplierDAO.listSupplierByCategoryID(2);
			assertTrue("Problem in Listing suppliers from DataBase",list.size()>0);
			
			for(Supplier suppliers:list)
			{
				System.out.print(suppliers.getSupplierid()+ "   ");
				System.out.print(suppliers.getSuppliername()+ "   ");
				System.out.println(suppliers.getCategoryid()+" "+suppliers.getSupplerstock());
				
			}
		}
		@Ignore
		@Test
		public void deleteSupplierTest()
		{
			Supplier supplier = supplierDAO.getSupplier(33);
			
			assertTrue("Problem in Deleting Supplier to the DataBase",supplierDAO.deleteSupplier(supplier));

		}
		
}



