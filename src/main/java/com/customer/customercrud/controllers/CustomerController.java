package com.customer.customercrud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.customer.customercrud.model.Customer;
import com.customer.customercrud.repository.CustomerRepository;

@Controller
public class CustomerController {
	
	@Autowired
	CustomerRepository customerRepository ;
	
	 @RequestMapping("/customer") //mapping URL
	    public String customer(Model model) {
	        model.addAttribute("customers", customerRepository.findAll()); //displaying customer list
	        return "customer";
	    }
	 
	 @RequestMapping("/create")
	    public String create(Model model) {
	        return "create";
	    }
	 
	 @RequestMapping("/save") // getting all parameters and inserting values in DB
	    public String save(@RequestParam String custName, @RequestParam String custAddress, @RequestParam String custEEmail, @RequestParam long custMobile) {
	        Customer customer = new Customer();
	        customer.setCustName(custName);
	        customer.setCustAddress(custAddress);
	        customer.setCustEEmail(custEEmail);
	        customer.setCustMobile(custMobile);
	        customerRepository.save(customer);

	        return "redirect:/show/" + customer.getId();
	    }
	 
	 @RequestMapping("/show/{id}")
	    public String show(@PathVariable String id, Model model) { // showing a particular customer by passing its ID
	        model.addAttribute("customer", customerRepository.findOne(id));
	        return "show";
	    }
	 
	 @RequestMapping("/delete")
	    public String delete(@RequestParam String id) { // deleting customer from DB by passing its ID
		 	Customer customer = customerRepository.findOne(id);
		 	customerRepository.delete(customer);
	      
	        return "redirect:/customer";
	    }
	 
	 @RequestMapping("/edit/{id}")
	    public String edit(@PathVariable String id, Model model) {  // showing customer from DB by passing its ID
	        model.addAttribute("customer", customerRepository.findOne(id));
	        return "edit";
	    }
	 
	 @RequestMapping("/update")
	    public String update(@RequestParam String id, @RequestParam String custName, @RequestParam String custAddress, @RequestParam String custEEmail, @RequestParam long custMobile) {
		// editing customer from DB by passing its ID
	        Customer customer = customerRepository.findOne(id);
	        customer.setCustName(custName);
	        customer.setCustAddress(custAddress);
	        customer.setCustEEmail(custEEmail);
	        customer.setCustMobile(custMobile);
	        customerRepository.save(customer);
	       
	        return "redirect:/show/" + customer.getId();
	    }
}
