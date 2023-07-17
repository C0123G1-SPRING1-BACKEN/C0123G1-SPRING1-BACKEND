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
public class LiquidationController_getInfoCustomer {
    @Autowired
    private MockMvc mockMvc;

    /**
     * Create By : KhangPVa
     * Date Create : 14/07/2023
     * get info customer [id] = null
     *
     * @throws Exception
     */

    @Test
    public void getInfoCustomer_id_1() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(
                                "/api/employee/liquidation/customer/{id}","null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create By : KhangPVa
     * Date Create : 14/07/2023
     * get info customer [id] = ""
     *
     * @throws Exception
     */

    @Test
    public void getInfoCustomer_id_2() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(
                                "/api/employee/liquidation/customer/{id}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * Create By : KhangPVa
     * Date Create : 14/07/2023
     * get info customer [id] Không tồn tại trong DB
     *
     * @throws Exception
     */

    @Test
    public void getInfoCustomer_id_3() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(
                                "/api/employee/liquidation/customer/{id}", "2"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * Create By : KhangPVa
     * Date Create : 14/07/2023
     * get info customer [id] Tồn tại trong DB
     *
     * @throws Exception
     */

    @Test
    public void getInfoCustomer_id_4() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(
                                "/api/employee/liquidation/customer/{id}", "1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("id").value(1))
                .andExpect(jsonPath("name").value("Huynh Duc Dinh"))
                .andExpect(jsonPath("citizenCode").value("201964254"))
                .andExpect(jsonPath("quantityContract").value(4));
    }

}
