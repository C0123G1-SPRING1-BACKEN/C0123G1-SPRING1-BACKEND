package com.example.back_end.controller;

import com.example.back_end.projections.ContractDTO;
import com.example.back_end.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/employee/contract")
@CrossOrigin("*")
public class ContractController {
    @Autowired
    private IContractService iContractService;

    /**
     * Created by: ThienNT
     * Date created: 13/07/2023
     * Function: get page transaction history from Database
     * <p>
     * @param page
     *
     * @return Page<ContractDTO>
     */

    @GetMapping("")
    public ResponseEntity<Page<ContractDTO>> getALlContract(@RequestParam(name = "page", defaultValue = "0") Integer page) {
        return new ResponseEntity<>(iContractService.findAllContract(page), HttpStatus.OK);
    }

    /**
     * Created by: ThienNT
     * Date created: 13/07/2023
     * Function: delete transaction history
     * <p>
     * @param id
     *
     * @return check
     */

    @GetMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteContract(@PathVariable("id") Integer id) {
        Boolean check = iContractService.deleteContractById(id);
        return new ResponseEntity<>(check, HttpStatus.OK);
    }

    /**
     * Created by: ThienNT
     * Date created: 13/07/2023
     * Function: find transaction history from Database
     * <p>
     * @param id
     *
     * @return contractDTO
     */
    @GetMapping("/detail/{id}")
    public ResponseEntity<ContractDTO> detailContract(@PathVariable("id") Integer id) {
        ContractDTO contractDTO = iContractService.findContractById(id);
        return new ResponseEntity<>(contractDTO, HttpStatus.OK);
    }
}
