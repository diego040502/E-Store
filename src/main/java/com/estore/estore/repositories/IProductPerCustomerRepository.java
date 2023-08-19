package com.estore.estore.repositories;

import com.estore.estore.models.ProductPerCustomerModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductPerCustomerRepository extends JpaRepository<ProductPerCustomerModel, Integer> {
}
