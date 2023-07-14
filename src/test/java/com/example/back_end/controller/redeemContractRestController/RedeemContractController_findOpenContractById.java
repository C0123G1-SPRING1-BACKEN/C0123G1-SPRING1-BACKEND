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
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class RedeemContractController_findOpenContractById {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private IRedeemingService redeemingService;
    @Autowired
    private ObjectMapper objectMapper;


    /**
     * Chức năng tìm đối tượng contracts
     * tìm thành công
     *
     *
     * @ throws Exception
     */
    @Test
    public void testFindByID_4() throws Exception {


        Contracts contracts = new Contracts();
        contracts.setId(2L);

        ContractStatus contractStatus = new ContractStatus();
        contractStatus.setId(2);
        contracts.setContractStatus(contractStatus);

        mockMvc.perform(patch("/api/employee/redeem/chose/{id}", contracts.getId())
                        .content(this.objectMapper.writeValueAsString(contracts))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())


                .andExpect(status().is2xxSuccessful());

    }


    /**
     * Chức năng tìm đối tượng contracts
     * id là null
     *
     *
     * @ throws Exception
     */
    @Test
    public void testFindByID_1() throws Exception {


        Contracts contracts = new Contracts();
        contracts.setId(null);

        ContractStatus contractStatus = new ContractStatus();
        contractStatus.setId(2);
        contracts.setContractStatus(contractStatus);

        mockMvc.perform(patch("/api/employee/redeem/chose/{id}", contracts.getId())
                        .content(this.objectMapper.writeValueAsString(contracts))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())


                .andExpect(status().is4xxClientError());

    }





    /**
     * Chức năng tìm đối tượng contracts
     * id là rỗng
     *
     *
     * @ throws Exception
     */
    @Test
    public void testFindByID_3() throws Exception {


        Contracts contracts = new Contracts();

        ContractStatus contractStatus = new ContractStatus();
        contractStatus.setId(2);
        contracts.setContractStatus(contractStatus);

        mockMvc.perform(patch("/api/employee/redeem/chose/{id}", "")
                        .content(this.objectMapper.writeValueAsString(contracts))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())

                .andExpect(status().is4xxClientError());

    }
}
