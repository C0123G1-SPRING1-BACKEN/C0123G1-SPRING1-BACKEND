package com.example.back_end.dto;

import com.example.back_end.model.ContractStatus;
import com.example.back_end.model.ProductType;

import javax.persistence.*;

@Entity

public class StockDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "product_name", columnDefinition = "VARCHAR(250)")
    private String productName;
    @ManyToOne
    @JoinColumn
    private ProductType productType;
    @ManyToOne
    @JoinColumn
    private ContractStatus contractStatus;
    private Long loans;

    public StockDTO() {
    }

    public StockDTO(Long id, String productName, ProductType productType, ContractStatus contractStatus, Long loans) {
        this.id = id;
        this.productName = productName;
        this.productType = productType;
        this.contractStatus = contractStatus;
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

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public ContractStatus getContractStatus() {
        return contractStatus;
    }

    public void setContractStatus(ContractStatus contractStatus) {
        this.contractStatus = contractStatus;
    }

    public Long getLoans() {
        return loans;
    }

    public void setLoans(Long loans) {
        this.loans = loans;
    }
}
