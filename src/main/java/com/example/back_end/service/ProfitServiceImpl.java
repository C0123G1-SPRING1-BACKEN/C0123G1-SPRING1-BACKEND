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
    public <T> Page<T> findAll(Pageable pageable, String profitType) {
        switch (profitType) {
            case "interest":
                return (Page<T>) iProfitRepository.getAllContract(pageable,2L);
            case "liquidation":
                break;
            case "foresee":
                return (Page<T>) iProfitRepository.getAllContract(pageable,3L);
            default:
                return null;
        }
        return null;
    }

    @Override
    public Long getTotalProfit(String startDate, String endDate, String profitType,Pageable pageable) {
        switch (profitType) {
            case "interest":
                return  iProfitRepository.getTotalContract(startDate,endDate,2L);
            case "liquidation":
                break;
            case "foresee":
                return  iProfitRepository.getTotalContract(startDate,endDate,3L);
            default:
                return null;
        }
        return null;
    }
}
