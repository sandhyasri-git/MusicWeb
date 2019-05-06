package com.music.musicweb.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.music.musicweb.model.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	public boolean insertCategory(Category category) {
		try
		{
			Session session=sessionFactory.getCurrentSession();
			session.save(category);
			System.out.println("New Category added");
			return true;
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return false;
		}
		
	}

	public boolean updateCategory(Category category) {
		
		try
		{
			Session session=sessionFactory.getCurrentSession();
			session.update(category);
			System.out.println(" Category updated");
			return true;
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean deleteCategory(Category category) {
		
		try
		{
			Session session=sessionFactory.getCurrentSession();
			session.delete(category);
			System.out.println(" Category deleted");
			return true;
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return false;
		}
	}

	public Category getCategory(int categoryid) {
		Session session=sessionFactory.openSession();
		Category category=(Category)session.get(Category.class, categoryid);
		session.close();
		return category;
	}

	public List<Category> getCategories() {
		try
		{
			Session session=sessionFactory.openSession();
			Query query=session.createQuery("From Category");
			List<Category>list=query.list();
			session.close();
			return list;
		}
		catch(Exception e)
		{
			System.out.println("Cannot retrieve list");
			return null;
		}
	}

}
