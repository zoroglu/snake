package com.snake.biws.user;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.snake.biws.dto.ResponseDTO;
import com.snake.biws.exceptions.RequestException;
import com.snake.biws.user.service.UserService;


@RestController
public class UserController {

	private static final Logger Log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	UserService userService;

	//@CrossOrigin Farklı porttan erişmeye çalıştığımızda sorun yaşamamak adına düzelttik
	@PostMapping("/ws/saveUser") // dinleidğimiz url i veriyoruz api ve versyiyonu istersek yazmayabiliriz tamamen öneri
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseDTO createUser(@Valid @RequestBody User user) {
		userService.save(user);
		return new ResponseDTO("User created");
	}
	
	//Spring validation yapılmasını sağladık
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public RequestException handleValidationException(MethodArgumentNotValidException e) {
		RequestException requestException = new RequestException(400, "/ws/saveUser", "Validation Error");
		Map<String, String> validation = new HashMap<>();
		for (FieldError fe : e.getBindingResult().getFieldErrors())
			validation.put(fe.getField(), fe.getDefaultMessage());
		requestException.setValidationErrors(validation);
		return requestException;
	}
}
