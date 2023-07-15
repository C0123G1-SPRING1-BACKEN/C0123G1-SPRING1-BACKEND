package com.example.back_end.projections;

public class ContractSearchDTO {
    private String productName;

    private String customerName;

    private String startDate;
    private String endDate;

    private Long contractType;

    private Long contractStatus;

    public ContractSearchDTO() {
    }

    public ContractSearchDTO(String productName, String customerName, String startDate, String endDate, Long contractType, Long contractStatus) {
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

    public Long getContractType() {
        return contractType;
    }

    public void setContractType(Long contractType) {
        this.contractType = contractType;
    }

    public Long getContractStatus() {
        return contractStatus;
    }

    public void setContractStatus(Long contractStatus) {
        this.contractStatus = contractStatus;
    }
}
