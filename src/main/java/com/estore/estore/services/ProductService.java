package com.estore.estore.services;

import com.estore.estore.models.ProductModel;
import com.estore.estore.repositories.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    IProductRepository productRepository;

    //Get products
    public ArrayList<ProductModel> getProducts(){
        return (ArrayList<ProductModel>) productRepository.findAll();
    }

    //Register product
    public ProductModel saveProduct(ProductModel product){
        return (ProductModel) productRepository.save(product);
    }

    //Get product
    public Optional<ProductModel> getById(Integer id){
        return productRepository.findById(id);
    }

    //Update product
    public ProductModel updateById(ProductModel request, Integer id){
        ProductModel product = (ProductModel) productRepository.findById(id).get();

        product.setName(request.getName());
        product.setBrand(request.getBrand());
        product.setMaker(request.getMaker());
        product.setPrice(request.getPrice());
        product.setStock(request.getStock());

        return product;

    }

    //Delete product
    public boolean deleteById(Integer id){
        try{
            productRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

}
