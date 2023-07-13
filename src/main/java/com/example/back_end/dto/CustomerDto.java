package com.example.back_end.dto;

public class CustomerDto {
    private Long id;
    private String name;
    private String citizenCode;

    public CustomerDto(Long id, String name, String citizenCode) {
        this.id = id;
        this.name = name;
        this.citizenCode = citizenCode;
    }

    public CustomerDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCitizenCode() {
        return citizenCode;
    }

    public void setCitizenCode(String citizenCode) {
        this.citizenCode = citizenCode;
    }
}
