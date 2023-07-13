package com.example.back_end.service;

import com.example.back_end.model.Contracts;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IRedeemingService {
    void redeem(Long id);

    Page<Contracts> findPageConTract(Pageable page);
}
