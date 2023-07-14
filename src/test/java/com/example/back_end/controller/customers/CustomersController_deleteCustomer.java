package com.example.back_end.controller.customers;

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
public class CustomersController_deleteCustomer {
    @Autowired
    private MockMvc mockMvc;
    /**
     * Created by: QuocNHA
     * Date created: 14/07/2023
     * @throws Exception
     */
    @Test
    public void deleteCustomerById_25() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.delete("/api/customer/{id}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Created by: QuocNHA
     * Date created: 14/07/2023
     * @throws Exception
     */
    @Test
    public void deleteCustomerById_26() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.delete("/api/customer/{id}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: QuocNHA
     * Date created: 14/07/2023
     * @throws Exception
     */
    @Test
    public void deleteCustomerById_27() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.delete("/api/customer/{id}", "a"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: QuocNHA
     * Date created: 14/07/2023
     * @throws Exception
     */
    @Test
    public void deleteCustomerById_28() throws Exception {
        Long customerId = 1L;
        this.mockMvc.perform(
                        MockMvcRequestBuilders.delete(
                                "/api/customer/{id}", customerId))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
