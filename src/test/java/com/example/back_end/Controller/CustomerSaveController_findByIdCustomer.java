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
        Long customerId = null;
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/customer/{id}", null))
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
        Long customerId = 123L;
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/customer/{id}", customerId))
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
        Long customerId = 1L;
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/customer/{id}", customerId))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Nguyen Van Anh"))
                .andExpect(jsonPath("$.birthday").value("2000-10-05"))
                .andExpect(jsonPath("$.gender").value(1))
                .andExpect(jsonPath("$.phoneNumber").value("0987678902"))
                .andExpect(jsonPath("$.email").value("toan.nang99@gmail.com"))
                .andExpect(jsonPath("$.address").value("19 Hai Chau, Da Nang"))
                .andExpect(jsonPath("$.citizenCode").value("123456789012"))
                .andExpect(jsonPath("$.image").value("https://pvb.com/avatarr.jpg"))
                .andExpect(jsonPath("$.frontCitizen").value("https://pvb.com/mattruoc.jpg"))
                .andExpect(jsonPath("$.backCitizen").value("https://pvb.com/matsau.jpg"))
                .andExpect(jsonPath("$.delete").value(false));
    }
}
