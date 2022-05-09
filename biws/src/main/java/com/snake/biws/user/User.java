package com.snake.biws.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.snake.biws.validation.Required;
import com.snake.biws.validation.UniqueUsername;

import lombok.Data;

@Data//Lombok devreye girdi. kullanmazsak getter/setter metotları kullanabilriz
@Entity
@Table(name = "u_user")
public class User {

	@Id
	@GeneratedValue
	private Long id;

	@NotNull(message = "{snake.validation.username.NotNull.message}")
	@Size(min = 4, max = 20)
	@UniqueUsername
	private String username;
	
	@NotNull
	@Size(min = 6, max = 255)
	//At least one lowercase letter, uppercase letter and digit
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$", message = "{snake.validation.password.pattern.message}")
	private String password;
	
	@NotNull
	@Size(min = 6, max = 255)
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$")
	private String passwordRepeat;
	
	@Required
	@Size(min = 4, max = 50)
	private String firstname;
	
	@Size(min = 4, max = 50)
	@NotNull
	private String lastname;

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", passwordRepeat=" + passwordRepeat + "]";
	}

	
}
