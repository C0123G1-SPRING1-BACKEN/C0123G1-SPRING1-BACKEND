package com.example.back_end.controller;

import com.example.back_end.dto.ICustomerDto;
import com.example.back_end.dto.IContractDto;
import com.example.back_end.dto.LiquidationsDto;
import com.example.back_end.model.Contracts;
import com.example.back_end.model.Liquidations;
import com.example.back_end.service.ICustomerService;
import com.example.back_end.service.contracts.IContractsService;
import com.example.back_end.service.impl.EmailService;
import com.example.back_end.service.liquidations.ILiquidationsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;


/**
 * Created by: KhangPVA
 * Date created: 13/07/2023
 * Function: create liquidation
 * <p>
 * // * @param LiquidaytionDto
 *
 * @return Liquidation
 */

@RestController
@RequestMapping("/api/employee/liquidation")
@CrossOrigin("*")
public class LiquidationRestController {
    @Autowired
    private ILiquidationsService liquidationsService;
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private IContractsService contractsService;
    @Autowired
    private EmailService emailService;

//    @Transactional
//    @PatchMapping("/pay/{id}")
//    public void redeem(@PathVariable("id") Long id, @Param("redeemDate") String redeemDate) {
//        iRedeemingService.redeems(id, redeemDate);
//        Contracts contracts = iRedeemingService.findOpenContract(id);
//        String name = contracts.getCustomers().getName();
//        String product = contracts.getProductName();
//
//        String to = contracts.getCustomers().getEmail();
//        String subject = "Xác nhận chuộc đồ - PawnShop";
//        String body = "Chào " + name + ",\n" +
//                "\n" +
//                "Chúng tôi gửi mail này để xác nhận rằng bạn vừa thanh toán đê nhận lại " + product + " vào ngày " + redeemDate +"\n" +
//                "\n" +
//                "Chúng tôi xin cảm ơn quý khách đã tin tường và sử dụng dịch vụ của chúng tôi.\n" +
//                "\n" +
//                "Pawn Shop\n" +
//                "\n";
//
//        emailService.sendMail(to, subject, body);
//
//
//    }
//

    @PostMapping("")
    public ResponseEntity<?> createLiquidation(@Valid @RequestBody LiquidationsDto liquidationsDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Liquidations liquidations = new Liquidations();
        BeanUtils.copyProperties(liquidationsDto, liquidations);
        liquidationsService.save(liquidations);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/customers")
    public ResponseEntity<Page<ICustomerDto>> getListCustomer(@PageableDefault(size = 6) Pageable pageable,
                                                              @RequestParam("name") String name) {
        Page<ICustomerDto> customerDtoPage = customerService.findByCustomer(pageable, name);
        if (customerDtoPage.isEmpty()) {
            return new ResponseEntity<>(customerDtoPage, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customerDtoPage, HttpStatus.OK);
    }


    @GetMapping("/contracts")
    public ResponseEntity<Page<IContractDto>> getListProduct(@PageableDefault(size = 6) Pageable pageable, @RequestParam("productName") String productName
            , @RequestParam("productType") String productType, @RequestParam("loans") String loans) {
        Page<IContractDto> contractsDtoPage = contractsService.findAllProduct(pageable, productName, productType, loans);
        if (contractsDtoPage.isEmpty()) {
            return new ResponseEntity<>(contractsDtoPage, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(contractsDtoPage, HttpStatus.OK);
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<ICustomerDto> getByIdCustomer(@PathVariable("id") Long id) {
        ICustomerDto iCustomerDto = customerService.findByIdCustomer(id);
        if (iCustomerDto == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(iCustomerDto, HttpStatus.OK);
    }

    @GetMapping("/contract/{id}")
    public ResponseEntity<IContractDto> getByIdContract(@PathVariable("id") Long id) {
        IContractDto iContractDto = contractsService.findContractById(id);
        if (iContractDto == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(iContractDto, HttpStatus.OK);
    }

}
