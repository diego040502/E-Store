package com.estore.estore.models;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class ProductModel {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryModel category_id;
    @Column(name = "name")
    private String name;
    @Column(name = "maker")
    private String maker;
    @Column(name = "price")
    private Integer price;
    @Column(name = "brand")
    private String brand;
    @Column(name = "stock")
    private Integer stock;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CategoryModel getCategory_id() {
        return category_id;
    }

    public void setCategory_id(CategoryModel category_id) {
        this.category_id = category_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
