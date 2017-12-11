package com.amoebiq.ssa.masterresponse;

import java.util.List;
import java.util.Set;

import com.couchbase.client.deps.com.fasterxml.jackson.annotation.JsonProperty;

public class SuperClassResponse<T> {
	
	private Metrics metrics;
	
	private List<T> object;
	private String name;
	
	public SuperClassResponse(Metrics metrics,List<T> object){
		this.metrics = metrics;
		this.object = object;
		
	}
	
	public Metrics getMetrics() {
		return metrics;
	}
	public void setMetrics(Metrics metrics) {
		this.metrics = metrics;
	}
	
	@JsonProperty("schoolSS")
	public List<T> getObject() {
		return object;
	}
	public void setObject(List<T> object) {
		this.object = object;
	}
	
	

}
