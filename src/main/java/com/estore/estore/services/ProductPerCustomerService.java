package com.estore.estore.services;

import com.estore.estore.models.ProductPerCustomerModel;
import com.estore.estore.repositories.IProductPerCustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ProductPerCustomerService {

    @Autowired
    IProductPerCustomerRepository productPerCustomerRepository;

    public ArrayList<ProductPerCustomerModel> getProductsPerCustomer(){
        return (ArrayList<ProductPerCustomerModel>) productPerCustomerRepository.findAll();
    }

    public ProductPerCustomerModel saveProductPerCustomer(ProductPerCustomerModel ppc){
        return productPerCustomerRepository.save(ppc);
    }

    public ProductPerCustomerModel updateById(ProductPerCustomerModel request,Integer id){
        ProductPerCustomerModel pr = productPerCustomerRepository.findById(id).get();

        pr.setBought(request.getBought());

        return pr;
    }

}
