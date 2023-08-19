package com.estore.estore.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "employee_per_customer")
@IdClass(EmployeePerCustomerModel.class)
public class EmployeePerCustomerModel {

    @Id
    @ManyToOne
    @JoinColumn(name = "customers_id")
    private CustomerModel customer;

    @Id
    @ManyToOne
    @JoinColumn(name = "employees_id")
    private EmployeeModel employee;
    @Column(name = "date_of_attention")
    private Date date_of_attention;

}
