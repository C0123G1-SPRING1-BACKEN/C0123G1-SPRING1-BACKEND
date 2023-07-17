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
public class LiquidationController_getInfoContract {
    @Autowired
    private MockMvc mockMvc;

    /**
     * Create By : KhangPVa
     * Date Create : 14/07/2023
     * get info contract [id] = null
     *
     * @throws Exception
     */

    @Test
    public void getInfoContract_id_1() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(
                                "/api/employee/liquidation/contract/{id}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create By : KhangPVa
     * Date Create : 14/07/2023
     * get info contract [id] = ""
     *
     * @throws Exception
     */

    @Test
    public void getInfoContract_id_2() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(
                                "/api/employee/liquidation/contract/{id}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Create By : KhangPVa
     * Date Create : 14/07/2023
     * get info contract [id] Không tồn tại trong DB
     *
     * @throws Exception
     */

    @Test
    public void getInfoContract_id_3() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(
                                "/api/employee/liquidation/contract/{id}", "2"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * Create By : KhangPVa
     * Date Create : 14/07/2023
     * get info contract [id] Tồn tại trong DB
     *
     * @throws Exception
     */

    @Test
    public void getInfoContract_id_4() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(
                                "/api/employee/liquidation/contract/{id}", "1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("productName").value("Iphone X"))
                .andExpect(jsonPath("productType").value(1))
                .andExpect(jsonPath("loans").value(123));
    }
}
