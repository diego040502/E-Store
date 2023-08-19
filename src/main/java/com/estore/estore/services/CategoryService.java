package com.estore.estore.services;

import com.estore.estore.models.CategoryModel;
import com.estore.estore.repositories.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    ICategoryRepository categoryRepository;

    //Get categories
    public ArrayList<CategoryModel> getCategories(){
        return (ArrayList<CategoryModel>) categoryRepository.findAll();
    }

    //Register category
    public CategoryModel saveCategory(CategoryModel category){
        return (CategoryModel) categoryRepository.save(category);
    }

    //Get category by id
    public Optional<CategoryModel> getById(Integer id){
        return categoryRepository.findById(id);
    }

    //Update by id
    public CategoryModel updateById(CategoryModel request ,Integer id){
        CategoryModel cat = (CategoryModel) categoryRepository.findById(id).get();

        cat.setName(request.getName());
        cat.setDescription(request.getDescription());

        return cat;
    }

    //Delete by id
    public boolean deleteById(Integer id){
        try{
            categoryRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }



}
