package com.estore.estore.controllers;

import com.estore.estore.models.EmployeePerCustomerModel;
import com.estore.estore.services.EmployeePerCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee-per-customer")
public class EmployeePerCustomerController {

    @Autowired
    EmployeePerCustomerService employeePerCustomerService;

    public List<EmployeePerCustomerModel> getEmployees(){
        return employeePerCustomerService.getEmployeesPerCustomer();
    }

}
