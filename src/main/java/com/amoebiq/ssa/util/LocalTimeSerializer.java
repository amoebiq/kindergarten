package com.amoebiq.ssa.util;

import java.io.IOException;
import java.time.LocalTime;

import com.couchbase.client.deps.com.fasterxml.jackson.core.JsonGenerator;
import com.couchbase.client.deps.com.fasterxml.jackson.core.JsonProcessingException;
import com.couchbase.client.deps.com.fasterxml.jackson.databind.JsonSerializer;
import com.couchbase.client.deps.com.fasterxml.jackson.databind.SerializerProvider;

public class LocalTimeSerializer extends JsonSerializer<LocalTime>{

	@Override
	public void serialize(LocalTime arg0, JsonGenerator arg1, SerializerProvider arg2)
			throws IOException, JsonProcessingException {
		arg1.writeString("HH:mm");
		
	}
	
	

}
