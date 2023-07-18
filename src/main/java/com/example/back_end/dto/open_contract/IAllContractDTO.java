package com.example.back_end.dto.open_contract;

public interface IAllContractDTO {
    Long getContractId();
    String getContractCode();
    String getCustomerName();
    String getProductName();
    Long getLoans();
    String getStartDate();
    Long getProfit();
    String getEndDate();
    String getContractType();
    String getProductType();
    String getContractStatus();
}
