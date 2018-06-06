package com.postprocesor.rest.service;

import com.postprocesor.rest.model.SubRequest;
import com.postprocesor.rest.model.Subscription;

import reactor.core.publisher.Mono;

public interface SubscriptionService {
	public Mono<Subscription> subscribe(SubRequest req);
	public Mono<Subscription> unsubscribe(SubRequest req);
	public Mono<Subscription> getByID(String id);
}
