package com.estore.estore.repositories;

import com.estore.estore.models.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleRepository extends JpaRepository<RoleModel,Integer>{
}
