package com.example.spring;

import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @Autowired
    private CustomerRepository repository;

    @GetMapping("/")
    public ResponseEntity<List<Customer>> listCustomers() {
        var customers = repository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(customers);
    }

    @PostMapping("/")
    public @ResponseBody String addCustomer(@RequestBody CustomerDTO customer) {
        Customer newCustomer = new Customer(customer);

        repository.save(newCustomer);

        return "saved";
    }
}
