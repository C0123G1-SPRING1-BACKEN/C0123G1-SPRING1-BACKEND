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
public class RegisterPawnController_getListProductType {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getListProductType_5() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/register/product-type"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
    /**
     * Danh sach rong .
     * @throws Exception
     */
    @Test
    public void getListProductType_6() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/register/product-type"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());

    }
    /**
     *  Co danh sach   .
     * @throws Exception
     */

}
