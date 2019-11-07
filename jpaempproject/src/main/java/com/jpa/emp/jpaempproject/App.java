package com.jpa.emp.jpaempproject;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



public class App {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("per");
		EntityManager em= emf.createEntityManager();
		
		System.out.println("Starting Transaction");
		em.getTransaction().begin();
		Employee emp=new Employee();
		emp.setEmpName("Jas");
		emp.setBranch("Chennai");
		System.out.println("Saving Employee to database");
		
		em.persist(emp);
		em.getTransaction().commit();
		System.out.println("Generated Employee ID ="+emp.getId());

		//getting object using primary key
		Employee emp1 = em.find(Employee.class, emp.getId());
		System.out.println("got object "+emp1.getEmpName()+" " +emp.getId());
		
		//getting all objects from employee table
		@SuppressWarnings("unchecked")
		List<Employee> listemp = em.createQuery("Select e From  Employee e").getResultList(); //employee e is class not table
		
		if(listemp==null)
		{
			System.out.println("No employee found. ");
		}
		else{
			for(Employee emp2:listemp){
				System.out.println("Employee name = "+emp2.getEmpName()+", Employee Branch ="+emp2.getBranch()+", Employee ID = "+emp2.getId());
				}
		}
		em.close();
		emf.close();
	}

}

