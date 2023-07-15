package com.example.back_end.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PostsRestController_deletePost {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getPosts_25() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .delete("/api/posts/delete/{id}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void getPosts_26() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .delete("/api/posts/delete/{id}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void getPosts_27() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .delete("/api/posts/delete/{id}", "20"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void getPosts_27_1() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .delete("/api/posts/delete/{id}", "ab"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void getPosts_27_2() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .delete("/api/posts/delete/{id}", "-5L"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void getPosts_28() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .delete("/api/posts/delete/{id}", "12"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
