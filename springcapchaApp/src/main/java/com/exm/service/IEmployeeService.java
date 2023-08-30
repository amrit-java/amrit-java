package com.exm.service;

import java.util.List;
import java.util.Optional;

import com.exm.model.Employee;

public interface IEmployeeService {
	
	void createEmployee(Employee employee);
	
	List<Employee> getAllEmployees();
	//List<Employee>: This is the return type of the method. It indicates that the method will return a list of objects of type Employee.
	
	Optional<Employee> getOneEmployee(Integer id);
	
	//Optional<Employee>: This is the return type of the method. It indicates that the method will return an Optional wrapping an object of type Employee.


}
