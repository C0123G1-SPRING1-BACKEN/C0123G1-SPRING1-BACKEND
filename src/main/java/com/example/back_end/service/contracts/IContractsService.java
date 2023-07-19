package com.example.back_end.service.contracts;

import com.example.back_end.dto.IContractDto;
import com.example.back_end.model.Contracts;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IContractsService {
    Page<IContractDto> findAllProduct(Pageable pageable);
    IContractDto findContractById(Long id);
    Page<IContractDto> searchProduct(Pageable pageable, String productName, String productType, String loans);
}
