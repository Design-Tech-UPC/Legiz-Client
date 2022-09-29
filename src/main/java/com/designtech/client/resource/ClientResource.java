package com.designtech.client.resource;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ClientResource {

	private String name;

	private String surname;

	private String email;

	private String password;

	private Long DNI;

	private LocalDate date_Birthday;

	private String civil_Status;

}