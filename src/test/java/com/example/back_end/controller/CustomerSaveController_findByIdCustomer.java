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
public class CustomerSaveController_findByIdCustomer {

    @Autowired
    private MockMvc mockMvc;

    /**
     * Create by DatNT
     * Date update 14/07/2023
     * This a method use check the return findByIdCustomer which param id = null
     * @Throws Exception
     */
    @Test
    public void findByIdCustomer_1() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/customer/null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by DatNT
     * Date update 14/07/2023
     * This a method use check the return findByIdCustomer ticket which param id = ''
     * @Throws Exception
     */
    @Test
    public void findByIdCustomer_2() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/customer/''"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by DatNT
     * Date update 14/07/2023
     * This a method use check the return findByIdCustomer id that is not in the database
     * @Throws Exception
     */
    @Test
    public void findByIdCustomer_3() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/customer/123"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by DatNT
     * Date update 14/07/2023
     * This a method use check the return findByIdCustomer id contained in the database id = 1
     * @Throws Exception
     */
    @Test
    public void findByIdCustomer_4() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/customer/1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Nguyen Van Anh"))
                .andExpect(jsonPath("$.birthday").value("2000-10-05"))
                .andExpect(jsonPath("$.gender").value(1))
                .andExpect(jsonPath("$.phoneNumber").value("0987678902"))
                .andExpect(jsonPath("$.email").value("toan.nang@gmail.com"))
                .andExpect(jsonPath("$.address").value("19 Hai Chau, Da Nang"))
                .andExpect(jsonPath("$.citizenCode").value("123456789012"))
                .andExpect(jsonPath("$.image").value("https://pvb.com/avatarr.jpg"))
                .andExpect(jsonPath("$.frontCitizen").value("https://pvb.com/mattruoc.jpg"))
                .andExpect(jsonPath("$.backCitizen").value("https://pvb.com/matsau.jpg"))
                .andExpect(jsonPath("$.delete").value(false));
    }
}