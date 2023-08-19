package com.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.entity.Customer;
import com.api.repository.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository Repo;

//	}
	 public List<Customer> getByCustomQuery() throws Exception {
	      
		 return Repo.findByCustomQuery();
	 }

}
