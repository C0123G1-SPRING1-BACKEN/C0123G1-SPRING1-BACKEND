package com.example.back_end.service.contracts.impl;

import com.example.back_end.dto.IContractDto;
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
    public Page<IContractDto> findAllProduct(Pageable pageable, String productName, String productType, String loans) {

        switch (loans) {
            case "1":
                return contractsRepository.finAllProduct(pageable, productName, productType, "0", "5000000");
            case "2":
                return contractsRepository.finAllProduct(pageable, productName, productType, "5000000", "10000000");
            case "3":
                return contractsRepository.finAllProduct(pageable, productName, productType, "10000000", "20000000");
            case "4":
                return contractsRepository.finAllProduct(pageable, productName, productType, "20000000", "20000000000");
            default:
                return contractsRepository.finAllProduct(pageable, productName, productType, "0", "2000000000000000000000000");
        }
    }

    @Override
    public IContractDto findContractById(Long id) {
        return contractsRepository.findContractById(id);
    }

}
