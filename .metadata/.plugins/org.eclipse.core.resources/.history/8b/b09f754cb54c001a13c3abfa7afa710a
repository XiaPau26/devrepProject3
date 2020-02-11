package model.security;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import model.User;

@SpringBootApplication
@RestController
@CrossOrigin(origins="*")
public class UserServiceApplication {
	@GetMapping("/")
	public ResponseEntity<User> login() {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		// System.out.println(user.getUsername() + " " + user.getPassword() + " " + user.getAuthority());
		return new ResponseEntity<>(user, HttpStatus.OK);		
	}
}
