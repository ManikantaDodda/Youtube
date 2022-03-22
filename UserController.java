package org.codejudge.sb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("/friends/{username}")
	public Userr fetchUser(@PathVariable("username") String username) {
		return userService.fetchUser(username);
	}

	@PostMapping("/create")
	public Userr createUser(@RequestBody Userr user) {
		return userService.createUser(user);
	}

	@PostMapping("/add/{u1}/{u2}")
	public StatusResponse followUser(@PathVariable("u1") String followedBy, @PathVariable("u2") String following) {
		return userService.followUser(followedBy, following);
	}

	
	
	
}
