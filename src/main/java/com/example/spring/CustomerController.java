package com.example.spring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @Autowired
    private CustomerRepository repository;

    @GetMapping("/")
    public Iterable<Customer> listCustomers() {

        return repository.findAll();
    }

    @PostMapping("/")
    public @ResponseBody String addCustomer(@RequestParam String firstName, @RequestParam String lastName) {
        Customer customer = new Customer();

        customer.setFirstname(firstName);
        customer.setLastname(lastName);

        repository.save(customer);

        return "saved";
    }
}
