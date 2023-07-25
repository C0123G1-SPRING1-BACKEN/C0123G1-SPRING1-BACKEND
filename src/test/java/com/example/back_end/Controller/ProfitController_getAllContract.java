package com.example.back_end.controller;

import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ProfitController_getAllContract {
    @Autowired
    private MockMvc mockMvc;

    /**
     * Lấy ra tất cả hợp đồng trong khoảng ngày được chọn
     *
     * @return Trả về nội dung lỗi FieldError ở REST
     * @throws Exception
     * @ param startDate , endDate có giá trị đúng , page mặc định là trang 0, với profitType (loại lợi nhuận) = null
     */
    @Test
    public void getAllContract_7() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/employee/profit?startDate=2023-07-13&endDate=2023-07-13&page=0&profitType=null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Lấy ra tất cả hợp đồng trong khoảng ngày được chọn
     *
     * @return Trả về mảng JSON, chứa đầy đủ các record trong table, đảm bảo các yếu tố:
     * - Tổng số phần tử.
     * - Số trang
     * @throws Exception
     * @ param startDate , endDate có giá trị đúng , page mặc định là trang 0, với profitType = empty (loại lợi nhuận,mặc định là interest nếu profit rỗng)
     */
    @Test
    public void getAllContract_8() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/employee/profit?startDate=2023-07-13&endDate=2023-07-13&page=0&profitType="))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("content[0].contractCode").value("HD-0003"));
    }

    /**
     * Lấy ra tất cả hợp đồng trong khoảng ngày được chọn
     *
     * @return Trả về nội dung lỗi FieldError ở REST
     * @throws Exception
     * @ param startDate , endDate có giá trị đúng , page mặc định là trang 0, với profitType (loại lợi nhuận) = tham số không tồn tại trong DB
     */
    @Test
    public void getAllContract_9() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/employee/profit?startDate=2023-07-13&endDate=2023-07-13&page=0&profitType=pawn"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Lấy ra tất cả hợp đồng trong khoảng ngày được chọn , trường hợp trả về size = 0
     *
     * @return Không có dữ liệu
     * @throws Exception
     * @ param startDate , endDate có giá trị đúng , page mặc định là trang 0, với profitType = interest (loại lợi nhuận,mặc định là interest nếu profit rỗng)
     */
    @Test
    public void getAllContract_10() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/employee/profit?startDate=2023-06-06&endDate=2023-06-08&page=0&profitType=interest"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Lấy ra tất cả hợp đồng trong khoảng ngày được chọn, trường hợp size trả về > 0,
     *
     * @return Trả về mảng JSON, chứa đầy đủ các record trong table, đảm bảo các yếu tố:
     * - Tổng số phần tử.
     * - Số trang
     * @throws Exception
     * @ param startDate , endDate có giá trị đúng , page mặc định là trang 0, với profitType = interest (loại lợi nhuận,mặc định là interest nếu profit rỗng)
     */
    @Test
    public void getAllContract_11() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/employee/profit?startDate=2023-06-06&endDate=2023-08-28&page=0&profitType=interest"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("content[0].contractCode").value("HD-0003"))
                .andExpect(jsonPath("content[3].contractCode").value("HD-0009"));
    }

    /**
     * Lấy ra tất cả hợp đồng trong khoảng ngày được chọn
     *
     * @return Trả về mảng JSON, chứa đầy đủ các record trong table khớp với endDate, đảm bảo các yếu tố:
     * - Tổng số phần tử.
     * - Số trang
     * @throws Exception
     * @ param startDate có giá trị rỗng , endDate có giá trị đúng , page mặc định là trang 0, với profitType = interest (loại lợi nhuận,mặc định là interest nếu profit rỗng)
     */
    @Test
    public void getAllContract_99() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/employee/profit?startDate=&endDate=2023-07-13&page=0&profitType=interest"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("content[0].contractCode").value("HD-0003"));
    }

    /**
     * Lấy ra tất cả hợp đồng trong khoảng ngày được chọn
     *
     * @return Trả về mảng JSON, chứa đầy đủ các record trong table khớp với startDate, đảm bảo các yếu tố:
     * - Tổng số phần tử.
     * - Số trang
     * @throws Exception
     * @ param startDate có giá trị đúng , endDate có giá trị rỗng , page mặc định là trang 0, với profitType = interest (loại lợi nhuận,mặc định là interest nếu profit rỗng)
     */
    @Test
    public void getAllContract_98() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/employee/profit?startDate=2023-07-13&endDate=&page=0&profitType=interest"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("content[0].contractCode").value("HD-0003"));
    }

    /**
     * Lấy ra tất cả hợp đồng trong khoảng ngày được chọn
     *
     * @return Trả về mảng JSON, chứa đầy đủ các record trong table, đảm bảo các yếu tố:
     * - Tổng số phần tử.
     * - Số trang
     * @throws Exception
     * @ param startDate có giá trị rỗng , endDate có giá trị rỗng , page mặc định là trang 0, với profitType = interest (loại lợi nhuận,mặc định là interest nếu profit rỗng)
     */
    @Test
    public void getAllContract_97() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/employee/profit?startDate=&endDate=&page=0&profitType=interest"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("content[0].contractCode").value("HD-0003"))
                .andExpect(jsonPath("content[3].contractCode").value("HD-0009"));
    }

    /**
     * Lấy ra tất cả hợp đồng trong khoảng ngày được chọn
     *
     * @return Trả về mảng JSON, chứa đầy đủ các record trong table khớp với khoảng từ startDate đến endDate, đảm bảo các yếu tố:
     * - Tổng số phần tử.
     * - Số trang
     * @throws Exception
     * @ param startDate và endDate có giá trị đúng , page mặc định là trang 0, với profitType = interest (loại lợi nhuận,mặc định là interest nếu profit rỗng)
     */
    @Test
    public void getAllContract_96() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/employee/profit?startDate=2023-07-23&endDate=2023-08-10&page=0&profitType=interest"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("content[0].contractCode").value("HD-0005"))
                .andExpect(jsonPath("content[1].contractCode").value("HD-0009"));
    }

    /**
     * Lấy ra tất cả hợp đồng trong khoảng ngày được chọn
     *
     * @return Trả về nội dung lỗi FieldError ở REST
     * @throws Exception
     * @ param startDate và endDate có giá trị đúng , page không đúng với số lượng trang , với profitType = interest (loại lợi nhuận,mặc định là interest nếu profit rỗng)
     */
    @Test
    public void getAllContract_95() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/employee/profit?startDate=2023-07-23&endDate=2023-08-10&page=1&profitType=interest"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
}