package com.example.back_end.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class ProfitController_getTotalProfit {
    @Autowired
    private MockMvc mockMvc;

    /**
     * Lấy ra tổng lợi nhuận trong khoảng ngày được chọn
     *
     * @return Trả về nội dung lỗi FieldError ở REST
     * @throws Exception
     * @ param startDate , endDate có giá trị đúng, với profitType (loại lợi nhuận) = null
     */
    @Test
    public void getTotalProfit_1() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/employee/profit/total-profit?startDate=2023-07-13&endDate=2023-07-13&profitType=null"))
                        .andDo(print())
                        .andExpect(status().is4xxClientError());
    }

    /**
     * Lấy ra tổng lợi nhuận trong khoảng ngày được chọn
     *
     * @return Trả về tổng lợi nhuận
     * @throws Exception
     * @ param startDate , endDate có giá trị đúng, với profitType = empty (loại lợi nhuận,mặc định là interest nếu profitType rỗng)
     */
    @Test
    public void getTotalProfit_2() throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/employee/profit/total-profit?startDate=2023-07-13&endDate=2023-07-13&profitType="))
                        .andDo(print())
                        .andExpect(status().is2xxSuccessful())
                        .andReturn();
        Long profit = Long.parseLong(mvcResult.getResponse().getContentAsString());
        assertEquals(246L, profit);
    }

    /**
     * Lấy ra tổng lợi nhuận trong khoảng ngày được chọn
     *
     * @return Trả về nội dung lỗi FieldError ở REST
     * @throws Exception
     * @ param startDate , endDate có giá trị đúng, với profitType (loại lợi nhuận) = tham số không tồn tại trong DB
     */
    @Test
    public void getTotalProfit_3() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/employee/profit/total-profit?startDate=2023-07-13&endDate=2023-07-13&profitType=pawn"))
                        .andDo(print())
                        .andExpect(status().is4xxClientError());
    }

    /**
     * Lấy ra tổng lợi nhuận trong khoảng ngày được chọn
     *
     * @return Không có dữ liệu
     * @throws Exception
     * @ param startDate , endDate có giá trị đúng, với profitType = interest (loại lợi nhuận,mặc định là interest nếu profitType rỗng)
     */
    @Test
    public void getTotalProfit_4() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/employee/profit/total-profit?startDate=2023-06-06&endDate=2023-06-08&profitType=interest"))
                        .andDo(print())
                        .andExpect(status().is4xxClientError());
    }

    /**
     * Lấy ra tổng lợi nhuận trong khoảng ngày được chọn
     *
     * @return Trả về tổng lợi nhuận
     * @throws Exception
     * @ param startDate , endDate có giá trị đúng, với profitType = interest (loại lợi nhuận,mặc định là interest nếu profitType rỗng)
     */
    @Test
    public void getTotalProfit_99() throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/employee/profit/total-profit?startDate=2023-06-06&endDate=2023-08-28&profitType=interest"))
                        .andDo(print())
                        .andExpect(status().is2xxSuccessful())
                        .andReturn();
        Long profit = Long.parseLong(mvcResult.getResponse().getContentAsString());
        assertEquals(2409L, profit);
    }

    /**
     * Lấy ra tổng lợi nhuận trong khoảng ngày được chọn
     *
     * @return Trả về tổng lợi nhuận khớp với endDate
     * @throws Exception
     * @ param startDate có giá trị rỗng , endDate có giá trị đúng, với profitType = interest (loại lợi nhuận,mặc định là interest nếu profitType rỗng)
     */
    @Test
    public void getTotalProfit_98() throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/employee/profit/total-profit?startDate=&endDate=2023-07-13&profitType=interest"))
                        .andDo(print())
                        .andExpect(status().is2xxSuccessful())
                        .andReturn();
        Long profit = Long.parseLong(mvcResult.getResponse().getContentAsString());
        assertEquals(246L, profit);
    }

    /**
     * Lấy ra tổng lợi nhuận trong khoảng ngày được chọn
     *
     * @return Trả về tổng lợi nhuận khớp với startDate
     * @throws Exception
     * @ param startDate có giá trị đúng , endDate có giá trị rỗng, với profitType = interest (loại lợi nhuận,mặc định là interest nếu profitType rỗng)
     */
    @Test
    public void getTotalProfit_97() throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/employee/profit/total-profit?startDate=2023-07-13&endDate=&profitType=interest"))
                        .andDo(print())
                        .andExpect(status().is2xxSuccessful())
                        .andReturn();
        Long profit = Long.parseLong(mvcResult.getResponse().getContentAsString());
        assertEquals(246L, profit);
    }

    /**
     * Lấy ra tổng lợi nhuận trong khoảng ngày được chọn
     *
     * @return Trả về tổng lợi nhuận
     * @throws Exception
     * @ param startDate có giá trị rỗng , endDate có giá trị rỗng, với profitType = interest (loại lợi nhuận,mặc định là interest nếu profitType rỗng)
     */
    @Test
    public void getTotalProfit_96() throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/employee/profit/total-profit?startDate=&endDate=&profitType=interest"))
                        .andDo(print())
                        .andExpect(status().is2xxSuccessful())
                        .andReturn();
        Long profit = Long.parseLong(mvcResult.getResponse().getContentAsString());
        assertEquals(2409L, profit);
    }

    /**
     * Lấy ra tổng lợi nhuận trong khoảng ngày được chọn
     *
     * @return Trả về tổng lợi nhuận khớp với khoảng từ startDate đến endDate
     * @throws Exception
     * @ param startDate và endDate có giá trị đúng, với profitType = interest (loại lợi nhuận,mặc định là interest nếu profitType rỗng)
     */
    @Test
    public void getTotalProfit_95() throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/employee/profit/total-profit?startDate=2023-07-23&endDate=2023-08-10&profitType=interest"))
                        .andDo(print())
                        .andExpect(status().is2xxSuccessful())
                        .andReturn();
        Long profit = Long.parseLong(mvcResult.getResponse().getContentAsString());
        assertEquals(596L, profit);
    }
}
