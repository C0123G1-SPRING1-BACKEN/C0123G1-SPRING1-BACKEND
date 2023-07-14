package com.example.back_end.service;

import com.example.back_end.dto.open_contract.OpenContractDTO;
import com.example.back_end.model.Contracts;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IRedeemingService {
    void redeem(Long id, String redeemDate);

    Page<OpenContractDTO> findPageConTract(Pageable page);

    Contracts findOpenContract(Long id);

    Page<OpenContractDTO> searchPageConTract(Pageable pageable, String contractCode, String customerName, String productName, String startDate);
}
