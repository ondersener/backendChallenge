package com.works.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.*;


@Entity
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eid;

    @Size(min = 2, max = 150)
    @NotEmpty
    @NotNull
    private String name;

    @Size(min = 2, max = 150)
    @NotEmpty
    @NotNull
    private String surname;

    @Max(120)
    @Column(nullable = false)
    @Min(18)
    private int age;

    @Size(min = 5, max = 150)
    @NotEmpty
    @NotNull
    @Column(unique = true)
    private String email;

    @Size(min = 5, max = 150)
    @NotEmpty
    @NotNull
    private String password;

    @ManyToOne
    Company company;
}
