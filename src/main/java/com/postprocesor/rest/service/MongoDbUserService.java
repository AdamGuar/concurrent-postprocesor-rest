package com.postprocesor.rest.service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.postprocesor.rest.model.Authentication;
import com.postprocesor.rest.model.User;
import com.postprocesor.rest.repo.UserRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Component
public class MongoDbUserService implements UserService{
	
	UserRepository repo;
	
	@Autowired
	public MongoDbUserService(UserRepository repo) {
		this.repo = repo;
	}

	@Override
	public Mono<Authentication> authenticateUser(User user) {
		Mono<User> fromRepo = repo.findById(user.getUsername());
		return fromRepo.flatMap(e->{
			boolean isPasswordMatching = BCrypt.checkpw(user.getPassword(), e.getPassword());
			User u = e;
			u.setPassword("###");
			return Mono.just(new Authentication(u, isPasswordMatching));
		});
	}

	@Override
	public Mono<User> saveUser(User user) {
		user.setPassword(hashPass(user.getPassword()));
		return repo.save(user);
	}
	
	
	private String hashPass(String pass) {
		return BCrypt.hashpw(pass, BCrypt.gensalt());
	}

	@Override
	public Flux<User> getAllUsers() {
		return repo.findAll()
				.map(e->{
					e.setPassword("###");
					return e;
				});
	}
	

}
