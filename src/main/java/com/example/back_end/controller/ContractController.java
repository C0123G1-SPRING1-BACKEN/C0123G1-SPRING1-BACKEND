package com.example.back_end.controller;

import com.example.back_end.model.Contracts;
import com.example.back_end.model.ProductType;
import com.example.back_end.dto.StockDTO;
import com.example.back_end.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/contract")
@CrossOrigin("*")
public class ContractController {
    @Autowired
    private IContractService contractService;
    @GetMapping("")
    public ResponseEntity<Page<StockDTO>> getList(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                                @RequestParam(value = "size", defaultValue = "10") Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<StockDTO> ordersPage = contractService.getALLContract(pageable);
        HttpHeaders headers = new HttpHeaders();
        headers.add("totalPages", String.valueOf(ordersPage.getTotalPages()));
        headers.add("totalElements", String.valueOf(ordersPage.getTotalElements()));
        return ResponseEntity.ok().headers(headers).body(ordersPage);
    }
    @GetMapping("/search")
    public ResponseEntity<Page<Contracts>> searchProduct(@RequestParam("name") String name,
                                                          @RequestParam("type") ProductType type,
                                                          @RequestParam(value = "page", defaultValue = "0") Integer page,
                                                          @RequestParam(value = "size", defaultValue = "5") Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Contracts> contracts = contractService.findProductInStock(name, type, pageable);

        if (contracts.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok().body(contracts);
    }

}
