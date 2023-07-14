package com.example.back_end.controller;

import com.example.back_end.dto.ContractDto;
import com.example.back_end.model.Contracts;
import com.example.back_end.service.IContractService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employee/contract")
@CrossOrigin("*")
public class ContractController {
    /**
     * Create by : TriPD
     * Date created : 13/07/2023
     * Function : findContractById(),updateContract()
     */
    @Autowired
    private IContractService iContractService;

    @GetMapping("/findContractById/{id}")
    public ResponseEntity<ContractDto> getContractById(@PathVariable Long id) {
        Optional<Contracts> contract = this.iContractService.findContractById(id);
        if (!contract.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        ContractDto contractDto = new ContractDto();
        BeanUtils.copyProperties(contract.get(), contractDto);
        return new ResponseEntity<>(contractDto, HttpStatus.OK);
    }


    @PatchMapping("/{id}")
    public ResponseEntity<ContractDto> updateContract(@PathVariable Long id, @RequestBody ContractDto contractDto) {
        if (contractDto==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iContractService.saveContract(id,contractDto);
     return new ResponseEntity<>(contractDto,HttpStatus.OK);
    }

    @GetMapping("/top10")
    public ResponseEntity<List<Contracts>> top10NewContract() {
        List<Contracts> contracts = this.iContractService.showTop10NewContract();
        if (contracts.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(contracts, HttpStatus.OK);
    }


}



