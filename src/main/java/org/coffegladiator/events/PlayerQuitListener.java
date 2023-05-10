package org.coffegladiator.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.coffegladiator.Coffe_Gladiators;
import org.coffegladiator.commands.desafiar.GladiatorDesafiar;

import static org.coffegladiator.events.OnDeathListener.kills;

public class PlayerQuitListener implements Listener {
    FileConfiguration config = Coffe_Gladiators.getInstance().getConfig();
    int saidas;
    @EventHandler
    public void quit(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        if (Coffe_Gladiators.battleplayers.containsKey(p.getUniqueId())) {
            saidas = kills.getInt("infos." + p.getName() + "." + "saidas");
            Coffe_Gladiators.battleplayers.remove(p.getUniqueId());
            Coffe_Gladiators.battleplayers.remove(GladiatorDesafiar.ps.getUniqueId());
            Bukkit.broadcastMessage(ChatColor.RED + "O jogador " + p.getName() + " peidou na farofa é saiu do servidor  no x1!");
            saidas++;
            config.set("infos." + p.getName() + "." + "saidas", saidas);

        }
    }
}
