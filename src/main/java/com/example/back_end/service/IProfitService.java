package com.example.back_end.service;

import com.example.back_end.model.Contracts;
import net.bytebuddy.description.type.TypeList;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProfitService {
    <T> Page<T> findAllContract(String startDate, String endDate,Pageable pageable,String profitType);
    Long getTotalProfit(String startDate, String endDate,String profitType);
}
