package com.example.back_end.controller;

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
public class ContractController_showListAndSearchTransactionHistory {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;


    /**
     * Danh sách có tham số null
     * Tạo bởi :ThienNT
     * Ngày tạo: 14/07/2023
     *
     * @param page ,limit
     * @throws Exception
     */

    @Test
    public void showListAndSearchTransactionHistory_7() throws Exception {
        ContractSearchDTO contractSearchDTO = new ContractSearchDTO();
        contractSearchDTO.setProductName("");
        contractSearchDTO.setCustomerName("");
        contractSearchDTO.setStartDate("");
        contractSearchDTO.setEndDate("");
        contractSearchDTO.setContractType("");
        contractSearchDTO.setContractStatus("");

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/employee/contract?page=&limit=", contractSearchDTO)
                                .content(this.objectMapper.writeValueAsString(contractSearchDTO))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Danh sách có tham số rỗng
     * Tạo bởi :ThienNT
     * Ngày tạo: 14/07/2023
     *
     * @param page,limit
     * @throws Exception
     */

    @Test
    public void showListAndSearchTransactionHistory_8() throws Exception {
        ContractSearchDTO contractSearchDTO = new ContractSearchDTO();
        contractSearchDTO.setProductName("");
        contractSearchDTO.setCustomerName("");
        contractSearchDTO.setStartDate("");
        contractSearchDTO.setEndDate("");
        contractSearchDTO.setContractType("");
        contractSearchDTO.setContractStatus("");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/employee/contract/transaction-history?page=''&limit=''")
                                .content(this.objectMapper.writeValueAsString(contractSearchDTO))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Danh sách có tham số page lớn hơn số page thực tế có trong database
     * Tạo bởi :ThienNT
     * Ngày tạo: 14/07/2023
     *
     * @param page,limit
     * @throws Exception
     */

    @Test
    public void showListAndSearchTransactionHistory_9() throws Exception {
        ContractSearchDTO contractSearchDTO = new ContractSearchDTO();
        contractSearchDTO.setProductName("");
        contractSearchDTO.setCustomerName("");
        contractSearchDTO.setStartDate("");
        contractSearchDTO.setEndDate("");
        contractSearchDTO.setContractType("");
        contractSearchDTO.setContractStatus("");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/employee/contract/transaction-history?page=99999999999&limit=5")
                                .content(this.objectMapper.writeValueAsString(contractSearchDTO))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Danh sách trả về size=0
     * Tạo bởi :ThienNT
     * Ngày tạo: 14/07/2023
     *
     * @param page,limit
     * @throws Exception
     */

    @Test
    public void showListAndSearchTransactionHistory_10() throws Exception {
        ContractSearchDTO contractSearchDTO = new ContractSearchDTO();
        contractSearchDTO.setProductName("");
        contractSearchDTO.setCustomerName("");
        contractSearchDTO.setStartDate("");
        contractSearchDTO.setEndDate("");
        contractSearchDTO.setContractType("");
        contractSearchDTO.setContractStatus("");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/employee/contract/transaction-history?page=0&limit=5")
                                .content(this.objectMapper.writeValueAsString(contractSearchDTO))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is(204));
    }

    /**
     * Danh sách trả về size>0
     * Tạo bởi :ThienNT
     * Ngày tạo: 14/07/2023
     *
     * @param page,limit
     * @throws
     */

    @Test
    public void showListAndSearchTransactionHistory_11() throws Exception {
        ContractSearchDTO contractSearchDTO = new ContractSearchDTO();
        contractSearchDTO.setProductName("");
        contractSearchDTO.setCustomerName("");
        contractSearchDTO.setStartDate("");
        contractSearchDTO.setEndDate("");
        contractSearchDTO.setContractType("");
        contractSearchDTO.setContractStatus("");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/employee/contract/transaction-history?page=0&limit=5")
                                .content(this.objectMapper.writeValueAsString(contractSearchDTO))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
