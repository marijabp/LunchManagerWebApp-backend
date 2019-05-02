package com.lunchmanager.customer;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, String> {
	
	public Optional<Customer> findCustomerById(Long id);

}
