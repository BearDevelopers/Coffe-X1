package org.coffegladiator.gui;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class AcceptGUI {
    public static void createGuiAccept(Player p) {
        Inventory gui = Bukkit.createInventory(null,9*3, "Convite de desafio");
        ItemStack one = new ItemStack(Material.COMPASS);
        ItemMeta metaone = one.getItemMeta();
        metaone.setDisplayName(ChatColor.GREEN + "Aceitar");
        one.setItemMeta(metaone);

        ItemStack two = new ItemStack(Material.BARRIER);
        ItemMeta metatwo = two.getItemMeta();
        metatwo.setDisplayName(ChatColor.GREEN + "Recusar");
        two.setItemMeta(metatwo);

        gui.setItem(11, one);
        gui.setItem(15, two);
        p.openInventory(gui);
    }
}
