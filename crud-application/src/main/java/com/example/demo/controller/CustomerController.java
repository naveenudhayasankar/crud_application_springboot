package com.example.demo.controller;

import com.example.demo.customer.Customer;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping("/customer")
    private List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/customer/{customerId}")
    private Customer getCustomer(@PathVariable("customerId") int customerId){
        return customerService.getCustomerById(customerId);
    }

    @DeleteMapping("/customer/{customerId}")
    private void deleteCustomer(@PathVariable("customerId") int customerId){
        customerService.delete(customerId);
    }

    @PostMapping("/customer")
    private long saveCustomer(@RequestBody Customer customer){
        customerService.saveOrUpdate(customer);
        return customer.getId();
    }

}

