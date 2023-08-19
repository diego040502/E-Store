package com.estore.estore.repositories;

import com.estore.estore.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<UserModel,Integer>{
}
