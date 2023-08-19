package com.estore.estore.controllers;

import com.estore.estore.models.ProductPerCustomerModel;
import com.estore.estore.services.ProductPerCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/product-per-customer")
public class ProductPerCustomerController {

    @Autowired
    ProductPerCustomerService productPerCustomerService;

    @GetMapping("/products-customer")
    public ArrayList<ProductPerCustomerModel> getProductsPerCustomer(){
       return productPerCustomerService.getProductsPerCustomer();
    }

    @PostMapping("/new")
    public ProductPerCustomerModel saveProductPerCustomer(@RequestBody ProductPerCustomerModel ppc){
        return productPerCustomerService.saveProductPerCustomer(ppc);
    }

    @PutMapping(path = "/{id}")
    public ProductPerCustomerModel updateById(@RequestBody ProductPerCustomerModel request, @PathVariable("id") Integer id){
        return (ProductPerCustomerModel) productPerCustomerService.updateById(request, id);
    }


}
