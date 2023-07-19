package com.example.back_end.dto;

public class ProfitLiquidationDTO {
    private String contractCode;
    private String loans;
    private String proceedsOfSale;
    private String profit;

    public ProfitLiquidationDTO() {
    }

    public ProfitLiquidationDTO( String contractCode, String loans, String proceedsOfSale, String profit) {
        this.contractCode = contractCode;
        this.loans = loans;
        this.proceedsOfSale = proceedsOfSale;
        this.profit = profit;
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

    public String getProceedsOfSale() {
        return proceedsOfSale;
    }

    public void setProceedsOfSale(String proceedsOfSale) {
        this.proceedsOfSale = proceedsOfSale;
    }

    public String getProfit() {
        return profit;
    }

    public void setProfit(String profit) {
        this.profit = profit;
    }
}
