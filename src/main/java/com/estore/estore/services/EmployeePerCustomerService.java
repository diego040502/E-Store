package com.estore.estore.services;

import com.estore.estore.repositories.IEmployeePerCustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeePerCustomerService {

    @Autowired
    IEmployeePerCustomerRepository employeePerCustomerRepository;

    public List<com.estore.estore.models.EmployeePerCustomerModel> getEmployeesPerCustomer(){
        return employeePerCustomerRepository.findAll();
    }

}
