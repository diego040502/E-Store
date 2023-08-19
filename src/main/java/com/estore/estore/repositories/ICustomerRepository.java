package com.estore.estore.repositories;

import com.estore.estore.models.CustomerModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<CustomerModel, Integer>{
}
