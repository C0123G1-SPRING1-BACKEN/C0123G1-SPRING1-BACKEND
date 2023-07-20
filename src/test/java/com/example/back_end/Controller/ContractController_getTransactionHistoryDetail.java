package com.example.back_end.Controller;


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
public class ContractController_getTransactionHistoryDetail {
    @Autowired
    private MockMvc mockMvc;

    /**
     * Tìm đối tượng có tham số [id] = null
     * Create by :ThienNT
     * Date create: 14/07/2023
     *
     * @param id
     * @throws Exception
     */

    @Test
    public void getTransactionHistoryDetail_1() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/employee/contract/detail/{id}", "null")
                )
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Tìm đối tượng có tham số [id] = rỗng ('')
     * Create by :ThienNT
     * Date create: 14/07/2023
     *
     * @param id
     * @throws Exception
     */

    @Test
    public void getTransactionHistoryDetail_2() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/employee/contract/detail/{id}", "")
                )
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Tìm đối tượng có tham số [id] = không có trong database
     * Create by :ThienNT
     * Date create: 14/07/2023
     *
     * @param id
     * @throws Exception
     */

    @Test
    public void getTransactionHistoryDetail_3() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/employee/contract/detail/{id}", "99999999999999999")
                )
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
}
