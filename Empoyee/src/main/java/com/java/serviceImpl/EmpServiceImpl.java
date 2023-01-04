package com.java.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.entity.Employee;
import com.java.repository.EmpRepo;
import com.java.service.EmpService;

@Service
public class EmpServiceImpl implements EmpService {
   
	@Autowired 
   private EmpRepo empRepo;
	
	@Override
	public Integer saveEmployee(Employee emp) {
		// TODO Auto-generated method stub
		
		return empRepo.save(emp).getEmpId();
	}


	@Override
	public Employee getEmployye(Integer empId) {
		// TODO Auto-generated method stub
		return empRepo.findById(empId).get();
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return empRepo.findAll();
	}


	@Override
	public void deleteEmployee(Integer empId) {
		// TODO Auto-generated method stub
		empRepo.deleteById(empId);
	}

}
