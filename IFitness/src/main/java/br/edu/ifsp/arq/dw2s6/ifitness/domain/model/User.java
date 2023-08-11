package br.edu.ifsp.arq.dw2s6.ifitness.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long 	id;
	@NotNull
	@Size(min = 3, max = 50)
	private String name;
	@NotNull
	@Email
	private String email;
	@NotNull
	@Size(min = 6, max = 8)
	private String password;
	@Min(value = 12)
	private int age;
	@Enumerated(EnumType.STRING)
	@NotNull
	private Gender gender;

}