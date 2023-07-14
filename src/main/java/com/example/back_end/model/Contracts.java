package com.example.back_end.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "contracts")
public class Contracts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_name", columnDefinition = "VARCHAR(250)" )
    private String productName;
    @Column(name = "contract_code", columnDefinition = "VARCHAR(250)")
    private String contractCode;
    private Long loans;
    private Long profit;
    @Column(name = "image", columnDefinition = "TEXT")
    private String image;
    @Column(name = "start_date", columnDefinition = "VARCHAR(25)")
    private String startDate;
    @Column(name = "end_date", columnDefinition = "VARCHAR(25)")
    private String endDate;
    @Column(name = "create_date", columnDefinition = "DATETIME DEFAULT now()", updatable = false)
    @CreationTimestamp
    private LocalDateTime createDate;
    @Column(name = "update_date", columnDefinition = "DATETIME DEFAULT now()", updatable = true)
    @UpdateTimestamp
    private LocalDateTime updateDate;

    @Column(name = "is_delete", columnDefinition = "BIT DEFAULT 0")
    private boolean isDelete;
    @ManyToOne
    @JoinColumn
    private ProductType productType;
    @ManyToOne
    @JoinColumn
    private Customers customer;
    @ManyToOne
    @JoinColumn
    private ContractStatus contractStatus;
    @ManyToOne
    @JoinColumn
    private Employees employee;
    @ManyToOne
    @JoinColumn
    private ContractType contractType;


    public Contracts(){
    }

    public Contracts(Long id, String productName, String contractCode, Long loans, Long profit, String image, String startDate, String endDate, LocalDateTime createDate, LocalDateTime updateDate, boolean isDelete, ProductType productType, Customers customer, ContractStatus contractStatus, Employees employee, ContractType contractType) {
        this.id = id;
        this.productName = productName;
        this.contractCode = contractCode;
        this.loans = loans;
        this.profit = profit;
        this.image = image;
        this.startDate = startDate;
        this.endDate = endDate;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.isDelete = isDelete;
        this.productType = productType;
        this.customer = customer;
        this.contractStatus = contractStatus;
        this.employee = employee;
        this.contractType = contractType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }

    public Long getLoans() {
        return loans;
    }

    public void setLoans(Long loans) {
        this.loans = loans;
    }

    public Long getProfit() {
        return profit;
    }

    public void setProfit(Long profit) {
        this.profit = profit;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
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

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public Customers getCustomer() {
        return customer;
    }

    public void setCustomer(Customers customer) {
        this.customer = customer;
    }

    public ContractStatus getContractStatus() {
        return contractStatus;
    }

    public void setContractStatus(ContractStatus contractStatus) {
        this.contractStatus = contractStatus;
    }

    public Employees getEmployee() {
        return employee;
    }

    public void setEmployee(Employees employee) {
        this.employee = employee;
    }

    public ContractType getContractType() {
        return contractType;
    }

    public void setContractType(ContractType contractType) {
        this.contractType = contractType;
    }
}
