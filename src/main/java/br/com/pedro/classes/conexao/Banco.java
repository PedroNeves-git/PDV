package br.com.pedro.classes.conexao;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class Banco {
    private static MongoDatabase database;

    public static MongoDatabase getDatabase() {
        if (database == null) {
            //cria conexao com o mongoDB
            MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
            database = mongoClient.getDatabase("pdv");

        }
        return database;
    }
}
