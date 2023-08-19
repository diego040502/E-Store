package com.estore.estore.controllers;

import com.estore.estore.models.RoleModel;
import com.estore.estore.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.management.relation.Role;
import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    RoleService roleService;

    @GetMapping(path = "/roles")
    public ArrayList<RoleModel> getRoles(){
        return roleService.getRoles();
    }

    @PostMapping(path = "/new")
    public RoleModel saveRoles(@RequestBody RoleModel role){
        return this.roleService.saveRole(role);
    }

    @GetMapping(path = "/{id}")
    public Optional<RoleModel> getRoleById(@PathVariable("id") Integer id){
        return this.roleService.getById(id);
    }

    @PutMapping(path = "/{id}")
    public RoleModel updateById(@RequestBody RoleModel request, @PathVariable("id") Integer id){
        return this.roleService.updateById(request, id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id") Integer id){
        boolean ok = this.roleService.deleteById(id);
        if(ok){
            return "The role with id" + id + "has been deleted";
        }else{
            return "The role with id" + id + "cannot be deleted";
        }
    }
}
