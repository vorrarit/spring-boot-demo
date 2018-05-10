package com.example.test.springbootdemo;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@RequestMapping(method=RequestMethod.GET, path="/hello-world")
	public HelloWorldBean helloWorld() {
		return new HelloWorldBean("Hello World");
	}

	@RequestMapping(method = RequestMethod.GET, path = "/hello-world/{name}")
	public HelloWorldBean helloWorld(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello, %s", name));
	}
}