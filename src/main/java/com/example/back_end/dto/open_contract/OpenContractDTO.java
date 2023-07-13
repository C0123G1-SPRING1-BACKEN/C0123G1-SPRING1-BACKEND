package com.example.back_end.dto.open_contract;

public class OpenContractDTO {
    private Long contractId;
    private Long contractCode;
    private String customerName;
    private String productName;
    private Long loans;
    private String startDate;

    public Long getContractCode() {
        return contractCode;
    }

    public void setContractCode(Long contractCode) {
        this.contractCode = contractCode;
    }

    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
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

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
}
