package com.example.back_end.service;

import com.example.back_end.model.Contracts;
import com.example.back_end.projections.ContractSearchDTO;
import com.example.back_end.projections.IContractProjection;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface IContractService {
    Page<IContractProjection> findAllTransactionHistory(Integer page,Integer limit);

    Boolean deleteTransactionHistoryById(Integer id);

    Page<IContractProjection> searchTransactionHistory(Integer page,Integer limit,ContractSearchDTO contractSearchDTO);

    Optional<Contracts> findTransactionHistoryById(Integer id);
}
