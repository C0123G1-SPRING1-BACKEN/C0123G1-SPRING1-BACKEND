package com.example.back_end.controller;

import com.example.back_end.model.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ContractRestController_updateContract {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void updateContract_contractCode_19() throws Exception {
        Contracts contracts= new Contracts();
        contracts.setContractCode(null);
        contracts.setProductName("xe máy");
        contracts.setLoans(Long.valueOf(1000000));
        contracts.setProfit(Long.valueOf(100000));
        contracts.setImage("https://images2.thanhnien.vn/Uploaded/ngocthanh/2016_03_23/9x01_YGEO.jpg");
        contracts.setStartDate("22/02/2022");
        contracts.setEndDate("23/03/2022");
        contracts.setCreateTime(LocalDateTime.parse("2022-05-14 13:30:10"));
        contracts.setUpdateDate(LocalDateTime.parse("2022-05-17 13:54"));
        contracts.setDelete(false);
        ProductType productType=new ProductType();
        productType.setId(Long.valueOf(2));
        contracts.setProductType(productType);
        Customers customers=new Customers();
        customers.setId(Long.valueOf(2));
        contracts.setCustomers(customers);
        ContractStatus contractStatus=new ContractStatus();
        contractStatus.setId(Long.valueOf(1));
        contracts.setContractStatus(contractStatus);
        Employees employees=new Employees();
        employees.setId(Long.valueOf(2));
        contracts.setEmployees(employees);
        ContractType contractType=new ContractType();
        contractType.setId(Long.valueOf(2));
        contracts.setContractType(contractType);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/employee/contract/{1}")
                        .content(this.objectMapper.writeValueAsString(contracts))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
}

