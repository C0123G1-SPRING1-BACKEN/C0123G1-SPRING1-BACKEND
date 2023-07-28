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
public class ContractController_deleteTransactionHistoryById {
    @Autowired
    private MockMvc mockMvc;

    /**
     * Delete transaction history param [id] = null
     * Create by :ThienNT
     * Date create: 14/07/2023
     *
     * @param
     * @throws Exception
     */

    @Test
    public void deleteTransactionHistoryById_25() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .delete("/api/employee/contract/delete/")
                )
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Delete transaction history param  [id] = blank ('')
     * Create by :ThienNT
     * Date create: 14/07/2023
     *
     * @param
     * @throws Exception
     */

    @Test
    public void deleteTransactionHistoryById_26() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .delete("/api/employee/contract/delete/{id}", "")
                )
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     *Delete transaction history param  [id] = have not in the database
     * Create by :ThienNT
     * Date create: 14/07/2023
     *
     * @param
     * @throws Exception
     */

    @Test
    public void deleteTransactionHistoryById_27() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .delete("/api/employee/contract/delete/{id}", "99999999999999999")
                )
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Delete transaction history param  [id] = have in the database
     * Create by :ThienNT
     * Date create: 14/07/2023
     *
     * @param
     */

    @Test
    public void deleteTransactionHistoryById_28() throws Exception {
        Long id =1L;
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .delete("/api/employee/contract/delete/{id}", id)
                )
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Delete transaction history param [id] = incorrect format
     * Date create: 14/07/2023
     *
     * @param
     */

    @Test
    public void deleteTransactionHistoryById_98() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .delete("/api/employee/contract/delete/{id}", "dasadx")
                )
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

}