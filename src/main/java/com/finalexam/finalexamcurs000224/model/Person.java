package com.finalexam.finalexamcurs000224.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "TB_PERSON")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Positive(message = "La edad debe ser positiva")
    @Column(name = "age")
    private Integer age;

    @Email(message = "Debe ser una dirección de correo electrónico válida")
    @Column(name = "email", unique = true, length = 100)
    private String email;
}
