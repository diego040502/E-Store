package com.estore.estore.controllers;

import com.estore.estore.models.CustomerModel;
import com.estore.estore.models.ProductModel;
import com.estore.estore.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping(path = "/customers")
    public ArrayList<CustomerModel> getCustomers(){
        return customerService.getCustomers();
    }

    @PostMapping(path = "/new")
    public CustomerModel saveCustomer(@RequestBody CustomerModel customer){
        return customerService.saveCustomer(customer);
    }

    @GetMapping(path = "/get/{id}")
    public Optional<CustomerModel> getById(@PathVariable("id") Integer id){
        return customerService.getById(id);
    }

    @PutMapping(path = "/{id}")
    public CustomerModel updateById(@RequestBody CustomerModel request ,@PathVariable("id") Integer id){
        return customerService.updateById(request, id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id") Integer id){
        boolean ok = this.customerService.deleteById(id);

        if(ok){
            return "The customer with id" + id + "has been deleted";
        }else{
            return "The customer with id" + id + "doesn't exist";
        }
    }

}
