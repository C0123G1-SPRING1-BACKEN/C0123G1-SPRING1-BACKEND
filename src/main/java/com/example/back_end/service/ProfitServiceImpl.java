/**
 * Created by: KhanhKQ
 * Date created: 13/07/2023
 * Function: display list contract/liquidation into Database, Calculate total profit
 *
 * @param pageable (Pagination for lists)
 * @param profitType (Type of profit)
 * @param startDate, endDate (The date range you want to calculate the profit)
 * @return findAll() : Returns a list of contracts by statistical date range
 * @return getTotalProfit() : Returns the total profit by the statistical date range
 */

package com.example.back_end.service;

import com.example.back_end.model.Contracts;
import com.example.back_end.repository.IProfitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProfitServiceImpl implements IProfitService {
    @Autowired
    private IProfitRepository iProfitRepository;

    @Override
    public <T> Page<T> findAllContract(String startDate, String endDate,Pageable pageable, String profitType) {
        switch (profitType) {
            case "interest":
                return (Page<T>) iProfitRepository.getAllContractInterest(startDate,endDate,pageable);
            case "liquidation":
                return (Page<T>) iProfitRepository.getAllLiquidation(startDate,endDate,pageable);
            case "foresee":
                return (Page<T>) iProfitRepository.getAllContractForesee(startDate,endDate,pageable);
            default:
                return null;
        }
    }

    @Override
    public Long getTotalProfit(String startDate, String endDate, String profitType) {
        switch (profitType) {
            case "interest":
                return  iProfitRepository.getTotalProfitContract(startDate,endDate,2L);
            case "liquidation":
                return  iProfitRepository.getTotalProfitLiquidation(startDate,endDate);
            case "foresee":
                return  iProfitRepository.getTotalProfitContract(startDate,endDate,3L);
            default:
                return null;
        }
    }
}
