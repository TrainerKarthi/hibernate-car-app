package com.ty.car;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;



public class TestGetUserByEmailandPassword {
	
	

	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		String sql = "SELECT u FROM User u WHERE u.name =?1 AND u.password = ?2";
		
	Query query = entityManager.createQuery(sql);//Hibernate takes the query and this method returns the query object
	
	query.setParameter(1, "karthik");//here for the  ?1 we give the values
	query.setParameter(2, "ghjk");//here for the  ?2 we give the values
	
	List<User> users = query.getResultList();
	
	if (users.size()>0)
	{
		User user = users.get(0);
		System.out.println(user.getName());
		System.out.println(user.getGender());
		System.out.println(user.getPassword());
	} else {
		System.out.println("No user found");
	}
		
	}

}
