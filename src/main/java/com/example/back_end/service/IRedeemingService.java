package com.example.back_end.service;

import com.example.back_end.dto.open_contract.AllContractDTO;
import com.example.back_end.dto.open_contract.OpenContractDTO;
import com.example.back_end.model.Contracts;
import com.example.back_end.model.ProductType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IRedeemingService {
    void redeems(Long id, String redeemDate);

    Page<OpenContractDTO> findPageConTract(Pageable page);

    Contracts findOpenContract(Long id);

    Page<OpenContractDTO> searchPageConTract(Pageable pageable, String contractCode, String customerName, String productName, String startDate);

    Page<AllContractDTO> findAllContractDTOS(Pageable pageable, String productName, String productType);

    List<ProductType> getProductType();
}
