package com.estore.estore.services;

import com.estore.estore.models.EmployeeModel;
import com.estore.estore.repositories.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    IEmployeeRepository employeeRepository;

    public ArrayList<EmployeeModel> getEmployees(){
        return (ArrayList<EmployeeModel>) employeeRepository.findAll();
    }

    public EmployeeModel saveEmployee(EmployeeModel employee){
        return employeeRepository.save(employee);
    }

    public Optional<EmployeeModel> getById(Integer id){
        return employeeRepository.findById(id);
    }

    public EmployeeModel updateById(EmployeeModel request, Integer id){
        EmployeeModel emp = employeeRepository.findById(id).get();

        emp.setFirst_name(request.getFirst_name());
        emp.setSurname(request.getSurname());
        emp.setEmail(request.getEmail());
        emp.setPhone(request.getPhone());

        return emp;
    }

    public boolean deleteById(Integer id){
        try{
            employeeRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

}
