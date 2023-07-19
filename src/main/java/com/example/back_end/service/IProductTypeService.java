package com.example.back_end.service;

import com.example.back_end.model.ContractStatus;
import com.example.back_end.model.ContractType;
import com.example.back_end.model.ProductType;

import java.util.List;

public interface IProductTypeService {
    List<ProductType> getAll();

    List<ContractStatus> getAllContractStatus();

    List<ContractType> getAllContractType();
}
