package com.example.back_end.controller.redeemContractRestController;

import com.example.back_end.dto.open_contract.IOpenContractDTO;
import com.example.back_end.dto.open_contract.OpenContractDTO;
import com.example.back_end.service.IRedeemingService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
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

    /**
     * test search thành công của phần chọn hợp đồng
     * @throws Exception
     */

    @Test
    public void testSearch_56() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/employee/redeem/search?page=0&contractCode=1&customerName=&productName=&startDate="))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }




    /**
     * test search thành công của phần chọn hợp đồng
     * @throws Exception
     */

    @Test
    public void testSearch_57() throws Exception {
        MvcResult result = this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/employee/redeem/search?page=0&contractCode=ád&customerName=&productName=&startDate="))
                .andExpect(status().is2xxSuccessful())
                .andReturn();
        String responseContent = result.getResponse().getContentAsString();
        assertThat(responseContent).isNotEmpty();
        assertThat(responseContent).contains(responseContent);

        // Kiểm tra định dạng dữ liệu phản hồi
        // assertThat(result.getResponse().getContentType()).isEqualTo("application/json");
    }

    /**
     * test search thành công của phần chọn hợp đồng
     * các trường search là null kể cả page
     * @throws Exception
     */
    @Test
    public void testSearch_59() throws Exception {
        MvcResult result = this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/employee/redeem/search?page=null&contractCode=null&customerName=null&productName=null&startDate=null"))
                .andExpect(status().is4xxClientError())
                .andReturn();
        String responseContent = result.getResponse().getContentAsString();
        assertThat(responseContent).isEmpty();
        assertThat(responseContent).contains(responseContent);

        // Kiểm tra định dạng dữ liệu phản hồi
        // assertThat(result.getResponse().getContentType()).isEqualTo("application/json");
    }

    /**
     * test search thành công của phần chọn hợp đồng
     * với page là 0 và các trường search là null
     * @throws Exception
     */
    @Test
    public void testSearch_60() throws Exception {
        MvcResult result = this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/employee/redeem/search?page=0&contractCode=null&customerName=null&productName=null&startDate=null"))
                .andExpect(status().is2xxSuccessful())
                .andReturn();
        String responseContent = result.getResponse().getContentAsString();
        assertThat(responseContent).isNotEmpty();
        assertThat(responseContent).contains(responseContent);

        // Kiểm tra định dạng dữ liệu phản hồi
        // assertThat(result.getResponse().getContentType()).isEqualTo("application/json");
    }

}
