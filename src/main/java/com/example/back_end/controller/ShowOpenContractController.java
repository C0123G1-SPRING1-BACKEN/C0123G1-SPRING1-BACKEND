package com.example.back_end.controller;

import com.example.back_end.dto.open_contract.AllContractDTO;
import com.example.back_end.model.Contracts;
import com.example.back_end.model.ProductType;
import com.example.back_end.service.IRedeemingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/api/employee/showContract")
@CrossOrigin("*")
public class ShowOpenContractController {
    @Autowired
    private IRedeemingService iRedeemingService;



    @Transactional
    @GetMapping("/showAllContract")
    public ResponseEntity<Page<AllContractDTO>> getAllContracts(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                                                @RequestParam("productName")String productName,
                                                                @RequestParam("productType")String productType) {
        Pageable pageable = PageRequest.of(page,5, Sort.by(Sort.Order.desc("create_time")));
        Page<AllContractDTO> allContractDTOS = iRedeemingService.findAllContractDTOS(pageable,"%" + productName + "%","%" + productType + "%");
        if (allContractDTOS == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(allContractDTOS,HttpStatus.OK);
    }

    @GetMapping("/getProductType")
    public ResponseEntity<List<ProductType>> getProductType(){
         List<ProductType> productTypes =  iRedeemingService.getProductType();

         if (productTypes == null) {
             return new ResponseEntity<>(HttpStatus.NO_CONTENT);
         }

         return new ResponseEntity<>(productTypes, HttpStatus.OK);
    }
}
