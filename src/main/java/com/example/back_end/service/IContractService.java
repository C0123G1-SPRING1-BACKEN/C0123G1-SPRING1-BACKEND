package com.example.back_end.service;

import com.example.back_end.dto.ContractDto;
import com.example.back_end.model.Contracts;

import java.util.Optional;

public interface IContractService {


   Optional<Contracts> findContractById(Long id);
}
