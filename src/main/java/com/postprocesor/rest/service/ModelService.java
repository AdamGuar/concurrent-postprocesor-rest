package com.postprocesor.rest.service;

import com.postprocesor.rest.model.Model;
import com.postprocesor.rest.model.ModelID;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ModelService {
	
	public Mono<Void> saveModel(Model model);
	
	public Flux<ModelID> getAllModelIds();
	
	public Mono<Model> getModelById(String modelName);

}
