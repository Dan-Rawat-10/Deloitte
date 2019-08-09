package com.deloitte.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {


@RequestMapping("/customer")
public ModelAndView addCustomer(Customer customer) {
	
	CustomerDAO cd = new CustomerDOAImpl();
	if(cd.insertCustomer(customer)){
		System.out.println("Customer Added");
	}
	
	return new ModelAndView("success", "cust", customer);
}

@RequestMapping("/update")
public ModelAndView updatecustomer(Customer customer) {
	CustomerDAO cd = new CustomerDOAImpl();
	cd.updateCustomer(customer);
	return new ModelAndView("success", "cust", customer);
}

@RequestMapping("/addCustomer")
public ModelAndView updatecustomer() {
	return new ModelAndView("CustomerDetailsById", "command", new Customer());
}

}
