package com.example.back_end.controller.redeemContractRestController;

import com.example.back_end.service.IRedeemingService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class RedeemContractRestController_search {
    @Autowired
    private MockMvc mockMvc;


    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    IRedeemingService iRedeemingService;

    @Test
    public void testSearch_98() throws Exception {
        String contractCode = "";
        String customerName = "";
        String productName = "";
        String startDate = "";
        int page = 0;


        this.mockMvc.perform(MockMvcRequestBuilders.get("/search")
                        .param("page", String.valueOf(page))


                        .param("contractCode", contractCode)
                        .param("customerName", customerName)
                        .param("productName", productName)
                        .param("startDate", startDate))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.content").isArray())
                .andExpect(jsonPath("$.content").isEmpty());
        verify(iRedeemingService, times(1))
                .searchPageConTract(any(Pageable.class), eq("%" + contractCode + "%"), eq("%" + customerName + "%"),
                        eq("%" + productName + "%"), eq("%" + startDate + "%"));


    }
}
