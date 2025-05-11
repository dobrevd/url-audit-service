package com.dobrev.urlauditservice.url_audit_service.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.dobrev.urlauditservice.url_audit_service.repository")
public class MongoConfig extends AbstractMongoClientConfiguration {
    @Override
    protected String getDatabaseName() {
        return "auditdatabase";
    }

    @Override
    public MongoClient mongoClient() {
        return MongoClients.create("mongodb://audit-mongodb:27017");
    }
}
