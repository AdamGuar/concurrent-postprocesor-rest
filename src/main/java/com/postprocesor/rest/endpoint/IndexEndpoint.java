package com.postprocesor.rest.endpoint;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexEndpoint {


	@RequestMapping("/")
	public String index() {
		return "Test!";
	}
	
}
