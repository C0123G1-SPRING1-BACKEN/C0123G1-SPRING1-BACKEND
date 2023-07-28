package com.example.back_end.service.contracts;

import com.example.back_end.dto.IContractDto;
import com.example.back_end.dto.LiquidationsDto;
import com.example.back_end.model.Contracts;
import com.example.back_end.projections.IMinAndMaxProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IContractsService {
    Page<IContractDto> findAllProduct(Pageable pageable, String productName, String productType, String loans);

    IContractDto findContractById(Long id);

    void createLiquidationContract(LiquidationsDto liquidationsDto);

}
