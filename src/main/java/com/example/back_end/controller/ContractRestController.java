package com.example.back_end.controller;

import com.example.back_end.model.Contracts;
import com.example.back_end.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/contract")
@RestController
@CrossOrigin("*")
public class ContractRestController {
    @Autowired
    private IContractService iContractService;
    @GetMapping("/")
    public ResponseEntity<List<Contracts>>getAllContract(){
        List<Contracts> contractsList=iContractService.findAll();
        return new ResponseEntity<>(contractsList, HttpStatus.OK);
    }
    @PostMapping("/createContract")
    public void createContracts(@RequestBody Contracts contracts){
        iContractService.createContract(contracts);
    }
}
