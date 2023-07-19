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
public class LiquidationController_getListCustomer {
    @Autowired
    private MockMvc mockMvc;


    /**
     * Create By : KhangPVa
     * Date Create : 14/07/2023
     * get list customers: Trường hợp trả về list có size = 0
     *
     * @throws Exception
     */

    @Test
    public void getListCustomer_5() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/employee/liquidation/customers/"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * Create By : KhangPVa
     * Date Create : 14/07/2023
     * get list customers: Trường hợp trả về list có size > 0
     *
     * @throws Exception
     */

    @Test
    public void getListCustomer_6() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/employee/liquidation/customers?page=0"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(3))
                .andExpect(jsonPath("content[0].name").value("Huynh Duc Dinh"))
                .andExpect(jsonPath("content[0].citizenCode").value("201964254"))
                .andExpect(jsonPath("content[0].quantityContract").value("4"));
    }

}
