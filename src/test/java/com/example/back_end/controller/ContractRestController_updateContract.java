package com.example.back_end.controller;

import com.example.back_end.dto.ContractDto;
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
        ContractDto contractDto=new ContractDto();
        contractDto.setContractCode(null);
        contractDto.setProductName("xe máy");
        contractDto.setLoans(Long.valueOf(1000000));
        contractDto.setProfit(Long.valueOf(100000));
        contractDto.setImage("https://images2.thanhnien.vn/Uploaded/ngocthanh/2016_03_23/9x01_YGEO.jpg");
        contractDto.setStartDate("22/02/2022");
        contractDto.setEndDate("23/03/2022");
        ProductType productType=new ProductType();
        productType.setId(Long.valueOf(2));
        contractDto.setProductType(productType);
        Customers customers=new Customers();
        customers.setId(Long.valueOf(2));
        contractDto.setCustomers(customers);
        ContractStatus contractStatus=new ContractStatus();
        contractStatus.setId(Long.valueOf(1));
        contractDto.setContractStatus(contractStatus);
        Employees employees=new Employees();
        employees.setId(Long.valueOf(2));
        contractDto.setEmployees(employees);
        ContractType contractType=new ContractType();
        contractType.setId(Long.valueOf(2));
        contractDto.setContractType(contractType);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/employee/contract/update/{id}","1")
                        .content(this.objectMapper.writeValueAsString(contractDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void updateContract_contractCode_20() throws Exception {
        ContractDto contractDto=new ContractDto();
        contractDto.setContractCode("");
        contractDto.setProductName("xe máy");
        contractDto.setLoans(Long.valueOf(1000000));
        contractDto.setProfit(Long.valueOf(100000));
        contractDto.setImage("https://images2.thanhnien.vn/Uploaded/ngocthanh/2016_03_23/9x01_YGEO.jpg");
        contractDto.setStartDate("22/02/2022");
        contractDto.setEndDate("23/03/2022");
        ProductType productType=new ProductType();
        productType.setId(Long.valueOf(2));
        contractDto.setProductType(productType);
        Customers customers=new Customers();
        customers.setId(Long.valueOf(2));
        contractDto.setCustomers(customers);
        ContractStatus contractStatus=new ContractStatus();
        contractStatus.setId(Long.valueOf(1));
        contractDto.setContractStatus(contractStatus);
        Employees employees=new Employees();
        employees.setId(Long.valueOf(2));
        contractDto.setEmployees(employees);
        ContractType contractType=new ContractType();
        contractType.setId(Long.valueOf(2));
        contractDto.setContractType(contractType);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/employee/contract/update/{id}","1")
                        .content(this.objectMapper.writeValueAsString(contractDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void updateContract_contractCode_21() throws Exception {
        ContractDto contractDto=new ContractDto();
        contractDto.setContractCode("HD-2");
        contractDto.setProductName("xe máy");
        contractDto.setLoans(Long.valueOf(1000000));
        contractDto.setProfit(Long.valueOf(100000));
        contractDto.setImage("https://images2.thanhnien.vn/Uploaded/ngocthanh/2016_03_23/9x01_YGEO.jpg");
        contractDto.setStartDate("22/02/2022");
        contractDto.setEndDate("23/03/2022");
        ProductType productType=new ProductType();
        productType.setId(Long.valueOf(2));
        contractDto.setProductType(productType);
        Customers customers=new Customers();
        customers.setId(Long.valueOf(2));
        contractDto.setCustomers(customers);
        ContractStatus contractStatus=new ContractStatus();
        contractStatus.setId(Long.valueOf(1));
        contractDto.setContractStatus(contractStatus);
        Employees employees=new Employees();
        employees.setId(Long.valueOf(2));
        contractDto.setEmployees(employees);
        ContractType contractType=new ContractType();
        contractType.setId(Long.valueOf(2));
        contractDto.setContractType(contractType);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/employee/contract/update/{id}","2")
                        .content(this.objectMapper.writeValueAsString(contractDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
}

