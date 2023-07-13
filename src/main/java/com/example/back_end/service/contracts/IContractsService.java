package com.example.back_end.service.contracts;

import com.example.back_end.dto.ContractsDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IContractsService {
    Page<ContractsDto> findAllProduct(Pageable pageable);
}
