package com.example.back_end.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = "contracts")
public class Contracts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_name", columnDefinition = "VARCHAR(250)", nullable = false)
    private String productName;
    @Column(name = "contract_code", columnDefinition = "VARCHAR(250)", nullable = false)
    private String contractCode;
    @Column(nullable = false)
    private Long loans;
    @Column(nullable = false)
    private Long profit;
    @Column(name = "image", columnDefinition = "TEXT", nullable = false)
    private String image;
    @Column(name = "start_date", columnDefinition = "VARCHAR(25)", nullable = false)
    private String startDate;
    @Column(name = "end_date", columnDefinition = "VARCHAR(25)", nullable = false)
    private String endDate;
    @CreationTimestamp
    @Column(name = "create_time", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT now()")
    private LocalDateTime createTime;
    @UpdateTimestamp
    @Column(name = "update_time", nullable = false, columnDefinition = "TIMESTAMP DEFAULT now()")
    private LocalDateTime updateTime;

    @Column(name = "is_delete", columnDefinition = "BIT DEFAULT 0")
    private boolean isDelete;

    @ManyToOne
    @JoinColumn
    private ProductType productType;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customers customers;
    @ManyToOne
    @JoinColumn
    private ContractStatus contractStatus;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employees employees;
    @ManyToOne
    @JoinColumn
    private ContractType contractType;
private String redeemDate;

    public String getRedeemDate() {
        return redeemDate;
    }

    public void setRedeemDate(String redeemDate) {
        this.redeemDate = redeemDate;
    }

    public Contracts() {
        // TODO document why this constructor is empty
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

    public Customers getCustomers() {
        return customers;
    }

    public void setCustomers(Customers customers) {
        this.customers = customers;
    }

    public ContractStatus getContractStatus() {
        return contractStatus;
    }

    public void setContractStatus(ContractStatus contractStatus) {
        this.contractStatus = contractStatus;
    }

    public Employees getEmployees() {
        return employees;
    }

    public void setEmployees(Employees employees) {
        this.employees = employees;
    }

    public ContractType getContractType() {
        return contractType;
    }

    public void setContractType(ContractType contractType) {
        this.contractType = contractType;
    }
}
