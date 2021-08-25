package com.vocalink.demo.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDTO {

	@NotNull
    private int empId;

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
}
