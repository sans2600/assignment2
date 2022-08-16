/*
 * 2)Develop an application using JPA try to insert employee Information
 * (empno,name,designation,sal ..etc) 
	into database and also fetch all the data from the database then display on console

 */

package com.java.jpa_assesment.employee;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table(name="employee1")

public class EmployeeEntity 
{
	@Id
	private int empno;
	private String name;
	private String designation;
	private double sal;
	
	public EmployeeEntity(int empno, String name, String desgination, double sal)
	{
		super();
		this.empno = empno;
		this.name = name;
		this.designation = designation;
		this.sal = sal;
	}
	
	public EmployeeEntity()
	{
		super();
	}

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public double getSal() {
		return sal;
	}

	public void setSal(double sal) {
		this.sal = sal;
	}
	
	

	
	

}
