package org.coffegladiator.database;

import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bukkit.entity.Player;
import org.coffegladiator.database.MongoDBConnection;

public class MongoDBUtils {
    public static MongoCollection<Document> collection = MongoDBConnection.getDatabase().getCollection(MongoDBConnection.DATABASE_NAME);
    public static void savePlayer(Player p, int souls, int vitorias, int percas) {
        Document doc = new Document("uuid", p.getUniqueId())
                .append("name", p.getName())
                .append("strenght", 0)
                .append("speed", 0)
                .append("protection", 0)
                .append("souls", souls)
                .append("vitorias", vitorias)
                .append("percas", percas);
        collection.insertOne(doc);
    }
    public static void updatePlayer(Player p, int souls, int vitorias, int percas, int level,int level1,int level2) {
        Document filter = new Document("uuid", p.getUniqueId());
        Document updatedDocument = new Document("uuid", p.getUniqueId())
                .append("name", p.getName())
                .append("strenght", level)
                .append("speed", level1)
                .append("protection", level2)
                .append("souls", souls)
                .append("vitorias", vitorias)
                .append("percas", percas);
        collection.replaceOne(filter, updatedDocument);
    }

    public static Document getPlayer(Player p) {
        Document doc = new Document("uuid", p.getUniqueId());
        Document getDados = collection.find(doc).first();
        assert getDados != null;
        return getDados;
    }
    public static boolean existPlayer(Player p) {
        Document query = new Document("uuid", p.getUniqueId());
        Document getDados = collection.find(query).first();
        return getDados != null;
    }
    public static void setStrenght(Player p, int level) {
        Document ex_docs = new Document("uuid", p.getUniqueId());
        Document docs = new Document("uuid", p.getUniqueId())
                .append("name", p.getName())
                .append("strenght", level);
        collection.replaceOne(ex_docs,docs);
    }
    public static void setSpeed(Player p, int level) {
        Document ex_docs = new Document("uuid", p.getUniqueId());
        Document docs = new Document("uuid", p.getUniqueId())
                .append("name", p.getName())
                .append("speed", level);
        collection.replaceOne(ex_docs,docs);
    }
    public static void setProtection(Player p, int level) {
        Document ex_docs = new Document("uuid", p.getUniqueId());
        Document docs = new Document("uuid", p.getUniqueId())
                .append("name", p.getName())
                .append("protection", level);
        collection.replaceOne(ex_docs,docs);
    }
    public static boolean getStrenght(Player p, int level) {
        Document docs = new Document("uuid", p.getUniqueId())
                .append("name", p.getName())
                .append("strenght", level);
        Document results = collection.find(docs).first();
        return results != null;
    }
    public static boolean getSpeed(Player p, int level) {
        Document docs = new Document("uuid", p.getUniqueId())
                .append("name", p.getName())
                .append("speed", level);
        Document results = collection.find(docs).first();
        return  results != null;
    }
    public static boolean getProtection(Player p, int level) {
        Document docs = new Document("uuid", p.getUniqueId())
                .append("name", p.getName())
                .append("protection", level);
        Document results = collection.find(docs).first();
        return  results != null;
    }
}
