package com.example.back_end.service;


import com.example.back_end.dto.ContractDto;
import com.example.back_end.model.Contracts;

import java.time.LocalDateTime;

import com.example.back_end.model.Contracts;
import com.example.back_end.projections.ContractSearchDTO;
import com.example.back_end.projections.IContractProjection;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface IContractService {



   Contracts findContractById(Long id);

   

   List<Contracts> showTop10NewContract();



   void saveContract(ContractDto contractDto);


    Page<IContractProjection> findAllTransactionHistory(Integer page,Integer limit);

    Boolean deleteTransactionHistoryById(Long id);

    Page<IContractProjection> searchTransactionHistory(Integer page,Integer limit,ContractSearchDTO contractSearchDTO);

    Optional<Contracts> findTransactionHistoryById(Long id);

    List<Contracts> findAll();

    void createContract(Contracts contracts);


}
