package com.example.back_end.service;

import com.example.back_end.model.*;

import java.util.List;

public interface IProductTypeService {

    List<ProductType> getAllProductType();
    List<ContractStatus> getAllContractStatus();

    List<ContractType> getAllContractType();


}
