package org.cbioportal.controller;

import org.cbioportal.service.api.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/helloworld")
public class HelloWorld {
	
	@Autowired
	TestService ts;
	
	@GetMapping
	public String helloWorld() {
		String jeremy = ts.getName();
		jeremy += " ignore me";
		return "Hello World " + jeremy + " is awesome, and you should always listen to him!";
	}

}
