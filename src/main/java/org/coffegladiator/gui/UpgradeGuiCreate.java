package org.coffegladiator.gui;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.coffegladiator.Coffe_Gladiators;
import org.coffegladiator.getinfos.GetInfosConfig;
import org.coffegladiator.manager.LoadLore;

import java.util.ArrayList;
import java.util.List;



public class UpgradeGuiCreate  {
    static FileConfiguration config = Coffe_Gladiators.getInstance().getConfig();


    public static void createUpgradeGui(Player p) {
        Inventory gui = Bukkit.createInventory(null, 9 * 5, ChatColor.GRAY + "Upgrades");

        List<String> shlore = new ArrayList<>();
        List<String> prlore = new ArrayList<>();
        List<String> splore = new ArrayList<>();
        List<String> stlore = new ArrayList<>();


        try {
            ItemStack sharpness = new ItemStack(Material.DIAMOND_SWORD);
            ItemStack protection = new ItemStack(Material.IRON_CHESTPLATE);
            ItemStack speed = new ItemStack(Material.GOLD_BOOTS);
            ItemStack strenght = new ItemStack(Material.DIAMOND_AXE);

            // Pegando os metas
            ItemMeta shmeta = sharpness.getItemMeta();
            ItemMeta phmeta = protection.getItemMeta();
            ItemMeta spmeta = speed.getItemMeta();
            ItemMeta stmeta = strenght.getItemMeta();

            // Setando as lore
            stmeta.setLore(LoadLore.LoadLoreQ(p,stlore));
            shmeta.setLore(LoadLore.LoadLoreOne(p, shlore));
            phmeta.setLore(LoadLore.LoadLoreTwo(p, prlore));
            spmeta.setLore(LoadLore.LoadLoreThree(p,splore));

            // Setando os display
            shmeta.setDisplayName(ChatColor.GRAY + "Sharpness");
            phmeta.setDisplayName(ChatColor.GRAY + "Protection");
            spmeta.setDisplayName(ChatColor.GRAY + "Speed");
            stmeta.setDisplayName(ChatColor.GRAY + "Strenght");

            // Setando os metas
            sharpness.setItemMeta(shmeta);
            protection.setItemMeta(phmeta);
            speed.setItemMeta(spmeta);
            strenght.setItemMeta(stmeta);

            // Setando os itens
            gui.setItem(12, sharpness);
            gui.setItem(14, protection);
            gui.setItem(29, speed);
            gui.setItem(33, strenght);

            p.openInventory(gui);
        }
        catch (Exception e) {
            p.sendMessage(ChatColor.RED + "Houve um erro ao carrecar a gui!");
            e.printStackTrace();
        }
    }
}
