package com.example.test.springbootdemo;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UsersController {

	@Autowired
	private UsersDao usersDao;

	@GetMapping(path="/users")
	public List<User> findAll() {
		return usersDao.findAll();
	}

	@GetMapping(path="/users/{id}")
	public User findOne(@PathVariable int id) {
		User user = usersDao.findOne(id);
		if (user==null) {
			throw new UserNotFoundException("id-" + id);
		}
		return user;
	}

	@PostMapping(path="/users")
	public ResponseEntity save(@RequestBody User user) {
		User savedUser = usersDao.save(user);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedUser.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
}