package com.example.back_end.service.liquidations.impl;

import com.example.back_end.model.Contracts;
import com.example.back_end.model.Liquidations;
import com.example.back_end.repository.ILiquidationsRepository;
import com.example.back_end.service.liquidations.ILiquidationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;

/**
 * Created by: KhangPVA
 * Date created: 13/07/2023
 * Function: create liquidation
 *
 * @param LiquidationDto
 * @return Liquidation
 */

@Service
public class LiquidationsServiceImpl implements ILiquidationsService {
    @Autowired
    private ILiquidationsRepository liquidationsRepository;

    @Transactional
    @Override
    public void save(Liquidations liquidations) {
        Contracts contract = liquidations.getContracts();
        if (contract == null) {
            contract = new Contracts();
            liquidations.setContracts(contract);
        }

        contract.setContractCode(String.valueOf(Math.round(Math.random() * 100000)));

        liquidationsRepository.createLiquidations(
                contract.getContractCode(),
                contract.getContractType().setId(2L),
                contract.getContractStatus().setId(5L),
                liquidations.getCustomers().getId(),
                contract.getProductName(),
                contract.getLoans(),
                contract.getProfit(),
                contract.getImage(),
                contract.setStartDate(LocalDate.now().toString()),
                contract.setEndDate(LocalDate.now().toString()),
                contract.getProductType().getId(),
                contract.getLinkContracts()
        );
    }
}