package com.snake.biws.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data//Lombok devreye girdi. kullanmazsak getter/setter metotları kullanabilriz
@Entity
@Table(name = "u_user")
public class User {

	@Id
	@GeneratedValue
	private Long id;

	@NotNull
	private String username;
	
	@NotNull
	private String password;
	
	@NotNull
	private String passwordRepeat;
	
	@NotNull
	private String firstname;
	
	@NotNull
	private String lastname;

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", passwordRepeat=" + passwordRepeat + "]";
	}

	
}
