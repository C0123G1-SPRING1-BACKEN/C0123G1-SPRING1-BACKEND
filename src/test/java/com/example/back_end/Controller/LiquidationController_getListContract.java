package com.example.back_end.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class LiquidationController_getListContract {
    @Autowired
    private MockMvc mockMvc;


    /**
     * Create By : KhangPVa
     * Date Create : 14/07/2023
     * get list contracts: Trường hợp trả về list có size = 0
     *
     * @throws Exception
     */

    @Test
    public void getListContract_5() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/employee/liquidation/contracts/"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * Create By : KhangPVa
     * Date Create : 14/07/2023
     * get list contracts: Trường hợp trả về list có size > 0
     *
     * @throws Exception
     */

    @Test
    public void getListCustomer_6() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/employee/liquidation/contracts?page=0"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(1))
                .andExpect(jsonPath("content[0].productName").value("Iphone X"))
                .andExpect(jsonPath("content[0].productType").value("Điện thoại"))
                .andExpect(jsonPath("content[0].loans").value("123"))
                .andExpect(jsonPath("content[0].total").value("1"));
    }
}
