package com.example.back_end.dto;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class CustomerSaveDto {
    private Long id;
    @NotBlank(message = "Tên không đươc để trống.")
    @Pattern(regexp = "^[a-zA-ZÀ-ỹ\\s ]*$", message = "Tên không được nhập số và ký tự đặc biệt.")
    private String name;
    @NotBlank(message = "Ngày sinh không đươc để trống")
    @Pattern(regexp = "^(19|20)\\d{2}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[0-1])$",
            message = "Ngày sinh phải đúng định dạng DD/MM/YYYY.")
    private String birthday;
    private int gender;
    @NotBlank(message = "Số điện thoại không được để trống.")
    @Pattern(message = "Số điện thoại không đúng định dạng.", regexp = "^(((\\\\+|)84)|0)(3|5|7|8|9)+([0-9]{8})$")
    private String phoneNumber;
    @NotBlank(message = "Email không được để trống.")
    @Email(message = "Email không đúng định dạng")
    private String email;
    @NotBlank
    private String address;
    @NotBlank(message = "Số CCCD không được để trống.")
    @Pattern(regexp = "^(\\d{12})| *$",
            message = "Số CCCD không đúng định dạng.")
    private String citizenCode;
    @NotBlank
    private String image;
    @NotBlank
    private String frontCitizen;
    @NotBlank
    private String backCitizen;
    private boolean isDelete;

    public CustomerSaveDto() {
    }

    public CustomerSaveDto(Long id, String name, String birthday, int gender, String phoneNumber, String email, String address, String citizenCode, String image, String frontCitizen, String backCitizen, boolean isDelete) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.citizenCode = citizenCode;
        this.image = image;
        this.frontCitizen = frontCitizen;
        this.backCitizen = backCitizen;
        this.isDelete = isDelete;
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    public String getCitizenCode() {
        return citizenCode;
    }

    public void setCitizenCode(String citizenCode) {
        this.citizenCode = citizenCode;
    }

    public String getImage() {
        return image;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getFrontCitizen() {
        return frontCitizen;
    }

    public void setFrontCitizen(String frontCitizen) {
        this.frontCitizen = frontCitizen;
    }

    public String getBackCitizen() {
        return backCitizen;
    }

    public void setBackCitizen(String backCitizen) {
        this.backCitizen = backCitizen;
    }
}
