package com.java.service;

import java.util.List;

import com.java.entity.Employee;

public interface EmpService {

	public Integer saveEmployee(Employee emp);
	public List<Employee> getAllEmployees();
	public Employee getEmployye(Integer empId);
	public void deleteEmployee(Integer empId);
}
