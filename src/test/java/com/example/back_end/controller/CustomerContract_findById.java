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
public class CustomerContract_findById {
    @Autowired
    private MockMvc mockMvc;

    /**
     * Create By : DinhHD
     * Date Create : 14/07/2023
     * Customer findById = null
     *
     * @throws Exception
     */
    @Test
    public void findByIdCustomer_1() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/employee/contract/customer/contract/","null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Create By : DinhHD
     * Date Create : 14/07/2023
     * Customer findById =""
     *
     * @throws Exception
     */
    @Test
    public void findByIdCustomer_2() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/employee/contract/customer/contract/",""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Create By : DinhHD
     * Date Create : 14/07/2023
     * Customer findById = Không tòn tại tỏng db
     *
     * @throws Exception
     */
    @Test
    public void findByIdCustomer_3() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/employee/contract/customer/contract/12"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * Create By : DinhHD
     * Date Create : 14/07/2023
     * Customer findById = Successful
     *
     * @throws Exception
     */
    @Test
    public void findByIdCustomer_4() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/employee/contract/customer/contract/1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
