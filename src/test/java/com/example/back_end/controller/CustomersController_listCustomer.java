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
public class CustomersController_listCustomer {
    @Autowired
    private MockMvc mockMvc;
    /**
     * Created by: QuocNHA
     * Date created: 14/07/2023
     * @throws Exception
     */
    @Test
    public void getListCustomers_5() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/customer"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Created by: QuocNHA
     * Date created: 14/07/2023
     * @throws Exception
     */
    @Test
    public void getListCustomer_6() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/customer?page=3"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(11))
                .andExpect(jsonPath("totalElements").value(33))
                .andExpect(jsonPath("content[0].name").value("Phan Văn Đồng"))
                .andExpect(jsonPath("content[0].birthday").value("10-11-1997"))
                .andExpect(jsonPath("content[0].gender").value(1))
                .andExpect(jsonPath("content[0].phoneNumber").value("0123456789"))
                .andExpect(jsonPath("content[0].email").value("dong@gmail.com"))
                .andExpect(jsonPath("content[0].address").value("234570 Trần hưng Đạo"))
                .andExpect(jsonPath("content[0].citizenCode").value("5478952468"))
                .andExpect(jsonPath("content[0].image").value("img"));

    }
}
