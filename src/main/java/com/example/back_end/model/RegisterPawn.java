package com.example.back_end.model;

import com.sun.istack.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.Valid;
import java.time.LocalDateTime;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Where(clause = "status=false")

public class RegisterPawn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
    @Column(unique = true,nullable = false)
    private String phone;
    @Column(unique = true,nullable = false)
    private String email;

    @Column(length = 500)
    private String address;

    @Column(length = 1000)
    private String contendNote;


    private boolean status = false;

    @ManyToOne
    @JoinColumn
    @Valid
    private ProductType productType;

    @Column(name = "create_time", columnDefinition = "DATETIME DEFAULT now()", updatable = false)
    @CreationTimestamp
    private LocalDateTime createTime;

    @Column(name = "update_time", columnDefinition = "DATETIME DEFAULT now()", updatable = false)
    @UpdateTimestamp
    private LocalDateTime updateTime;
    public RegisterPawn() {
    }

    public RegisterPawn(Long id, String name, String phone, String email, String address, String contendNote, boolean status, ProductType productType, LocalDateTime createTime,LocalDateTime updateTime) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.contendNote = contendNote;
        this.status = status;
        this.productType = productType;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public RegisterPawn(String name, String phone, String email, String address, String contendNote, boolean status, ProductType productType, LocalDateTime createTime,LocalDateTime updateTime) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.contendNote = contendNote;
        this.status = status;
        this.productType = productType;
        this.createTime = createTime;
        this.updateTime = updateTime;
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

    public void setProductType(ProductType servicePawn) {
        this.productType = servicePawn;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }
}
