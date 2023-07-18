package com.example.back_end.controller;

import com.example.back_end.dto.ContractDto;
import com.example.back_end.dto.CreateContractDto;
import com.example.back_end.model.Contracts;
import com.example.back_end.projections.IContractProjection;
import com.example.back_end.service.IContractService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RequestMapping("/api/employee/contract")
@RestController
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
     * @param
     * @return ResponseEntity<Page < IContractProjection>>
     */

    @GetMapping("")
    public ResponseEntity<Page<IContractProjection>> getAllTransactionHistory(@RequestParam(name = "page", defaultValue = "0") Integer page,
                                                                              @RequestParam(name = "limit", defaultValue = "5") Integer limit) {
        Page<IContractProjection> contractProjectionPage = this.iContractService.findAllTransactionHistory(page, limit);
        int totalPage = contractProjectionPage.getTotalPages();
        if (page >= totalPage) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(contractProjectionPage, HttpStatus.OK);
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
    public ResponseEntity<Boolean> deleteTransactionHistoryById(@PathVariable("id") String id) {
        Optional<Contracts> contractDTO = iContractService.findTransactionHistoryById(id);
        if (!contractDTO.isPresent()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
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
    public ResponseEntity<Contracts> showTransactionHistoryDetail(@PathVariable("id") String id) {
        Optional<Contracts> contractDTO = iContractService.findTransactionHistoryById(id);
        return contractDTO.map(contracts -> new ResponseEntity<>(contracts, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    /**
     * Created by: ThienNT
     * Date created: 13/07/2023
     * Function: search transaction history from Database
     * <p>
     *
     * @param
     * @return ResponseEntity<IContractProjection>
     * @requestbody contractSearchDTO
     */

//    @GetMapping("")
//    public ResponseEntity<Page<IContractProjection>> showListAndSearchTransactionHistory(@RequestParam(name = "page", defaultValue = "0") Integer page,
//                                                                                         @RequestParam(name = "limit", defaultValue = "5") Integer limit,
//                                                                                         @RequestBody ContractSearchDTO contractSearchDTO) {
//        Page<IContractProjection> contractProjectionsPage = iContractService.showListAndSearchTransactionHistory(page, limit, contractSearchDTO);
//        int totalPage = contractProjectionsPage.getTotalPages();
//        if (page >= totalPage) {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//        return new ResponseEntity<>(contractProjectionsPage, HttpStatus.OK);
//    }
    @GetMapping("/list")
    public ResponseEntity<List<Contracts>> getAllContract() {
        List<Contracts> contractsList = iContractService.findAll();
        return new ResponseEntity<>(contractsList, HttpStatus.OK);
    }

    @PostMapping("/createContract")
    public ResponseEntity<?> createContracts(@RequestBody @Valid CreateContractDto contractDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Contracts contracts = new Contracts();
        BeanUtils.copyProperties(contractDto, contracts);
        iContractService.createContract(contracts);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * Create by : TriPD
     * Date created : 13/07/2023
     * Function : findContractById(),updateContract()
     */

    @GetMapping("/findContractById/{id}")
    public ResponseEntity<ContractDto> getContractById(@PathVariable Long id) {
        Contracts contract = this.iContractService.findContractById(id);
        if (contract == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        ContractDto contractDto = new ContractDto();
        BeanUtils.copyProperties(contract, contractDto);
        return new ResponseEntity<>(contractDto, HttpStatus.OK);
    }


    @PatchMapping("/update")
    public ResponseEntity<ContractDto> updateContract(@RequestBody ContractDto contractDto) {
        if (contractDto == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        iContractService.saveContract(contractDto);
        return new ResponseEntity<>(contractDto, HttpStatus.OK);
    }

    @GetMapping("/top10")
    public ResponseEntity<List<Contracts>> top10NewContract() {
        List<Contracts> contracts = this.iContractService.showTop10NewContract();
        if (contracts.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(contracts, HttpStatus.OK);
    }
}