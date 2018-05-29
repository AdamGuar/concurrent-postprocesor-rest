package com.postprocesor.rest.endpoint;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.postprocesor.rest.model.Model;
import com.postprocesor.rest.service.ModelService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/model")
public class ModelEndpoint {
	
	ModelService service;
	
	@Autowired
	public ModelEndpoint(ModelService service) {
		this.service = service;
	}
	
	@PostMapping("/save")
	public Mono<Void> saveModel(MultipartFile file, Map<String,String> formInputs) throws IOException{	
		Model model = new Model(formInputs.get("name"), new ByteArrayInputStream(file.getBytes()));
		return service.saveModel(model);
		
	}
	
	@GetMapping("/getids")
	public Flux<String> getModelsIDs() {
		return service.getAllModelIds();
	}
	
	@GetMapping("/getids/{modelname}")
	public Mono<Model> getModelByID(@PathVariable String modelname) {
		return service.getModelById(modelname);
	}
	

}
