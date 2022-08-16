/*
 * 2)Develop an application using JPA try to insert employee Information
 * (empno,name,designation,sal ..etc) 
	into database and also fetch all the data from the database then display on console

 */

package com.java.jpa_assesment.employee;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.mysql.cj.Query;

public class EmployeeInsert {

	public static void main(String[] args) 
	{
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("Employee_details");
	    EntityManager em=emf.createEntityManager();
		
	    //insert data
	    
	    em.getTransaction().begin();
	    EmployeeEntity e1 = new EmployeeEntity();
	    e1.setEmpno(101);
	    e1.setName("Sanskruti");
	    e1.setDesignation("Manager");
	    e1.setSal(40000);
	    
	    EmployeeEntity e2 = new EmployeeEntity();
	    e2.setEmpno(102);
	    e2.setName("Shruti");
	    e2.setDesignation("Senior Project Manager");
	    e2.setSal(70000);
	    
	    em.persist(e1);
	    em.persist(e2);
	    
	    em.getTransaction().commit();
	    
	    em.getTransaction().begin();
	    CriteriaBuilder cb = em.getCriteriaBuilder();
	    CriteriaQuery<EmployeeEntity> cq = cb.createQuery(EmployeeEntity.class);
	    
	    Root<EmployeeEntity> emp = cq.from(EmployeeEntity.class);
	    
	    cq.multiselect(emp.get("empno"),emp.get("name"),emp.get("designation"),emp.get("sal"));
	    
	    CriteriaQuery<EmployeeEntity> select = cq.select(emp);
	    TypedQuery<EmployeeEntity> q = em.createQuery(select);
//	    Query q = (Query) em.createQuery("select * from employee1");
	    
	    List <EmployeeEntity> list= q.getResultList();
	    
	    System.out.print("empno\t");
	    System.out.print("name\t");
	    System.out.print("designstion\t");
	    System.out.print("sal\t\n");
	    
	    for(EmployeeEntity e :list)
	    {
	    	System.out.print(e.getEmpno() + "\t");
	    	System.out.print(e.getName() +"\t");
	    	System.out.print(e.getDesignation() + "\t");
	    	System.out.print(e.getSal() + "\t\n");
	    }
	    
	    em.getTransaction().commit();
	    em.close();
	    emf.close();

	}

}
