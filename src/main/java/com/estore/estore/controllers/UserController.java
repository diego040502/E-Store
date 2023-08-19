package com.estore.estore.controllers;

import com.estore.estore.models.UserModel;
import com.estore.estore.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/users")
    public ArrayList<UserModel> getUsers(){
        return userService.getUsers();
    }

    @PostMapping(path = "/new")
    public UserModel saveUsers(@RequestBody UserModel request){
        return this.userService.saveUsers(request);
    }

    @GetMapping(path = "/{id}")
    public Optional<UserModel> getUserById(@PathVariable("id") Integer id){
        return this.userService.getById(id);
    }

    @PutMapping(path = "/{id}")
    public UserModel updateUserById(@RequestBody UserModel request, @PathVariable("id") Integer id){
        return this.userService.updateById(request, id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteUserById(@PathVariable("id") Integer id){
        boolean ok = this.userService.deleteById(id);
        if(ok){
            return "The user"+ id +"has been deleted";
        }else {
            return "There has an error with the user" + id;
        }
    }
}
