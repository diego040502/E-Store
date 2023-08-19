package com.estore.estore.controllers;

import com.estore.estore.models.CategoryModel;
import com.estore.estore.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/categories")
    public ArrayList<CategoryModel> getCategories(){
        return categoryService.getCategories();
    }

    @PostMapping("/new")
    public CategoryModel saveCategory(@RequestBody CategoryModel request){
        return categoryService.saveCategory(request);
    }

    @GetMapping(path = "/{id}")
    public Optional<CategoryModel> getById(@PathVariable("id") Integer id){
        return categoryService.getById(id);
    }

    @PutMapping(path = "/{id}")
    public CategoryModel updateById(@RequestBody CategoryModel request, @PathVariable("id") Integer id){
        return categoryService.updateById(request, id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id") Integer id){
        boolean ok = categoryService.deleteById(id);

        if(ok){
            return "The category with id"+ id + "has been deleted";
        }else{
            return "The category with id"+ id + "doesn't exist";
        }
    }

}
