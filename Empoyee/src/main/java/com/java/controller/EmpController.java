package com.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.entity.Employee;
import com.java.service.EmpService;
@RestController
@RequestMapping("/api/v1")
public class EmpController {

	@Autowired
	private EmpService empService; 
	
	@PostMapping("/saveEmp")
    public ResponseEntity<String> saveEmployee( @RequestBody Employee employee){
        Integer id = empService.saveEmployee(employee);
        return  new ResponseEntity<String>("empService with '"+id+"' has been saved", HttpStatus.OK);

}
    @GetMapping("/employeeList")
    public ResponseEntity<List<Employee>> getAllEmployeeDetails(){
        List<Employee> list = empService.getAllEmployees();
        return new ResponseEntity<List<Employee>>(list,HttpStatus.OK);
    }
    
    @GetMapping("/getEmployee/{empId}")
    public ResponseEntity<Employee> getEmployeeById( @PathVariable("empId")  Integer empId){
    	Employee std = empService.getEmployye(empId);
        return new ResponseEntity<Employee>(std,HttpStatus.OK);
    }
    @DeleteMapping("deleteEmployee/{empId}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("empId") Integer empId){
    	empService.deleteEmployee(empId);
        return new ResponseEntity<String>("Employee with '"+empId+"' has been deleted",HttpStatus.OK);
    }
}
