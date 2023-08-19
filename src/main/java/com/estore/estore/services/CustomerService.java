package com.estore.estore.services;

import com.estore.estore.models.CustomerModel;
import com.estore.estore.repositories.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    ICustomerRepository customerRepository;

    //Get customers
    public ArrayList<CustomerModel> getCustomers(){
        return (ArrayList<CustomerModel>) customerRepository.findAll();
    }

    //Register customer
    public CustomerModel saveCustomer(CustomerModel customer){
        return (CustomerModel) customerRepository.save(customer);
    }

    //Get customer by id
    public Optional<CustomerModel> getById(Integer id){
        return customerRepository.findById((id));
    }

    //Update customer
    public CustomerModel updateById(CustomerModel request,Integer id){
        CustomerModel customer = (CustomerModel)customerRepository.findById(id).get();

        customer.setFirst_name(request.getFirst_name());
        customer.setSurname(request.getSurname());
        customer.setEmail(request.getEmail());
        customer.setAddress(request.getAddress());
        customer.setPhone(request.getPhone());

        return customer;
    }

    //Delete customer
    public boolean deleteById(Integer id){
        try{
            customerRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
