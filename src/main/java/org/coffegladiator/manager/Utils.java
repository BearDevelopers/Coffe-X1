package org.coffegladiator.manager;


import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.scheduler.BukkitRunnable;
import org.coffegladiator.Coffe_Gladiators;
import org.coffegladiator.apis.TitleAPI;
import org.coffegladiator.getinfos.GetInfosConfig;


public class Utils {

    static TitleAPI titles = new TitleAPI();
    public static FileConfiguration config = Coffe_Gladiators.getInstance().getConfig();
    public static void sendTitle(Player p, Player ps) {
        titles.sendTitle(p, 10, 10, 10, "Batalha", "Você sera tranportado em 15 segundos!");
        titles.sendTitle(ps, 10, 10, 10, "Batalha", "Você sera tranportado em 15 segundos!");
    }
    public static void sendTitles(Player p, Player ps) {
        titles.sendFullTitle(p, 10,10,10, ChatColor.GREEN + "F", ChatColor.GREEN + "Infelizmente você perdeu o 1v1 :l");
        titles.sendFullTitle(ps, 10,10,10, ChatColor.GREEN + "GG", ChatColor.GREEN + "Você ganhou do jogador " + p.getName() + " é agora esta com " + GetInfosConfig.getSouls(p) + " kills!");
        ps.playSound(ps.getLocation(), Sound.GHAST_FIREBALL, 1f,1f);
    }
    public static void saveSpawn(Player p) {
        config.set("camarote.location.x", p.getLocation().getX());
        config.set("camarote.location.y", p.getLocation().getY());
        config.set("camarote.location.z", p.getLocation().getZ());
        config.set("camarote.location.world-name", p.getLocation().getWorld().getName());
        Coffe_Gladiators.getInstance().saveConfig();
    }
    public static void putPlayers(Player p, Player ps) {
        Coffe_Gladiators.battleplayers.put(p.getUniqueId(), p);
        Coffe_Gladiators.battleplayers.put(ps.getUniqueId(), ps);
    }
    public static void removePlayers(Player p, Player ps) {
        Coffe_Gladiators.battleplayers.remove(p.getUniqueId());
        Coffe_Gladiators.battleplayers.remove(ps.getUniqueId());
    }
    public static void putMove(Player p, Player ps) {
        Coffe_Gladiators.intime.put(p.getUniqueId(), p);
        Coffe_Gladiators.intime.put(ps.getUniqueId(), ps);
        new BukkitRunnable() {
            @Override
            public void run() {
                Coffe_Gladiators.intime.remove(p.getUniqueId());
                Coffe_Gladiators.intime.remove(ps.getUniqueId());
            }
        }.runTaskLater(Coffe_Gladiators.getInstance(), 20*5);
    }
    public static void removeMove(Player p, Player ps) {
        Coffe_Gladiators.intime.remove(p.getUniqueId());
        Coffe_Gladiators.intime.remove(ps.getUniqueId());
    }
    public static PlayerInventory getPlayerInventory(Player p, int i) {
        i = 12;
        return null;
    }

}
