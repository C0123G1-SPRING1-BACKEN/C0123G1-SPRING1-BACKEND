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
public class ContractController_showTransactionHistoryDetail {
    @Autowired
    private MockMvc mockMvc;

    /**
     * Find transaction history have param [id] = null
     * Create by :ThienNT
     * Date create: 14/07/2023
     *
     * @param
     * @throws Exception
     */

    @Test
    public void showTransactionHistoryDetail_1() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/employee/contract/detail/{id}", "null")
                )
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Find transaction history have param [id] = blank ('')
     * Create by :ThienNT
     * Date create: 14/07/2023
     *
     * @param
     * @throws Exception
     */

    @Test
    public void showTransactionHistoryDetail_2() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/employee/contract/detail/{id}", "")
                )
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Find transaction history have param [id] = have not in the database
     * Create by :ThienNT
     * Date create: 14/07/2023
     *
     * @param
     * @throws Exception
     */

    @Test
    public void showTransactionHistoryDetail_3() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/employee/contract/detail/{id}", "99999999999999999")
                )
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Find transaction history have param [id] = have in the database
     * Create by :ThienNT
     * Date create: 14/07/2023
     *
     * @param
     */

    @Test
    public void showTransactionHistoryDetail_4() throws Exception {
        Long id = 1L;
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/employee/contract/detail/{id}", id)
                )
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Find transaction history have param [id] = incorrect format
     * Create by :ThienNT
     * Date create: 14/07/2023
     *
     * @param
     */

    @Test
    public void showTransactionHistoryDetail_96() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/employee/contract/detail/{id}", "dasadx")
                )
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

}
