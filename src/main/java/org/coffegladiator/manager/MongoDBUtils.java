package org.coffegladiator.manager;

import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bukkit.entity.Player;
import org.coffegladiator.database.MongoDBConnection;

public class MongoDBUtils {
    public static MongoCollection<Document> collection = MongoDBConnection.getDatabase().getCollection(MongoDBConnection.DATABASE_NAME);
    public static void savePlayer(Player p, int souls, int vitorias, int percas) {
        Document doc = new Document("uuid", p.getUniqueId())
                .append("souls", souls)
                .append("vitorias", vitorias)
                .append("percas", percas);
        collection.insertOne(doc);
    }
    public static void updatePlayer(Player p, int souls, int vitorias, int percas) {
        Document filter = new Document("uuid", p.getUniqueId());
        Document updatedDocument = new Document("uuid", p.getUniqueId())
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
}
