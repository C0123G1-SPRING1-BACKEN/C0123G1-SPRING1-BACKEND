package com.example.back_end.dto;

import com.example.back_end.model.ProductType;

import javax.validation.constraints.*;


public class RegisterDTO {

    private Long id;

    @Size(max = 100, message = "Tên Của Bạn Không Được Quá 100 Ký Tự")
    @Pattern(regexp = "^([A-Z][a-z]*(\\s[A-Z][a-z]*)*)$", message = "Tên Của Bạn Không Đúng Định Dạng ")
    @NotBlank(message = "Bạn Cần Điền Đủ Thông Tin")
    private String name;

    @Size(max = 11, message = "Số Điện Thoại Của Bạn Không Được Quá 11 Số !!!")
    @Pattern(regexp = "^((\\+84)|0)\\d{9}$", message = "Bạn Nhập Không Đúng Định Dạng Số Điện Thoại")
    @NotBlank(message = "Bạn Cần Nhập Đủ Thông Tin ")
    private String phone;

    @Email(message = "Email Của Bạn Không Đúng . Làm Ơn Nhập Kiểu :  abc@gmail.com ")
    @Size(max = 100, message = "Tên Của Bạn Không Được Quá 100 Ký Tự")
    @NotBlank(message = "Bạn Cần Nhập Đủ Thông Tin")
    private String email;


    @NotBlank(message = "Bạn Cần Nhập Đủ Thông Tin")
    @Size(max = 500, message = "Địa Chỉ Của Bạn Không Được Quá 500 Ký Tự !!!")
    private String address;

    @Size(max = 1000, message = "Nội Dung Ghi Chú  Của Bạn Không Được Quá 1000 Ký Tự !!!")
    @NotBlank(message = "Bạn Cần Nhập Đủ Thông Tin")
    private String contentNote;

    private boolean status = false;
    @NotNull
    private ProductType productType;


    public RegisterDTO() {
    }

    public RegisterDTO(String name, String phone, String email, String address, String contentNote, boolean status, ProductType productType) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.contentNote = contentNote;
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

    public String getContentNote() {
        return contentNote;
    }

    public void setContentNote(String contentNote) {
        this.contentNote = contentNote;
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
