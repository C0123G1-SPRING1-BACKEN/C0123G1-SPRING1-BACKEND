package com.example.back_end.service;

import com.example.back_end.dto.IStatistics;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProfitService {
    <T> Page<T> findAllContract(String startDate, String endDate,Pageable pageable,String profitType);
    Long getTotalProfit(String startDate, String endDate,String profitType);
    List<IStatistics> statisticsProfit(String startDate, String endDate, String profitType);
}
