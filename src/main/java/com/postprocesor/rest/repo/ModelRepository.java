package com.postprocesor.rest.repo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.postprocesor.rest.model.Model;

@Repository
public interface ModelRepository extends ReactiveMongoRepository<Model, String>{

}
