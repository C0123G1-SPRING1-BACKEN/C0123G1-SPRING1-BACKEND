package com.example.back_end.service.impl;

import com.example.back_end.model.Contracts;
import com.example.back_end.repository.IRedeemingRepository;
import com.example.back_end.service.IRedeemingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class RedeemingService implements IRedeemingService {
    @Autowired
    private IRedeemingRepository iRedeemingRepository;

    @Override
    public void redeem(Long id) {
        iRedeemingRepository.redeem(id);
    }

    @Override
    public Page<Contracts> findPageConTract(Pageable page) {
        return iRedeemingRepository.findPageConTract(page);
    }
}
