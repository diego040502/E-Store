package com.estore.estore.services;

import com.estore.estore.models.RoleModel;
import com.estore.estore.repositories.IRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class RoleService {
    @Autowired
    IRoleRepository roleRepository;

    //Get all roles
    public ArrayList<RoleModel> getRoles(){
        return (ArrayList<RoleModel>) roleRepository.findAll();
    }

    //Register role
    public RoleModel saveRole(RoleModel role){
        return (RoleModel) roleRepository.save(role);
    }

    //Get role by id
    public Optional<RoleModel> getById(Integer id){
        return roleRepository.findById(id);
    }

    //Update role
    public RoleModel updateById(RoleModel request, Integer id){
        RoleModel role = (RoleModel) roleRepository.findById(id).get();

        role.setRole(request.getRole());

        return role;
    }

    //Delete role by id
    public boolean deleteById(Integer id){
        try{
            roleRepository.deleteById(id);
            return true;
        }catch(Exception e){
            return false;
        }
    }
}
