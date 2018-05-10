package com.example.test.springbootdemo;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.dom4j.util.UserDataAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
	public Resource<User> findOne(@PathVariable int id) {
		User user = usersDao.findOne(id);
		if (user==null) {
			throw new UserNotFoundException("id-" + id);
		}

		Resource<User> resource = new Resource<User>(user);
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).findAll());
		resource.add(linkTo.withRel("all-users"));

		return resource;
	}

	@PostMapping(path="/users")
	public ResponseEntity save(@Valid @RequestBody User user) {
		User savedUser = usersDao.save(user);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedUser.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	@DeleteMapping(path="/users/{id}")
	public User delete(@PathVariable int id) {
		User deletedUser = usersDao.delete(id);

		if (deletedUser == null) {
			throw new UserNotFoundException("id-" + id);
		}

		return deletedUser;
	}
}