package org.coffegladiator.events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.coffegladiator.Coffe_Gladiators;
import org.coffegladiator.database.MongoDBUtils;

import static org.coffegladiator.events.OnDeathListener.kills;

public class PlayerJoinListener implements Listener {

    public static int souls;
    public static int vitorias;
    public static int perdas;
    @EventHandler
    public void playerJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();

        try {
            souls = MongoDBUtils.getPlayer(p).getInteger("souls");
            vitorias = MongoDBUtils.getPlayer(p).getInteger("vitorias");
            perdas = MongoDBUtils.getPlayer(p).getInteger("percas");
        }catch (Exception es) {
            souls = 0;
            vitorias = 0;
            perdas = 0;
        }
        if (!MongoDBUtils.existPlayer(p)) {
            MongoDBUtils.savePlayer(p, souls,vitorias,perdas);
            p.sendMessage(ChatColor.GREEN + "Inserimos você em nosso banco de dados");
        }
        else {
            p.sendMessage(ChatColor.RED + "Você ja foi inserido em nosso banco de dados!");
        }
        kills.set("infos." + p.getName() + "." + "mortes", souls);
        kills.set("infos." + p.getName() + "." + "vitorias", vitorias);
        kills.set("infos." + p.getName() + "." + "perdas", perdas);
        Coffe_Gladiators.top_players.put(p.getUniqueId(), p);
        Coffe_Gladiators.getInstance().saveConfig();
    }
}
