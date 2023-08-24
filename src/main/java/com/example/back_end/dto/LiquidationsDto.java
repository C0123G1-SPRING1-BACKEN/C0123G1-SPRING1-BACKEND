package com.example.back_end.dto;

import com.example.back_end.model.Contracts;
import com.example.back_end.model.Customers;
import com.example.back_end.model.Employees;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class LiquidationsDto {
    private Long id;

    @NotNull(message = "Vui lòng chọn khách hàng.")
    private Customers customers;
    @NotNull(message = "Vui lòng chọn sản phẩm.")
    private String products;
    @NotNull
    private Long totalPrice;
    private LocalDateTime createTime;
 private Employees employees;
    public LiquidationsDto() {
    }

    public LiquidationsDto(Long id, Customers customers, String products, Long totalPrice, LocalDateTime createTime, Employees employees) {
        this.id = id;
        this.customers = customers;
        this.products = products;
        this.totalPrice = totalPrice;
        this.createTime = createTime;
        this.employees = employees;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customers getCustomers() {
        return customers;
    }

    public void setCustomers(Customers customers) {
        this.customers = customers;
    }

    public String getProducts() {
        return products;
    }

    public void setProducts(String products) {
        this.products = products;
    }

    public Long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public Employees getEmployees() {
        return employees;
    }

    public void setEmployees(Employees employees) {
        this.employees = employees;
    }
}
