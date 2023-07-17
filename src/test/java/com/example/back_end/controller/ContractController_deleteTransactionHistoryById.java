package com.example.back_end.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ContractController_deleteTransactionHistoryById {
    @Autowired
    private MockMvc mockMvc;

    /**
     * Xóa đối tượng có tham số [id] = null
     * Create by :ThienNT
     * Date create: 14/07/2023
     *
     * @param
     * @throws Exception
     */

    @Test
    public void deleteTransactionHistoryById_1() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/employee/contract/delete/{id}", "null")
                )
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Xóa đối tượng có tham số [id] = rỗng ('')
     * Create by :ThienNT
     * Date create: 14/07/2023
     *
     * @param
     * @throws Exception
     */

    @Test
    public void deleteTransactionHistoryById_2() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/employee/contract/detail/{id}", "")
                )
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Xóa đối tượng có tham số [id] = không có trong database
     * Create by :ThienNT
     * Date create: 14/07/2023
     *
     * @param
     * @throws Exception
     */

    @Test
    public void deleteTransactionHistoryById_3() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/employee/contract/detail/{id}", "99999999999999999")
                )
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Xóa đối tượng có tham số [id] = có trong database
     * Create by :ThienNT
     * Date create: 14/07/2023
     *
     * @param
     */

    @Test
    public void deleteTransactionHistoryById_4() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/employee/contract/detail/{id}", "1")
                )
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Xóa đối tượng có tham số [id] = không đúng định dạng là số nguyên
     * Create by :ThienNT
     * Date create: 14/07/2023
     *
     * @param
     */

    @Test
    public void deleteTransactionHistoryById_99() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/employee/contract/detail/{id}", "dasadx")
                )
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

}

