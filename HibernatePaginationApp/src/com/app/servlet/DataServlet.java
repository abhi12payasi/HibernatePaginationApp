package com.app.servlet; 
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.dao.IEmployeeDAO;
import com.app.dao.impl.EmployeeDAOImpl;
import com.app.model.Employee; 

@WebServlet("/data")
public class DataServlet extends HttpServlet {
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		IEmployeeDAO dao=new EmployeeDAOImpl();
		int tr=dao.getTotalRowsCount();
		System.out.println(tr);
		int ps=8;
		int np=tr/ps+(tr%ps>0?1:0);
		System.out.println(np);
		int pn=1;
		String pns=request.getParameter("pn");
		if(pns!=null && !"".equals(pns.trim())) {
			pn=Integer.parseInt(pns);
		}
		List<Employee> emps=dao.getAllEmps(pn,ps);
		request.setAttribute("emps", emps);
		request.setAttribute("nps", np);
		request.getRequestDispatcher("Data.jsp").include(request, response);
	}
}
