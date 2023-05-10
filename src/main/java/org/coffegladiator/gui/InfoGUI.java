package org.coffegladiator.gui;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.coffegladiator.apis.Criar;

public class InfoGUI {
    public static void infoGUI(Player p ) {
        Inventory gui = Bukkit.createInventory(p, 9*3, "Info");
        ItemStack item = Criar.add(Material.DIAMOND_SWORD, "Kills");
        gui.setItem(10,item);
    }
}
