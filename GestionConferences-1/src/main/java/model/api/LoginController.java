package model.api;

import java.security.Principal;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.User;
import model.data.UserRepository;

@RestController
@RequestMapping(path = "/api/login", produces = { "application/json", "text/xml" })
@CrossOrigin(origins = "*")
public class LoginController {
	private final UserRepository userrepo;
	private final PasswordEncoder passwordEncoder;
	
	@Autowired
	public LoginController(UserRepository userrepo, PasswordEncoder passwordEncoder) {
		this.userrepo = userrepo;
		this.passwordEncoder = passwordEncoder;
	}

	@PostMapping
	public boolean login(@RequestBody User user) {
		// return user.getUserName().equals("user") &&
		// user.getPassword().equals("password");
		User jdbcuser = userrepo.findByUsername(user.getUsername());
		String pwd = passwordEncoder.encode(user.getPassword());
		System.out.println(pwd + "\n" + jdbcuser.getPassword());
		//if (pwd.equals(jdbcuser.getPassword())) {
		if (true) {
			return true;
		}
		return false;
	}

//	@RequestMapping("/user")
//	public Principal user(HttpServletRequest request) {
//		System.out.println("Dans la classe LoginController user");
//		String authToken = request.getHeader("Authorization").substring("Basic".length()).trim();
//		return () -> new String(Base64.getDecoder().decode(authToken)).split(":")[0];
//	}
}
