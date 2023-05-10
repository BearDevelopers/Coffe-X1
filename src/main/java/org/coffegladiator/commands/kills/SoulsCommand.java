package org.coffegladiator.commands.kills;

import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.coffegladiator.database.MongoDBConnection;
import org.coffegladiator.gui.TopGuis;
import org.coffegladiator.database.MongoDBUtils;

public class SoulsCommand implements CommandExecutor {
    MongoCollection<Document> collection = MongoDBConnection.getDatabase().getCollection(MongoDBConnection.DATABASE_NAME);

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Apenas in-game!");
            return false;
        }
        else {
            Player p = (Player) sender;
            Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "Souls: " + MongoDBUtils.getPlayer(p).getInteger("souls") + " Vitorias: " + MongoDBUtils.getPlayer(p).getInteger("vitorias") + " Percas: " + MongoDBUtils.getPlayer(p).getInteger("percas"));
            TopGuis.createTopGUI(p);
        }
        return false;
    }
}
