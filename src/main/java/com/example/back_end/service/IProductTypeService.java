package com.example.back_end.service;



import com.example.back_end.model.ContractStatus;
import com.example.back_end.model.Customers;
import com.example.back_end.model.Employees;
import com.example.back_end.model.ProductType;

import java.util.List;

public interface IProductTypeService {
    List<ProductType> findAll();
    List<Customers> findAllCustomer();
    List<Employees> findAllEmployee();
    List<ContractStatus> findAllContractStatus();


}
