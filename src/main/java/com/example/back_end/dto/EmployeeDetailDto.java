package com.example.back_end.dto;

import com.example.back_end.model.Users;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class EmployeeDetailDto {

    private Long id;
    @Size(max = 50)
    @NotBlank(message = "Không được để trống !")
    @Pattern(regexp = "^[^!@#$%^&*()+=\\[\\]{};':\"\\\\|.<>?`~]+$", message = "Không chứa kí tự số và kí tự đặc biệt")
    private String name;
    private String birthDay;
    private Integer gender;
    @NotBlank(message = "Không được để trống !")
    @NotBlank(message = "Vui lòng nhập địa chỉ email")
    @Email(message = "Nhập đúng định dạng. VD: abc@gmail.com")
    private String email;
    @Size(max = 10)
    @NotBlank(message = "Không được để trống !")
    private String phoneNumber;
    @NotBlank(message = "Không được để trống !")
    private String address;
    @NotBlank(message = "Không được để trống !")
    @Pattern(regexp = "^\\d+$", message = "Tiền không được nhập số âm")
    private String salary;
    @NotBlank(message = "Không được để trống !")
    @Pattern(regexp = "^[0-9]{12}$", message = "Nhập không đúng định dạng CMND/Hộ chiếu")
    private String citizenCode;
    private String image;
    private Users users;

    public EmployeeDetailDto() {
    }

    public EmployeeDetailDto(Long id, String name, String birthDay, Integer gender, String email, String phoneNumber, String address, String salary, String citizenCode, String image, Users users) {
        this.id = id;
        this.name = name;
        this.birthDay = birthDay;
        this.gender = gender;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.salary = salary;
        this.citizenCode = citizenCode;
        this.image = image;
        this.users = users;
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

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
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

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
}
