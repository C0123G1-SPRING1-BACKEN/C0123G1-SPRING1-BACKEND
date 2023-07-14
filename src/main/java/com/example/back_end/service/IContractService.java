package com.example.back_end.service;

import com.example.back_end.dto.ContractDto;
import com.example.back_end.model.Contracts;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface IContractService {


   Optional<Contracts> findContractById(Long id);

   void saveContract(Long id,ContractDto contractDto);

   List<Contracts> showTop10NewContract();


}
