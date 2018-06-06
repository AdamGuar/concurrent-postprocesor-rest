package com.postprocesor.rest.repo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.postprocesor.rest.model.Subscription;

public interface SubscriptionRepository extends ReactiveMongoRepository<Subscription, String>{

}
