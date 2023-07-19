package com.example.back_end.controller;


import com.example.back_end.dto.LiquidationsDto;
import com.example.back_end.model.Contracts;

import com.example.back_end.model.Customers;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class LiquidationController_createLiquidation {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    /**
     * Create By : KhangPVa
     * Date Create : 14/07/2023
     * create liquidation [customer] = null
     *
     * @throws Exception
     */

@Test
    public void createLiquidation_customer_13() throws Exception {
    LiquidationsDto liquidationsDto=new LiquidationsDto();
    liquidationsDto.setTotalPrice(Long.valueOf("10000"));
    Contracts contracts=new Contracts();
    contracts.setId(Long.valueOf("1"));
    liquidationsDto.setContracts(contracts);

    this.mockMvc
            .perform(MockMvcRequestBuilders
                    .post("/api/employee/liquidation")
                    .content(this.objectMapper.writeValueAsString(liquidationsDto))
                    .contentType(MediaType.APPLICATION_JSON_VALUE))
            .andDo(print())
            .andExpect(status().is4xxClientError());
}


    /**
     * Create By : KhangPVa
     * Date Create : 14/07/2023
     * create liquidation [contract] = null
     *
     * @throws Exception
     */

@Test
    public void createLiquidation_contract_13() throws Exception {
    LiquidationsDto liquidationsDto=new LiquidationsDto();
    liquidationsDto.setTotalPrice(Long.valueOf("10000"));
    Customers customers=new Customers();
    customers.setId(Long.valueOf("1"));
    liquidationsDto.setCustomers(customers);

    this.mockMvc
            .perform(MockMvcRequestBuilders
                    .post("/api/employee/liquidation")
                    .content(this.objectMapper.writeValueAsString(liquidationsDto))
                    .contentType(MediaType.APPLICATION_JSON_VALUE))
            .andDo(print())
            .andExpect(status().is4xxClientError());
}


    /**
     * Create By : KhangPVa
     * Date Create : 14/07/2023
     * create liquidation [totalPrice] = null
     *
     * @throws Exception
     */

@Test
    public void createLiquidation_totalPrice_13() throws Exception {
    LiquidationsDto liquidationsDto=new LiquidationsDto();
    Customers customers=new Customers();
    customers.setId(Long.valueOf("1"));
    liquidationsDto.setCustomers(customers);
    Contracts contracts=new Contracts();
    contracts.setId(Long.valueOf("1"));
    liquidationsDto.setContracts(contracts);

    this.mockMvc
            .perform(MockMvcRequestBuilders
                    .post("/api/employee/liquidation")
                    .content(this.objectMapper.writeValueAsString(liquidationsDto))
                    .contentType(MediaType.APPLICATION_JSON_VALUE))
            .andDo(print())
            .andExpect(status().is4xxClientError());
}
    /**
     * Create By : KhangPVa
     * Date Create : 14/07/2023
     * create liquidation All [item] đều hợp lệ
     *
     * @throws Exception
     */

@Test
    public void createLiquidation_18() throws Exception {
    LiquidationsDto liquidationsDto=new LiquidationsDto();
    liquidationsDto.setTotalPrice(Long.valueOf("10000"));
    Customers customers=new Customers();
    customers.setId(Long.valueOf("1"));
    liquidationsDto.setCustomers(customers);
    Contracts contracts=new Contracts();
    contracts.setId(Long.valueOf("1"));
    liquidationsDto.setContracts(contracts);

    this.mockMvc
            .perform(MockMvcRequestBuilders
                    .post("/api/employee/liquidation")
                    .content(this.objectMapper.writeValueAsString(liquidationsDto))
                    .contentType(MediaType.APPLICATION_JSON_VALUE))
            .andDo(print())
            .andExpect(status().is2xxSuccessful());
}
}
