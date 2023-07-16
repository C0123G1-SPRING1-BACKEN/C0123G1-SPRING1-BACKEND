package com.example.back_end.controller;

import com.example.back_end.dto.*;
import com.example.back_end.model.*;
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
public class CreateContractRestController_createContract {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    /**
     * Create By : DinhHD
     * Date Create : 14/07/2023
     * create Contract productName = ""
     *
     * @throws Exception
     */
    @Test
    public void createContract_ProductName_14() throws Exception {
        CreateContractDto contractDto = new CreateContractDto();
        contractDto.setProductName("");
        contractDto.setContractCode("HD-0002");
        contractDto.setLoans(Long.valueOf(10000000));
        contractDto.setProfit(Long.valueOf(65000));
        contractDto.setImage("https://tse1.mm.bing.net/th?id=OIP.toFOTjJ8rRnokTZZzDVx1QHaE8&pid=Api&rs=1&c=1&qlt=95&w=161&h=107");
        contractDto.setStartDate("12-3-2023");
        contractDto.setEndDate("15-3-2023");

        Employees employee=new Employees();
        employee.setId(Long.valueOf(1));
        contractDto.setEmployees(employee);

        Customers customer = new Customers();
        customer.setId(Long.valueOf(1));
        contractDto.setCustomers(customer);

        ContractStatus contractStatus = new ContractStatus();
        contractStatus.setId(Long.valueOf(1));
        contractDto.setContractStatus(contractStatus);

        ContractType contractType = new ContractType();
        contractType.setId(Long.valueOf(1));
        contractDto.setContractType(contractType);

        ProductType productType = new ProductType();
        productType.setId(Long.valueOf(1));
        contractDto.setProductType(productType);

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/api/employee/contract/createContract")
                        .content(this.objectMapper.writeValueAsString(contractDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Create By : DinhHD
     * Date Create : 14/07/2023
     * create Contract contractCode = ""
     *
     * @throws Exception
     */
    @Test
    public void createContract_ContractCode_14() throws Exception {
        CreateContractDto contractDto = new CreateContractDto();
        contractDto.setProductName("Huỳnh Đức Định");
        contractDto.setContractCode("");
        contractDto.setLoans(Long.valueOf(10000000));
        contractDto.setProfit(Long.valueOf(65000));
        contractDto.setImage("https://tse1.mm.bing.net/th?id=OIP.toFOTjJ8rRnokTZZzDVx1QHaE8&pid=Api&rs=1&c=1&qlt=95&w=161&h=107");
        contractDto.setStartDate("12-3-2023");
        contractDto.setEndDate("15-3-2023");

        Employees employee=new Employees();
        employee.setId(Long.valueOf(1));
        contractDto.setEmployees(employee);

        Customers customer = new Customers();
        customer.setId(Long.valueOf(1));
        contractDto.setCustomers(customer);

        ContractStatus contractStatus = new ContractStatus();
        contractStatus.setId(Long.valueOf(1));
        contractDto.setContractStatus(contractStatus);

        ContractType contractType = new ContractType();
        contractType.setId(Long.valueOf(1));
        contractDto.setContractType(contractType);

        ProductType productType = new ProductType();
        productType.setId(Long.valueOf(1));
        contractDto.setProductType(productType);

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/api/employee/contract/createContract")
                        .content(this.objectMapper.writeValueAsString(contractDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Create By : DinhHD
     * Date Create : 14/07/2023
     * create Contract image = ""
     *
     * @throws Exception
     */
    @Test
    public void createContract_Image_14() throws Exception {
        CreateContractDto contractDto = new CreateContractDto();
        contractDto.setProductName("Huỳnh Đức Định");
        contractDto.setContractCode("HD-0001");
        contractDto.setLoans(Long.valueOf(10000000));
        contractDto.setProfit(Long.valueOf(65000));
        contractDto.setImage("");
        contractDto.setStartDate("12-3-2023");
        contractDto.setEndDate("15-3-2023");

        Employees employee=new Employees();
        employee.setId(Long.valueOf(1));
        contractDto.setEmployees(employee);

        Customers customer = new Customers();
        customer.setId(Long.valueOf(1));
        contractDto.setCustomers(customer);

        ContractStatus contractStatus = new ContractStatus();
        contractStatus.setId(Long.valueOf(1));
        contractDto.setContractStatus(contractStatus);

        ContractType contractType = new ContractType();
        contractType.setId(Long.valueOf(1));
        contractDto.setContractType(contractType);

        ProductType productType = new ProductType();
        productType.setId(Long.valueOf(1));
        contractDto.setProductType(productType);

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/api/employee/contract/createContract")
                        .content(this.objectMapper.writeValueAsString(contractDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Create By : DinhHD
     * Date Create : 14/07/2023
     * create Contract startDay = ""
     *
     * @throws Exception
     */
    @Test
    public void createContract_StartDate_14() throws Exception {
        CreateContractDto contractDto = new CreateContractDto();
        contractDto.setProductName("Huỳnh Đức Định");
        contractDto.setContractCode("HD-0001");
        contractDto.setLoans(Long.valueOf(10000000));
        contractDto.setProfit(Long.valueOf(65000));
        contractDto.setImage("https://tse1.mm.bing.net/th?id=OIP.toFOTjJ8rRnokTZZzDVx1QHaE8&pid=Api&rs=1&c=1&qlt=95&w=161&h=107");
        contractDto.setStartDate("");
        contractDto.setEndDate("15-3-2023");

        Employees employee=new Employees();
        employee.setId(Long.valueOf(1));
        contractDto.setEmployees(employee);

        Customers customer = new Customers();
        customer.setId(Long.valueOf(1));
        contractDto.setCustomers(customer);

        ContractStatus contractStatus = new ContractStatus();
        contractStatus.setId(Long.valueOf(1));
        contractDto.setContractStatus(contractStatus);

        ContractType contractType = new ContractType();
        contractType.setId(Long.valueOf(1));
        contractDto.setContractType(contractType);

        ProductType productType = new ProductType();
        productType.setId(Long.valueOf(1));
        contractDto.setProductType(productType);

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/api/employee/contract/createContract")

                        .content(this.objectMapper.writeValueAsString(contractDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Create By : DinhHD
     * Date Create : 14/07/2023
     * create Contract endDay = ""
     *
     * @throws Exception
     */
    @Test
    public void createContract_EndDate_14() throws Exception {
        CreateContractDto contractDto = new CreateContractDto();
        contractDto.setProductName("Huỳnh Đức Định");
        contractDto.setContractCode("HD-0001");
        contractDto.setLoans(Long.valueOf(10000000));
        contractDto.setProfit(Long.valueOf(65000));
        contractDto.setImage("https://tse1.mm.bing.net/th?id=OIP.toFOTjJ8rRnokTZZzDVx1QHaE8&pid=Api&rs=1&c=1&qlt=95&w=161&h=107");
        contractDto.setStartDate("12-3-2023");
        contractDto.setEndDate("");

        Employees employee=new Employees();
        employee.setId(Long.valueOf(1));
        contractDto.setEmployees(employee);

        Customers customer = new Customers();
        customer.setId(Long.valueOf(1));
        contractDto.setCustomers(customer);

        ContractStatus contractStatus = new ContractStatus();
        contractStatus.setId(Long.valueOf(1));
        contractDto.setContractStatus(contractStatus);

        ContractType contractType = new ContractType();
        contractType.setId(Long.valueOf(1));
        contractDto.setContractType(contractType);

        ProductType productType = new ProductType();
        productType.setId(Long.valueOf(1));
        contractDto.setProductType(productType);

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/api/employee/contract/createContract")

                        .content(this.objectMapper.writeValueAsString(contractDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create By : DinhHD
     * Date Create : 14/07/2023
     * create Contract [ProductName] = null
     *
     * @throws Exception
     */
    @Test
    public void createContract_ProductName_13() throws Exception {
        CreateContractDto contractDto = new CreateContractDto();
//        contractDto.setProductName("Huỳnh Đức Định");
        contractDto.setContractCode("HD-0001");
        contractDto.setLoans(Long.valueOf(10000000));
        contractDto.setProfit(Long.valueOf(65000));
        contractDto.setImage("https://tse1.mm.bing.net/th?id=OIP.toFOTjJ8rRnokTZZzDVx1QHaE8&pid=Api&rs=1&c=1&qlt=95&w=161&h=107");
        contractDto.setStartDate("12-3-2023");
        contractDto.setEndDate("");

        Employees employee=new Employees();
        employee.setId(Long.valueOf(1));
        contractDto.setEmployees(employee);

        Customers customer = new Customers();
        customer.setId(Long.valueOf(1));
        contractDto.setCustomers(customer);

        ContractStatus contractStatus = new ContractStatus();
        contractStatus.setId(Long.valueOf(1));
        contractDto.setContractStatus(contractStatus);

        ContractType contractType = new ContractType();
        contractType.setId(Long.valueOf(1));
        contractDto.setContractType(contractType);

        ProductType productType = new ProductType();
        productType.setId(Long.valueOf(1));
        contractDto.setProductType(productType);

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/api/employee/contract/createContract")
                        .content(this.objectMapper.writeValueAsString(contractDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Create By : DinhHD
     * Date Create : 14/07/2023
     * create Contract [ContractCode] = null
     *
     * @throws Exception
     */
    @Test
    public void createContract_ContractCode_13() throws Exception {
        CreateContractDto contractDto = new CreateContractDto();
        contractDto.setProductName("Huỳnh Đức Định");
//        contractDto.setContractCode("HD-0001");
        contractDto.setLoans(Long.valueOf(10000000));
        contractDto.setProfit(Long.valueOf(65000));
        contractDto.setImage("https://tse1.mm.bing.net/th?id=OIP.toFOTjJ8rRnokTZZzDVx1QHaE8&pid=Api&rs=1&c=1&qlt=95&w=161&h=107");
        contractDto.setStartDate("12-3-2023");
        contractDto.setEndDate("");

        Employees employee=new Employees();
        employee.setId(Long.valueOf(1));
        contractDto.setEmployees(employee);

        Customers customer = new Customers();
        customer.setId(Long.valueOf(1));
        contractDto.setCustomers(customer);

        ContractStatus contractStatus = new ContractStatus();
        contractStatus.setId(Long.valueOf(1));
        contractDto.setContractStatus(contractStatus);

        ContractType contractType = new ContractType();
        contractType.setId(Long.valueOf(1));
        contractDto.setContractType(contractType);

        ProductType productType = new ProductType();
        productType.setId(Long.valueOf(1));
        contractDto.setProductType(productType);

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/api/employee/contract/createContract")
                        .content(this.objectMapper.writeValueAsString(contractDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Create By : DinhHD
     * Date Create : 14/07/2023
     * create Contract [Loans] = null
     *
     * @throws Exception
     */
    @Test
    public void createContract_Loans_13() throws Exception {
        CreateContractDto contractDto = new CreateContractDto();
        contractDto.setProductName("Huỳnh Đức Định");
        contractDto.setContractCode("HD-0001");
//        contractDto.setLoans(Long.valueOf(10000000));
        contractDto.setProfit(Long.valueOf(65000));
        contractDto.setImage("https://tse1.mm.bing.net/th?id=OIP.toFOTjJ8rRnokTZZzDVx1QHaE8&pid=Api&rs=1&c=1&qlt=95&w=161&h=107");
        contractDto.setStartDate("12-3-2023");
        contractDto.setEndDate("");

        Employees employee=new Employees();
        employee.setId(Long.valueOf(1));
        contractDto.setEmployees(employee);

        Customers customer = new Customers();
        customer.setId(Long.valueOf(1));
        contractDto.setCustomers(customer);

        ContractStatus contractStatus = new ContractStatus();
        contractStatus.setId(Long.valueOf(1));
        contractDto.setContractStatus(contractStatus);

        ContractType contractType = new ContractType();
        contractType.setId(Long.valueOf(1));
        contractDto.setContractType(contractType);

        ProductType productType = new ProductType();
        productType.setId(Long.valueOf(1));
        contractDto.setProductType(productType);

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/api/employee/contract/createContract")
                        .content(this.objectMapper.writeValueAsString(contractDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Create By : DinhHD
     * Date Create : 14/07/2023
     * create Contract [Profit] = null
     *
     * @throws Exception
     */
    @Test
    public void createContract_Profit_13() throws Exception {
        CreateContractDto contractDto = new CreateContractDto();
        contractDto.setProductName("Huỳnh Đức Định");
        contractDto.setContractCode("HD-0001");
        contractDto.setLoans(Long.valueOf(10000000));
//        contractDto.setProfit(Long.valueOf(65000));
        contractDto.setImage("https://tse1.mm.bing.net/th?id=OIP.toFOTjJ8rRnokTZZzDVx1QHaE8&pid=Api&rs=1&c=1&qlt=95&w=161&h=107");
        contractDto.setStartDate("12-3-2023");
        contractDto.setEndDate("");

        Employees employee=new Employees();
        employee.setId(Long.valueOf(1));
        contractDto.setEmployees(employee);

        Customers customer = new Customers();
        customer.setId(Long.valueOf(1));
        contractDto.setCustomers(customer);

        ContractStatus contractStatus = new ContractStatus();
        contractStatus.setId(Long.valueOf(1));
        contractDto.setContractStatus(contractStatus);

        ContractType contractType = new ContractType();
        contractType.setId(Long.valueOf(1));
        contractDto.setContractType(contractType);

        ProductType productType = new ProductType();
        productType.setId(Long.valueOf(1));
        contractDto.setProductType(productType);

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/api/employee/contract/createContract")
                        .content(this.objectMapper.writeValueAsString(contractDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Create By : DinhHD
     * Date Create : 14/07/2023
     * create Contract [Image] = null
     *
     * @throws Exception
     */
    @Test
    public void createContract_Image_13() throws Exception {
        CreateContractDto contractDto = new CreateContractDto();
        contractDto.setProductName("Huỳnh Đức Định");
        contractDto.setContractCode("HD-0001");
        contractDto.setLoans(Long.valueOf(10000000));
        contractDto.setProfit(Long.valueOf(65000));
//        contractDto.setImage("https://tse1.mm.bing.net/th?id=OIP.toFOTjJ8rRnokTZZzDVx1QHaE8&pid=Api&rs=1&c=1&qlt=95&w=161&h=107");
        contractDto.setStartDate("12-3-2023");
        contractDto.setEndDate("");

        Employees employee=new Employees();
        employee.setId(Long.valueOf(1));
        contractDto.setEmployees(employee);

        Customers customer = new Customers();
        customer.setId(Long.valueOf(1));
        contractDto.setCustomers(customer);

        ContractStatus contractStatus = new ContractStatus();
        contractStatus.setId(Long.valueOf(1));
        contractDto.setContractStatus(contractStatus);

        ContractType contractType = new ContractType();
        contractType.setId(Long.valueOf(1));
        contractDto.setContractType(contractType);

        ProductType productType = new ProductType();
        productType.setId(Long.valueOf(1));
        contractDto.setProductType(productType);

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/api/employee/contract/createContract")
                        .content(this.objectMapper.writeValueAsString(contractDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Create By : DinhHD
     * Date Create : 14/07/2023
     * create Contract [StartDate] = null
     *
     * @throws Exception
     */
    @Test
    public void createContract_StartDate_13() throws Exception {
        CreateContractDto contractDto = new CreateContractDto();
        contractDto.setProductName("Huỳnh Đức Định");
        contractDto.setContractCode("HD-0001");
        contractDto.setLoans(Long.valueOf(10000000));
        contractDto.setProfit(Long.valueOf(65000));
        contractDto.setImage("https://tse1.mm.bing.net/th?id=OIP.toFOTjJ8rRnokTZZzDVx1QHaE8&pid=Api&rs=1&c=1&qlt=95&w=161&h=107");
//        contractDto.setStartDate("12-3-2023");
        contractDto.setEndDate("13-3-2023");

        Employees employee=new Employees();
        employee.setId(Long.valueOf(1));
        contractDto.setEmployees(employee);

        Customers customer = new Customers();
        customer.setId(Long.valueOf(1));
        contractDto.setCustomers(customer);

        ContractStatus contractStatus = new ContractStatus();
        contractStatus.setId(Long.valueOf(1));
        contractDto.setContractStatus(contractStatus);

        ContractType contractType = new ContractType();
        contractType.setId(Long.valueOf(1));
        contractDto.setContractType(contractType);

        ProductType productType = new ProductType();
        productType.setId(Long.valueOf(1));
        contractDto.setProductType(productType);

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/api/employee/contract/createContract")
                        .content(this.objectMapper.writeValueAsString(contractDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Create By : DinhHD
     * Date Create : 14/07/2023
     * create Contract [StartDate] = null
     *
     * @throws Exception
     */
    @Test
    public void createContract_EndDate_13() throws Exception {
        CreateContractDto contractDto = new CreateContractDto();
        contractDto.setProductName("Huỳnh Đức Định");
        contractDto.setContractCode("HD-0001");
        contractDto.setLoans(Long.valueOf(10000000));
        contractDto.setProfit(Long.valueOf(65000));
        contractDto.setImage("https://tse1.mm.bing.net/th?id=OIP.toFOTjJ8rRnokTZZzDVx1QHaE8&pid=Api&rs=1&c=1&qlt=95&w=161&h=107");
        contractDto.setStartDate("12-3-2023");
//        contractDto.setEndDate("13-3-2023");

        Employees employee=new Employees();
        employee.setId(Long.valueOf(1));
        contractDto.setEmployees(employee);

        Customers customer = new Customers();
        customer.setId(Long.valueOf(1));
        contractDto.setCustomers(customer);

        ContractStatus contractStatus = new ContractStatus();
        contractStatus.setId(Long.valueOf(1));
        contractDto.setContractStatus(contractStatus);

        ContractType contractType = new ContractType();
        contractType.setId(Long.valueOf(1));
        contractDto.setContractType(contractType);

        ProductType productType = new ProductType();
        productType.setId(Long.valueOf(1));
        contractDto.setProductType(productType);

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/api/employee/contract/createContract")
                        .content(this.objectMapper.writeValueAsString(contractDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }




    /**
     * Create By : DinhHD
     * Date Create : 14/07/2023
     * create Contract CHECK(loans >0)
     *
     * @throws Exception
     */
    @Test
    public void createContract_Loans_15() throws Exception {
        CreateContractDto contractDto = new CreateContractDto();
        contractDto.setProductName("Huỳnh Đức Định");
        contractDto.setContractCode("HD-0001");
        contractDto.setLoans(Long.valueOf(-1));
        contractDto.setProfit(Long.valueOf(65000));
        contractDto.setImage("https://tse1.mm.bing.net/th?id=OIP.toFOTjJ8rRnokTZZzDVx1QHaE8&pid=Api&rs=1&c=1&qlt=95&w=161&h=107");
        contractDto.setStartDate("12-3-2023");
        contractDto.setEndDate("13-3-2023");

        Employees employee=new Employees();
        employee.setId(Long.valueOf(1));
        contractDto.setEmployees(employee);

        Customers customer = new Customers();
        customer.setId(Long.valueOf(1));
        contractDto.setCustomers(customer);

        ContractStatus contractStatus = new ContractStatus();
        contractStatus.setId(Long.valueOf(1));
        contractDto.setContractStatus(contractStatus);

        ContractType contractType = new ContractType();
        contractType.setId(Long.valueOf(1));
        contractDto.setContractType(contractType);

        ProductType productType = new ProductType();
        productType.setId(Long.valueOf(1));
        contractDto.setProductType(productType);

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/api/employee/contract/createContract")
                        .content(this.objectMapper.writeValueAsString(contractDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Create By : DinhHD
     * Date Create : 14/07/2023
     * create Contract
     *
     * @throws Exception
     */
    @Test
    public void createContract_18() throws Exception {
        CreateContractDto contractDto = new CreateContractDto();
        contractDto.setProductName("Huỳnh Đức Định");
        contractDto.setContractCode("HD-0001");
        contractDto.setLoans(10000000L);
        contractDto.setProfit(6500L);
        contractDto.setImage("https://tse1.mm.bing.net/th?id=OIP.toFOTjJ8rRnokTZZzDVx1QHaE8&pid=Api&rs=1&c=1&qlt=95&w=161&h=107");
        contractDto.setStartDate("12-3-2023");
        contractDto.setEndDate("13-3-2023");

        Employees employee=new Employees();
        employee.setId(Long.valueOf(1));
        contractDto.setEmployees(employee);

        Customers customer = new Customers();
        customer.setId(Long.valueOf(1));
        contractDto.setCustomers(customer);

        ContractStatus contractStatus = new ContractStatus();
        contractStatus.setId(Long.valueOf(1));
        contractDto.setContractStatus(contractStatus);

        ContractType contractType = new ContractType();
        contractType.setId(Long.valueOf(1));
        contractDto.setContractType(contractType);

        ProductType productType = new ProductType();
        productType.setId(Long.valueOf(1));
        contractDto.setProductType(productType);

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/api/employee/contract/createContract")
                        .content(this.objectMapper.writeValueAsString(contractDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }


}
