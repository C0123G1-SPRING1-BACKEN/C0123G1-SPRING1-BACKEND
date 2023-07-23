package com.example.back_end.controller;

import com.example.back_end.service.IProductTypeService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.FieldError;
import com.example.back_end.dto.ContractDto;
import com.example.back_end.dto.CreateContractDto;
import com.example.back_end.model.ContractStatus;
import com.example.back_end.model.ContractType;
import com.example.back_end.model.Contracts;
import com.example.back_end.projections.ContractSearchDTO;
import com.example.back_end.projections.ITransactionHistoryProjection;
import com.example.back_end.service.IContractService;
import com.example.back_end.service.IProductTypeService;
import com.example.back_end.service.impl.EmailService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@RequestMapping("/api/employee/contract")
@RestController
@CrossOrigin("*")
public class ContractRestController {

    @Autowired
    private IContractService iContractService;

    @Autowired
    private IProductTypeService iProductTypeService;

    @Autowired
    private EmailService emailService;


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
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_EMPLOYEE')")
    public ResponseEntity<Boolean> deleteTransactionHistoryById(@PathVariable("id") Integer id) {
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
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_EMPLOYEE')")
    public ResponseEntity<Contracts> showTransactionHistoryDetail(@PathVariable("id") Integer id) {
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

    @PostMapping("/transaction-history")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_EMPLOYEE')")
    public ResponseEntity<Page<ITransactionHistoryProjection>> showListAndSearchTransactionHistory(@RequestParam(name = "page", defaultValue = "0") Integer page,
                                                                                                   @RequestParam(name = "limit", defaultValue = "5") Integer limit,
                                                                                                   @RequestBody ContractSearchDTO contractSearchDTO) {
        Page<ITransactionHistoryProjection> contractProjectionsPage = iContractService.showListAndSearchTransactionHistory(page, limit, contractSearchDTO);
        int totalPage = contractProjectionsPage.getTotalPages();
        if (page > totalPage || page < 0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(contractProjectionsPage, HttpStatus.OK);
    }

    @GetMapping("/list")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_EMPLOYEE')")
    public ResponseEntity<List<Contracts>> getAllContract() {
        List<Contracts> contractsList = iContractService.findAll();
        return new ResponseEntity<>(contractsList, HttpStatus.OK);
    }

    /**
     * Create by : TriPD
     * Date created : 18/07/2023
     * Function : findContractById()
     *
     * @Param: id
     * @Return: object
     */

    @GetMapping("/findContractById/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_EMPLOYEE')")
    public ResponseEntity<ContractDto> getContractById(@PathVariable Long id) {
        Contracts contract = this.iContractService.findContractById(id);
        if (contract == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        ContractDto contractDto = new ContractDto();
        BeanUtils.copyProperties(contract, contractDto);
        return new ResponseEntity<>(contractDto, HttpStatus.OK);
    }

    /**
     * Create by : TriPD
     * Date created : 18/07/2023
     * Function : updateContract()
     *
     * @Param: contractDto
     * @Return: void
     */

    @PatchMapping("/update")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_EMPLOYEE')")
    public ResponseEntity<?> updateContract(@RequestBody ContractDto contractDto) {
        try {
            iContractService.saveContract(contractDto);
            return ResponseEntity.ok(contractDto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(".....");
        }

    }

    /**
     * Create by : TriPD
     * Date created : 18/07/2023
     * Function : top10NewContract()
     *
     * @Param: pageable
     * @Return: Page<Contracts>
     */

    @GetMapping("/top10")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_EMPLOYEE')")
    public ResponseEntity<Page<Contracts>> top10NewContract(@PageableDefault(sort = "create_time", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<Contracts> contracts = this.iContractService.showTop10NewContract(pageable);
        if (contracts.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(contracts, HttpStatus.OK);
    }

    @GetMapping("/list-contract-status")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_EMPLOYEE')")
    public ResponseEntity<List<ContractStatus>> getALlContractStatus() {
        List<ContractStatus> contractStatusList = this.iProductTypeService.getAllContractStatus();
        if (contractStatusList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(contractStatusList, HttpStatus.OK);
    }

    @GetMapping("/list-contract-type")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_EMPLOYEE')")
    public ResponseEntity<List<ContractType>> getALlContractType() {
        List<ContractType> contractTypeList = this.iProductTypeService.getAllContractType();
        if (contractTypeList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(contractTypeList, HttpStatus.OK);
    }


    @PostMapping("/createContract")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_EMPLOYEE')")
    public ResponseEntity<CreateContractDto> createContracts(@RequestBody @Valid CreateContractDto contractDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
            List<Contracts> contractsList = iContractService.findAll();
//        tạo list rỗng chứa trùng lặp
        List<Contracts> contractsArrayList = new ArrayList<>();
            // Kiểm tra mã trùng lặp
            Set<String> productCodesSet = new HashSet<>();
            for (Contracts contracts : contractsList) {
                String productCode = contracts.getContractCode();
//                kiểm tra mã hợp đồng tồn tị hay chưa , nếu tồn tại rồi thì sẽ thêm vào list rổng ở trên
                if (productCodesSet.contains(productCode)) {
                    contractsArrayList.add(contracts);
                } else {
                    productCodesSet.add(productCode);

                }
            }

        Contracts contracts = new Contracts();
        BeanUtils.copyProperties(contractDto, contracts);
        iContractService.createContract(contracts);
        //Format Giá tiền (000,000,000,)
        NumberFormat numberFormat = NumberFormat.getInstance();
        String profit = (numberFormat.format(contracts.getProfit()));
        String loans = (numberFormat.format(contracts.getLoans()));
        System.out.println("Đầu ra tiền cho vay: " + loans);
        System.out.println("Đầu ra tiền lãi: " + profit);
        //Format Ngày tháng năm(dd/MM/yyyy)
        DateTimeFormatter dateTimer = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate startDate = LocalDate.parse(contracts.getStartDate());
        LocalDate endDate = LocalDate.parse(contracts.getEndDate());
        String start = startDate.format(dateTimer);
        String end = endDate.format(dateTimer);
        System.out.println("Ngày bắt đầu: " + start);
        System.out.println("Ngày kết thúc: " + end);

        emailService.sendMail(contracts.getCustomers().getEmail(), "Xin chào " + contracts.getCustomers().getName() + ", cảm ơn bạn đã ghé Pawn Shop ! ", "Bạn đã cầm món đồ có tên : " + contracts.getProductName() + "\n " +
                "\n -Với giá là:" + loans + " VNĐ" +
                "\n -Ngày bắt đầu hợp đồng là :" + start +
                "\n -Đến ngày kết thúc hợp đồng là :" + end +
                "\n -Với tổng số tiền lãi là " + profit + " VND" +
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

    @GetMapping("/randomContract")
    public String randomContractCode() {
      String random= iContractService.randomContract().toString();

        return random;
    }
}