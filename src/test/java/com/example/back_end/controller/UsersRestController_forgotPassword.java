package com.example.back_end.controller;

import com.example.back_end.dto.UsersDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UsersRestController_forgotPassword {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    /**
     * check email null
     * @throws Exception
     */
    @Test
    public void checkEmail_99() throws Exception {
        UsersDto usersDto = new UsersDto();
        usersDto.setEmail("");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/checkEmail")
                        .content(this.objectMapper.writeValueAsString(usersDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * check email wrong data
     * @throws Exception
     */

    @Test
    public void checkEmail_98() throws Exception {
        UsersDto usersDto = new UsersDto();
        usersDto.setEmail("hehe@gmail.com");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/checkEmail")
                        .content(this.objectMapper.writeValueAsString(usersDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * check email success
     * @throws Exception
     */
    @Test
    public void checkEmail_97() throws Exception {
        UsersDto usersDto = new UsersDto();
        usersDto.setEmail("nguyenthangfa2001@gmail.com");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/checkEmail")
                        .content(this.objectMapper.writeValueAsString(usersDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isOk());
    }
    /**
     * check code null
     * @throws Exception
     */
    @Test
    public void checkCode_99() throws Exception {
        UsersDto usersDto = new UsersDto();
        usersDto.setId(2L);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/checkCode")
                        .content(this.objectMapper.writeValueAsString(usersDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * check code wrong data
     * @throws Exception
     */
    @Test
    public void checkCode_98() throws Exception {
        UsersDto usersDto = new UsersDto();
        usersDto.setId(2L);
        usersDto.setVerificationCode(123456);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/checkCode")
                        .content(this.objectMapper.writeValueAsString(usersDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * check code success
     * @throws Exception
     */
    @Test
    public void checkCode_97() throws Exception {
        UsersDto usersDto = new UsersDto();
        usersDto.setId(2L);
        usersDto.setVerificationCode(853331);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/checkCode")
                        .content(this.objectMapper.writeValueAsString(usersDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isOk());
    }
    /**
     * update new password null
     * @throws Exception
     */
    @Test
    public void newPassword_99() throws Exception {
        UsersDto usersDto = new UsersDto();
        usersDto.setId(2L);
        usersDto.setPassword("");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/user/newPassword")
                        .content(this.objectMapper.writeValueAsString(usersDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * update new password wrong size
     * @throws Exception
     */
    @Test
    public void newPassword_98() throws Exception {
        UsersDto usersDto = new UsersDto();
        usersDto.setId(2L);
        usersDto.setPassword("ho12");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/user/newPassword")
                        .content(this.objectMapper.writeValueAsString(usersDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * update new password success
     * @throws Exception
     */
    @Test
    public void newPassword_97() throws Exception {
        UsersDto usersDto = new UsersDto();
        usersDto.setId(2L);
        usersDto.setPassword("thang12345");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/user/newPassword")
                        .content(this.objectMapper.writeValueAsString(usersDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
// 321383
