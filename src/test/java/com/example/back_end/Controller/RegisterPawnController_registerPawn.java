package com.example.back_end.Controller;

import com.example.back_end.dto.RegisterDTO;
import com.example.back_end.model.ProductType;
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
public class RegisterPawnController_registerPawn {


    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * register pawn rong ("")
     *
     * @throws Exception
     */

    @Test
    public void registerPawn_16() throws Exception {
        RegisterDTO registerDTO = new RegisterDTO();
        registerDTO.setName("");
        registerDTO.setAddress("");
        registerDTO.setPhone("");
        registerDTO.setEmail("");
        registerDTO.setContendNote("");

        ProductType productType = new ProductType();
        productType.setId(2L);
        registerDTO.setProductType(productType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/register/create")
                        .content(this.objectMapper.writeValueAsString(registerDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * register pawn name  ("")
     *
     * @throws Exception
     */
    @Test
    public void registerPawn_name_16() throws Exception {
        RegisterDTO registerDTO = new RegisterDTO();
        registerDTO.setName("");
        registerDTO.setAddress("Hoa Xuan,Cam Le,Da Nang");
        registerDTO.setPhone("0909129121");
        registerDTO.setEmail("nguyenthangfa2001@gmail.com");
        registerDTO.setContendNote("ghi chu trong nay");


        ProductType productType = new ProductType();
        productType.setId(2L);
        registerDTO.setProductType(productType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/register/create")
                        .content(this.objectMapper.writeValueAsString(registerDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * register pawn address  ("")
     *
     * @throws Exception
     */
    @Test
    public void registerPawn_address_16() throws Exception {
        RegisterDTO registerDTO = new RegisterDTO();
        registerDTO.setName("Nguyen Duc Thang");
        registerDTO.setAddress("");
        registerDTO.setPhone("0909129121");
        registerDTO.setEmail("nguyenthangfa2001@gmail.com");
        registerDTO.setContendNote("Ghi chu o trong nay");


        ProductType productType = new ProductType();
        productType.setId(2L);
        registerDTO.setProductType(productType);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/register/create")
                        .content(this.objectMapper.writeValueAsString(registerDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * register pawn phone  ("")
     *
     * @throws Exception
     */
    @Test
    public void registerPawn_phone_16() throws Exception {
        RegisterDTO registerDTO = new RegisterDTO();
        registerDTO.setName("Nguyen Duc Thang");
        registerDTO.setAddress("Hoa Xuan,Cam Le,Da Nang");
        registerDTO.setPhone("");
        registerDTO.setEmail("nguyenthangfa2001@gmail.com");
        registerDTO.setContendNote("Ghi chu o trong nay");


        ProductType productType = new ProductType();
        productType.setId(2L);
        registerDTO.setProductType(productType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/register/create")
                        .content(this.objectMapper.writeValueAsString(registerDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * register pawn email ("")
     *
     * @throws Exception
     */
    @Test
    public void registerPawn_email_16() throws Exception {
        RegisterDTO registerDTO = new RegisterDTO();
        registerDTO.setName("Nguyen Duc Thang");
        registerDTO.setAddress("Hoa Xuan,Cam Le,Da Nang");
        registerDTO.setPhone("0909121121");
        registerDTO.setEmail("");
        registerDTO.setContendNote("Ghi chu o trong nay");

        ProductType productType = new ProductType();
        productType.setId(2L);
        registerDTO.setProductType(productType);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/register/create")
                        .content(this.objectMapper.writeValueAsString(registerDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * register pawn contend note ("")
     *
     * @throws Exception
     */
    @Test
    public void registerPawn_contendNote_16() throws Exception {
        RegisterDTO registerDTO = new RegisterDTO();
        registerDTO.setName("Nguyen Duc Thang");
        registerDTO.setAddress("Hoa Xuan,Cam Le,Da Nang");
        registerDTO.setPhone("0909121121");
        registerDTO.setEmail("nguyenthangfa2001@gmail.com");
        registerDTO.setContendNote("");

        ProductType productType = new ProductType();
        productType.setId(2L);
        registerDTO.setProductType(productType);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/register/create")
                        .content(this.objectMapper.writeValueAsString(registerDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * register pawn name don't over 100 character !!!
     *
     * @throws Exception
     */
    @Test
    public void registerPawn_name_19() throws Exception {
        RegisterDTO registerDTO = new RegisterDTO();
        registerDTO.setName("Nguyen Duc Thang ddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
                "ddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
                "ddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
                "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
                "ddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
                "dddddddddddddddddddddddddddddddddddddddddddddddddd");
        registerDTO.setAddress("Hoa Xuan,Cam Le,Da Nang");
        registerDTO.setPhone("0909121121");
        registerDTO.setEmail("nguyenthangfa2001@gmail.com");
        registerDTO.setContendNote("ghi chu trong nay");

        ProductType productType = new ProductType();
        productType.setId(2L);
        registerDTO.setProductType(productType);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/register/create")
                        .content(this.objectMapper.writeValueAsString(registerDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * register pawn  Incorrect name !!!
     *
     * @throws Exception
     */
    @Test
    public void registerPawn_name_17() throws Exception {
        RegisterDTO registerDTO = new RegisterDTO();
        registerDTO.setName("tran tien dung");
        registerDTO.setAddress("Hoa Xuan,Cam Le,Da Nang");
        registerDTO.setPhone("0909121121");
        registerDTO.setEmail("nguyenthangfa2001@gmail.com");
        registerDTO.setContendNote("ghi chu trong nay");

        ProductType productType = new ProductType();
        productType.setId(2L);
        registerDTO.setProductType(productType);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/register/create")
                        .content(this.objectMapper.writeValueAsString(registerDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * register pawn  phone > 11 number !!!
     *
     * @throws Exception
     */
    @Test
    public void registerPawn_phone_19() throws Exception {
        RegisterDTO registerDTO = new RegisterDTO();
        registerDTO.setName("Tran Tien Dung");
        registerDTO.setAddress("Hoa Xuan,Cam Le,Da Nang");
        registerDTO.setPhone("090912112112121212121212121212121212121212");
        registerDTO.setEmail("nguyenthangfa2001@gmail.com");
        registerDTO.setContendNote("ghi chu trong nay");

        ProductType productType = new ProductType();
        productType.setId(2L);
        registerDTO.setProductType(productType);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/register/create")
                        .content(this.objectMapper.writeValueAsString(registerDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * register pawn  phone  is not in the correct format !!!
     *
     * @throws Exception
     */
    @Test
    public void registerPawn_phone_17() throws Exception {
        RegisterDTO registerDTO = new RegisterDTO();
        registerDTO.setName("Tran Tien Dung");
        registerDTO.setAddress("Hoa Xuan,Cam Le,Da Nang");
        registerDTO.setPhone("1234567891");
        registerDTO.setEmail("nguyenthangfa2001@gmail.com");
        registerDTO.setContendNote("ghi chu trong nay");

        ProductType productType = new ProductType();
        productType.setId(2L);
        registerDTO.setProductType(productType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/register/create")
                        .content(this.objectMapper.writeValueAsString(registerDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * register pawn  email  don't over 100 character !!!
     *
     * @throws Exception
     */
    @Test
    public void registerPawn_email_19() throws Exception {
        RegisterDTO registerDTO = new RegisterDTO();
        registerDTO.setName("Tran Tien Dung");
        registerDTO.setAddress("Hoa Xuan,Cam Le,Da Nang");
        registerDTO.setPhone("0123456891");
        registerDTO.setEmail("nguyenthangfa2001@gmail.comgggggggggggggggggggggggggggggggggggggggggggggggggggggggggggg" +
                "gggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggg" +
                "ggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggg" +
                "ggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggg");
        registerDTO.setContendNote("ghi chu trong nay");

        ProductType productType = new ProductType();
        productType.setId(2L);
        registerDTO.setProductType(productType);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/register/create")
                        .content(this.objectMapper.writeValueAsString(registerDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * register pawn    email invalidate !!!
     *
     * @throws Exception
     */
    @Test
    public void registerPawn_email_17() throws Exception {
        RegisterDTO registerDTO = new RegisterDTO();
        registerDTO.setName("Tran Tien Dung");
        registerDTO.setAddress("Hoa Xuan,Cam Le,Da Nang");
        registerDTO.setPhone("0123456789");
        registerDTO.setEmail("nguyenthangfa2001.com");
        registerDTO.setContendNote("ghi chu trong nay");

        ProductType productType = new ProductType();
        productType.setId(2L);
        registerDTO.setProductType(productType);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/register/create")
                        .content(this.objectMapper.writeValueAsString(registerDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * register pawn    address  don't over 500 character !!!
     *
     * @throws Exception
     */
    @Test
    public void registerPawn_address_19() throws Exception {
        RegisterDTO registerDTO = new RegisterDTO();
        registerDTO.setName("Tran Tien Dung");
        registerDTO.setAddress("Hoa Xuddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddđffff" +
                "fXuddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddđffff" +
                "Xuddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddđffff" +
                "Xuddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddđffff" +
                "Xuddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddđffff" +
                "Xuddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddđffff" +
                "Xuddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddđffff" +
                "Xuddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddđffff" +
                "Xuddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddđffff" +
                "Xuddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddđffff" +
                "Xuddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddđffff" +
                "Xuddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddđffff" +
                "Xuddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddđffff" +
                "Xuddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddđffff" +
                "");
        registerDTO.setPhone("0123456789");
        registerDTO.setEmail("nguyenthangfa2001.com");
        registerDTO.setContendNote("ghi chu trong nay");

        ProductType productType = new ProductType();
        productType.setId(2L);
        registerDTO.setProductType(productType);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/register/create")
                        .content(this.objectMapper.writeValueAsString(registerDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * register pawn    condtend note   don't over 1000 character !!!
     *
     * @throws Exception
     */
    @Test
    public void registerPawn_contendNote_19() throws Exception {
        RegisterDTO registerDTO = new RegisterDTO();
        registerDTO.setName("Tran Tien Dung");
        registerDTO.setAddress("Hoa Xu");
        registerDTO.setPhone("0123456789");
        registerDTO.setEmail("nguyenthangfa2001.com");
        registerDTO.setContendNote("nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn" +
                "nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn" +
                "nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn" +
                "nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn" +
                "nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn" +
                "nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn" +
                "nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn" +
                "nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn" +
                "nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn" +
                "nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn" +
                "nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn" +
                "nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn" +
                "nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn" +
                "nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn" +
                "nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn" +
                "nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn" +
                "nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn" +
                "" +
                "");

        ProductType productType = new ProductType();
        productType.setId(2L);
        registerDTO.setProductType(productType);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/register/create")
                        .content(this.objectMapper.writeValueAsString(registerDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * register pawn  create successfully  !!!
     *
     * @throws Exception
     */
    @Test
    public void registerPawn_20() throws Exception {
        RegisterDTO registerDTO = new RegisterDTO();
        registerDTO.setName("Ho Vien");
        registerDTO.setAddress("Thừa Thiên Huế");
        registerDTO.setPhone("0768566127");
        registerDTO.setEmail("hovien2201@gmail.com");
        registerDTO.setContendNote("Cầm sổ đỏ 10 ngày ! sinh viên không có tiền nên cầm . ");

        ProductType productType = new ProductType();
        productType.setId(2L);
        registerDTO.setProductType(productType);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/register/create")
                        .content(this.objectMapper.writeValueAsString(registerDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * register pawn  field  null  !!!
     *
     * @throws Exception
     */
    @Test
    public void registerPawn_15() throws Exception {
        RegisterDTO registerDTO = new RegisterDTO();
        registerDTO.setName(null);
        registerDTO.setAddress(null);
        registerDTO.setPhone(null);
        registerDTO.setEmail(null);
        registerDTO.setContendNote(null);

        ProductType productType = new ProductType();
        productType.setId(2L);
        registerDTO.setProductType(productType);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/register/create")
                        .content(this.objectMapper.writeValueAsString(registerDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * register pawn  name   null  !!!
     *
     * @throws Exception
     */
    @Test
    public void registerPawn_name_15() throws Exception {
        RegisterDTO registerDTO = new RegisterDTO();
        registerDTO.setName(null);
        registerDTO.setAddress("Hoa Xuan,Cam Le,Da Nang");
        registerDTO.setPhone("0909129121");
        registerDTO.setEmail("nguyenthangfa20011@gmail.com");
        registerDTO.setContendNote("ghi chú trong này");

        ProductType productType = new ProductType();
        productType.setId(2L);
        registerDTO.setProductType(productType);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/register/create")
                        .content(this.objectMapper.writeValueAsString(registerDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * register pawn  address   null  !!!
     *
     * @throws Exception
     */
    @Test
    public void registerPawn_address_15() throws Exception {
        RegisterDTO registerDTO = new RegisterDTO();
        registerDTO.setName("Nguyen Duc Thang");
        registerDTO.setAddress(null);
        registerDTO.setPhone("0909129121");
        registerDTO.setEmail("nguyenthangfa20011@gmail.com");
        registerDTO.setContendNote("ghi chú trong này");

        ProductType productType = new ProductType();
        productType.setId(2L);
        registerDTO.setProductType(productType);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/register/create")
                        .content(this.objectMapper.writeValueAsString(registerDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * register pawn  phone   null  !!!
     *
     * @throws Exception
     */
    @Test
    public void registerPawn_phone_15() throws Exception {
        RegisterDTO registerDTO = new RegisterDTO();
        registerDTO.setName("Nguyen Duc Thang");
        registerDTO.setAddress("Hoa Xuan,Cam Le,Da Nang");
        registerDTO.setPhone(null);
        registerDTO.setEmail("nguyenthangfa20011@gmail.com");
        registerDTO.setContendNote("ghi chú trong này");

        ProductType productType = new ProductType();
        productType.setId(2L);
        registerDTO.setProductType(productType);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/register/create")
                        .content(this.objectMapper.writeValueAsString(registerDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * register pawn  email   null  !!!
     *
     * @throws Exception
     */
    @Test
    public void registerPawn_email_15() throws Exception {
        RegisterDTO registerDTO = new RegisterDTO();
        registerDTO.setName("Nguyen Duc Thang");
        registerDTO.setAddress("Hoa Xuan,Cam Le,Da Nang");
        registerDTO.setPhone("0909129111");
        registerDTO.setEmail(null);
        registerDTO.setContendNote("ghi chú trong này");

        ProductType productType = new ProductType();
        productType.setId(2L);
        registerDTO.setProductType(productType);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/register/create")
                        .content(this.objectMapper.writeValueAsString(registerDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * register pawn  contend note   null  !!!
     *
     * @throws Exception
     */
    @Test
    public void registerPawn_contendNote_15() throws Exception {
        RegisterDTO registerDTO = new RegisterDTO();
        registerDTO.setName("Nguyen Duc Thang");
        registerDTO.setAddress("Hoa Xuan,Cam Le,Da Nang");
        registerDTO.setPhone("0909129111");
        registerDTO.setEmail("nguyenthangfa21@gmail.com");
        registerDTO.setContendNote(null);

        ProductType productType = new ProductType();
        productType.setId(2L);
        registerDTO.setProductType(productType);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/register/create")
                        .content(this.objectMapper.writeValueAsString(registerDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * register pawn  name   contain special characters  !!!
     *
     * @throws Exception
     */
    @Test
    public void registerPawn_name_99() throws Exception {
        RegisterDTO registerDTO = new RegisterDTO();
        registerDTO.setName("/?.<><>!~~~@@#$%^%!#()*%@)*)%%%%%%%%%@#@#@$#@$@$@$@$");
        registerDTO.setAddress("Hoa Xuan,Cam Le,Da Nang");
        registerDTO.setPhone("0909129111");
        registerDTO.setEmail("nguyenthangfa21@gmail.com");
        registerDTO.setContendNote("ghi chú trong này");

        ProductType productType = new ProductType();
        productType.setId(2L);
        registerDTO.setProductType(productType);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/register/create")
                        .content(this.objectMapper.writeValueAsString(registerDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * register pawn  phone   contain special characters  !!!
     *
     * @throws Exception
     */
    @Test
    public void registerPawn_phone_99() throws Exception {
        RegisterDTO registerDTO = new RegisterDTO();
        registerDTO.setName("Nguyen Duc Thang");
        registerDTO.setAddress("Hoa Xuan,Cam Le,Da Nang");
        registerDTO.setPhone("/?.<><>!~~~@@#$%^%!#()*%@)*)%%%%%%%%%@#@#@$#@$@$@$@$");
        registerDTO.setEmail("nguyenthangfa21@gmail.com");
        registerDTO.setContendNote("ghi chú trong này");

        ProductType productType = new ProductType();
        productType.setId(2L);
        registerDTO.setProductType(productType);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/register/create")
                        .content(this.objectMapper.writeValueAsString(registerDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * register pawn  phone   contain special characters  !!!
     *
     * @throws Exception
     */
    @Test
    public void registerPawn_email_99() throws Exception {
        RegisterDTO registerDTO = new RegisterDTO();
        registerDTO.setName("Nguyen Duc Thang");
        registerDTO.setAddress("Hoa Xuan,Cam Le,Da Nang");
        registerDTO.setPhone("0909111111");
        registerDTO.setEmail("/?.<><>!~~~@@#$%^%!#()*%@)*)%%%%%%%%%@#@#@$#@$@$@$@$");
        registerDTO.setContendNote("ghi chú trong này");

        ProductType productType = new ProductType();
        productType.setId(2L);
        registerDTO.setProductType(productType);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/register/create")
                        .content(this.objectMapper.writeValueAsString(registerDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * register pawn  name double-ended whitespace !!!
     *
     * @throws Exception
     */
    @Test
    public void registerPawn_name_98() throws Exception {
        RegisterDTO registerDTO = new RegisterDTO();
        registerDTO.setName(" Nguyen Duc Thang ");
        registerDTO.setAddress("Hoa Xuan,Cam Le,Da Nang");
        registerDTO.setPhone("0909111111");
        registerDTO.setEmail("nguyenthangfa2001@gmail");
        registerDTO.setContendNote("ghi chú trong này");

        ProductType productType = new ProductType();
        productType.setId(2L);
        registerDTO.setProductType(productType);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/register/create")
                        .content(this.objectMapper.writeValueAsString(registerDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * register pawn  phone double-ended whitespace !!!
     *
     * @throws Exception
     */
    @Test
    public void registerPawn_phone_98() throws Exception {
        RegisterDTO registerDTO = new RegisterDTO();
        registerDTO.setName("Nguyen Duc Thang");
        registerDTO.setAddress("Hoa Xuan,Cam Le,Da Nang");
        registerDTO.setPhone(" 0909111111 ");
        registerDTO.setEmail("nguyenthangfa2001@gmail");
        registerDTO.setContendNote("ghi chú trong này");

        ProductType productType = new ProductType();
        productType.setId(2L);
        registerDTO.setProductType(productType);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/register/create")
                        .content(this.objectMapper.writeValueAsString(registerDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * register pawn  email double-ended whitespace !!!
     *
     * @throws Exception
     */
    @Test
    public void registerPawn_email_98() throws Exception {
        RegisterDTO registerDTO = new RegisterDTO();
        registerDTO.setName("Nguyen Duc Thang");
        registerDTO.setAddress("Hoa Xuan,Cam Le,Da Nang");
        registerDTO.setPhone("0909111111");
        registerDTO.setEmail("   nguyenthangfa2001@gmail   ");
        registerDTO.setContendNote("ghi chú trong này");

        ProductType productType = new ProductType();
        productType.setId(2L);
        registerDTO.setProductType(productType);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/register/create")
                        .content(this.objectMapper.writeValueAsString(registerDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


}
