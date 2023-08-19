package com.estore.estore.services;

import com.estore.estore.models.UserModel;
import com.estore.estore.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    IUserRepository userRepository;

    //Get all users
    public ArrayList<UserModel> getUsers(){
       return (ArrayList<UserModel>) userRepository.findAll();
    }

    //Register user
    public UserModel saveUsers(UserModel user){
        return (UserModel) userRepository.save(user);
    }

    //Get user by id
    public Optional<UserModel> getById(Integer id){
        return userRepository.findById(id);
    }

    //Update user
    public UserModel updateById(UserModel request, Integer id){
      UserModel user = (UserModel) userRepository.findById(id).get();

      user.setName(request.getName());
      user.setSurname(request.getSurname());
      user.setEmail(request.getEmail());
      user.setPassword(request.getPassword());

      return user;
    }

    //Delete user
    public boolean deleteById(Integer id){
        try{
            userRepository.deleteById(id);
            return true;
        }catch(Exception e){
            return false;
        }
    }

}
