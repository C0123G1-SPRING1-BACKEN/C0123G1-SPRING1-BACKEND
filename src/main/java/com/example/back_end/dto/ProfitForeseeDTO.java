package com.example.back_end.dto;

public class ProfitForeseeDTO {
    private String contractCode;
    private String loans;
    private String interest;
    private String startDate;
    private String endDate;
    private String profitForesee;

    public ProfitForeseeDTO() {
    }

    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }

    public String getLoans() {
        return loans;
    }

    public void setLoans(String loans) {
        this.loans = loans;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
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

    public String getProfitForesee() {
        return profitForesee;
    }

    public void setProfitForesee(String profitForesee) {
        this.profitForesee = profitForesee;
    }
}
