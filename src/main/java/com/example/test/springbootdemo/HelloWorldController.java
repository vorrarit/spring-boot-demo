package com.example.test.springbootdemo;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@Autowired
	private ResourceBundleMessageSource messageSource;

	@RequestMapping(method=RequestMethod.GET, path="/hello-world")
	public HelloWorldBean helloWorld() {
		return new HelloWorldBean("Hello World");
	}

	@RequestMapping(method = RequestMethod.GET, path = "/hello-world/{name}")
	public HelloWorldBean helloWorld(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello, %s", name));
	}

	@RequestMapping(method = RequestMethod.GET, path = "/hello-world-i18n")
	public String helloWorldI18N() {
		return messageSource.getMessage("greeting.message", null, LocaleContextHolder.getLocale());
	}
}