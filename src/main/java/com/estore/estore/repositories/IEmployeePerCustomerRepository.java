package com.estore.estore.repositories;

import com.estore.estore.models.EmployeePerCustomerModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeePerCustomerRepository extends JpaRepository<EmployeePerCustomerModel, Integer> {
}
