package com.example.back_end.dto;

import com.example.back_end.model.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CreateContractDto {

    private Long id;
    @NotBlank(message = "Không được để trống !")
    private String productName;
    @NotBlank(message = "Không được để trống !")
    private String contractCode;
    @NotNull(message = "Không được để trống !")
    private Long loans;
    @NotNull(message = "Không được để trống !")
    private Long profit;
    @NotBlank(message = "Không được để trống !")

    private String image;
    @NotBlank(message = "Không được để trống !")

    private String startDate;
    @NotBlank(message = "Không được để trống !")

    private String endDate;
@NotNull(message = "Không được để trống !")
    private ProductType productType;
    @NotNull(message = "Không được để trống !")

    private Customers customer;

    private ContractStatus contractStatus;

    private Employees employee;

    private ContractType contractType;

    public CreateContractDto() {
    }

    public CreateContractDto(Long id, String productName, String contractCode, Long loans, Long profit, String image, String startDate, String endDate, ProductType productType, Customers customer, ContractStatus contractStatus, Employees employee, ContractType contractType) {
        this.id = id;
        this.productName = productName;
        this.contractCode = contractCode;
        this.loans = loans;
        this.profit = profit;
        this.image = image;
        this.startDate = startDate;
        this.endDate = endDate;
        this.productType = productType;
        this.customer = customer;
        this.contractStatus = contractStatus;
        this.employee = employee;
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

    public Customers getCustomer() {
        return customer;
    }

    public void setCustomer(Customers customer) {
        this.customer = customer;
    }

    public ContractStatus getContractStatus() {
        return contractStatus;
    }

    public void setContractStatus(ContractStatus contractStatus) {
        this.contractStatus = contractStatus;
    }

    public Employees getEmployee() {
        return employee;
    }

    public void setEmployee(Employees employee) {
        this.employee = employee;
    }

    public ContractType getContractType() {
        return contractType;
    }

    public void setContractType(ContractType contractType) {
        this.contractType = contractType;
    }
}
