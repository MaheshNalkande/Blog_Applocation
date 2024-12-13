package com.blog.app.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter@Setter
public class UserDto {

	private int id;
	
	@NotEmpty
	@Size(min=4,message = "Username must be greater than 4 characters")
	private String name;
	@Email(message = "Enter a valid mail")
	private String email;
	@NotNull
	@Size(min = 4, max =10, message ="Please make sure  your password have 4-10 charaters." )
	private String password;
	@NotNull
	private String about;
}
