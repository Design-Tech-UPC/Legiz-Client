package com.designtech.client.resource;

import java.time.LocalDate;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientResource {

	private String name;

	private String surname;

	private String email;

	private String password;

	private Long DNI;

	private LocalDate date_Birthday;

	private String civil_Status;

}