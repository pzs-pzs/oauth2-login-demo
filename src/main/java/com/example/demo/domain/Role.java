package com.example.demo.domain;

import javax.persistence.*;

@Entity
@Table(name = "t_roles")
public class Role {
    @GeneratedValue
    @Id
    private Long id;

    @Column(name = "name",unique = true)
    private String name;

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

    public Role(String name) {
        this.name = name;
    }

    public Role(){

    }
}
