package com.example.back_end.service;

import com.example.back_end.projections.ContractDTO;
import org.springframework.data.domain.Page;

public interface IContractService {
    Page<ContractDTO> findAllContract(Integer page);

    Boolean deleteContractById(Integer id);

    ContractDTO findContractById(Integer id);
}
