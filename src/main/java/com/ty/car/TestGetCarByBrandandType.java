package com.ty.car;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class TestGetCarByBrandandType {

	public static void main(String[] args)
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Query query = entityManager.createQuery("Select c FROM Car c WHERE c.brand = ?1 AND c.type =?2");
		
		query.setParameter(1, "maruthi");
		query.setParameter(2, "Hachback");
		
		List<Car> cars = query.getResultList();
		
		if (cars.size() >0)
		{
			for (Car car : cars) {
				System.out.println(car.getName());
				System.out.println(car.getBrand());
				System.out.println(car.getCost());
				System.out.println(car.getId());
				System.out.println(car.getType());
			}
		}
		else
		{
			System.out.println("no cars found");
		}
		
		
	}

}
