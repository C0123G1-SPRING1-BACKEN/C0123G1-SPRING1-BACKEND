package com.example.back_end.projections;

import com.example.back_end.model.ContractStatus;
import com.example.back_end.model.ContractType;
import com.example.back_end.model.Customers;

public class ContractDTO {
    private Long id;

    private String contractCode;

    private String productName;

    private Customers customers;

    private String startDate;

    private ContractType contractType;

    private ContractStatus contractStatus;

    public ContractDTO() {
    }

    public ContractDTO(Long id, String contractCode, String productName, Customers customers, String startDate, ContractType contractType, ContractStatus contractStatus) {
        this.id = id;
        this.contractCode = contractCode;
        this.productName = productName;
        this.customers = customers;
        this.startDate = startDate;
        this.contractType = contractType;
        this.contractStatus = contractStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Customers getCustomers() {
        return customers;
    }

    public void setCustomers(Customers customers) {
        this.customers = customers;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public ContractType getContractType() {
        return contractType;
    }

    public void setContractType(ContractType contractType) {
        this.contractType = contractType;
    }

    public ContractStatus getContractStatus() {
        return contractStatus;
    }

    public void setContractStatus(ContractStatus contractStatus) {
        this.contractStatus = contractStatus;
    }
}
