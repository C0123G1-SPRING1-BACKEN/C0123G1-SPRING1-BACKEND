package com.example.back_end.dto.open_contract;

public interface IOpenContractDTO {
    Long getContractId();
    Long getContractCode();
    String getCustomerName();
    String getProductName();
    Long getLoans();
    String getStartDate();
    Long getProfit();
    String getEndDate();
    String getRedeemDate();
}
