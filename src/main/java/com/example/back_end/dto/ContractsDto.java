package com.example.back_end.dto;

public class ContractsDto {
    private Long id;
    private String productName;
    private Long totalCount;
    private Long loans;

    public ContractsDto() {
    }

    public ContractsDto(Long id, String productName, Long totalCount, Long loans) {
        this.id = id;
        this.productName = productName;
        this.totalCount = totalCount;
        this.loans = loans;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    public Long getLoans() {
        return loans;
    }

    public void setLoans(Long loans) {
        this.loans = loans;
    }
}
