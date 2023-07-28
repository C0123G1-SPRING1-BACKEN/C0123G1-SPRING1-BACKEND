package com.example.back_end.service;

import com.example.back_end.dto.ContractDto;
import com.example.back_end.model.Contracts;
import com.example.back_end.model.Users;
import com.example.back_end.projections.ContractSearchDTO;
import com.example.back_end.projections.IContractProjection;
import com.example.back_end.projections.IMinAndMaxProjection;
import com.example.back_end.projections.ITransactionHistoryProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface IContractService {


    Contracts findContractById(Long id);


    Page<Contracts> showTop10NewContract(Pageable pageable);


    void saveContract(ContractDto contractDto);


    Boolean deleteTransactionHistoryById(Integer id);

    Page<ITransactionHistoryProjection> showListAndSearchTransactionHistory(Integer page, Integer limit, ContractSearchDTO contractSearchDTO);

    Optional<Contracts> findTransactionHistoryById(Integer id);

    List<Contracts> findAll();

    void createContract(Contracts contracts);

    String randomContract();

    Optional<IMinAndMaxProjection>findMinDateAndMaxDate();

}
