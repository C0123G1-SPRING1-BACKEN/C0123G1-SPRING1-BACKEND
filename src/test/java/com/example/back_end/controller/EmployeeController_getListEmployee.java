package com.example.back_end.controller;

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
public class EmployeeController_getListEmployee {

    @Autowired
    private MockMvc mockMvc;

    /**
     * Create By : DongPV
     * Danh sach rong
     * Date Create : 14/07/2023
     * @throws Exception
     */
    @Test
    public void findAll_5() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/employee?page=0&search=abc"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create By : DongPV
     * Date Create : 14/07/2023
     * Danh sach employee,tìm kiếm
     *
     * @throws Exception
     */
    @Test
    public void findAll_6() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/employee?page=1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(4))
                .andExpect(jsonPath("totalElements").value(17))
                .andExpect(jsonPath("content[0].name").value("Ngô Ngọc Sơn"))
                .andExpect(jsonPath("content[0].birthDay").value("27/05/1995"))
                .andExpect(jsonPath("content[0].gender").value(1))
                .andExpect(jsonPath("content[0].email").value("ngongocson@gmail.com"))
                .andExpect(jsonPath("content[0].phoneNumber").value("0974123785"))
                .andExpect(jsonPath("content[0].address").value("50 Nguyễn Công Hoan"))
                .andExpect(jsonPath("content[0].salary").value("20000000"))
                .andExpect(jsonPath("content[0].citizenCode").value("157852369312"))
                .andExpect(jsonPath("content[0].image").value("https://thanglon66.com/chup-hinh-chan-dung-gia-bao-nhieu/imager_8069.jpg"))
                .andExpect(jsonPath("content[0].users.id").value(1));
    }
}
