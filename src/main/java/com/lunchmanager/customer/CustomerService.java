package com.lunchmanager.customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	public List<Customer> getAllCustomers(){
		List <Customer> customers=new ArrayList<>();
		customerRepository.findAll().forEach(customers::add);
		return customers;
	}
	
	public void addCustomer(Customer customer) {
		customerRepository.save(customer);
	}
	
	public void updateCustomer(Customer customer) {
		customerRepository.save(customer);
	}

	public Optional<Customer> getCustomerById(Long id) {
		return customerRepository.findCustomerById(id);
	}
}
