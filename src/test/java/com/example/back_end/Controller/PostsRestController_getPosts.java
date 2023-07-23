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

    /**
     * Danh sach rong,  page = null
     *
     * @throws Exception
     */
    @Test
    public void getPosts_5() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/posts"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Danh sach page = null
     *
     * @throws Exception
     */
    @Test
    public void getPosts_5_1() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/posts?page=null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Có dữ liệu
     * Danh sach page = 0
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
                .andExpect(jsonPath("totalPages").value(2))
                .andExpect(jsonPath("totalElements").value(6))
                .andExpect(jsonPath("content[0].title").value("Làm thế nào để vay tiền đơn giản tại tiệm cầm đồ"))
                .andExpect(jsonPath("content[0].content").value("Làm thế nào để vay tiền đơn giản tại tiệm cầm đồ"))
                .andExpect(jsonPath("content[0].employees.id").value(1))
                .andExpect(jsonPath("content[2].title").value("Dịch vụ rút tiền thẻ, đáo hạn thẻ tín dụng nhanh tại Hà Nội"))
                .andExpect(jsonPath("content[2].content").value("Dịch vụ rút tiền thẻ, đáo hạn thẻ tín dụng nhanh tại Hà Nội"))
                .andExpect(jsonPath("content[2].employees.id").value(2));
    }
    /**
     * Có dữ liệu
     * Danh sach page = 1
     *
     * @throws Exception
     */
    @Test
    public void getPosts_6_1() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/posts?page=1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(2))
                .andExpect(jsonPath("totalElements").value(6))
                .andExpect(jsonPath("content[0].title").value("Dịch vụ rút tiền thẻ, đáo hạn thẻ tín dụng nhanh tại Hà Nội"))
                .andExpect(jsonPath("content[0].content").value("Dịch vụ rút tiền thẻ, đáo hạn thẻ tín dụng nhanh tại Hà Nội"))
                .andExpect(jsonPath("content[0].employees.id").value(2))
                .andExpect(jsonPath("content[2].title").value("Dịch vụ rút tiền thẻ, đáo hạn thẻ tín dụng nhanh tại Hà Nội"))
                .andExpect(jsonPath("content[2].content").value("Dịch vụ rút tiền thẻ, đáo hạn thẻ tín dụng nhanh tại Hà Nội"))
                .andExpect(jsonPath("content[2].employees.id").value(2));
    }

}
