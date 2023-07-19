package com.example.back_end.controller;

import com.example.back_end.dto.CreateContractDto;
import com.example.back_end.model.Contracts;
import com.example.back_end.model.ProductType;
import com.example.back_end.projections.ContractSearchDTO;
import com.example.back_end.projections.IContractProjection;
import com.example.back_end.service.IContractService;
import com.example.back_end.service.impl.EmailService;
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


/**
 * Created by: DinhHD
 * Date created: 13/07/2023
 * Function: do about pawn interface, customer selection interface
 * <p>
 * // * @param Contracts
 *
 * @return createContracts()
 */

@RequestMapping("/api/employee/contract")
@RestController

@CrossOrigin("*")
public class ContractController {
    @Autowired
    private IContractService iContractService;

    @Autowired
    private EmailService emailService;

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
        Page<IContractProjection> contractProjectionPage = this.iContractService.findAllTransactionHistory(page, limit);
        int totalPage = contractProjectionPage.getTotalPages();
        if (page >= totalPage) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if (contractProjectionPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
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
    public ResponseEntity<Contracts> getTransactionHistoryDetail(@PathVariable("id") Integer id) {
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
        Page<IContractProjection> contractProjectionsPage = iContractService.searchTransactionHistory(page, limit, contractSearchDTO);
        return new ResponseEntity<>(contractProjectionsPage, HttpStatus.OK);
    }

    @PostMapping("/createContract")
    public ResponseEntity<?> createContracts(@RequestBody @Valid CreateContractDto contractDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Contracts contracts = new Contracts();
        BeanUtils.copyProperties(contractDto, contracts);
        iContractService.createContract(contracts);
//        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//        String startDateFormatted = dateFormat.format(contracts.getStartDate());
//        String endDateFormatted = dateFormat.format(contracts.getEndDate());
        emailService.sendMail(contracts.getCustomers().getEmail(), "Xin chào " + contracts.getCustomers().getName() + ", cảm ơn bạn đã ghé Pawn Shop ! ", "Bạn đã cầm món đồ có tên : " + contracts.getProductName() + "\n " +
                "\n -Với giá là:" + contracts.getLoans() + " VNĐ" +
                "\n -Có thời hạn chuộc lại từ :" + contracts.getStartDate() +
                "\n -Đến ngày hết hạn là :" + contracts.getStartDate() +
                "\n -Với tổng số tiền lãi là " + contracts.getProfit() + " VND" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "---------------------------------------" + "\n" +
                "Name :Pawn Shop\n" +
                "Mobile : 0782391943\n" +
                "Email : pawnshopC0123@gmail.com\n" +
                "Address :\u200B2\u200B80\u200B \u200BTrần Hưng Đạo\u200B streets, \u200BSơn Trà\u200B District, Da Nang");

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Contracts>> getAllContracts() {
        List<Contracts> contractsList = iContractService.findAll();
        return new ResponseEntity<>(contractsList, HttpStatus.OK);
    }
}