package com.example.back_end.projections;


public class ContractSearchDTO {
    private String productName;

    private String customerName;

    private String startDate;
    private String endDate;

    private String contractType;

    private String contractStatus;

    public ContractSearchDTO() {
    }

    public ContractSearchDTO(String productName, String customerName, String startDate, String endDate, String contractType, String contractStatus) {
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

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getContractType() {
        return contractType;
    }

    public void setContractType(String contractType) {
        this.contractType = contractType;
    }

    public String getContractStatus() {
        return contractStatus;
    }

    public void setContractStatus(String contractStatus) {
        this.contractStatus = contractStatus;
    }
}