package org.coffegladiator.gui;

import org.bukkit.*;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.coffegladiator.Coffe_Gladiators;
import org.coffegladiator.database.MongoDBUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class TopGuis {
    static FileConfiguration kills = Coffe_Gladiators.getInstance().getConfig();
    public static int souls;
    public static int vitorias;
    public static int saidas;


    public static void createTopGUI(Player p) {
        Inventory gui = Bukkit.createInventory(p, 45, "Top kills");

        for (UUID playerId : Coffe_Gladiators.top_players.keySet()) {
            Player player = Coffe_Gladiators.top_players.get(playerId);

            try {
                souls = MongoDBUtils.getPlayer(player).getInteger("souls");
                vitorias = MongoDBUtils.getPlayer(player).getInteger("vitorias");
                saidas = MongoDBUtils.getPlayer(player).getInteger("saidas");
            } catch (Exception e) {
                souls = kills.getInt("infos." + player.getName() + ".mortes");
                vitorias = kills.getInt("infos." + player.getName() + ".vitorias");
                saidas = kills.getInt("infos." + player.getName() + ".saidas");
            }

            ItemStack item = new ItemStack(Material.SKULL,1, (byte)3);
            SkullMeta meta = (SkullMeta) item.getItemMeta();
            meta.setOwner(player.getName());
            meta.setDisplayName(player.getName());
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.WHITE + " ");
            lore.add(ChatColor.WHITE + "Vitórias: " + vitorias);
            lore.add(ChatColor.WHITE + "Kills: " + souls);
            lore.add(ChatColor.WHITE + "Saídas: " + saidas);
            lore.add(ChatColor.WHITE + "Elo: " + kills + vitorias);
            lore.add(ChatColor.WHITE + " ");
            meta.setLore(lore);
            item.setItemMeta(meta);

            gui.addItem(item);
        }

        p.openInventory(gui);
    }
}
