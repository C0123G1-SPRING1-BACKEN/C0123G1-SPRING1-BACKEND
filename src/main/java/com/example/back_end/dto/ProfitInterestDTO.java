package com.example.back_end.dto;

public class ProfitInterestDTO {
    private Long id;
    private String contractCode;
    private Long loans;
    private Long interest;
    private Long profit;

    public ProfitInterestDTO() {
    }

    public ProfitInterestDTO(Long id, String contractCode, Long loans, Long interest, Long profit) {
        this.id = id;
        this.contractCode = contractCode;
        this.loans = loans;
        this.interest = interest;
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

    public Long getInterest() {
        return interest;
    }

    public void setInterest(Long interest) {
        this.interest = interest;
    }

    public Long getProfit() {
        return profit;
    }

    public void setProfit(Long profit) {
        this.profit = profit;
    }
}
