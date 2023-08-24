package com.example.back_end.projections;


public interface ITransactionHistoryProjection {

    String getId();

    String getContractCode();

    String getProductName();

    String getCustomers();

    String getStartDate();

    String getContractType();

    String getContractStatus();
}