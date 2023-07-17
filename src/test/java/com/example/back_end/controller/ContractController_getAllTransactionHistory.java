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
public class ContractController_getAllTransactionHistory {
    @Autowired
    private MockMvc mockMvc;

    /**
     * List Transaction History have param [page]=null and [limit]=null
     * Create by :ThienNT
     * Date create: 14/07/2023
     *
     * @param
     * @throws Exception
     */

    @Test
    public void getAllTransactionHistory_7() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/employee/contract?page=l&limit="))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * List Transaction History have param [page]='' and [limit]=''
     * Create by :ThienNT
     * Date create: 14/07/2023
     *
     * @param
     * @throws Exception
     */

    @Test
    public void getAllTransactionHistory_8() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/employee/contract?page=''&limit=''"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * List Transaction History have param [page] and [limit]=have in the database
     * Create by :ThienNT
     * Date create: 14/07/2023
     *
     * @param
     * @throws Exception
     */

    @Test
    public void getAllTransactionHistory_9() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/employee/contract?page=9999999999999999999999999&limit=5"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * List Transaction History size =0
     * Create by :ThienNT
     * Date create: 14/07/2023
     *
     * @param
     * @throws Exception
     */

    @Test
    public void getAllTransactionHistory_10() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/employee/contract?page=0&limit=5"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * List Transaction History size >0
     * Create by :ThienNT
     * Date create: 14/07/2023
     *
     * @param
     * @throws
     */

    @Test
    public void getAllTransactionHistory_11() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/employee/contract?page=0&limit=5"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * List Transaction History has param [page] and [limit]= incorrect format
     * Create by :ThienNT
     * Date create: 14/07/2023
     *
     * @param
     * @throws
     */

    @Test
    public void getAllTransactionHistory_99() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/employee/contract?page=xvca&limit=5"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
}
