package com.app.dao;

import java.util.List;

import com.app.model.Employee;

public interface IEmployeeDAO {
	public int saveEmployee(Employee e);
	public List<Employee> getAllEmps(int pn,int ps);
	public int getTotalRowsCount();
}
