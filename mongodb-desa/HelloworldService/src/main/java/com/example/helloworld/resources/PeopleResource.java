package com.example.helloworld.resources;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.codahale.metrics.annotation.Timed;
import com.example.helloworld.client.MongoHelper;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

/**
 * 
 * @author csanchezpe
 *
 */
@Path("/people")
@Produces(MediaType.APPLICATION_JSON)
public class PeopleResource {
	
	private MongoHelper helper = new MongoHelper();
	
	public PeopleResource(MongoHelper helper) {
		this.helper = helper;
	}

	@GET
	@Timed
	@Path("")
	public Response obtainAll() {
		DBCursor people =  helper.getCollection("people").find();
		List<DBObject> result = new ArrayList<>();
		for (DBObject bean : people) {
			result.add(bean);
		}
		people.close();
		return Response.status(Response.Status.OK).entity(result).build();
	}

	@GET
	@Timed
	@Path("/gender/{gender}")
	public Response obtainAllByGender(@PathParam("gender") String gender) {
		
		BasicDBObject filtro = new BasicDBObject();
		filtro.append("gender", gender);
		DBCursor people =  helper.getCollection("people").find(filtro);
		List<DBObject> result = new ArrayList<>();
		for (DBObject bean : people) {
			result.add(bean);
		}
		people.close();
		return Response.status(Response.Status.OK).entity(result).build();
	}
	
	@GET
	@Timed
	@Path("/name/{name}")
	public Response obtainAllByName(@PathParam("name") String name) {
		
		BasicDBObject filtro = new BasicDBObject();
		filtro.append("name", name);
		DBCursor people =  helper.getCollection("people").find(filtro);
		List<DBObject> result = new ArrayList<>();
		for (DBObject bean : people) {
			result.add(bean);
		}
		people.close();
		return Response.status(Response.Status.OK).entity(result).build();
	}
	
	@GET
	@Timed
	@Path("/age/{age}")
	public Response obtainAllByAge(@PathParam("age") Long age) {
		
		BasicDBObject filtro = new BasicDBObject();
		filtro.append("age", age);
		DBCursor people =  helper.getCollection("people").find(filtro);
		List<DBObject> result = new ArrayList<>();
		for (DBObject bean : people) {
			result.add(bean);
		}
		people.close();
		return Response.status(Response.Status.OK).entity(result).build();
	}
}
