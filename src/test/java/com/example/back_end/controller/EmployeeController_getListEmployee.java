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
     * Danh sach rong
     *
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
                .andExpect(jsonPath("totalPages").value(3))
                .andExpect(jsonPath("totalElements").value(15))
                .andExpect(jsonPath("content[0].name").value("Lê Văn Hai"))
                .andExpect(jsonPath("content[0].birthDay").value("17/10/2000"))
                .andExpect(jsonPath("content[0].gender").value(1))
                .andExpect(jsonPath("content[0].email").value("levanhai@gmail.com"))
                .andExpect(jsonPath("content[0].phoneNumber").value("0964297433"))
                .andExpect(jsonPath("content[0].address").value("15 Điện Biên Phủ"))
                .andExpect(jsonPath("content[0].salary").value("15000000"))
                .andExpect(jsonPath("content[0].citizenCode").value("1578523693"))
                .andExpect(jsonPath("content[0].image").value("https://www.inhuydat.com/uploads/hinhthe/IMG_2457_copy.jpg"))
                .andExpect(jsonPath("content[0].users.id").value(1));
    }
}
