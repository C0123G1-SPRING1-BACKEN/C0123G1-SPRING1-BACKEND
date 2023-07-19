package com.example.back_end.dto;


import com.example.back_end.utils.YearOldValid;

import javax.validation.constraints.*;

public class CustomerSaveDto {
    private Long id;
    @NotBlank(message = "Tên không đươc để trống.")
    @Size(min = 5, message = "Bạn cần nhập tối thiểu 5 ký tự")
    @Size(max = 20, message = "Bạn nhập quá 20 ký tự. Vui lòng kiểm tra lại")
    @Pattern(regexp = "^[a-zA-ZÀ-ỹ\\s ]*$", message = "Tên không được nhập số và ký tự đặc biệt.")
    private String name;
    @Size(min = 10, message = "Bạn cần nhập tối thiểu 10 ký tự")
    @Size(max = 12, message = "Bạn nhập quá 12 ký tự. Vui lòng kiểm tra lại")
    @NotBlank(message = "Ngày sinh không đươc để trống")
    @Pattern(regexp = "^(19|20)\\d{2}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[0-1])$",
            message = "Ngày sinh phải đúng định dạng DD/MM/YYYY.")
    @YearOldValid
    private String birthday;
    @NotNull(message = "Giới tính không được để trống")
    private int gender;
    @Size(min = 10, max = 10, message = "Bạn cần nhập 10 ký tự")
    @NotBlank(message = "Số điện thoại không được để trống.")
    @Pattern(message = "Số điện thoại không đúng định dạng.", regexp = "^(0[0-9]{9})$")
    private String phoneNumber;
    @Size(min = 10, message = "Bạn cần nhập tối thiểu 10 ký tự")
    @Size(max = 50, message = "Bạn nhập quá 50 ký tự. Vui lòng kiểm tra lại")
    @NotBlank(message = "Email không được để trống.")
    @Email(message = "Email không đúng định dạng")
    private String email;
    @NotBlank
    @Size(min = 10, message = "Bạn cần nhập tối thiểu 10 ký tự")
    @Size(max = 100, message = "Bạn nhập quá 100 ký tự. Vui lòng kiểm tra lại")
    private String address;
    @NotBlank(message = "Số CCCD không được để trống.")
    @Size(min = 12, max = 12, message = "Bạn cần nhập 12 ký tự")
    @Pattern(regexp = "^(\\d{12})| $",
            message = "Số CCCD không đúng định dạng.")
    private String citizenCode;
    @NotBlank
    @Size(min = 5, message = "Bạn cần nhập tối thiểu 5 ký tự")
    @Size(max = 200, message = "Bạn nhập quá 200 ký tự. Vui lòng kiểm tra lại")
    private String image;
    @NotBlank
    @Size(min = 5, message = "Bạn cần nhập tối thiểu 5 ký tự")
    @Size(max = 200, message = "Bạn nhập quá 200 ký tự. Vui lòng kiểm tra lại")
    private String frontCitizen;
    @NotBlank
    @Size(min = 5, message = "Bạn cần nhập tối thiểu 5 ký tự")
    @Size(max = 200, message = "Bạn nhập quá 200 ký tự. Vui lòng kiểm tra lại")
    private String backCitizen;

    public CustomerSaveDto() {
    }

    public CustomerSaveDto(Long id, String name, String birthday, int gender, String phoneNumber, String email, String address, String citizenCode, String image, String frontCitizen, String backCitizen) {
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
