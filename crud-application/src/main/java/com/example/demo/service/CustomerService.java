package com.example.demo.service;

import com.example.demo.customer.Customer;
import com.example.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<Customer>();
        customerRepository.findAll().forEach(customer -> customers.add(customer));
        return customers;
    }

    public Customer getCustomerById(int id){
        return customerRepository.findById(id).get();
    }

    public void saveOrUpdate(Customer customer){
        customerRepository.save(customer);
    }

    public void delete(int id){
        customerRepository.deleteById(id);
    }
}
