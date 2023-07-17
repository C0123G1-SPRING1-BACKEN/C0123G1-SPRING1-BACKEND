package com.example.back_end.dto.open_contract;

public class OpenContractDTO {
    private Long contractId;
    private String contractCode;
    private String customerName;
    private String productName;
    private Long loans;
    private String startDate;
    private Long profit;
    private String endDate;
    private String redeemDate;

    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
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

    public  void setLoans(Long loans) {
        this.loans = loans;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public Long getProfit() {
        return profit;
    }

    public void setProfit(Long profit) {
        this.profit = profit;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getRedeemDate() {
        return redeemDate;
    }

    public void setRedeemDate(String redeemDate) {
        this.redeemDate = redeemDate;
    }
}