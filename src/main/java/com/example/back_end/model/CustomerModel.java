package com.example.back_end.model;

import javax.persistence.*;
import java.time.LocalDateTime;
@Entity
@Table(name = "customer")
public class CustomerModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idCustomer;
    private String nameCustomer;
    private String birthday;
    private int gender;
    private String phone;
    private String email;
    private String address;
    private String codeCitizen;
    private String image;
    private String frondCitizen;
    private String backCitizen;
    private String quantityContract;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private boolean isDelete;

    public CustomerModel() {
    }

    public CustomerModel(int idCustomer, String nameCustomer, String birthday, int gender, String phone, String email, String address, String codeCitizen, String image, String frondCitizen, String backCitizen, String quantityContract, LocalDateTime createDate, LocalDateTime updateDate, boolean isDelete) {
        this.idCustomer = idCustomer;
        this.nameCustomer = nameCustomer;
        this.birthday = birthday;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.codeCitizen = codeCitizen;
        this.image = image;
        this.frondCitizen = frondCitizen;
        this.backCitizen = backCitizen;
        this.quantityContract = quantityContract;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.isDelete = isDelete;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
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

    public String getCodeCitizen() {
        return codeCitizen;
    }

    public void setCodeCitizen(String codeCitizen) {
        this.codeCitizen = codeCitizen;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getFrondCitizen() {
        return frondCitizen;
    }

    public void setFrondCitizen(String frondCitizen) {
        this.frondCitizen = frondCitizen;
    }

    public String getBackCitizen() {
        return backCitizen;
    }

    public void setBackCitizen(String backCitizen) {
        this.backCitizen = backCitizen;
    }

    public String getQuantityContract() {
        return quantityContract;
    }

    public void setQuantityContract(String quantityContract) {
        this.quantityContract = quantityContract;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    public boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(boolean isDelete) {
        this.isDelete = isDelete;
    }
}
