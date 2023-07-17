package com.example.back_end.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ContractRestController_top10NewContract {
    @Autowired
    private MockMvc mockMvc;
    @Test
    public void showTop10NewContract_5() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/employee/contract/top19"))
                .andDo(print()).andExpect(status().is4xxClientError());

    }
    @Test
    public void showTop10NewContract_6() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/employee/contract/top10"))
                .andDo(print()).andExpect(status().is2xxSuccessful());

    }


}
