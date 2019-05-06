package com.music.musicweb.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.music.musicweb.model.User;

@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	public boolean registerUser(User userdetail)
	{
		try
		{
			Session session = sessionFactory.getCurrentSession();
			session.save(userdetail);
			return true;
		}
		
		catch(Exception e)
		{
			return false;
		}
	}

	public boolean updateUser(User userdetail)
	{
		try
		{
			Session session = sessionFactory.getCurrentSession();
			session.update(userdetail);
			return true;
		}
		
		catch(Exception e)
		{
			return false;
		}
	}

	
	public User getUser(String username) 
	{
		Session session = sessionFactory.openSession();
		User userdetail = session.get(User.class,username);
		session.close();
		return userdetail;
		
	}

}
