package com.designtech.client.domain.model;


import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "client")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
public class Client {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(max = 30)
    private String name;

    @NotNull
    @Size(max = 30)
    private String surname;

    @NotNull
    @Size(max = 50)
    private String email;

    @NotNull
    @Size(max = 30)
    private String password;

    @NotNull
    private Long DNI;

    @DateTimeFormat
    private LocalDate date_Birthday;
    
    @NotNull
    private String civil_Status;

}
