package com.example.back_end.service.liquidations.impl;

import com.example.back_end.model.Liquidations;
import com.example.back_end.repository.ILiquidationsRepository;
import com.example.back_end.service.liquidations.ILiquidationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


    @Override
    public void save(Liquidations liquidations) {
//        liquidationsRepository.createLiquidations(liquidations.getCustomers().getName(), liquidations.getContracts().getProductName(), liquidations.getContracts().getLoans(),liquidations.getCreateTime());
    }


}
