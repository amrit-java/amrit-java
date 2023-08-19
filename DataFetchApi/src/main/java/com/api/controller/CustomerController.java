package com.api.controller;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.entity.Customer;
import com.api.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerController {
	//localhost:8888/api/customer?city=patna
	@Autowired
	private CustomerService customerService;
	
//	@GetMapping("/{name}")
//	public Customer getCustomer(@PathVariable("name") String name) {
//		
//		return this.customerService.getCustomer(name);
//		
//	}
	
	@GetMapping("/customer")
    public ResponseEntity<List<Customer>> getEntitiesByCustomQuery() throws Exception {
        List<Customer> customer = customerService.getByCustomQuery();
       List<Customer> list=new ArrayList<>();
//        for(Customer obj:customer)
//        {
//        	Customer cust=new Customer();
//        	cust.setCity((String)obj[0]);
//        	//cust.setName((String)obj[1]);
//        	cust.setProduct((String)obj[1]);
//        	list.add(cust);
//        }
        return ResponseEntity.ok(customer);
    }

}
