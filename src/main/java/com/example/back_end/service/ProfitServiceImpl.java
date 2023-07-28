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

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Service
public class ProfitServiceImpl implements IProfitService {
    private  static final String PROFIT_INTEREST  = "interest";
    private  static final String PROFIT_LIQUIDATION  = "liquidation";
    private  static final String PROFIT_FORESEE  = "foresee";
    @Autowired
    private IProfitRepository iProfitRepository;

    public String checkCurrentDate (String startDate,String endDate,String years){
        String currentYear = "2023";
        if(!years.equals("")){
            return years;
        }else {
            if(startDate.equals("") && endDate.equals("")){
                return   String.valueOf(LocalDateTime.now().getYear());
            }else {
                return currentYear;
            }
        }
    }
    @Override
    public <T> Page<T> findAllContract(String startDate, String endDate,String years,Pageable pageable, String profitType) {
        String currentYear = checkCurrentDate(startDate,endDate,years);
        switch (profitType) {
            case PROFIT_INTEREST:
                return (Page<T>) iProfitRepository.getAllContractInterest(startDate,endDate,pageable,currentYear);
            case PROFIT_LIQUIDATION:
                return (Page<T>) iProfitRepository.getAllLiquidation(startDate,endDate,pageable,currentYear);
            case PROFIT_FORESEE:
                return (Page<T>) iProfitRepository.getAllContractForesee(startDate,endDate,pageable,currentYear);
            default:
                return null;
        }
    }

    @Override
    public Long getTotalProfit(String startDate, String endDate,String years, String profitType) {
        String currentYear = checkCurrentDate(startDate,endDate,years);
        switch (profitType) {
            case PROFIT_INTEREST:
                return  iProfitRepository.getTotalProfitContract(startDate,endDate,3L,currentYear);
            case PROFIT_LIQUIDATION:
                return  iProfitRepository.getTotalProfitLiquidation(startDate,endDate,currentYear);
            case PROFIT_FORESEE:
                return  iProfitRepository.getTotalProfitContract(startDate,endDate,2L,currentYear);
            default:
                return null;
        }

    }

    @Override
    public List<IStatistics> statisticsProfit(String startDate, String endDate,String years, String profitType) {
        String currentYear = checkCurrentDate(startDate,endDate,years);
        switch (profitType) {
            case PROFIT_INTEREST:
                return  iProfitRepository.statisticsProfit(startDate,endDate,3L,currentYear);
            case PROFIT_LIQUIDATION:
                return  iProfitRepository.statisticsProfitLiquidation(startDate,endDate,currentYear);
            case PROFIT_FORESEE:
                return  iProfitRepository.statisticsProfit(startDate,endDate,2L,currentYear);
            default:
                return Collections.emptyList();
        }
    }
}
