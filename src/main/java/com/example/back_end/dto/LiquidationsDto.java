package com.example.back_end.dto;

import com.example.back_end.model.Contracts;
import com.example.back_end.model.Customers;

import java.time.LocalDateTime;

public class LiquidationsDto {
    private Long id;
    private Customers customers;
    private Contracts contracts;
    private Long totalPrice;
    private LocalDateTime createTime;

    public LiquidationsDto() {
    }

    public LiquidationsDto(Long id, Customers customers, Contracts contracts, Long totalPrice, LocalDateTime createTime) {
        this.id = id;
        this.customers = customers;
        this.contracts = contracts;
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

    public Contracts getContracts() {
        return contracts;
    }

    public void setContracts(Contracts contracts) {
        this.contracts = contracts;
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
