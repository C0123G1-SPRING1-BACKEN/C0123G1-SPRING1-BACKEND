package com.example.back_end.model;

import javax.persistence.*;

@Entity
@Table(name = "contract_status")
public class ContractStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false,unique = true)

    private String name;

    public ContractStatus() {
    }

    public ContractStatus(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public ContractStatus(ContractStatus contractStatus) {
    }

    public ContractStatus(Long contractStatusId) {
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
}