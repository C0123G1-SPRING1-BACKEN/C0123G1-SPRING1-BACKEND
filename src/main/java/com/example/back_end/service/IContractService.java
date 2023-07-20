package com.example.back_end.service;

import com.example.back_end.model.Contracts;
import com.example.back_end.model.Users;
import com.example.back_end.projections.ContractSearchDTO;
import com.example.back_end.projections.IContractProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IContractService {



   Contracts findContractById(Long id);

   

   Page<Contracts> showTop10NewContract(Pageable pageable);



   void saveContract(ContractDto contractDto);


    Page<ITransactionHistoryProjection> findAllTransactionHistory(Integer page, Integer limit);

    Boolean deleteTransactionHistoryById(String id);

    Page<ITransactionHistoryProjection> showListAndSearchTransactionHistory(Integer page, Integer limit, ContractSearchDTO contractSearchDTO);

    Optional<Contracts> findTransactionHistoryById(String id);

    List<Contracts> findAll();

    void createContract(Contracts contracts);

}
