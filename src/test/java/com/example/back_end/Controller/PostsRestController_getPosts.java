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
public class PostsRestController_getPosts {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getPosts_5() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/posts"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Danh sach rong, size = 0
     *
     * @throws Exception
     */
    @Test
    public void getPosts_6() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/posts?page=0"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(3))
                .andExpect(jsonPath("totalElements").value(7))
                .andExpect(jsonPath("content[0].title").value("Làm thế nào để vay tiền đơn giản tại tiệm cầm đồ"))
                .andExpect(jsonPath("content[0].content").value("Làm thế nào để vay tiền đơn giản tại tiệm cầm đồ"))
                .andExpect(jsonPath("content[0].employees.id").value(1))
                .andExpect(jsonPath("content[2].title").value("Dịch vụ rút tiền thẻ, đáo hạn thẻ tín dụng nhanh tại Hà Nội"))
                .andExpect(jsonPath("content[2].content").value("Dịch vụ rút tiền thẻ, đáo hạn thẻ tín dụng nhanh tại Hà Nội"))
                .andExpect(jsonPath("content[2].employees.id").value(2));
    }

    /**
     * Danh sach size > 0
     * @throws Exception
     */
}
