package com.example.back_end.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ContractsDto{
    @Id
    private Long id;
    private String productName;
    private Long loans;

    public ContractsDto() {
    }

    public ContractsDto(Long id, String productName, Long loans) {
        this.id = id;
        this.productName = productName;
        this.loans = loans;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getLoans() {
        return loans;
    }

    public void setLoans(Long loans) {
        this.loans = loans;
    }
}
