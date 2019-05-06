package com.music.musicweb.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.music.musicweb.model.Supplier;

@Repository("supplierDAO")
@Transactional
public class SupplierDAOImpl implements SupplierDAO {
	
	@Autowired
	
	SessionFactory sessionFactory;

	public boolean addSupplier(Supplier supplier) {
		try
		{
			Session session=sessionFactory.getCurrentSession();
			session.save(supplier);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("New Supplier cannot be saved");
			return false;
		}
	}

	public boolean deleteSupplier(Supplier supplier) {
		
		try
		{
			Session session=sessionFactory.getCurrentSession();
			session.delete(supplier);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Supplier cannot be deleted");
			return false;
		}
	}

	public boolean updateSupplier(Supplier supplier) {
		try
		{
			Session session=sessionFactory.getCurrentSession();
			session.update(supplier);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Supplier cannot be updated");
			return false;
		}
	}

	public Supplier getSupplier(int ID) {
		Session session = sessionFactory.openSession();
		Supplier supplier = (Supplier) session.get(Supplier.class, ID);
		session.close();
		return supplier;
	}

	public List<Supplier> list() {
		try
		{
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Supplier");
		
		List<Supplier> list = (List<Supplier>) query.list();
		session.close();
		
		return list;
		}
		
		catch(Exception e)
		{
			System.out.println("Cannot retrieve supplier list");
			return null;
		}
	}

	public List<Supplier> listSupplierByCategoryID(int categoryID) {
		try
		{
			Session session = sessionFactory.openSession();

			Query query = session.createQuery("from Supplier where CategoryId=:categoryID");
			query.setParameter("categoryID", categoryID);
			List<Supplier> list = (List<Supplier>) query.list();
			session.close();
			return list;


		}
		catch(Exception e)
		{
			System.out.println("Cannot retrieve Suppliers based on Category");
			return null;
		}
	}

}
