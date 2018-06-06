package com.postprocesor.rest.endpoint;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@PostMapping("/saveplain/{name}")
	public Mono<Void> saveModel(@PathVariable String name, @RequestBody String body) throws IOException {
		System.out.println(body);
		Model model = new Model(name, new ByteArrayInputStream(body.getBytes()));
		return service.saveModel(model);

	}
	
	
	@PostMapping("/save")
	public Mono<Void> saveModel(MultipartFile file, @RequestParam Map<String,String> params) throws IOException {
		Model model = new Model(params.get("name"), new ByteArrayInputStream(file.getBytes()));
		return service.saveModel(model);

	}

	@GetMapping("/getids")
	public Flux<String> getModelsIDs() {
		return service.getAllModelIds();
	}

	@GetMapping("/getbyid/{modelname}")
	public Mono<Model> getModelByID(@PathVariable String modelname) {
		return service.getModelById(modelname);
	}


}
