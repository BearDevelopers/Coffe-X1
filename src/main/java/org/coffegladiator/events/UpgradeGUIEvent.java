package org.coffegladiator.events;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.coffegladiator.Coffe_Gladiators;
import org.coffegladiator.database.MongoDBUtils;

import static org.coffegladiator.events.OnDeathListener.kills;


public class UpgradeGUIEvent implements Listener {
    String title = ChatColor.GRAY + "Upgrades";

    @EventHandler
    public void inventoryClickEvent(InventoryClickEvent e) {
        if (e.getClickedInventory().getName().equalsIgnoreCase(title)) {
            Player p = (Player) e.getWhoClicked();
            e.setCancelled(true);
            if (e.getClick() == ClickType.LEFT && e.getCurrentItem().getType() == Material.DIAMOND_SWORD) {
                try {
                    String sc = kills.getString("infos." + e.getWhoClicked().getName() + "." + "sharpness" + "." + "lvl1" + "." + "comprada");
                    int souls = kills.getInt("infos." + e.getWhoClicked().getName() + "." + "mortes");

                    try {
                        if (sc.equalsIgnoreCase("sim")) {
                            p.sendMessage(ChatColor.RED + "Você ja comprou este item!");
                        }
                        else {
                            kills.set("infos." + e.getWhoClicked().getName() + "." + "sharpness" + "." + "lvl1" + "." + "comprada.", "sim");
                            Coffe_Gladiators.getInstance().saveConfig();
                            p.sendMessage(ChatColor.GREEN + "Adquirido com sucesso. Você está com um total de " + souls + " kills!");
                            p.closeInventory();
                        }
                    }catch (Exception ess) {
                        p.sendMessage(ChatColor.RED + "Você não tem a quantia necessaria!");
                        ess.printStackTrace();
                    }
                }catch (Exception es) {
                    p.sendMessage(ChatColor.RED + "Erro, Houve um erro ao enviar os jogadores a sua devida posição!");
                    p.sendMessage(ChatColor.RED + "Notifique para algum staff!");
                }
            }
            if (e.getClick() == ClickType.LEFT && e.getCurrentItem().getType() == Material.IRON_CHESTPLATE) {
                try {
                    String sc = kills.getString("infos." + p.getName() + "." + "protection" + "." + "lvl1"  + "." + "comprada");
                    int souls = kills.getInt("infos." + e.getWhoClicked().getName() + "." + "mortes");


                    try {
                        if (sc.equalsIgnoreCase("sim")) {
                            p.sendMessage(ChatColor.RED + "Você ja comprou este item!");
                        }
                        else {
                            kills.set("infos." + e.getWhoClicked().getName() + "." + "protection" + "." + "lvl1"  + "." + "comprada", "sim");
                            Coffe_Gladiators.getInstance().saveConfig();
                            p.sendMessage(ChatColor.GREEN + "Adquirido com sucesso. Você está com um total de " + souls + " kills!");
                            p.closeInventory();
                        }
                    }catch (Exception ess) {
                        p.sendMessage(ChatColor.RED + "Você não tem a quantia necessaria!");
                        ess.printStackTrace();
                    }
                }catch (Exception es) {
                    p.sendMessage(ChatColor.RED + "Erro, Houve um erro ao enviar os jogadores a sua devida posição!");
                    p.sendMessage(ChatColor.RED + "Notifique para algum staff!");
                }
            }
            if (e.getClick() == ClickType.LEFT && e.getCurrentItem().getType() == Material.GOLD_BOOTS) {
                try {
                    String sc = kills.getString("infos." + p.getName() + "." + "speed" + "." + "comprada");
                    int souls = kills.getInt("infos." + e.getWhoClicked().getName() + "." + "mortes");
                    try {
                        if (sc.equalsIgnoreCase("sim")) {
                            p.sendMessage(ChatColor.RED + "Você ja comprou este item!");
                        }
                        else {
                            kills.set("infos." + e.getWhoClicked().getName() + "." + "speed" + "." + "comprada", "sim");
                            Coffe_Gladiators.getInstance().saveConfig();
                            p.sendMessage(ChatColor.GREEN + "Adquirido com sucesso. Você está com um total de " + souls + " kills!");
                            p.closeInventory();
                        }
                    }catch (Exception ess) {
                        p.sendMessage(ChatColor.RED + "Você não tem a quantia necessaria!");
                        ess.printStackTrace();
                    }
                }catch (Exception es) {
                    p.sendMessage(ChatColor.RED + "Erro, Houve um erro ao enviar os jogadores a sua devida posição!");
                    p.sendMessage(ChatColor.RED + "Notifique para algum staff!");
                }
            }
            if (e.getClick() == ClickType.LEFT && e.getCurrentItem().getType() == Material.DIAMOND_AXE) {
                try {
                    int souls = MongoDBUtils.getPlayer(p).getInteger("souls");
                    try {
                        if (MongoDBUtils.getStrenght(p,1)) {
                            p.sendMessage(ChatColor.RED + "Você ja comprou este item!");
                        }
                        else {
                            MongoDBUtils.setStrenght(p,1);
                            p.sendMessage(ChatColor.GREEN + "Adquirido com sucesso. Você está com um total de " + souls + " kills!");
                            p.closeInventory();
                        }
                    }
                    catch (Exception es) {
                        p.sendMessage(ChatColor.RED + "Você não tem a quantia necessaria!");
                        es.printStackTrace();
                    }

                }catch (Exception es) {
                    es.printStackTrace();
                    p.sendMessage(ChatColor.RED + "Erro, Houve um erro ao enviar os jogadores a sua devida posição!");
                }
            }
            Coffe_Gladiators.getInstance().saveConfig();
        }
    }

}
