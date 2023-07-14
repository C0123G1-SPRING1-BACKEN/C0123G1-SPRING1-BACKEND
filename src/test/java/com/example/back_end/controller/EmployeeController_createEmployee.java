package com.example.back_end.controller;

import com.example.back_end.dto.EmployeeDTO;
import com.example.back_end.dto.UsersDto;
import com.example.back_end.model.Users;
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
public class EmployeeController_createEmployee {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * Create By : DongPV
     * Date Create : 14/07/2023
     * create employee [name] = null
     *
     * @throws Exception
     */
    @Test
    public void createEmployee_name_13() throws Exception {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        Users users = new Users();
        employeeDTO.setBirthDay("12-05-1997");
        employeeDTO.setGender(1);
        employeeDTO.setEmail("levana@gmail.com");
        employeeDTO.setPhoneNumber("0964297438");
        employeeDTO.setAddress("60 Hàm Nghi");
        employeeDTO.setSalary("15000000");
        employeeDTO.setCitizenCode("197353406");
        employeeDTO.setImage("https://images2.thanhnien.vn/Uploaded/ngocthanh/2016_03_23/9x01_YGEO.jpg");
        users.setId(Long.valueOf(1));
        employeeDTO.setUsers(users);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/employee/create-employee")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create By : DongPV
     * Date Create : 14/07/2023
     * create employee [birthDay] = null
     *
     * @throws Exception
     */
    @Test
    public void createEmployee_birthDay_13() throws Exception {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        Users users = new Users();
        employeeDTO.setName("Ngô Văn Hậu");
        employeeDTO.setGender(1);
        employeeDTO.setEmail("levana@gmail.com");
        employeeDTO.setPhoneNumber("0964297438");
        employeeDTO.setAddress("60 Hàm Nghi");
        employeeDTO.setSalary("15000000");
        employeeDTO.setCitizenCode("197353406");
        employeeDTO.setImage("https://images2.thanhnien.vn/Uploaded/ngocthanh/2016_03_23/9x01_YGEO.jpg");
        users.setId(Long.valueOf(1));
        employeeDTO.setUsers(users);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/employee/create-employee")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create By : DongPV
     * Date Create : 14/07/2023
     * create employee [email] = null
     *
     * @throws Exception
     */
    @Test
    public void createEmployee_email_13() throws Exception {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        Users users = new Users();
        employeeDTO.setName("Ngô Văn Hậu");
        employeeDTO.setGender(1);
        employeeDTO.setBirthDay("12-05-1997");
        employeeDTO.setPhoneNumber("0964297438");
        employeeDTO.setAddress("60 Hàm Nghi");
        employeeDTO.setSalary("15000000");
        employeeDTO.setCitizenCode("197353406");
        employeeDTO.setImage("https://images2.thanhnien.vn/Uploaded/ngocthanh/2016_03_23/9x01_YGEO.jpg");
        users.setId(Long.valueOf(1));
        employeeDTO.setUsers(users);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/employee/create-employee")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create By : DongPV
     * Date Create : 14/07/2023
     * create employee [phoneNumber] = null
     *
     * @throws Exception
     */
    @Test
    public void createEmployee_phoneNumber_13() throws Exception {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        Users users = new Users();
        employeeDTO.setName("Ngô Văn Hậu");
        employeeDTO.setGender(1);
        employeeDTO.setBirthDay("12-05-1997");
        employeeDTO.setEmail("levana@gmail.com");
        employeeDTO.setAddress("60 Hàm Nghi");
        employeeDTO.setSalary("15000000");
        employeeDTO.setCitizenCode("197353406");
        employeeDTO.setImage("https://images2.thanhnien.vn/Uploaded/ngocthanh/2016_03_23/9x01_YGEO.jpg");
        users.setId(Long.valueOf(1));
        employeeDTO.setUsers(users);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/employee/create-employee")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create By : DongPV
     * Date Create : 14/07/2023
     * create employee [address] = null
     *
     * @throws Exception
     */
    @Test
    public void createEmployee_address_13() throws Exception {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        Users users = new Users();
        employeeDTO.setName("Ngô Văn Hậu");
        employeeDTO.setGender(1);
        employeeDTO.setBirthDay("12-05-1997");
        employeeDTO.setEmail("levana@gmail.com");
        employeeDTO.setPhoneNumber("0964297438");
        employeeDTO.setSalary("15000000");
        employeeDTO.setCitizenCode("197353406");
        employeeDTO.setImage("https://images2.thanhnien.vn/Uploaded/ngocthanh/2016_03_23/9x01_YGEO.jpg");
        users.setId(Long.valueOf(1));
        employeeDTO.setUsers(users);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/employee/create-employee")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create By : DongPV
     * Date Create : 14/07/2023
     * create employee [salary] = null
     *
     * @throws Exception
     */
    @Test
    public void createEmployee_salary_13() throws Exception {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        Users users = new Users();
        employeeDTO.setName("Ngô Văn Hậu");
        employeeDTO.setBirthDay("12-05-1997");
        employeeDTO.setGender(1);
        employeeDTO.setEmail("levana@gmail.com");
        employeeDTO.setPhoneNumber("0964297438");
        employeeDTO.setAddress("60 Hàm Nghi");
        employeeDTO.setCitizenCode("197353406");
        employeeDTO.setImage("https://images2.thanhnien.vn/Uploaded/ngocthanh/2016_03_23/9x01_YGEO.jpg");
        users.setId(Long.valueOf(1));
        employeeDTO.setUsers(users);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/employee/create-employee")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create By : DongPV
     * Date Create : 14/07/2023
     * create employee [citizenCode] = null
     *
     * @throws Exception
     */
    @Test
    public void createEmployee_citizenCode_13() throws Exception {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        Users users = new Users();
        employeeDTO.setName("Ngô Văn Hậu");
        employeeDTO.setBirthDay("12-05-1997");
        employeeDTO.setGender(1);
        employeeDTO.setEmail("levana@gmail.com");
        employeeDTO.setPhoneNumber("0964297438");
        employeeDTO.setAddress("60 Hàm Nghi");
        employeeDTO.setSalary("15000000");
        employeeDTO.setImage("https://images2.thanhnien.vn/Uploaded/ngocthanh/2016_03_23/9x01_YGEO.jpg");
        users.setId(Long.valueOf(1));
        employeeDTO.setUsers(users);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/employee/create-employee")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create By : DongPV
     * Date Create : 14/07/2023
     * create employee name = ""
     *
     * @throws Exception
     */
    @Test
    public void createEmployee_name_14() throws Exception {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        Users users = new Users();
        employeeDTO.setName("");
        employeeDTO.setBirthDay("12-05-1997");
        employeeDTO.setGender(1);
        employeeDTO.setEmail("levana@gmail.com");
        employeeDTO.setPhoneNumber("0964297438");
        employeeDTO.setAddress("60 Hàm Nghi");
        employeeDTO.setSalary("15000000");
        employeeDTO.setCitizenCode("197353406");
        employeeDTO.setImage("https://images2.thanhnien.vn/Uploaded/ngocthanh/2016_03_23/9x01_YGEO.jpg");
        users.setId(Long.valueOf(1));
        employeeDTO.setUsers(users);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/employee/create-employee")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create By : DongPV
     * Date Create : 14/07/2023
     * create employee birthDay = ""
     *
     * @throws Exception
     */
    @Test
    public void createEmployee_birthDay_14() throws Exception {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        Users users = new Users();
        employeeDTO.setName("Ngô Văn Hậu");
        employeeDTO.setBirthDay("");
        employeeDTO.setGender(1);
        employeeDTO.setEmail("levana@gmail.com");
        employeeDTO.setPhoneNumber("0964297438");
        employeeDTO.setAddress("60 Hàm Nghi");
        employeeDTO.setSalary("15000000");
        employeeDTO.setCitizenCode("197353406");
        employeeDTO.setImage("https://images2.thanhnien.vn/Uploaded/ngocthanh/2016_03_23/9x01_YGEO.jpg");
        users.setId(Long.valueOf(1));
        employeeDTO.setUsers(users);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/employee/create-employee")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create By : DongPV
     * Date Create : 14/07/2023
     * create employee email = ""
     *
     * @throws Exception
     */
    @Test
    public void createEmployee_email_14() throws Exception {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        Users users = new Users();
        employeeDTO.setName("Ngô Văn Hậu");
        employeeDTO.setBirthDay("10-05-1995");
        employeeDTO.setGender(1);
        employeeDTO.setEmail("");
        employeeDTO.setPhoneNumber("0964297438");
        employeeDTO.setAddress("60 Hàm Nghi");
        employeeDTO.setSalary("15000000");
        employeeDTO.setCitizenCode("197353406");
        employeeDTO.setImage("https://images2.thanhnien.vn/Uploaded/ngocthanh/2016_03_23/9x01_YGEO.jpg");
        users.setId(Long.valueOf(1));
        employeeDTO.setUsers(users);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/employee/create-employee")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create By : DongPV
     * Date Create : 14/07/2023
     * create employee phoneNumber = ""
     *
     * @throws Exception
     */
    @Test
    public void createEmployee_phoneNumber_14() throws Exception {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        Users users = new Users();
        employeeDTO.setName("Ngô Văn Hậu");
        employeeDTO.setBirthDay("10-05-1995");
        employeeDTO.setGender(1);
        employeeDTO.setEmail("levana@gmail.com");
        employeeDTO.setPhoneNumber("");
        employeeDTO.setAddress("60 Hàm Nghi");
        employeeDTO.setSalary("15000000");
        employeeDTO.setCitizenCode("197353406");
        employeeDTO.setImage("https://images2.thanhnien.vn/Uploaded/ngocthanh/2016_03_23/9x01_YGEO.jpg");
        users.setId(Long.valueOf(1));
        employeeDTO.setUsers(users);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/employee/create-employee")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create By : DongPV
     * Date Create : 14/07/2023
     * create employee address = ""
     *
     * @throws Exception
     */
    @Test
    public void createEmployee_address_14() throws Exception {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        Users users = new Users();
        employeeDTO.setName("Ngô Văn Hậu");
        employeeDTO.setBirthDay("10-05-1995");
        employeeDTO.setGender(1);
        employeeDTO.setEmail("levana@gmail.com");
        employeeDTO.setPhoneNumber("0964285369");
        employeeDTO.setAddress("");
        employeeDTO.setSalary("15000000");
        employeeDTO.setCitizenCode("197353406");
        employeeDTO.setImage("https://images2.thanhnien.vn/Uploaded/ngocthanh/2016_03_23/9x01_YGEO.jpg");
        users.setId(Long.valueOf(1));
        employeeDTO.setUsers(users);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/employee/create-employee")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create By : DongPV
     * Date Create : 14/07/2023
     * create employee salary = ""
     *
     * @throws Exception
     */
    @Test
    public void createEmployee_salary_14() throws Exception {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        Users users = new Users();
        employeeDTO.setName("Ngô Văn Hậu");
        employeeDTO.setBirthDay("10-05-1995");
        employeeDTO.setGender(1);
        employeeDTO.setEmail("levana@gmail.com");
        employeeDTO.setPhoneNumber("0964285369");
        employeeDTO.setAddress("01 Hàm Nghi");
        employeeDTO.setSalary("");
        employeeDTO.setCitizenCode("197353406");
        employeeDTO.setImage("https://images2.thanhnien.vn/Uploaded/ngocthanh/2016_03_23/9x01_YGEO.jpg");
        users.setId(Long.valueOf(1));
        employeeDTO.setUsers(users);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/employee/create-employee")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create By : DongPV
     * Date Create : 14/07/2023
     * create employee citizenCode = ""
     *
     * @throws Exception
     */
    @Test
    public void createEmployee_citizenCode_14() throws Exception {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        Users users = new Users();
        employeeDTO.setName("Ngô Văn Hậu");
        employeeDTO.setBirthDay("10-05-1995");
        employeeDTO.setGender(1);
        employeeDTO.setEmail("levana@gmail.com");
        employeeDTO.setPhoneNumber("0964285369");
        employeeDTO.setAddress("01 Hàm Nghi");
        employeeDTO.setSalary("10000000");
        employeeDTO.setCitizenCode("");
        employeeDTO.setImage("https://images2.thanhnien.vn/Uploaded/ngocthanh/2016_03_23/9x01_YGEO.jpg");
        users.setId(Long.valueOf(1));
        employeeDTO.setUsers(users);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/employee/create-employee")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create By : DongPV
     * Date Create : 14/07/2023
     * create employee image = ""
     *
     * @throws Exception
     */
    @Test
    public void createEmployee_image_14() throws Exception {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        Users users = new Users();
        employeeDTO.setName("Ngô Văn Hậu");
        employeeDTO.setBirthDay("10-05-1995");
        employeeDTO.setGender(1);
        employeeDTO.setEmail("levana@gmail.com");
        employeeDTO.setPhoneNumber("0964285369");
        employeeDTO.setAddress("01 Hàm Nghi");
        employeeDTO.setSalary("10000000");
        employeeDTO.setCitizenCode("197254789");
        employeeDTO.setImage("");
        users.setId(Long.valueOf(1));
        employeeDTO.setUsers(users);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/employee/create-employee")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create By : DongPV
     * Date Create : 14/07/2023
     * create employee birthDay wrong format
     *
     * @throws Exception
     */
    @Test
    public void createEmployee_birthDay_15() throws Exception {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        Users users = new Users();
        employeeDTO.setName("Ngô Văn Hậu");
        employeeDTO.setBirthDay("2023-01-11");
        employeeDTO.setGender(1);
        employeeDTO.setEmail("levana@gmail.com");
        employeeDTO.setPhoneNumber("0964297438");
        employeeDTO.setAddress("60 Hàm Nghi");
        employeeDTO.setSalary("15000000");
        employeeDTO.setCitizenCode("197353406");
        employeeDTO.setImage("https://images2.thanhnien.vn/Uploaded/ngocthanh/2016_03_23/9x01_YGEO.jpg");
        users.setId(Long.valueOf(1));
        employeeDTO.setUsers(users);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/employee/create-employee")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create By : DongPV
     * Date Create : 14/07/2023
     * create employee email wrong format
     *
     * @throws Exception
     */
    @Test
    public void createEmployee_email_15() throws Exception {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        Users users = new Users();
        employeeDTO.setName("Ngô Văn Hậu");
        employeeDTO.setBirthDay("2023-01-11");
        employeeDTO.setGender(1);
        employeeDTO.setEmail("levana@yahoo.com");
        employeeDTO.setPhoneNumber("0964297438");
        employeeDTO.setAddress("60 Hàm Nghi");
        employeeDTO.setSalary("15000000");
        employeeDTO.setCitizenCode("197353406");
        employeeDTO.setImage("https://images2.thanhnien.vn/Uploaded/ngocthanh/2016_03_23/9x01_YGEO.jpg");
        users.setId(Long.valueOf(1));
        employeeDTO.setUsers(users);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/employee/create-employee")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create By : DongPV
     * Date Create : 14/07/2023
     * create employee phoneNumber can only write numbers
     *
     * @throws Exception
     */
    @Test
    public void createEmployee_phoneNumber_15() throws Exception {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        Users users = new Users();
        employeeDTO.setName("Ngô Văn Hậu");
        employeeDTO.setBirthDay("2023-01-11");
        employeeDTO.setGender(1);
        employeeDTO.setEmail("levana@gmail.com");
        employeeDTO.setPhoneNumber("adasdsasd");
        employeeDTO.setAddress("60 Hàm Nghi");
        employeeDTO.setSalary("15000000");
        employeeDTO.setCitizenCode("197353406");
        employeeDTO.setImage("https://images2.thanhnien.vn/Uploaded/ngocthanh/2016_03_23/9x01_YGEO.jpg");
        users.setId(Long.valueOf(1));
        employeeDTO.setUsers(users);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/employee/create-employee")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create By : DongPV
     * Date Create : 14/07/2023
     * create employee salary can only write numbers
     *
     * @throws Exception
     */
    @Test
    public void createEmployee_salary_15() throws Exception {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        Users users = new Users();
        employeeDTO.setName("Ngô Văn Hậu");
        employeeDTO.setBirthDay("2023-01-11");
        employeeDTO.setGender(1);
        employeeDTO.setEmail("levana@gmail.com");
        employeeDTO.setPhoneNumber("12000000");
        employeeDTO.setAddress("60 Hàm Nghi");
        employeeDTO.setSalary("sadsadasd");
        employeeDTO.setCitizenCode("197353406");
        employeeDTO.setImage("https://images2.thanhnien.vn/Uploaded/ngocthanh/2016_03_23/9x01_YGEO.jpg");
        users.setId(Long.valueOf(1));
        employeeDTO.setUsers(users);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/employee/create-employee")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create By : DongPV
     * Date Create : 14/07/2023
     * create employee negative salary
     *
     * @throws Exception
     */
    @Test
    public void createEmployee_Salary_15() throws Exception {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        Users users = new Users();
        employeeDTO.setName("Ngô Văn Hậu");
        employeeDTO.setBirthDay("2023-01-11");
        employeeDTO.setGender(1);
        employeeDTO.setEmail("levana@gmail.com");
        employeeDTO.setPhoneNumber("12000000");
        employeeDTO.setAddress("60 Hàm Nghi");
        employeeDTO.setSalary("-1500000");
        employeeDTO.setCitizenCode("197353406");
        employeeDTO.setImage("https://images2.thanhnien.vn/Uploaded/ngocthanh/2016_03_23/9x01_YGEO.jpg");
        users.setId(Long.valueOf(1));
        employeeDTO.setUsers(users);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/employee/create-employee")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create By : DongPV
     * Date Create : 14/07/2023
     * create employee name length >= 2
     *
     * @throws Exception
     */
    @Test
    public void createEmployee_name_16() throws Exception {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        Users users = new Users();
        employeeDTO.setName("a");
        employeeDTO.setBirthDay("2023-01-11");
        employeeDTO.setGender(1);
        employeeDTO.setEmail("levana@gmail.com");
        employeeDTO.setPhoneNumber("0964287456");
        employeeDTO.setAddress("60 Hàm Nghi");
        employeeDTO.setSalary("12000000");
        employeeDTO.setCitizenCode("197353406");
        employeeDTO.setImage("https://images2.thanhnien.vn/Uploaded/ngocthanh/2016_03_23/9x01_YGEO.jpg");
        users.setId(Long.valueOf(1));
        employeeDTO.setUsers(users);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/employee/create-employee")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create By : DongPV
     * Date Create : 14/07/2023
     * create employee phoneNumber length = 10
     *
     * @throws Exception
     */
    @Test
    public void createEmployee_phone_number_16() throws Exception {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        Users users = new Users();
        employeeDTO.setName("Ngô Văn Hậu");
        employeeDTO.setBirthDay("2023-01-11");
        employeeDTO.setGender(1);
        employeeDTO.setEmail("levana@gmail.com");
        employeeDTO.setPhoneNumber("096428");
        employeeDTO.setAddress("60 Hàm Nghi");
        employeeDTO.setSalary("12000000");
        employeeDTO.setCitizenCode("197353406");
        employeeDTO.setImage("https://images2.thanhnien.vn/Uploaded/ngocthanh/2016_03_23/9x01_YGEO.jpg");
        users.setId(Long.valueOf(1));
        employeeDTO.setUsers(users);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/employee/create-employee")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create By : DongPV
     * Date Create : 14/07/2023
     * create employee citizenCode length >= 10
     *
     * @throws Exception
     */
    @Test
    public void createEmployee_citizenCode_16() throws Exception {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        Users users = new Users();
        employeeDTO.setName("Ngô Văn Hậu");
        employeeDTO.setBirthDay("2023-01-11");
        employeeDTO.setGender(1);
        employeeDTO.setEmail("levana@gmail.com");
        employeeDTO.setPhoneNumber("0964287456");
        employeeDTO.setAddress("60 Hàm Nghi");
        employeeDTO.setSalary("12000000");
        employeeDTO.setCitizenCode("19735");
        employeeDTO.setImage("https://images2.thanhnien.vn/Uploaded/ngocthanh/2016_03_23/9x01_YGEO.jpg");
        users.setId(Long.valueOf(1));
        employeeDTO.setUsers(users);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/employee/create-employee")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create By : DongPV
     * Date Create : 14/07/2023
     * create employee name length < 50
     *
     * @throws Exception
     */
    @Test
    public void createEmployee_name_17() throws Exception {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        Users users = new Users();
        employeeDTO.setName("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        employeeDTO.setBirthDay("2023-01-11");
        employeeDTO.setGender(1);
        employeeDTO.setEmail("levana@gmail.com");
        employeeDTO.setPhoneNumber("0964287456");
        employeeDTO.setAddress("60 Hàm Nghi");
        employeeDTO.setSalary("12000000");
        employeeDTO.setCitizenCode("197353406");
        employeeDTO.setImage("https://images2.thanhnien.vn/Uploaded/ngocthanh/2016_03_23/9x01_YGEO.jpg");
        users.setId(Long.valueOf(1));
        employeeDTO.setUsers(users);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/employee/create-employee")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create By : DongPV
     * Date Create : 14/07/2023
     * create employee phoneNumber length <= 10
     *
     * @throws Exception
     */
    @Test
    public void createEmployee_phone_number_17() throws Exception {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        Users users = new Users();
        employeeDTO.setName("Ngô Văn Hậu");
        employeeDTO.setBirthDay("2023-01-11");
        employeeDTO.setGender(1);
        employeeDTO.setEmail("levana@gmail.com");
        employeeDTO.setPhoneNumber("0964287456123213");
        employeeDTO.setAddress("60 Hàm Nghi");
        employeeDTO.setSalary("12000000");
        employeeDTO.setCitizenCode("197353406");
        employeeDTO.setImage("https://images2.thanhnien.vn/Uploaded/ngocthanh/2016_03_23/9x01_YGEO.jpg");
        users.setId(Long.valueOf(1));
        employeeDTO.setUsers(users);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/employee/create-employee")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create By : DongPV
     * Date Create : 14/07/2023
     * create employee citizenCode length <= 12
     *
     * @throws Exception
     */
    @Test
    public void createEmployee_citizenCode_17() throws Exception {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        Users users = new Users();
        employeeDTO.setName("Ngô Văn Hậu");
        employeeDTO.setBirthDay("2023-01-11");
        employeeDTO.setGender(1);
        employeeDTO.setEmail("levana@gmail.com");
        employeeDTO.setPhoneNumber("0964287456");
        employeeDTO.setAddress("60 Hàm Nghi");
        employeeDTO.setSalary("12000000");
        employeeDTO.setCitizenCode("197353406123213");
        employeeDTO.setImage("https://images2.thanhnien.vn/Uploaded/ngocthanh/2016_03_23/9x01_YGEO.jpg");
        users.setId(Long.valueOf(1));
        employeeDTO.setUsers(users);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/employee/create-employee")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create By : DongPV
     * Date Create : 14/07/2023
     * create employee success
     *
     * @throws Exception
     */
    @Test
    public void createEmployee_success_18() throws Exception {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        Users users = new Users();
        employeeDTO.setName("Ngô Văn Hậu");
        employeeDTO.setBirthDay("2023-01-11");
        employeeDTO.setGender(1);
        employeeDTO.setEmail("levana@gmail.com");
        employeeDTO.setPhoneNumber("0964287456");
        employeeDTO.setAddress("60 Hàm Nghi");
        employeeDTO.setSalary("12000000");
        employeeDTO.setCitizenCode("197353406114");
        employeeDTO.setImage("https://images2.thanhnien.vn/Uploaded/ngocthanh/2016_03_23/9x01_YGEO.jpg");
        users.setId(Long.valueOf(1));
        employeeDTO.setUsers(users);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/employee/create-employee")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
