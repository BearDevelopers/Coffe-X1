package org.coffegladiator.gui;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.coffegladiator.Coffe_Gladiators;

import java.util.ArrayList;
import java.util.List;

public class UpgradeGuiCreate  {


    public static void createUpgradeGui(Player p) {
        List<String> shlore = new ArrayList<>();
        List<String> prlore = new ArrayList<>();
        List<String> splore = new ArrayList<>();
        List<String> stlore = new ArrayList<>();


        shlore.add(ChatColor.GRAY + " ");
        shlore.add(ChatColor.GRAY + "Custo: " + Coffe_Gladiators.getInstance().getConfig().getInt("upgrade.sh.cost") + " Kills");
        shlore.add(ChatColor.GRAY + "Clique com o botao esquerdo para comprar");
        shlore.add(ChatColor.GRAY + " ");

        prlore.add(ChatColor.GRAY + " ");
        prlore.add(ChatColor.GRAY + "Custo: " + Coffe_Gladiators.getInstance().getConfig().getInt("upgrade.protection.cost") + " Kills");
        prlore.add(ChatColor.GRAY + "Clique com o botao esquerdo para comprar");
        prlore.add(ChatColor.GRAY + " ");

        splore.add(ChatColor.GRAY + " ");
        splore.add(ChatColor.GRAY + "Custo: " + Coffe_Gladiators.getInstance().getConfig().getInt("upgrade.speed.cost") + " Kills");
        splore.add(ChatColor.GRAY + "Clique com o botao esquerdo para comprar");
        splore.add(ChatColor.GRAY + " ");

        stlore.add(ChatColor.GRAY + " ");
        stlore.add(ChatColor.GRAY + "Custo: " + Coffe_Gladiators.getInstance().getConfig().getInt("upgrade.strenght.cost") + " Kills");
        stlore.add(ChatColor.GRAY + "Clique com o botao esquerdo para comprar");
        stlore.add(ChatColor.GRAY + " ");


        Inventory gui = Bukkit.createInventory(null, 9 * 5, ChatColor.GRAY + "Upgrades");
        // 2 Linha

        ItemStack sharpness = new ItemStack(Material.DIAMOND_SWORD);
        ItemStack protection = new ItemStack(Material.IRON_CHESTPLATE);
        ItemStack speed = new ItemStack(Material.DIAMOND_SWORD);
        ItemStack strenght = new ItemStack(Material.IRON_CHESTPLATE);


        // Pegando os metas
        ItemMeta shmeta = sharpness.getItemMeta();
        ItemMeta phmeta = protection.getItemMeta();
        ItemMeta spmeta = speed.getItemMeta();
        ItemMeta stmeta = strenght.getItemMeta();


        // Setando as lore
        shmeta.setLore(shlore);
        phmeta.setLore(prlore);
        spmeta.setLore(splore);
        stmeta.setLore(stlore);

        // Set item metas
        sharpness.setItemMeta(shmeta);
        protection.setItemMeta(phmeta);
        speed.setItemMeta(shmeta);
        strenght.setItemMeta(stmeta);

        // Setando os itens
        gui.setItem(12,sharpness);
        gui.setItem(14, protection);
        gui.setItem(29,speed);
        gui.setItem(30, strenght);


        p.openInventory(gui);
    }
}
