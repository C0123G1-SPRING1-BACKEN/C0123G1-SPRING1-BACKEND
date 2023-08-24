package com.example.back_end.Controller;

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
public class PageCustomerRestController_customerPage {
    @Autowired
    private MockMvc mockMvc;
    @Test
    public void getAllCustomer_5() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/employee/contract/customer"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void getAllCustomer_6() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/employee/contract/customer"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("content[0].name").value("Nguyễn Hà Anh Quốc"))
                .andExpect(jsonPath("content[0].citizenCode").value(578952458))
            ;
    }

}
