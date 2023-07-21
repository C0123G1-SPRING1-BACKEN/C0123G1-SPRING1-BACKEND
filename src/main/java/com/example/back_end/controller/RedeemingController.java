package com.example.back_end.controller;

import com.example.back_end.dto.open_contract.IOpenContractDTO;
import com.example.back_end.dto.open_contract.OpenContractDTO;
import com.example.back_end.model.Contracts;
import com.example.back_end.model.Customers;
import com.example.back_end.service.IRedeemingService;
import com.example.back_end.service.impl.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.time.LocalDate;

@RestController
@RequestMapping("/api/employee/redeem")
@CrossOrigin("*")
public class RedeemingController {
    @Autowired
    private IRedeemingService iRedeemingService;

    @Autowired
    private EmailService emailService;

    /**
     * Created by: HoaTQ
     * Date created: 13/07/2023
     * Function: redeem the pawned object
     * <p>
     * param: contractID
     * void: update contractStatus to closed
     */
    @Transactional
    @PatchMapping("/pay/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_EMPLOYEE')")
    public void redeem(@PathVariable("id") Long id) {
        LocalDate redeemDate = LocalDate.now();
        iRedeemingService.redeems(id, String.valueOf(redeemDate));
        Contracts contracts = iRedeemingService.findOpenContract(id);
        String name = contracts.getCustomers().getName();
        String product = contracts.getProductName();

        String to = contracts.getCustomers().getEmail();
        String subject = "Xác nhận chuộc đồ - PawnShop";
        String body = "Chào " + name + ",\n" +
                "\n" +
                "Chúng tôi gửi mail này để xác nhận rằng bạn vừa thanh toán đê nhận lại " + product + " vào ngày " + redeemDate +"\n" +
                "\n" +
                "Chúng tôi xin cảm ơn quý khách đã tin tường và sử dụng dịch vụ của chúng tôi.\n" +
                "\n" +
                "Pawn Shop\n" +
                "\n";

        emailService.sendMail(to, subject, body);


    }


    /**
     * Created by: HoaTQ
     * Date created: 13/07/2023
     * Function:  findById()
     * <p>
     * param: contractId (from PathVariable)
     * return: the list of contract with the contractStatus is open and match the contractId
     */
    @GetMapping("/chose/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_EMPLOYEE')")
    public ResponseEntity<Contracts> findById(@PathVariable("id") Long id) {
        return new ResponseEntity<Contracts>(iRedeemingService.findOpenContract(id), HttpStatus.OK);
    }


    /**
     * Created by: HoaTQ
     * Date created: 13/07/2023
     * Function:  getOpenContractList(page
     * <p>
     * param: page (the page number that the user want to view)
     * return: the list of contract with the contractStatus is open
     * issue: in progress for searching how to get list from Spring Data JPA DTO Projection
     * I have covered my issue.
     */
    @Transactional
    @GetMapping("/chooseContract")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_EMPLOYEE')")
    public ResponseEntity<Page<OpenContractDTO>> getOpenContractList(@RequestParam(value = "page", defaultValue = "0") Integer page) {
        Pageable pageable = PageRequest.of(page, 5, Sort.by(Sort.Order.desc("create_time")));
        Page<OpenContractDTO> contractsPage = iRedeemingService.findPageConTract(pageable);

        if (contractsPage == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(contractsPage, HttpStatus.OK);
    }


    /**
     * Created by: HoaTQ
     * Date created: 13/07/2023
     * Function: getOpenContractSearchList()
     * <p>
     * param: page,contractCode,customerName,productName,startDate (from RequestParam on URL )
     * return: the list of contract with the contractStatus is open and match to those params
     */
    @Transactional
    @GetMapping("/search")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_EMPLOYEE')")
    public ResponseEntity<Page<OpenContractDTO>> getOpenContractSearchList(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                                                           @RequestParam(value = "contractCode") String contractCode,
                                                                           @RequestParam(value = "customerName") String customerName,
                                                                           @RequestParam(value = "productName") String productName,
                                                                           @RequestParam(value = "startDate") String startDate) {
        Pageable pageable = PageRequest.of(page, 5, Sort.by(Sort.Order.desc("create_time")));
        Page<OpenContractDTO> contractsPage = iRedeemingService.searchPageConTract(pageable, '%' + contractCode + '%', '%' + customerName + '%', '%' + productName + '%', '%' + startDate + '%');

        if (contractsPage == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(contractsPage, HttpStatus.OK);
    }

}
