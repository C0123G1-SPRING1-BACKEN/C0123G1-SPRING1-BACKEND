package com.example.back_end.Controller;

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
public class UsersRestController_login {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    /**
     * login null
     * @throws Exception
     */
    @Test
    public void login_99() throws Exception {

        UsersDto usersDto = new UsersDto();
        usersDto.setUsername("");
        usersDto.setPassword("");


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/authenticate")
                        .content(this.objectMapper.writeValueAsString(usersDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * login wrong username
     * @throws Exception
     */
    @Test
    public void login_98() throws Exception {

        UsersDto usersDto = new UsersDto();
        usersDto.setUsername("thangthang");
        usersDto.setPassword("thang123");


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/authenticate")
                        .content(this.objectMapper.writeValueAsString(usersDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * login wrong password
     * @throws Exception
     */
    @Test
    public void login_97() throws Exception {

        UsersDto usersDto = new UsersDto();
        usersDto.setUsername("thangfa");
        usersDto.setPassword("123456");


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/authenticate")
                        .content(this.objectMapper.writeValueAsString(usersDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * login success
     * @throws Exception
     */
    @Test
    public void login_96() throws Exception {

        UsersDto usersDto = new UsersDto();
        usersDto.setUsername("thangfa");
        usersDto.setPassword("thang123");


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/authenticate")
                        .content(this.objectMapper.writeValueAsString(usersDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
