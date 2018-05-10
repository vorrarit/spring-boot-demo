package com.example.test.springbootdemo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UsersDao {
	private static List<User> users = new ArrayList<User>();
	private static int usersCount = 2;

	static {
		users.add(new User(1, "Tom", "password", new Date()));
		users.add(new User(2, "Ben", "password", new Date()));
	}

	public List<User> findAll() {
		return users;
	}

	public User findOne(Integer id) {
		for (User user : users) {
			if (user.getId() == id) {
				return user;
			}
		}

		return null;
	}

	public User delete(Integer id) {
		for (User user : users) {
			if (user.getId() == id) {
				users.remove(user);
				return user;
			}
		}

		return null;
	}

	public User save(User user) {
		if (user.getId() == null) {
			user.setId(++usersCount);
		}
		users.add(user);
		return user;
	}




}