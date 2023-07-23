package com.example.back_end.dto;

import com.example.back_end.model.ProductType;

import javax.validation.constraints.*;


public class RegisterDTO {

    private Long id;

    @Size(max = 100, message = "Tên của bạn không được quá 100 ký tự")
    @Pattern(regexp = "^\\p{Lu}\\p{Ll}*(\\s\\p{Lu}\\p{Ll}*)*$", message = "Tên của bạn không đúng định dạng . Ví dụ : Phạm Minh Sơn ")
    @NotBlank(message = "Bạn cần điền đủ thông tin")
    private String name;

    @Size(max = 11, message = "Số điện thoại của bạn không được quá 11 số !!!")
    @Pattern(regexp = "^((\\+84)|0)\\d{9}$", message = "Bạn nhập không đúng định dạng số điện thoại . Vui lòng nhập kiểu 0xxx xxx xxx")
    @NotBlank(message = "Bạn cần nhập đủ thông tin ")
    private String phone;

    @Email(message = "Email của bạn không đúng . Vui lòng nhập kiểu : abc@gmail.com ")
    @Size(max = 100, message = "Tên Của Bạn Không Được Quá 100 Ký Tự")
    @NotBlank(message = "Bạn Cần Nhập Đủ Thông Tin")
    private String email;


    @NotBlank(message = "Bạn cần nhập đủ thông tin")
    @Size(max = 500, message = "Địa chỉ của bạn không được quá 500 ký tự !!!")
    private String address;

    @Size(max = 1000, message = "Nội dung ghi chú  của bạn không được quá 1000 ký tự !!!")
    @NotBlank(message = "Bạn cần nhập đủ thông tin")
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
