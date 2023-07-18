package com.example.back_end.dto;

import com.example.back_end.model.*;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;

public class CreateContractDto implements Validator {

    private Long id;

    private String productName;

    private String contractCode;
    @NotNull(message = "Không được để trống !")
    @Min(value = 500000, message = "Lớn hơn 500000")
    private Long loans;

    private Long profit;
    private String image;
    @NotBlank(message = "Không được để trống !")
//    @FutureOrPresent(message = "Ngày tạo phải là hiện tại hoặc tương lai")
    private String startDate;
//    @FutureOrPresent(message = "Ngày tạo phải là  hiện tại hoặc tương lai ")
    @NotBlank(message = "Không được để trống !")
    private String endDate;

    private ProductType productType;

    private Customers customers;


    private ContractStatus contractStatus;


    private Employees employees;


    private ContractType contractType;

    public CreateContractDto() {
    }

    public CreateContractDto(Long id, String productName, String contractCode, Long loans, Long profit, String image, String startDate, String endDate, ProductType productType, Customers customers, ContractStatus contractStatus, Employees employees, ContractType contractType) {
        this.id = id;
        this.productName = productName;
        this.contractCode = contractCode;
        this.loans = loans;
        this.profit = profit;
        this.image = image;
        this.startDate = startDate;
        this.endDate = endDate;
        this.productType = productType;
        this.customers = customers;
        this.contractStatus = contractStatus;
        this.employees = employees;
        this.contractType = contractType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }

    public Long getLoans() {
        return loans;
    }

    public void setLoans(Long loans) {
        this.loans = loans;
    }

    public Long getProfit() {
        return profit;
    }

    public void setProfit(Long profit) {
        this.profit = profit;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public Customers getCustomers() {
        return customers;
    }

    public void setCustomers(Customers customers) {
        this.customers = customers;
    }

    public ContractStatus getContractStatus() {
        return contractStatus;
    }

    public void setContractStatus(ContractStatus contractStatus) {
        this.contractStatus = contractStatus;
    }

    public Employees getEmployees() {
        return employees;
    }

    public void setEmployees(Employees employees) {
        this.employees = employees;
    }

    public ContractType getContractType() {
        return contractType;
    }

    public void setContractType(ContractType contractType) {
        this.contractType = contractType;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
