package com.sales.controllers;

import java.util.ArrayList;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.sales.models.Customer;
import com.sales.services.CustomerService;

@Controller
public class CustomerController {
	@Autowired
	CustomerService cs;

	// Displaying customers
	@RequestMapping(value = "/showCustomers")
	public String getCustomers(Model m) {
		ArrayList<Customer> customers = (ArrayList<Customer>) cs.getCustomers();
		m.addAttribute("customers", customers);
		return "showCustomers";
	}

	@RequestMapping(value = "/addCustomer", method = RequestMethod.GET)
	public String addCustomerGet(Model m) {
		Customer c = new Customer();
		m.addAttribute("customers", c);
		return "addCustomer";
	}

	@RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
	public String addCustomerPost(@Valid @ModelAttribute("customers") Customer customer, BindingResult result) {
		// Error found
		if (result.hasErrors()) {
			// Don't add customer
			return "addCustomer";
		}
		else {
			// Otherwise add the customer & redirect
			cs.addCustomer(customer);
			return "redirect:/showCustomers";
		}
	}
}
