package com.music.musicweb.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.music.musicweb.model.SaveForLater;
@Repository("saveDAO")
@Transactional
public class SaveDAOImpl implements SaveForLaterDAO {

	@Autowired
	SessionFactory sessionFactory;
	public boolean addSavedItem(SaveForLater savedItem) {
		try
		{
			sessionFactory.getCurrentSession().saveOrUpdate(savedItem);
			return true;
		}
		
		catch(Exception e)
		{
			System.out.println(e);
			return false;

		}
	}

	public SaveForLater getSavedItem(int savedItemId) {
		try
		{
		   Session session = sessionFactory.openSession();
		   SaveForLater savedItem = (SaveForLater) session.get(SaveForLater.class,savedItemId);
		   session.close();
		   return savedItem;
		}
		
		catch(Exception e)
		{
			return null;

		}
	}

	public boolean deleteSavedItem(SaveForLater savedItem) {
		try
		{
			sessionFactory.getCurrentSession().delete(savedItem);
			return true;
		}
		
		catch(Exception e)
		{
			return false;

		}
	}

	public List<SaveForLater> savedItemsList(String username) {
		try
		{
		   Session session = sessionFactory.openSession();
		   Query query = session.createQuery("from SaveForLater where username=:userName");
		   query.setParameter("userName", username);
		   List<SaveForLater> savedItemsList = (List<SaveForLater>) query.list();
		   session.close();
		   return savedItemsList;
		}
		
		catch(Exception e)
		{
			return null;

		}
	}

}
