package com.example.back_end.controller;

import com.example.back_end.dto.ContractDto;
import com.example.back_end.model.Contracts;
import com.example.back_end.service.IContractService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by: DinhHD
 * Date created: 13/07/2023
 * Function: do about pawn interface, customer selection interface
 *
// * @param Contracts
 * @return createContracts()
 */

@RequestMapping("/api/contract")
@RestController
@CrossOrigin("*")
public class ContractRestController {
    @Autowired
    private IContractService iContractService;
    @GetMapping("")
    public ResponseEntity<List<Contracts>>getAllContract(){
        List<Contracts> contractsList=iContractService.findAll();
        return new ResponseEntity<>(contractsList, HttpStatus.OK);
    }
    @PostMapping("/createContract")
    public ResponseEntity<?> createContracts(@RequestBody @Valid ContractDto contractDto,BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Contracts contracts=new Contracts();
        BeanUtils.copyProperties(contractDto,contracts);
            iContractService.createContract(contracts);
            return new ResponseEntity<>(HttpStatus.CREATED);
    }
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
//        Map<String, String> errors = new HashMap<>();
//        ex.getBindingResult().getAllErrors().forEach((error) -> {
//            String fieldName = ((FieldError) error).getField();
//            String errorMessage = error.getDefaultMessage();
//            errors.put(fieldName, errorMessage);
//        });
//        return errors;
//    }

}

