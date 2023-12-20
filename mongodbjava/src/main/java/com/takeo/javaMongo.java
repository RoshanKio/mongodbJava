package com.takeo;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class javaMongo {
	public static void main(String ...my) {
		
		//Creating a Mongo client
		MongoClient mongoClient = new MongoClient("localhost", 27017);//27017 is the default port
		System.out.println("mongoClient = "+mongoClient+"\nCreated Mongo Connection successfully\n\n");
		
		MongoDatabase db = mongoClient.getDatabase("mongodbjava");
		System.out.println("db = "+db+"\nGet database is successful\n\n");
		
		//To get all database names
		MongoCursor<String> dbsCursor = mongoClient.listDatabaseNames().iterator();
		System.out.println("Below is the list of databases present in MongoDB:");
		while(dbsCursor.hasNext()) {
			System.out.println(dbsCursor.next());
		}
		
		//Inserting sample record by creating collection and document
		MongoCollection<Document> collection = db.getCollection("javaPrograms");
		Document doc = new Document("name", "helloworld");
		collection.insertOne(doc);
		System.out.println("\n############Insertion is completed  ############");
		MongoCursor<String> dbsCursord = mongoClient.listDatabaseNames().iterator();
		while(dbsCursord.hasNext()) {
			System.out.println(dbsCursord.next());
		}
		
		//Drop Database
		mongoClient.dropDatabase("youtube");
		
		
	}

}
