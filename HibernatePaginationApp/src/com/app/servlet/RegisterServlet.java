package com.app.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.dao.IEmployeeDAO;
import com.app.dao.impl.EmployeeDAOImpl;
import com.app.model.Employee;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String eid=request.getParameter("eid");
		String empName=request.getParameter("ename");
		String esal=request.getParameter("esal");
		String empDept=request.getParameter("edept");
		
		int empId=Integer.parseInt(eid);
		double empSal=Double.parseDouble(esal);
		
		Employee e=new Employee(empId, empName, empSal, empDept);
 	    IEmployeeDAO dao=new EmployeeDAOImpl();
		int count=dao.saveEmployee(e);
		 
		 String msg="Employee "+count+"added successfully!\n"+e;
		 request.setAttribute("msg",msg);
		 request.getRequestDispatcher("register.jsp").forward(request, response);
	}

}
