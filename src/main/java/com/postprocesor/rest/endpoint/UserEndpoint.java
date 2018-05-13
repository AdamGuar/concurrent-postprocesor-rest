package com.postprocesor.rest.endpoint;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.postprocesor.rest.model.Authentication;
import com.postprocesor.rest.model.GeneralStatus;
import com.postprocesor.rest.model.User;
import com.postprocesor.rest.service.UserService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/user")
public class UserEndpoint {
	
	UserService service;
	
	@Autowired
	public UserEndpoint(UserService service) {
		this.service = service;
	}
	
	@PostMapping("/auth")
	public Mono<Authentication> authenticateUser(@Valid @RequestBody User user){
		return service.authenticateUser(user);
	}
	
	@PostMapping("/save")
	public Mono<GeneralStatus> save(@Valid @RequestBody User user){
		return service.saveUser(user).flatMap(e ->{
			return Mono.just(new GeneralStatus(200, String.format("User %s created", e.getUsername()), ""));
		});
	}
	
	@GetMapping("/list")
	public Flux<User> getAll(){
		return service.getAllUsers();
	}
	
}
