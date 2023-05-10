package org.coffegladiator.manager;

import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bukkit.entity.Player;
import org.coffegladiator.database.MongoDBConnection;

public class MongoDBUtils {
    public static MongoCollection<Document> collection = MongoDBConnection.getDatabase().getCollection(MongoDBConnection.DATABASE_NAME);
    public static void savePlayer(Player p, int souls) {
        Document doc = new Document("uuid", p.getUniqueId())
                .append("souls", souls);
        collection.insertOne(doc);
    }
    public static void updatePlayer(Player p, int souls) {
        Document doc = new Document("uuid", p.getUniqueId())
                .append("souls", souls);
        collection.updateOne(doc,doc);
    }
    public static Document getPlayer(Player p) {
        Document doc = new Document("uuid", p.getUniqueId());
        Document getDados = collection.find(doc).first();
        assert getDados != null;
        return getDados;

    }
}
