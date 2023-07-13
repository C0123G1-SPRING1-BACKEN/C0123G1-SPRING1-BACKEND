package com.example.back_end.dto;

import com.example.back_end.model.ProductType;
import com.sun.istack.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

public class RegisterDTO {

    private Long id;

    @Size(max = 100, message = "Name cannot be longer than 100 characters")
    @Pattern(regexp = "^\\p{Lu}\\p{Ll}*(\\s\\p{Lu}\\p{Ll}*)*$", message = "Your name is not in the correct format")
    @NotBlank(message = "Please insert value")
    private String name;

    @Size(max = 11, message = "Phone number cannot 11 number !!!")
    @Pattern(regexp = "^((\\+84)|0)[0-9]{9}$", message = "Invalid phone number")
    @NotBlank(message = "Please insert value")
    private String phone;

    @Email(message = "Email is incorrect . Please type abc@gmail.com ")
    @NotBlank(message = "Please insert value")

    private String email;


    @NotBlank(message = "Please insert value")
    @Size(max = 500, message = "Phone number cannot 500 character !!!")
    private String address;

    @Size(max = 1000, message = "Phone number cannot 1000 character !!!")
    @NotBlank(message = "Please insert value")
    private String contendNote;


    private boolean status = false;


    private ProductType productType;

    public RegisterDTO() {
    }

    public RegisterDTO(String name, String phone, String email, String address, String contendNote, boolean status, ProductType productType) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.contendNote = contendNote;
        this.status = status;
        this.productType = productType;
    }

    public RegisterDTO(Long id, String name, String phone, String email, String address, String contendNote, boolean status, ProductType productType) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.contendNote = contendNote;
        this.status = status;
        this.productType = productType;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContendNote() {
        return contendNote;
    }

    public void setContendNote(String contendNote) {
        this.contendNote = contendNote;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }
}
