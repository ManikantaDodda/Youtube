package org.codejudge.sb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("api/")
public class PostController {

	@Autowired
	PostService postService;

	@PostMapping("/create/{username}")
	public Post createPost(@RequestBody Post post, @PathVariable("username") String username) {
		return postService.createPost(post, username);
	}

	@GetMapping("/friends/{username}")
	public List<Post> getAllPosts(@PathVariable("username") String username) {
		return postService.getAllPosts(username);
	}

	
	
	}

}
