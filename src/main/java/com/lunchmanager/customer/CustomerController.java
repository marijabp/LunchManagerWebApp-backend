package com.lunchmanager.customer;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CustomerController {
	
	@Autowired 
	private CustomerService customerService;
	
	@RequestMapping(value="/customers")
	public List<Customer> getAllCustomers() {
		return customerService.getAllCustomers();
	}
	
	@RequestMapping("/customer/{id}")
	public Optional<Customer> getCustomerById(@PathVariable Long id) {
		return customerService.getCustomerById(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/updatecustomer/{id}")
	public void updateCustomerData(@RequestBody Customer customer, @PathVariable Long id) {
		customerService.updateCustomer(customer);
	}

}
