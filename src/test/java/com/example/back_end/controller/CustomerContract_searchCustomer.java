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
public class CustomerContract_searchCustomer {
    @Autowired
    private MockMvc mockMvc;

    /**
     * Create By : DinhHD
     * Date Create : 14/07/2023
     * Customer findById = Successful size >0
     *
     * @throws Exception
     */
    @Test
    public void searchCustomer_6_1() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/employee/contract/customer/contract/search?name=Phan Văn Đồng"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
    /**
     * Create By : DinhHD
     * Date Create : 14/07/2023
     * Customer findById = Successful size >0
     *
     * @throws Exception
     */
    @Test
    public void searchCustomer_6() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/employee/contract/customer/contract/search?name=",""))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
    /**
     * Create By : DinhHD
     * Date Create : 14/07/2023
     * Customer findById = Successful size < 0
     *
     * @throws Exception
     */
    @Test
    public void searchCustomer_2() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/employee/contract/customer/contract/search?name=Huỳnh Đức Định"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
}
