package com.postprocesor.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.postprocesor.rest.model.Model;
import com.postprocesor.rest.repo.ModelRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class MongoDbModelService implements ModelService{
	
	ModelRepository repo;
	
	@Autowired
	public MongoDbModelService(ModelRepository repo) {
		this.repo = repo;
	}
	
	@Override
	public Mono<Void> saveModel(Model model) {
		return repo.save(model).then();
	}

	@Override
	public Flux<String> getAllModelIds() {
		return repo.findAll().map(e->{
			return e.getModelName();
		});
	}

	@Override
	public Mono<Model> getModelById(String modelName) {
		return repo.findById(modelName);
	}

}
