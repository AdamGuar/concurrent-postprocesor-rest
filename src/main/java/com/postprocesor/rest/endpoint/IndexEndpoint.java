package com.postprocesor.rest.endpoint;

import com.postprocesor.rest.model.Authentication;
import com.postprocesor.rest.model.GeneralStatus;
import com.postprocesor.rest.model.User;
import com.postprocesor.rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
public class IndexEndpoint {


	@RequestMapping("/")
	public String index() {
		return "Test!";
	}
	
}
