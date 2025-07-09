package com.example.customerapi.controller;

import com.example.customerapi.service.CustomerService;
import com.example.customerapi.model.CustomerRelationshipAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer-relationship-accounts")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/getCustomer/{customerId}")
    public CustomerRelationshipAccount getCustomer(@PathVariable String customerId) {
       return customerService.getCustomerById(customerId);
    }

    @GetMapping("/getCustomerAccount/{customerId}")
    public String getCustomerAccount(@PathVariable String customerId) {
        return customerService.getAccountIdByCustomerId(customerId);
    }

    @GetMapping("/getCustomerFromAccountId/{accountId}")
    public CustomerRelationshipAccount getCustomerDetails(@PathVariable String accountId){
        return customerService.getCustomerByAccountId(accountId);
    }
}
