package com.postprocesor.rest.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.postprocesor.rest.model.SubRequest;
import com.postprocesor.rest.model.Subscription;
import com.postprocesor.rest.repo.SubscriptionRepository;

import reactor.core.publisher.Mono;

@Component
public class MongoDBSubscriptionService implements SubscriptionService{
	
	@Autowired
	SubscriptionRepository repo;
	
	@Override
	public Mono<Subscription> subscribe(final SubRequest req) {
		return repo.findById(req.getModelID()).doAfterSuccessOrError((e,t)->{
			Subscription sub;
			if(e!=null) {
				sub = e;
				List<String> subs = sub.getSbuscribents();
				if(!subs.contains(req.getSubscribent()))
					subs.add(req.getSubscribent());
				sub.setSbuscribents(subs);
			}else {
				sub = new Subscription(req.getModelID(), Arrays.asList(req.getSubscribent()));
			}
			
			repo.save(sub).subscribe();
		});

	}

	@Override
	public Mono<Subscription> unsubscribe(SubRequest req) {
		return repo.findById(req.getModelID()).doAfterSuccessOrError((e,t)->{
			Subscription sub;
			if(e!=null) {
				sub = e;
				List<String> subs = sub.getSbuscribents();
				subs.remove(req.getSubscribent());
				sub.setSbuscribents(subs);
			}else {
				sub = new Subscription(req.getModelID(), new ArrayList<String>());
			}
			repo.save(sub).subscribe();
		});
	}

	@Override
	public Mono<Subscription> getByID(String id) {
		return repo.findById(id);
	}

}
