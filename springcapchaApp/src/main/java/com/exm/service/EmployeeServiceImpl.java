package com.exm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exm.model.Employee;
import com.exm.repo.EmployeeRepository;



@Service
public class EmployeeServiceImpl implements IEmployeeService {
	@Autowired
	private EmployeeRepository repo;

	@Override
	public void createEmployee(Employee employee) {//This method takes an Employee object as a parameter, representing the employee data that needs to be persisted.
		repo.save(employee);// This line uses a repository  to save the Employee object to the database.
	}
	
	@Override
	public List<Employee> getAllEmployees() {//This method is declared to return a list of Employee objects.
		return repo.findAll();//This line uses a repository (usually extending JpaRepository or a similar interface provided by Spring Data JPA) to fetch all employee records from the database.
		//findAll method retrieves all records of the specified entity (in this case, the Employee entity) from the database and returns them as a list.
	}

	@Override
	public Optional<Employee> getOneEmployee(Integer id) {//This method is declared to return an Optional wrapping an Employee object. The method takes an id parameter, which represents the unique identifier of the employee you want to retrieve.
		return repo.findById(id);// This line uses a repository  to retrieve an employee record from the database based on the provided id.
		//findById method searches for an entity with the specified ID.
		//
		
	}

	
}