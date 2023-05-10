package org.coffegladiator.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.coffegladiator.Coffe_Gladiators;
import org.coffegladiator.commands.desafiar.GladiatorDesafiar;

public class MoveEventListener implements Listener {

    @EventHandler
    public void moveEvent(PlayerMoveEvent e) {

        if (Coffe_Gladiators.intime.containsKey(e.getPlayer().getUniqueId())) {
            e.setCancelled(true);
            new BukkitRunnable() {
                @Override
                public void run() {
                    Coffe_Gladiators.intime.remove(e.getPlayer().getUniqueId());
                    Coffe_Gladiators.intime.remove(GladiatorDesafiar.ps.getUniqueId());
                    e.setCancelled(false);
                }
            }.runTaskLater(Coffe_Gladiators.getInstance(), 20*5);
        }
    }
}
