package com.example.helloworld;

import com.example.helloworld.client.MongoHelper;
import com.example.helloworld.health.TemplateHealthCheck;
import com.example.helloworld.resources.HelloWorldResource;
import com.example.helloworld.resources.PeopleResource;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class HelloworldServiceApplication extends Application<HelloworldServiceConfiguration> {

	public static void main(final String[] args) throws Exception {
		new HelloworldServiceApplication().run(args);
	}

	@Override
	public String getName() {
		return "HelloworldService";
	}

	@Override
	public void initialize(final Bootstrap<HelloworldServiceConfiguration> bootstrap) {
		// TODO: application initialization
	}

	@Override
	public void run(HelloworldServiceConfiguration configuration, Environment environment) {
		final HelloWorldResource resource = new HelloWorldResource(configuration.getTemplate(), configuration.getDefaultName());
		final TemplateHealthCheck healthCheck = new TemplateHealthCheck(configuration.getTemplate());
		environment.healthChecks().register("template", healthCheck);
		
		//CONEXION BD-INI
	    String database = "devmongodb";
		MongoHelper helper = new MongoHelper();
		helper.Initialize(database);
		//CONEXION BD-FIN		
		final PeopleResource peopleResource = new PeopleResource(helper);
		environment.jersey().register(resource);
		environment.jersey().register(peopleResource);
	}

}
