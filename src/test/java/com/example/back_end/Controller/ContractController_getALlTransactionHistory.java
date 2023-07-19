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
public class ContractController_getALlTransactionHistory {
    @Autowired
    private MockMvc mockMvc;

    /**
     * Danh sách có tham số null
     * Create by :ThienNT
     * Date create: 14/07/2023
     *
     * @param page ,limit
     * @throws Exception
     */

    @Test
    public void getALlTransactionHistory_7() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/employee/contract?page=null&limit=null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Danh sách có tham số rỗng
     * Create by :ThienNT
     * Date create: 14/07/2023
     *
     * @param page,limit
     * @throws Exception
     */

    @Test
    public void getALlTransactionHistory_8() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/employee/contract?page=''&limit=''"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Danh sách có tham số page lớn hơn số page thực tế có trong database
     * Create by :ThienNT
     * Date create: 14/07/2023
     *
     * @param page,limit
     * @throws Exception
     */

    @Test
    public void getALlTransactionHistory_9() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/employee/contract?page=9999999999999999999999999&limit=5"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Danh sách có rỗng
     * Create by :ThienNT
     * Date create: 14/07/2023
     *
     * @param page,limit
     * @throws Exception
     */

    @Test
    public void getALlTransactionHistory_10() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/employee/contract?page=0&limit=5"))
                .andDo(print())
                .andExpect(status().is(204));
    }

    /**
     * Danh sách trả về size>0
     * Create by :ThienNT
     * Date create: 14/07/2023
     *
     * @param page,limit
     * @throws
     */

    @Test
    public void getALlTransactionHistory_11() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/employee/contract?page=0&limit=5"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
