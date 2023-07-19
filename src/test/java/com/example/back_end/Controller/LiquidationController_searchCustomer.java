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
public class LiquidationController_searchCustomer {
    @Autowired
    private MockMvc mockMvc;

    /**
     * Create By : KhangPVa
     * Date Create : 14/07/2023
     * search customer Trường hợp Trả về list có size = 0
     *
     * @throws Exception
     */

    @Test
    public void searchCustomer_5() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/employee/liquidation/customers/search?name=null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }



    /**
     * Create By : KhangPVa
     * Date Create : 14/07/2023
     * search customer Trường hợp Trả về list có size > 0
     *
     * @throws Exception
     */

    @Test
    public void searchCustomer_6() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/employee/liquidation/customers/search?name=Huynh Duc Dinh"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
