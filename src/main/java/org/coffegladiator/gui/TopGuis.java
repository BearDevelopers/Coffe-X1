package org.coffegladiator.gui;

import org.bukkit.*;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.coffegladiator.Coffe_Gladiators;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class TopGuis {
    static FileConfiguration kills = Coffe_Gladiators.getInstance().getConfig();

    public static void createTopGUI(Player p) {
        Inventory gui = Bukkit.createInventory(p, 45, "Top kills");
        for (UUID players : Coffe_Gladiators.top_players.keySet()) {
            Player psps = Coffe_Gladiators.top_players.get(players);
            int souls = kills.getInt("infos." + psps.getName() + "." + "mortes");
            int vitorias = kills.getInt("infos." + psps.getName() + "." + "vitorias");
            int saidas = kills.getInt("infos." + psps.getName() + "." + "saidas");
            ItemStack i = new ItemStack(Material.SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal());
            List<String> lore = new ArrayList<>();
            SkullMeta meta = (SkullMeta) i.getItemMeta();
            meta.setOwner(psps.getName());
            meta.setDisplayName(psps.getName());
            Coffe_Gladiators.getInstance().reloadConfig();
            lore.add(ChatColor.WHITE + " ");
            lore.add(ChatColor.WHITE + "Vitorias: " + vitorias);
            lore.add(ChatColor.WHITE + "Kills: " + souls);
            lore.add(ChatColor.WHITE + "Saidas: " + saidas);
            lore.add(ChatColor.WHITE + "Elo: " + kills + vitorias);
            lore.add(ChatColor.WHITE + " ");
            meta.setLore(lore);
            i.setItemMeta(meta);
            for (int is = 10; is <= 35; is++) {
                if (is == 17) {
                    is++;
                    is++;
                }
                if(is == 26) {
                    is++;
                    is++;
                }
                if (is == 35) {
                    is++;
                    is++;
                }
                if (is > 35) {
                    break;
                }
                gui.setItem(is,i);
            }
        }

        p.openInventory(gui);
    }
}
