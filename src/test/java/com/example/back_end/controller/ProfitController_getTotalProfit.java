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
public class ProfitController_getTotalProfit {
    @Autowired
    private MockMvc mockMvc;

    /**
     * Lấy ra tổng lợi nhuận trong khoảng ngày được chọn
     * @ param startDate , endDate có giá trị đúng, với profitType (loại lợi nhuận) = null
     * @return Trả về nội dung lỗi FieldError ở REST
     * @throws Exception
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
     * @ param startDate , endDate có giá trị đúng, với profitType = empty (loại lợi nhuận,mặc định là interest nếu profitType rỗng)
     * @return Trả về mảng JSON, chứa đầy đủ các record trong table, đảm bảo các yếu tố:
     * - Tổng số phần tử.
     * - Số trang
     * @throws Exception
     */
    @Test
    public void getTotalProfit_2() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/employee/profit/total-profit?startDate=2023-07-13&endDate=2023-07-13&profitType="))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Lấy ra tổng lợi nhuận trong khoảng ngày được chọn
     * @ param startDate , endDate có giá trị đúng, với profitType (loại lợi nhuận) = tham số không tồn tại trong DB
     * @return Trả về nội dung lỗi FieldError ở REST
     * @throws Exception
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
     * @ param startDate , endDate có giá trị đúng, với profitType = interest (loại lợi nhuận,mặc định là interest nếu profitType rỗng)
     * @return Không có dữ liệu
     * @throws Exception
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
     * @ param startDate , endDate có giá trị đúng, với profitType = interest (loại lợi nhuận,mặc định là interest nếu profitType rỗng)
     * @return Trả về mảng JSON, chứa đầy đủ các record trong table, đảm bảo các yếu tố:
     * - Tổng số phần tử.
     * - Số trang
     * @throws Exception
     */
    @Test
    public void getTotalProfit_99() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/employee/profit/total-profit?startDate=2023-06-06&endDate=2023-08-28&profitType=interest"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Lấy ra tổng lợi nhuận trong khoảng ngày được chọn
     * @ param startDate có giá trị rỗng , endDate có giá trị đúng, với profitType = interest (loại lợi nhuận,mặc định là interest nếu profitType rỗng)
     * @return Trả về mảng JSON, chứa đầy đủ các record trong table khớp với endDate, đảm bảo các yếu tố:
     * - Tổng số phần tử.
     * - Số trang
     * @throws Exception
     */
    @Test
    public void getTotalProfit_98() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/employee/profit/total-profit?startDate=&endDate=2023-07-13&profitType=interest"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Lấy ra tổng lợi nhuận trong khoảng ngày được chọn
     * @ param startDate có giá trị đúng , endDate có giá trị rỗng, với profitType = interest (loại lợi nhuận,mặc định là interest nếu profitType rỗng)
     * @return Trả về mảng JSON, chứa đầy đủ các record trong table khớp với startDate, đảm bảo các yếu tố:
     * - Tổng số phần tử.
     * - Số trang
     * @throws Exception
     */
    @Test
    public void getTotalProfit_97() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/employee/profit/total-profit?startDate=2023-07-13&endDate=&profitType=interest"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Lấy ra tổng lợi nhuận trong khoảng ngày được chọn
     * @ param startDate có giá trị rỗng , endDate có giá trị rỗng, với profitType = interest (loại lợi nhuận,mặc định là interest nếu profitType rỗng)
     * @return Trả về mảng JSON, chứa đầy đủ các record trong table, đảm bảo các yếu tố:
     * - Tổng số phần tử.
     * - Số trang
     * @throws Exception
     */
    @Test
    public void getTotalProfit_96() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/employee/profit/total-profit?startDate=&endDate=&profitType=interest"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Lấy ra tổng lợi nhuận trong khoảng ngày được chọn
     * @ param startDate và endDate có giá trị đúng, với profitType = interest (loại lợi nhuận,mặc định là interest nếu profitType rỗng)
     * @return Trả về mảng JSON, chứa đầy đủ các record trong table khớp với khoảng từ startDate đến endDate, đảm bảo các yếu tố:
     * - Tổng số phần tử.
     * - Số trang
     * @throws Exception
     */
    @Test
    public void getTotalProfit_95() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/employee/profit/total-profit?startDate=2023-07-23&endDate=2023-08-10&profitType=interest"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
