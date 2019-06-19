package com.app.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.app.dao.IEmployeeDAO;
import com.app.model.Employee;
import com.app.util.HibernateUtil;

public class EmployeeDAOImpl implements IEmployeeDAO {
	@Override
	public int saveEmployee(Employee e) {
		Transaction tx=null;
		try(Session ses=HibernateUtil.getSessionFactory().openSession()){
			tx=ses.beginTransaction();
			ses.save(e);
			tx.commit();
		}
		catch(Exception ex) {
			ex.printStackTrace();
			tx.rollback();
		}
		return e.getEmpId();
	}
	@Override
	public List<Employee> getAllEmps(int pn,int ps){
		List<Employee> emps=null;
		try(Session ses=HibernateUtil.getSessionFactory().openSession()){
			String hql="from "+Employee.class.getName();
			Query q=ses.createQuery(hql);
			q.setFirstResult((pn-1)*ps);
			q.setMaxResults(ps);
			emps=q.list();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return emps;
	}
	@Override
	public int getTotalRowsCount() {
		int rowCount=0;
		try(Session ses=HibernateUtil.getSessionFactory().openSession()){
			String hql="select count(empId) from com.app.model.Employee";
			Query q=ses.createQuery(hql);
			long count=(long)q.uniqueResult();
			rowCount=(int)count;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return rowCount;
	}
}
