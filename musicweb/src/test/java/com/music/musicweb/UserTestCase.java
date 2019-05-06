package com.music.musicweb;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.music.musicweb.dao.UserDAO;
import com.music.musicweb.model.User;

public class UserTestCase {

static UserDAO userDAO;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext("com");
		   
		userDAO = (UserDAO) context.getBean("userDAO"); 
	}

	//@Ignore
	@Test
	public void registerUserTest()
	{
		User userdetail = new User();
		userdetail.setEmailid("user1@gmail.com");
		userdetail.setPassword("password");
		userdetail.setRole("User");
		userdetail.setFirstname("user1");
		userdetail.setLastname("user1");;
		
		assertTrue("Problem in Registering UserDetail in Database",userDAO.registerUser(userdetail));
	}
}



