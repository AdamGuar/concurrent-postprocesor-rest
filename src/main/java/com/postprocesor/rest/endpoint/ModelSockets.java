package com.postprocesor.rest.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.util.HtmlUtils;

import com.postprocesor.rest.model.Model;
import com.postprocesor.rest.service.ModelService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
public class ModelSockets {

    ModelService service;

    @Autowired
    public ModelSockets(ModelService service) {
        this.service = service;
    }

    @MessageMapping("/model")
    @SendTo("/model")
    public Mono<Model> sendModel(@PathVariable String modelname) throws Exception {

        return service.getModelById(modelname);
    }


}
