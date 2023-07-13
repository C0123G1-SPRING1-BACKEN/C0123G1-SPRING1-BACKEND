package com.example.back_end.controller;

import com.example.back_end.dto.ContractDto;
import com.example.back_end.model.Contracts;
import com.example.back_end.service.IContractService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<ContractDto>getContractById(@PathVariable Long id){
    Optional<Contracts> contract=this.iContractService.findContractById(id);
    ContractDto contractDto=new ContractDto();
    BeanUtils.copyProperties(contract,contractDto);
    return new ResponseEntity<>(contractDto,HttpStatus.OK);
}



}
