package com.postprocesor.rest.endpoint;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.postprocesor.rest.model.SubRequest;
import com.postprocesor.rest.model.Subscription;
import com.postprocesor.rest.service.SubscriptionService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/sub")
public class SubscriptionEndpoint {
	
	@Autowired
	SubscriptionService service;
	
	@PostMapping("/subscribe")
	public Mono<Subscription> subs(@RequestBody SubRequest req){
		return service.subscribe(req);
	}
	
	@PostMapping("/unsubscribe")
	public Mono<Subscription> unsubs(@RequestBody SubRequest req){
		return service.unsubscribe(req);
	}
	
	@GetMapping("/get/{id}")
	public Mono<Subscription> getSubByID(@PathVariable String id){
		return service.getByID(id);
	}
	
	@GetMapping("/sample")
	public Mono<SubRequest> sample(){
		SubRequest req = new SubRequest("modelID", "aa@g.com");
		return Mono.just(req);
	}
	
}
