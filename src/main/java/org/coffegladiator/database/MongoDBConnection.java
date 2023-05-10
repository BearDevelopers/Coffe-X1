package org.coffegladiator.database;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

public class MongoDBConnection {
    private static final String CONNECTION_STRING = "mongodb://localhost:27017";
    public static final String DATABASE_NAME = "x1_plugin";

    private MongoClient mongoClient;
    private static MongoDatabase database;

    public MongoDBConnection() {
        connect();
    }

    public void connect() {
        MongoClientURI uri = new MongoClientURI(CONNECTION_STRING);
        mongoClient = new MongoClient(uri);
        database = mongoClient.getDatabase(DATABASE_NAME);
    }

    public static MongoDatabase getDatabase() {
        return database;
    }

    public void close() {
        if (mongoClient != null) {
            mongoClient.close();
        }
    }
}
