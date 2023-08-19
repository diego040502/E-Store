package com.estore.estore.controllers;

import com.estore.estore.models.EmployeeModel;
import com.estore.estore.models.RoleModel;
import com.estore.estore.services.EmployeeService;
import com.estore.estore.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    RoleService roleService;

    @GetMapping("/employees")
    public ArrayList<EmployeeModel> getEmployees(){
        return employeeService.getEmployees();
    }

    @GetMapping("/roles")
    public List<RoleModel> getAllRoles(){
        return roleService.getRoles();
    }

    @PostMapping("/new")
    public EmployeeModel saveEmployee(@RequestBody EmployeeModel emp){
        return employeeService.saveEmployee(emp);
    }

    /*@GetMapping(path = "/{id}")
    public Optional<EmployeeModel> getById(@PathVariable("id") Integer id){
        return employeeService.getById(id);
    }*/

    @PutMapping(path = "/{id}")
    public EmployeeModel updateById(@RequestBody EmployeeModel request, @PathVariable("id") Integer id){
        return employeeService.updateById(request, id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id") Integer id){
        boolean ok = employeeService.deleteById(id);

        if(ok){
            return "This employee with id" + id + "has been deleted";
        }else{
            return "The employee with id"+ id + "doesn't exist";
        }
    }


}
