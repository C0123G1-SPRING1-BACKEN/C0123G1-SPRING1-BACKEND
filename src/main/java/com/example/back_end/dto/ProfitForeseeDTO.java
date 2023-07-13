package com.example.back_end.dto;

public class ProfitForeseeDTO {
    private Long id;
    private String contractCode;
    private Long loans;
    private Long totalPrice;
    private Long profit;

    public ProfitForeseeDTO() {
    }

    public ProfitForeseeDTO(Long id, String contractCode, Long loans, Long totalPrice, Long profit) {
        this.id = id;
        this.contractCode = contractCode;
        this.loans = loans;
        this.totalPrice = totalPrice;
        this.profit = profit;
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

    public Long getLoans() {
        return loans;
    }

    public void setLoans(Long loans) {
        this.loans = loans;
    }

    public Long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Long getProfit() {
        return profit;
    }

    public void setProfit(Long profit) {
        this.profit = profit;
    }
}
