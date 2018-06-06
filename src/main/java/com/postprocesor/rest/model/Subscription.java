package com.postprocesor.rest.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "subs")
public class Subscription {
	
	@Id
	String modelID;
	List<String> sbuscribents;
	
	public String getModelID() {
		return modelID;
	}
	public void setModelID(String modelID) {
		this.modelID = modelID;
	}
	public List<String> getSbuscribents() {
		return sbuscribents;
	}
	public void setSbuscribents(List<String> sbuscribents) {
		this.sbuscribents = sbuscribents;
	}
	
	public Subscription(String modelID, List<String> sbuscribents) {
		this.modelID = modelID;
		this.sbuscribents = sbuscribents;
	}
	
	public Subscription() {
	}

}
