package com.greatlearning.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.dao.CustomerRepository;
import com.greatlearning.entity.Customer;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository customerRepository;

	public void addCustomer(Customer customer) {
		Customer customer2 = null;
		try {
			customer2 = customerRepository.save(customer);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteCustomer(int id) {
		customerRepository.deleteById(id);
	}

	public Customer getCustomerDetailsById(int id) {
		Customer customer = null;
		try {
			customer = customerRepository.getById();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customer;
	}

	public Customer updateCustomerDetailsById(int id, Customer customer) {
		Customer customer1 = null;
		customer1 = customerRepository.save(customer);
		return customer1;
	}

	public List<Customer> getAllCustomerDetails() {
		List<Customer> customerList = null;
		try {
			customerList = (List<Customer>) customerRepository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customerList;
	}

}
