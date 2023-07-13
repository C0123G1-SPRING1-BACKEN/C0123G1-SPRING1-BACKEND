package com.example.back_end.projections;

import com.example.back_end.model.ContractStatus;
import com.example.back_end.model.ContractType;
import com.example.back_end.model.Customers;

import java.time.LocalDate;

public class ContractSearchDTO {
    private String productName;

    private String customerName;

    private LocalDate startDate;
    private LocalDate endDate;

    private ContractType contractType;

    private ContractStatus contractStatus;

    public ContractSearchDTO() {
    }

    public ContractSearchDTO(String productName, String customerName, LocalDate startDate, LocalDate endDate, ContractType contractType, ContractStatus contractStatus) {
        this.productName = productName;
        this.customerName = customerName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.contractType = contractType;
        this.contractStatus = contractStatus;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
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
