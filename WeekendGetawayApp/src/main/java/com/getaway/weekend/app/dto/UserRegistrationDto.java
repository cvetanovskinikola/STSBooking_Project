package com.getaway.weekend.app.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserRegistrationDto {

	@NotBlank
	@Size(min = 3, max = 20)
	private String firstName;
	@NotBlank
	@Size(min = 2, max = 30)
	private String lastName;
	@NotNull
	@Min(18)
	@Max(101)
	private Integer age;
	@NotNull
	@Min(value = 1000000000000000l)
	@Max(value = 9999999999999999l)
	private Long credit_card;
	@Email
	private String email;
	@Size(min = 7, max = 30)
	private String password;
	
	public UserRegistrationDto() {
		super();
	}
	public UserRegistrationDto(String firstName, String lastName, Integer age,Long credit_card, String email, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.credit_card=credit_card;
		this.email = email;
		this.password = password;
	}
	
	
	public Long getCredit_card() {
		return credit_card;
	}
	public void setCredit_card(Long credit_card) {
		this.credit_card = credit_card;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
