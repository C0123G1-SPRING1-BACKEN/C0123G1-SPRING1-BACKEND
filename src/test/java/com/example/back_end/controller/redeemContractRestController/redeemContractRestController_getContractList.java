package com.example.back_end.controller.redeemContractRestController;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class redeemContractRestController_getContractList {
    @Autowired
    private MockMvc mockMvc;

    /**
     * Danh sach size > 0
     *
     * @ throws Exception
     */
    @Test
    public void getListOpenContract_6() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/employee/redeem/chooseContract?page=0"))
                .andDo(print()).andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(2))
                .andExpect(jsonPath("totalElements").value(10))
                .andExpect(jsonPath("content[0].customerName").value("hoaaa"))
                .andExpect(jsonPath("content[4].customerName").value("hoaaa"));
    }


    /**
     * Danh sach size < 0
     *
     * @ throws Exception
     * vì param page em để default value là 0 nên khi đường dẫn không có tham số là page thì vẫn trả về successful
     * nên muốn trả về 4xx thì sẽ là sai URL hoặc sai tên param truyền vào
     */
    @Test
    public void getListOpenContract_5() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/employee/redeem/chooseContract/p"))
                .andDo(print()).andExpect(status().is4xxClientError());
    }
}
