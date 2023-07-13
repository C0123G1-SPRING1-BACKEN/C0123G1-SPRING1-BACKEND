package com.example.back_end.controller;

import com.example.back_end.model.Contracts;
import com.example.back_end.service.IProfitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/profit-interest")
public class ProfitController {
    @Autowired
    private IProfitService iProfitService;

    @GetMapping("")
    private <T> ResponseEntity<Page<T>> getAllContract(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                                       @RequestParam(value = "profitType", defaultValue = "interest") String profitType) {
        Pageable pageable = PageRequest.of(page, 8);
        Page<T> contractPage = iProfitService.findAll(pageable, profitType);
        return new ResponseEntity<>(contractPage, HttpStatus.OK);
    }

    @GetMapping("/total-profit")
    private ResponseEntity<Long> getTotalProfitInterest(@RequestParam(value = "startDate", defaultValue = "") String startDate,
                                                        @RequestParam(value = "endDate", defaultValue = "") String endDate,
                                                        @RequestParam(value = "profitType", defaultValue = "interest") String profitType) {
            Long total = iProfitService.getTotalProfit(startDate, endDate, profitType);
            if (total == null) {
                return new ResponseEntity<>(0L, HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(total, HttpStatus.OK);
        }
    }
