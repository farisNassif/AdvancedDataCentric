package com.sales.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sales.models.Customer;
import com.sales.repositories.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	CustomerRepository cr;

	public Iterable<Customer> getCustomers(){
		return cr.findAll();
	}
	public void addCustomer(Customer c){
		cr.save(c);
	}
	public Customer findCustomer(Long cid){
		return cr.findOne(cid);	
	}	
}
