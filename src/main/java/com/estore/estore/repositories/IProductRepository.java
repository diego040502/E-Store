package com.estore.estore.repositories;

import com.estore.estore.models.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<ProductModel,Integer>{
}
