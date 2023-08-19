package com.estore.estore.repositories;

import com.estore.estore.models.CategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<CategoryModel,Integer>{
}
