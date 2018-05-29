package com.postprocesor.rest.service;

import com.postprocesor.rest.model.Model;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ModelService {
	
	public Mono<Void> saveModel(Model model);
	
	public Flux<String> getAllModelIds();
	
	public Mono<Model> getModelById(String modelName);

}
