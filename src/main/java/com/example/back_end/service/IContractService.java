package com.example.back_end.service;

import com.example.back_end.model.Contracts;
import com.example.back_end.model.ProductType;
import com.example.back_end.dto.StockDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IContractService {
    Page<StockDTO> getALLContract(Pageable pageable);
    Page<Contracts> findProductInStock(String name , ProductType productType, Pageable pageable);


}
