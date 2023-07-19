/**
 * Created by: KhanhKQ
 * Date created: 13/07/2023
 * Function: display list contract/liquidation into Database, Calculate total profit
 *
 * @param page,
 * @param profitType (Type of profit)
 * @param startDate, endDate (The date range you want to calculate the profit)
 * @return getAllContract() : Returns a list of contracts by statistical date range
 * @return getTotalProfit() : Returns the total profit by the statistical date range
 * @return statisticsProfit() : Returns the statistics of months by date range
 */


package com.example.back_end.controller;

import com.example.back_end.dto.IStatistics;
import com.example.back_end.service.IProfitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/employee/profit")
public class ProfitController {
    @Autowired
    private IProfitService iProfitService;


    @GetMapping("")
    private <T> ResponseEntity<Page<T>> getAllContract(@RequestParam(value = "startDate", defaultValue = "") String startDate,
                                                       @RequestParam(value = "endDate", defaultValue = "") String endDate,
                                                       @RequestParam(value = "page", defaultValue = "0") Integer page,
                                                       @RequestParam(value = "profitType", defaultValue = "interest") String profitType) {
        Pageable pageable = PageRequest.of(page, 8);
        Page<T> contractPage = iProfitService.findAllContract(startDate, endDate, pageable, profitType);
        if (contractPage.getTotalElements() ==0 || contractPage.getContent().size() == 0) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(contractPage, HttpStatus.OK);
    }

    @GetMapping("/total-profit")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_EMPLOYEE')")
    private ResponseEntity<Long> getTotalProfit( @RequestParam(value = "startDate", defaultValue = "") String startDate,
                                                @RequestParam(value = "endDate", defaultValue = "") String endDate,
                                                @RequestParam(value = "profitType", defaultValue = "interest") String profitType) {
        Long totalProfit = iProfitService.getTotalProfit(startDate, endDate, profitType);
        if(totalProfit == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(totalProfit, HttpStatus.OK);
    }

    @GetMapping("/statistics-profit")
    private ResponseEntity<List<IStatistics>> statisticsProfit(@RequestParam(value = "startDate", defaultValue = "") String startDate,
                                                         @RequestParam(value = "endDate", defaultValue = "") String endDate,
                                                         @RequestParam(value = "profitType", defaultValue = "interest") String profitType){
        List<IStatistics> statisticsList = iProfitService.statisticsProfit(startDate,endDate,profitType);
        if(statisticsList.size() == 0){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(statisticsList,HttpStatus.OK);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntimeException(RuntimeException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Not Found");
    }
}
