package br.com.thiagosousa.account.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.thiagosousa.account.models.User;
import br.com.thiagosousa.account.services.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/member")
	public ResponseEntity<Iterable<User>> getAll() {
	    Iterable<User> all = userService.findAll();
		return ResponseEntity.ok(all);
	}
	 
	@PostMapping("/member")
	public ResponseEntity<User> register(@RequestBody User input) {
	    User result = userService.registerUser(input);
	    return ResponseEntity.ok(result);
	}
}
