package com.example.back_end.service.contracts;

import com.example.back_end.dto.IContractDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IContractsService {
    Page<IContractDto> findAllProduct(Pageable pageable);
}
