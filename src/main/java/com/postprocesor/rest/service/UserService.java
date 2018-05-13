package com.postprocesor.rest.service;

import com.postprocesor.rest.model.Authentication;
import com.postprocesor.rest.model.User;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {
	
	public Mono<Authentication> authenticateUser(User user);
	
	public Mono<User> saveUser(User user);
	
	public Flux<User> getAllUsers();
}
