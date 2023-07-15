package com.example.back_end.service.contracts.impl;

import com.example.back_end.dto.IContractDto;
import com.example.back_end.model.Contracts;
import com.example.back_end.repository.IContractsRepository;
import com.example.back_end.service.contracts.IContractsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ContractsServiceImpl implements IContractsService {
    @Autowired
    private IContractsRepository contractsRepository;
    @Override
    public Page<IContractDto> findAllProduct(Pageable pageable) {
        return contractsRepository.finAllProduct(pageable);
    }

    @Override
    public IContractDto findContractById(Long id) {
        return contractsRepository.findContractById(id);
    }

    @Override
    public Page<IContractDto> searchProduct(Pageable pageable, String productName, String productType, String loans) {
        return contractsRepository.searchProduct(pageable,productName,productType,loans);
    }

}
