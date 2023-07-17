package com.example.back_end.controller;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class LiquidationController_searchContract {
    @Autowired
    private MockMvc mockMvc;

    /**
     * Create By : KhangPVa
     * Date Create : 14/07/2023
     * search contract Trường hợp Trả về list có size = 0
     *
     * @throws Exception
     */

    @Test
    public void searchContract_5() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/employee/liquidation/contracts/search?productName=null&productType=null&loans=null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * Create By : KhangPVa
     * Date Create : 14/07/2023
     * search contract Trường hợp Trả về list có size > 0
     *
     * @throws Exception
     */

    @Test
    public void searchContract_6() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/employee/liquidation/contracts/search?productName=Iphone X&productType=1&loans=123"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
