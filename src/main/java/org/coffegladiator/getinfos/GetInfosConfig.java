package org.coffegladiator.getinfos;


import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.coffegladiator.Coffe_Gladiators;


public class GetInfosConfig {
    private static FileConfiguration config = Coffe_Gladiators.getInstance().getConfig();
    public static String getInfos(Player p, String enchantment) {
        String sc = config.getString("infos." + p.getName() + "." + enchantment + "." + "lvl1" + "." + "comprada");
        return sc;
    }
    public static String getLevel(Player p, String enchantment) {
        String sc = config.getString("infos." + p.getName() + "." + enchantment + "." +  "comprada");
        return sc;
    }
    public static void setSouls(Player p, Integer souls) {
        config.set("infos." + p.getName() + "." + "mortes", souls);
    }
    public static void setVitorys(Player p, Integer vitorys) {
        config.set("infos." + p.getName() + "." + "vitorias", vitorys);
    }
    public static void setPerdas(Player p, Integer perdas) {
        config.set("infos." + p.getName() + "." + "perdas", perdas);
    }
    public static Integer getSouls(Player p) {
        int i = config.getInt("infos." + p.getName() + "." + "mortes");
        return i;
    }
}