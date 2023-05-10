package org.coffegladiator.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.coffegladiator.Coffe_Gladiators;
import org.coffegladiator.manager.MongoDBUtils;

import static org.coffegladiator.events.OnDeathListener.kills;
import static org.coffegladiator.events.OnDeathListener.souls;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void playerJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        int is = Coffe_Gladiators.getInstance().getConfig().getInt("kills." + p.getName() + "." + "mortes");
        int vitorias = kills.getInt("infos." + e.getPlayer().getName() + "." + "vitorias");
        int perdas = kills.getInt("infos." + e.getPlayer().getName() + "." + "perdas");
        MongoDBUtils.savePlayer(p, is, vitorias,perdas);
        kills.set("infos." + p.getName() + "." + "mortes", is);
        kills.set("infos." + p.getName() + "." + "vitorias", vitorias);
        kills.set("infos." + p.getName() + "." + "perdas", perdas);
        Coffe_Gladiators.top_players.put(p.getUniqueId(), p);
        Coffe_Gladiators.getInstance().saveConfig();
    }
}
