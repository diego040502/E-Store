package com.estore.estore.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "products_per_customer")
@IdClass(ProductPerCustomerModel.class)
public class ProductPerCustomerModel {

    @Id
    @ManyToOne
    @JoinColumn(name = "customers_id")
    private CustomerModel customers_id;

    @Id
    @ManyToOne
    @JoinColumn(name = "products_id")
    private ProductModel products_id;
    @Column(name = "bought")
    private Date bought;


    public CustomerModel getCustomers_id() {
        return customers_id;
    }

    public void setCustomers_id(CustomerModel customers_id) {
        this.customers_id = customers_id;
    }

    public ProductModel getProducts_id() {
        return products_id;
    }

    public void setProducts_id(ProductModel products_id) {
        this.products_id = products_id;
    }

    public Date getBought() {
        return bought;
    }

    public void setBought(Date bought) {
        this.bought = bought;
    }
}
