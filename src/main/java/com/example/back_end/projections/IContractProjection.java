package com.example.back_end.projections;

import com.example.back_end.model.Customers;

public interface IContractProjection {

    String getId();

    String getContractCode();

    String getProductName();

    String getCustomers();

    String getStartDate();

    String getContractType();

    String getContractStatus();
}
