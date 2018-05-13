package com.postprocesor.rest.repo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.postprocesor.rest.model.User;

@Repository
public interface UserRepository extends ReactiveMongoRepository<User, String>{
	
}
