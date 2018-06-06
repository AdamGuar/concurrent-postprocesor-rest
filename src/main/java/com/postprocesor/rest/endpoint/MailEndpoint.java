package com.postprocesor.rest.endpoint;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.postprocesor.rest.model.MailMessage;
import com.postprocesor.rest.service.MailService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/mail")
public class MailEndpoint {

	@Autowired
	MailService service;
		
	@PostMapping("/send")
	public Mono<Boolean> saveModel(@RequestBody MailMessage msg){
		boolean result = service.sendSimpleMessage(msg.getTo(),msg.getFrom(), msg.getSubject(), msg.getMessage());
		return Mono.just(result);
	}
	
	@GetMapping("/sample")
	public Mono<MailMessage> getSample(){
		MailMessage msg = new MailMessage();
		List<String> to = Arrays.asList("asd@g.com","bb@aa.com");
		msg.setTo(to);
		msg.setFrom("from@g.com");
		msg.setSubject("Hej");
		msg.setMessage("ddddddddddddddddddddddddddddddddddddddd");
		return Mono.just(msg);
	}



}
