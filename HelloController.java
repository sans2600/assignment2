/*
 * 1)Develop an application using SpringMVC.
try to read employee Information(empno,name,designation,sal ..etc) from the keyboard
and display on webpage
 */

package com.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController 
{
	public Connection getConnection()throws Exception 
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/globallogic", "root", "root");
		
		return con;
	}

	String query = "";
	
	@RequestMapping("/hello")
	  public String display(@RequestParam("empno") String empno,@RequestParam("name") String name,@RequestParam("designation") String designation,@RequestParam("sal") String sal, Model m) throws SQLException, Exception
	  {
		query = "insert into employee2 values(?,?,?,?)";
		
		PreparedStatement ps = getConnection().prepareStatement(query);

		ps.setString(1, empno);
		ps.setString(2, name);
		ps.setString(3, designation);
		ps.setString(4, sal);
		ps.execute();
		
		System.out.println("Sucessfull");
		
		String msg = "EmpNo : " + empno + "Name : " + name + "Designation : " + designation + "Salary : " + sal;
		m.addAttribute("message",msg);
		return "viewpage";
	  }
}
