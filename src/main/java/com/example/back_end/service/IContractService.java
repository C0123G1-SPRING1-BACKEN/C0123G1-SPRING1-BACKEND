package com.example.back_end.service;

import com.example.back_end.model.Contracts;

import java.util.List;

public interface IContractService {
    List<Contracts> findAll();

    void createContract(Contracts contracts);
}
