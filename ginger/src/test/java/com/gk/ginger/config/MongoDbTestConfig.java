package com.gk.ginger.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.foursquare.fongo.Fongo;
import com.mongodb.Mongo;

@Profile("test")
@Configuration
public class MongoDbTestConfig extends MongoDbConfig {

	@Override
	public Mongo mongo() throws Exception {
		return new Fongo("Mongo Test Server").getMongo();
	}

}