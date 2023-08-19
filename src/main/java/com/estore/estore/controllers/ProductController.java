package com.estore.estore.controllers;

import com.estore.estore.models.ProductModel;
import com.estore.estore.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;


    @GetMapping("/products")
    public ArrayList<ProductModel> getProducts(){
        return productService.getProducts();
    }

    @PostMapping("/new")
    public ProductModel saveProducts(@RequestBody ProductModel product){
        return productService.saveProduct(product);
    }

    @GetMapping(path = "/{id}")
    public Optional<ProductModel> getById(@PathVariable("id") Integer id){
        return productService.getById(id);
    }

    @PutMapping(path = "/{id}")
    public ProductModel updateById(@RequestBody ProductModel request, @PathVariable("id") Integer id){
        return productService.updateById(request, id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id") Integer id){
        boolean ok = productService.deleteById(id);

        if(ok){
            return "The product with id"+ id + "has been deleted";
        }else{
            return "The product with id"+ id + "doesn't exist";
        }
    }

}
