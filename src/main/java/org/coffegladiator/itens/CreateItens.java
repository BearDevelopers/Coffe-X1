package org.coffegladiator.itens;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class CreateItens {
    public static void loadItem(Player p) {
        p.getInventory().clear();
        p.getInventory().setItem(0, new ItemStack(Material.DIAMOND_SWORD));
        p.getInventory().setItem(1, new ItemStack(Material.GOLDEN_APPLE, 8));
        p.getInventory().setItem(2, new ItemStack(Material.BOW));
        p.getInventory().setItem(22, new ItemStack(Material.ARROW, 16));
        p.getInventory().setHelmet(new ItemStack(Material.CHAINMAIL_HELMET));
        p.getInventory().setChestplate(new ItemStack(Material.CHAINMAIL_CHESTPLATE));
        p.getInventory().setLeggings(new ItemStack(Material.CHAINMAIL_LEGGINGS));
        p.getInventory().setBoots(new ItemStack(Material.CHAINMAIL_BOOTS));
        p.sendMessage(ChatColor.GREEN + "Itens setados");
    }


}
