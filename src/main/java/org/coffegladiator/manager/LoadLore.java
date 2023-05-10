package org.coffegladiator.manager;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.coffegladiator.Coffe_Gladiators;
import org.coffegladiator.getinfos.GetInfosConfig;
import java.util.List;

public class LoadLore {
    public static List<String> LoadLoreOne(Player p, List<String> shlore) {
        String stcssss = GetInfosConfig.getLevel(p,"sharpness");
        if (stcssss.equalsIgnoreCase("sim")) {
            shlore.add(ChatColor.GRAY + " ");
            shlore.add(ChatColor.GRAY + "Lvl: 1");
            shlore.add(ChatColor.GRAY + "Aquirido: True");
            shlore.add(ChatColor.GRAY + " ");
        } else {
            shlore.add(ChatColor.GRAY + " ");
            shlore.add(ChatColor.GRAY + "Custo: " + Coffe_Gladiators.getInstance().getConfig().getInt("upgrade.sh.cost") + " Kills");
            shlore.add(ChatColor.GRAY + "Clique com o botao esquerdo para comprar");
            shlore.add(ChatColor.GRAY + " ");
        }
        return shlore;
    }
    public static List<String> LoadLoreTwo(Player p, List<String> shlore) {
        String stcsss = GetInfosConfig.getLevel(p,"protection");
        if (stcsss.equalsIgnoreCase("sim")) {
            shlore.add(ChatColor.GRAY + " ");
            shlore.add(ChatColor.GRAY + "Lvl: 1");
            shlore.add(ChatColor.GRAY + "Aquirido: True");
            shlore.add(ChatColor.GRAY + " ");
        } else {
            shlore.add(ChatColor.GRAY + " ");
            shlore.add(ChatColor.GRAY + "Custo: " + Coffe_Gladiators.getInstance().getConfig().getInt("upgrade.sh.cost") + " Kills");
            shlore.add(ChatColor.GRAY + "Clique com o botao esquerdo para comprar");
            shlore.add(ChatColor.GRAY + " ");
        }
        return shlore;
    }
    public static List<String> LoadLoreThree(Player p, List<String> shlore) {
        String stcss = GetInfosConfig.getLevel(p,"protection");
        if (stcss.equalsIgnoreCase("sim")) {
            shlore.add(ChatColor.GRAY + " ");
            shlore.add(ChatColor.GRAY + "Lvl: 1");
            shlore.add(ChatColor.GRAY + "Aquirido: True");
            shlore.add(ChatColor.GRAY + " ");
        } else {
            shlore.add(ChatColor.GRAY + " ");
            shlore.add(ChatColor.GRAY + "Custo: " + Coffe_Gladiators.getInstance().getConfig().getInt("upgrade.sh.cost") + " Kills");
            shlore.add(ChatColor.GRAY + "Clique com o botao esquerdo para comprar");
            shlore.add(ChatColor.GRAY + " ");
        }
        return shlore;
    }
    public static List<String> LoadLoreQ(Player p, List<String> shlore) {
        String stcs = GetInfosConfig.getLevel(p,"protection");
        if (stcs.equalsIgnoreCase("sim")) {
            shlore.add(ChatColor.GRAY + " ");
            shlore.add(ChatColor.GRAY + "Lvl: 1");
            shlore.add(ChatColor.GRAY + "Aquirido: True");
            shlore.add(ChatColor.GRAY + " ");
        } else {
            shlore.add(ChatColor.GRAY + " ");
            shlore.add(ChatColor.GRAY + "Custo: " + Coffe_Gladiators.getInstance().getConfig().getInt("upgrade.sh.cost") + " Kills");
            shlore.add(ChatColor.GRAY + "Clique com o botao esquerdo para comprar");
            shlore.add(ChatColor.GRAY + " ");
        }
        return shlore;
    }
}
