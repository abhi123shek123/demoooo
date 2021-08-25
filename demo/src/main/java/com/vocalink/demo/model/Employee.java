package com.vocalink.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Employee {

	@ApiModelProperty(notes = "Id of employee")
	@Id
	private int empId;

	@ApiModelProperty(notes = "name of employee")
	@NotNull(message = "Employee name cannot be null")
	@NotBlank
	private String empName;
	
	@NotNull(message = "Employee email cannot be null")
	@Email(message = "Not a valid email")
	private String email;
	
	@NotNull
	@Size(min = 8, max = 12, message = "Password must be greater than 4 and less than 12 character")
	private String password;
	
	@NotNull
	private double salary;

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", email=" + email + ", password=" + password
				+ ", salary=" + salary + "]";
	}

	
}
