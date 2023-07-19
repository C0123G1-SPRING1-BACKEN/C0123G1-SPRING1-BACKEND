package com.example.back_end.model;


import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
@Entity
public class Liquidations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn
    private Customers customers;
    @Column(nullable = false)
    private String products;
    @Column(nullable = false)
    private Long totalPrice;
    @Column(name = "create_time", columnDefinition = "DATETIME DEFAULT now()",updatable = false)
    @CreationTimestamp
    private LocalDateTime createTime;

    public Liquidations() {
    }

    public Liquidations(Long id, Customers customers, String products, Long totalPrice, LocalDateTime createTime) {
        this.id = id;
        this.customers = customers;
        this.products = products;
        this.totalPrice = totalPrice;
        this.createTime = createTime;
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
}
