package com.example.back_end.controller;

import com.example.back_end.model.Contracts;
import com.example.back_end.service.IRedeemingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/api/employee/redeem")
@CrossOrigin("*")
public class RedeemingController {
    @Autowired
    private IRedeemingService iRedeemingService;


    @Transactional
    @PatchMapping("/{id}")
    public void redeem(@PathVariable("id") Long id) {
        iRedeemingService.redeem(id);
    }

    @Transactional
    @GetMapping("/chooseContract")
    public ResponseEntity<Page<Contracts>> getOpenContractList(@RequestParam(value = "page", defaultValue = "0") Integer page) {
        Pageable pageable = PageRequest.of(page,5, Sort.by(Sort.Order.desc("create_time")));
        Page<Contracts> contractsPage = iRedeemingService.findPageConTract(pageable);

        if (contractsPage == null) {
            return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(contractsPage,HttpStatus.OK);
    }
}
