package com.exm.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exm.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
//Employee: The first generic parameter specifies the entity type that the repository deals with, in this case, Employee.
	//Integer: The second generic parameter specifies the type of the primary key of the Employee entity. In this case, it's Integer
}
