package org.coffegladiator.manager;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.coffegladiator.Coffe_Gladiators;
import org.coffegladiator.getinfos.GetInfosConfig;
import java.util.List;

public class LoadLore {
    private static final int UPGRADE_COST = Coffe_Gladiators.getInstance().getConfig().getInt("upgrade.sh.cost");
    private static final String LEVEL_1_LORE = ChatColor.GRAY + "Lvl: 1";
    private static final String ACQUIRED_TRUE_LORE = ChatColor.GRAY + "Adquirido: True";
    private static final String COST_LORE = ChatColor.GRAY + "Custo: " + UPGRADE_COST + " Kills";
    private static final String BUY_LORE = ChatColor.GRAY + "Clique com o botão esquerdo para comprar";

    public static List<String> loadLoreOne(Player player, List<String> lore) {
        String sharpnessLevel = GetInfosConfig.getLevel(player, "sharpness");
        if (sharpnessLevel.equalsIgnoreCase("sim")) {
            lore.add(ChatColor.GRAY + " ");
            lore.add(LEVEL_1_LORE);
            lore.add(ACQUIRED_TRUE_LORE);
            lore.add(ChatColor.GRAY + " ");
        } else {
            lore.add(ChatColor.GRAY + " ");
            lore.add(COST_LORE);
            lore.add(BUY_LORE);
            lore.add(ChatColor.GRAY + " ");
        }
        return lore;
    }

    public static List<String> loadLoreTwo(Player player, List<String> lore) {
        String protectionLevel = GetInfosConfig.getLevel(player, "protection");
        if (protectionLevel.equalsIgnoreCase("sim")) {
            lore.add(ChatColor.GRAY + " ");
            lore.add(LEVEL_1_LORE);
            lore.add(ACQUIRED_TRUE_LORE);
            lore.add(ChatColor.GRAY + " ");
        } else {
            lore.add(ChatColor.GRAY + " ");
            lore.add(COST_LORE);
            lore.add(BUY_LORE);
            lore.add(ChatColor.GRAY + " ");
        }
        return lore;
    }

    public static List<String> loadLoreThree(Player player, List<String> lore) {
        String protectionLevel = GetInfosConfig.getLevel(player, "protection");
        if (protectionLevel.equalsIgnoreCase("sim")) {
            lore.add(ChatColor.GRAY + " ");
            lore.add(LEVEL_1_LORE);
            lore.add(ACQUIRED_TRUE_LORE);
            lore.add(ChatColor.GRAY + " ");
        } else {
            lore.add(ChatColor.GRAY + " ");
            lore.add(COST_LORE);
            lore.add(BUY_LORE);
            lore.add(ChatColor.GRAY + " ");
        }
        return lore;
    }

    public static List<String> loadLoreQ(Player player, List<String> lore) {
        String protectionLevel = GetInfosConfig.getLevel(player, "protection");
        if (protectionLevel.equalsIgnoreCase("sim")) {
            lore.add(ChatColor.GRAY + " ");
            lore.add(LEVEL_1_LORE);
            lore.add(ACQUIRED_TRUE_LORE);
            lore.add(ChatColor.GRAY + " ");
        } else {
            lore.add(ChatColor.GRAY + " ");
            lore.add(COST_LORE);
            lore.add(BUY_LORE);
            lore.add(ChatColor.GRAY + " ");
        }
        return lore;
    }
}