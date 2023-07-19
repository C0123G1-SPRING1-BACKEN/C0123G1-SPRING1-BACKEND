package com.example.back_end.controller;

import com.example.back_end.model.ContractStatus;
import com.example.back_end.model.ContractType;
import com.example.back_end.projections.ContractSearchDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ContractController_searchTransactionHistory {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;


    /**
     * Tìm kiếm lịch sử giao dịch size>0
     * Create by :ThienNT
     * Date create: 14/07/2023
     *
     * @param
     */

    @Test
    public void searchTransactionHistory_5() throws Exception {
        ContractSearchDTO contractSearchDTO = new ContractSearchDTO();
        contractSearchDTO.setCustomerName("");
        contractSearchDTO.setProductName("");
        contractSearchDTO.setStartDate("");
        contractSearchDTO.setEndDate("");
        contractSearchDTO.setContractStatus("");
        contractSearchDTO.setContractType("");

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/employee/contract/search?page=0&limit=5")
                                .content(this.objectMapper.writeValueAsString(contractSearchDTO))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
