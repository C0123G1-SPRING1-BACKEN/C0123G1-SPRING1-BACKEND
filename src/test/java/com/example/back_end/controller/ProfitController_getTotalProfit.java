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
public class ProfitController_getTotalProfit {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getTotalProfit_1() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                .get("/api/employee/profit/total-profit"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
}
