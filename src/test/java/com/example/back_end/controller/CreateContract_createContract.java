package com.example.back_end.controller;

import com.example.back_end.dto.*;
import com.example.back_end.model.*;
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

/**
 * Created by: DinhHD
 * Date created: 13/07/2023
 * Function: do about pawn interface, customer selection interface
 * <p>
 * // * @param (có tên sản phẩm có giá trị rỗng(""))
 *
 * @return createContract()
 */
@SpringBootTest
@AutoConfigureMockMvc
public class CreateContract_createContract {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Test
    public void createContract_14() throws Exception {
        ContractDto contractDto = new ContractDto();
        contractDto.setProductName(" ");
        contractDto.setContractCode("HD-0002");
        contractDto.setLoans(Long.valueOf(10000000));
        contractDto.setProfit(Long.valueOf(65000));
        contractDto.setImage("https://tse1.mm.bing.net/th?id=OIP.toFOTjJ8rRnokTZZzDVx1QHaE8&pid=Api&rs=1&c=1&qlt=95&w=161&h=107");
        contractDto.setStartDate("12-3-2023");
        contractDto.setEndDate("15-3-2023");

        Employees employee=new Employees();
        employee.setId(Long.valueOf(1));
        contractDto.setEmployee(employee);

        Customers customer = new Customers();
        customer.setId(Long.valueOf(1));
        contractDto.setCustomer(customer);

        ContractStatus contractStatus = new ContractStatus();
        contractStatus.setId(Long.valueOf(1));
        contractDto.setContractStatus(contractStatus);

        ContractType contractType = new ContractType();
        contractType.setId(Long.valueOf(1));
        contractDto.setContractType(contractType);

        ProductType productType = new ProductType();
        productType.setId(Long.valueOf(1));
        contractDto.setProductType(productType);

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/api/contract/createContract")
                        .content(this.objectMapper.writeValueAsString(contractDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
}
