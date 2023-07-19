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

import com.example.back_end.dto.IStatistics;
import com.example.back_end.repository.IProfitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ProfitServiceImpl implements IProfitService {
    private  static final String PROFIT_INTEREST  = "interest";
    private  static final String PROFIT_LIQUIDATION  = "liquidation";
    private  static final String PROFIT_FORESEE  = "foresee";
    @Autowired
    private IProfitRepository iProfitRepository;

    @Override
    public <T> Page<T> findAllContract(String startDate, String endDate,Pageable pageable, String profitType) {
        switch (profitType) {
            case PROFIT_INTEREST:
                return (Page<T>) iProfitRepository.getAllContractInterest(startDate,endDate,pageable);
            case PROFIT_LIQUIDATION:
                return (Page<T>) iProfitRepository.getAllLiquidation(startDate,endDate,pageable);
            case PROFIT_FORESEE:
                return (Page<T>) iProfitRepository.getAllContractForesee(startDate,endDate,pageable);
            default:
                return null;
        }
    }

    @Override
    public Long getTotalProfit(String startDate, String endDate, String profitType) {
        switch (profitType) {
            case PROFIT_INTEREST:
                return  iProfitRepository.getTotalProfitContract(startDate,endDate,3L);
            case PROFIT_LIQUIDATION:
                return  iProfitRepository.getTotalProfitLiquidation(startDate,endDate);
            case PROFIT_FORESEE:
                return  iProfitRepository.getTotalProfitContract(startDate,endDate,2L);
            default:
                return null;
        }

    }

    @Override
    public List<IStatistics> statisticsProfit(String startDate, String endDate, String profitType) {
        switch (profitType) {
            case PROFIT_INTEREST:
                return  iProfitRepository.statisticsProfit(startDate,endDate,3L);
            case PROFIT_LIQUIDATION:
                return  iProfitRepository.statisticsProfitLiquidation(startDate,endDate);
            case PROFIT_FORESEE:
                return  iProfitRepository.statisticsProfit(startDate,endDate,2L);
            default:
                return Collections.emptyList();
        }
    }
}
