package com.example.back_end.model;

import javax.persistence.*;

@Entity
@Table(name = "contract_type")
public class ContractType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,unique = true)
    private String name;

    public ContractType(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public ContractType(Long id) {
        this.id = id;
    }

    public ContractType() {
    }

    public Long getId() {
        return id;
    }

    public long setId(Long id) {
        this.id = id;
        return 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}