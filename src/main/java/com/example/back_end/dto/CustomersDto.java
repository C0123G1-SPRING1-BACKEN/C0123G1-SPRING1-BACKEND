package com.example.back_end.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CustomersDto {
    @Id
    private Long id;
    private String name;
    private String phoneNumber;
    private String citizenCode;
    private String quantityContract;

    public CustomersDto() {
    }

    public CustomersDto(Long id, String name, String phoneNumber, String citizenCode, String quantityContract) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.citizenCode = citizenCode;
        this.quantityContract = quantityContract;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCitizenCode() {
        return citizenCode;
    }

    public void setCitizenCode(String citizenCode) {
        this.citizenCode = citizenCode;
    }

    public String getQuantityContract() {
        return quantityContract;
    }

    public void setQuantityContract(String quantityContract) {
        this.quantityContract = quantityContract;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
