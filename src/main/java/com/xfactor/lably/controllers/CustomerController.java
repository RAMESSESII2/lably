package com.xfactor.lably.controllers;

import java.util.List;

import com.xfactor.lably.entity.Customer;
import com.xfactor.lably.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerRepository custRepo;

    @GetMapping()
    public String helloCustomer(){
        return "Welcome to the Customer's page.";
    }
    
    @PostMapping("/addCustomer")
    public Customer addCustomer(@RequestBody Customer c ){
        Customer pc = custRepo.save(c);
        return pc;
    }

    @GetMapping("/showCustomers")
    public List<Customer> showCustomer(){
        List<Customer> customer =  custRepo.findAll();
        return customer;
    }

    @GetMapping("/findCustomer")
    public Customer find(@RequestParam String name){
        List<Customer> customers = custRepo.findAll();
        for( Customer x: customers){
            if( x.getName().equalsIgnoreCase(name)){
                return x;
            }
        }
        return null;
    }
    
}
