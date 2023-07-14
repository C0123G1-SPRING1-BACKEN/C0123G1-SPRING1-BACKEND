package com.example.back_end.controller;

import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ProfitController_getAllContract {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getAllContract_7() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/employee/profit?startDate=2023-07-13&endDate=2023-07-13&page=0&profitType=null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getAllContract_8() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/employee/profit?startDate=2023-07-13&endDate=2023-07-13&page=0&profitType="))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
    @Test
    public void getAllContract_9() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/employee/profit?startDate=2023-07-13&endDate=2023-07-13&page=0&profitType=pawn"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void getAllContract_10() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/employee/profit?startDate=2023-06-06&endDate=2023-06-08&page=0&profitType=interest"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void getAllContract_11() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/employee/profit?startDate=2023-06-06&endDate=2023-08-28&page=0&profitType=interest"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
    @Test
    public void getAllContract_99() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/employee/profit?startDate=&endDate=2023-07-13&page=0&profitType=interest"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
    @Test
    public void getAllContract_98() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/employee/profit?startDate=2023-07-13&endDate=&page=0&profitType=interest"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
    @Test
    public void getAllContract_97() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/employee/profit?startDate=&endDate=&page=0&profitType=interest"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
    @Test
    public void getAllContract_96() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/employee/profit?startDate=2023-07-23&endDate=2023-08-10&page=0&profitType=interest"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
    @Test
    public void getAllContract_95() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/employee/profit?startDate=2023-07-23&endDate=2023-08-10&page=1&profitType=interest"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
}
