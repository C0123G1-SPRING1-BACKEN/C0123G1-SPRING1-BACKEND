package com.example.back_end.controller;

import com.example.back_end.model.Contracts;
import com.example.back_end.projections.ContractSearchDTO;
import com.example.back_end.projections.IContractProjection;
import com.example.back_end.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/api/employee/contract")
@CrossOrigin("*")
public class ContractRestController {
    @Autowired
    private IContractService iContractService;

    /**
     * Created by: ThienNT
     * Date created: 13/07/2023
     * Function: get page transaction history from Database
     * <p>
     *
     * @param page
     * @return ResponseEntity<Page < IContractProjection>>
     */

    @GetMapping("")
    public ResponseEntity<Page<IContractProjection>> getALlTransactionHistory(@RequestParam(name = "page", defaultValue = "0") Integer page,
                                                                              @RequestParam(name = "limit", defaultValue = "5") Integer limit) {
        return new ResponseEntity<>(iContractService.findAllTransactionHistory(page, limit), HttpStatus.OK);
    }

    /**
     * Created by: ThienNT
     * Date created: 13/07/2023
     * Function: delete transaction history
     * <p>
     *
     * @param id
     * @return ResponseEntity<Boolean>
     */

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteTransactionHistoryById(@PathVariable("id") Integer id) {
        Boolean check = iContractService.deleteTransactionHistoryById(id);
        return new ResponseEntity<>(check, HttpStatus.OK);
    }

    /**
     * Created by: ThienNT
     * Date created: 13/07/2023
     * Function: find transaction history from Database
     * <p>
     *
     * @param id
     * @return ResponseEntity<Contracts>
     */

    @GetMapping("/detail/{id}")
    public ResponseEntity<Contracts> detailTransactionHistoryById(@PathVariable("id") Integer id) {
        Optional<Contracts> contractDTO = iContractService.findTransactionHistoryById(id);
        return contractDTO.map(iContractProjection -> new ResponseEntity<>(iContractProjection, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    /**
     * Created by: ThienNT
     * Date created: 13/07/2023
     * Function: search transaction history from Database
     * <p>
     *
     * @param contractSearchDTO
     * @return ResponseEntity<IContractProjection>
     * @requestbody contractSearchDTO
     */

    @GetMapping("/search")
    public ResponseEntity<Page<IContractProjection>> searchTransactionHistory(@RequestParam(name = "page", defaultValue = "0") Integer page,
                                                                              @RequestParam(name = "limit", defaultValue = "5") Integer limit,
                                                                              @RequestBody ContractSearchDTO contractSearchDTO) {
        Page<IContractProjection>contractProjectionsPage=iContractService.searchTransactionHistory(page, limit, contractSearchDTO);
        return new ResponseEntity<>(contractProjectionsPage, HttpStatus.OK);
    }
}