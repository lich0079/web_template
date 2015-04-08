package com.lich0079.controller;

import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.lich0079.entity.User;
import com.lich0079.entity.UserCodec;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;


@Configuration
public class AppConfig {

	@Bean
    public MongoClient  getMongoClient() {
		UserCodec codec = new UserCodec(MongoClient.getDefaultCodecRegistry().get(Document.class));
		CodecRegistry codecRegistry =  CodecRegistries.fromRegistries(CodecRegistries.fromCodecs(codec,MongoClient.getDefaultCodecRegistry().get(String.class)));
		MongoClientOptions options = MongoClientOptions.builder().codecRegistry(codecRegistry).build();
		MongoClient client = new MongoClient(new ServerAddress(), options);  
        return  client;
    }
	
	
	@Bean
	@Autowired
    public MongoCollection<User> getUserCollection(MongoClient mongoClient) {
		MongoCollection<User>	collection = mongoClient.getDatabase("user").getCollection("cp_user",User.class);
        return  collection;
    }
}
