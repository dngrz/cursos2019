package com.example.helloworld.client;

import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class MongoHelper {

	private MongoClient client;

	private String HOST_NAME = "localhost";

	private Integer PORT_NUMBER = 27017;

	private DB database = null;

	private DBCollection collection = null;

	public MongoHelper() {
		super();
		try {
			client = new MongoClient(HOST_NAME, PORT_NUMBER);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

	public void Initialize(String databaseName) {
		this.setDatabase(client.getDB(databaseName));
	}

	public void dropDatabase(String dbName) {
		client.dropDatabase(dbName);
	}

	public void dropCollection(String collectionName) {
		this.getDatabase().getCollection(collectionName).drop();
	}

	public MongoClient getClient() {
		return client;
	}

	public void setClient(MongoClient client) {
		this.client = client;
	}

	public DB getDatabase() {
		return database;
	}

	public void setDatabase(DB database) {
		this.database = database;
	}

	public DBCollection getCollection() {
		return collection;
	}

	public void setCollection(DBCollection collection) {
		this.collection = collection;
	}

	public DBCollection getCollection(String collectionName) {
		return this.getDatabase().getCollection(collectionName);
	}

}
