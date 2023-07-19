package com.example.back_end.controller.redeemContractRestController;

import com.example.back_end.model.ContractStatus;
import com.example.back_end.model.Contracts;
import com.example.back_end.service.IRedeemingService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import java.time.LocalDate;

import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class RedeemContractRestController_Redeem {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private IRedeemingService redeemingService;
    @Autowired
    private ObjectMapper objectMapper;


    /**
     * Created by HoaTQ
     * Chức năng chuộc đồ thành công
     * Chức năng chuộc đồ chỉ thay đổi status của hợp đồng nên không có trường hợp test với các ô input
     *
     * @ throws Exception
     */
    @Test
    public void testRedeem_24() throws Exception {

Long id =  6L;

String  date =  "1231";

        mockMvc.perform(MockMvcRequestBuilders.patch("/api/employee/redeem/pay/{id}", id,  date)
                        .param("redeemDate" , date)
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());

    }


    /**
     * Created by HoaTQ
     * Chức năng chuộc đồ chỉ thay đổi status của hợp đồng nên không có trường hợp test với các ô input
     * ở test case này em chỉ test trường hợp là nếu như id là null
     *
     * @ throws Exception
     */
    @Test
    public void testRedeem_1() throws Exception {

        LocalDate redeemDate = LocalDate.now();

        Contracts contracts = new Contracts();
        contracts.setId(null);

//        contracts.setRedeemDate(String.valueOf(redeemDate));
        ContractStatus contractStatus = new ContractStatus();
        contractStatus.setId(2L);
        contracts.setContractStatus(contractStatus);

        mockMvc.perform(patch("/api/employee/redeem/pay/{id}", contracts.getId())
                        .content(this.objectMapper.writeValueAsString(contracts))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());


    }





    /**
     * Created by HoaTQ
     * Chức năng chuộc đồ chỉ thay đổi status của hợp đồng nên không có trường hợp test với các ô input
     * ở test case này em chỉ test trường hợp là nếu như id là rỗng
     *
     * @ throws Exception
     */
    @Test
    public void testRedeem_2() throws Exception {

        LocalDate redeemDate = LocalDate.now();

        Contracts contracts = new Contracts();

//        contracts.setRedeemDate(String.valueOf(redeemDate));
        ContractStatus contractStatus = new ContractStatus();
        contractStatus.setId(2L);
        contracts.setContractStatus(contractStatus);

        mockMvc.perform(patch("/api/employee/redeem/pay/{id}", "")
                        .content(this.objectMapper.writeValueAsString(contracts))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());


    }

}
