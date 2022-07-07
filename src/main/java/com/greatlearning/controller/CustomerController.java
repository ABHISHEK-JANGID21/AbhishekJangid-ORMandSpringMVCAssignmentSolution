package com.greatlearning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.entity.Customer;
import com.greatlearning.service.CustomerService;

@RestController
@RequestMapping("/web-customer-track2")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping("/getAll")
	public List<Customer> getAll() {
		List<Customer> customerList = customerService.getAllCustomerDetails();
		return customerList;
	}

	@PostMapping("/add")
	public void addNewCustomer(@RequestBody Customer customer) {
		customerService.addCustomer(customer);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteCustomerById(@PathVariable(value = "id") int id) {
		customerService.deleteCustomer(id);

	}

	@GetMapping("/get/{id}")
	public Customer getCustomerById(@PathVariable(value = "id") int id) {
		Customer customer = customerService.getCustomerDetailsById(id);
		return customer;

	}

	@PutMapping("/update/{id}")
	public Customer updateCustomerDetailsById(@PathVariable(value = "id") int id, @RequestBody Customer customer) {
		Customer customer2 = customerService.updateCustomerDetailsById(id, customer);
		return customer2;
	}
}
