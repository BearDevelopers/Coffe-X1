package org.coffegladiator.events;


import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.coffegladiator.Coffe_Gladiators;
import org.coffegladiator.apis.ActionBarAPI;
import org.coffegladiator.apis.TitleAPI;
import org.coffegladiator.commands.desafiar.GladiatorDesafiar;
import org.coffegladiator.manager.GetLocations;
import org.coffegladiator.manager.Utils;



public class DesafioEvent implements Listener {
    static TitleAPI titles = new TitleAPI();
    ActionBarAPI barAPI = new ActionBarAPI();

    @EventHandler
    public void inventoryClickEvent(InventoryClickEvent e) {
        if (e.getClickedInventory().getName().equalsIgnoreCase("Convite de desafio")) {
            Player p = (Player) e.getWhoClicked();
            e.setCancelled(true);
            if (e.getClick() == ClickType.LEFT && e.getCurrentItem().getType() == Material.COMPASS) {
                try {
                    Utils.sendTitle(p,  GladiatorDesafiar.ps);
                    Utils.putPlayers(p, GladiatorDesafiar.ps);
                    GetLocations.tp(p, GladiatorDesafiar.ps);
                    p.closeInventory();
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            for (Player online : Bukkit.getOnlinePlayers()) {
                                barAPI.sendAction(online, "O jogador " + GladiatorDesafiar.ps.getName() + " desafiou o jogador " + p.getName() + " caso queira ver o x1 digite /camarote!");
                            }
                            p.sendMessage(ChatColor.RED + "X1 Iniciado!");
                            GladiatorDesafiar.ps.sendMessage(ChatColor.RED + "X1 Iniciado!");
                            Utils.putMove(p,GladiatorDesafiar.ps);
                        }
                    }.runTaskLater(Coffe_Gladiators.getInstance(), 20L * 15);


                }catch (Exception es) {
                    p.sendMessage(ChatColor.RED + "ERROR, Houve um erro ao enviar os jogadores a sua devida posição!");
                    p.sendMessage(ChatColor.RED + "Notifique para algum staff!");
                }

            }
            if (e.getClick() == ClickType.LEFT && e.getCurrentItem().getType() == Material.BARRIER) {
                p.sendMessage(ChatColor.RED + "Você recusou o pedido do jogador " + GladiatorDesafiar.ps.getName());
                GladiatorDesafiar.ps.sendMessage(ChatColor.RED + "O jogador recusou o seu pedido!");
                p.closeInventory();
            }
        }
    }

}

