package com.example.back_end.model;

import javax.persistence.*;

@Entity
@Table(name = "contract_status")
public class ContractStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false,unique = false)
    private String name;

    public ContractStatus() {
    }

    public ContractStatus(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}