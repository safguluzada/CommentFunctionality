package com.ada.config;

import com.mongodb.MongoClient;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MongoConfig {

    public MongoClient mongoClient() {
        return new MongoClient("127.0.0.1", 27017);
    }

    protected String getDatabaseName() {
        return "comments";
    }

}
