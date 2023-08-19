package com.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.api.entity.Customer;
public interface CustomerRepository extends JpaRepository<Customer, String> {
	
	@Query(value = "select city,product from customer ", nativeQuery = true)
    List<Customer> findByCustomQuery();

	Optional<Customer> findByCity(String city);

}
 