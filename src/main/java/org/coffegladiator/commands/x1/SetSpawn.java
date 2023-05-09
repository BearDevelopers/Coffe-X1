package org.coffegladiator.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.coffegladiator.Coffe_Gladiators;
import org.coffegladiator.apis.TitleAPI;

public class SetSpawn implements CommandExecutor {
    FileConfiguration config = Coffe_Gladiators.getInstance().getConfig();
    TitleAPI titles = new TitleAPI();
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Apenas no jogo!");
        }
        else {
            if (cmd.getName().equalsIgnoreCase("setspawn")) {
                Player p = (Player) sender;
                try {
                    if (p.hasPermission(config.getString("camarote.permission"))) {
                        config.set("camarote.location.x", p.getLocation().getX());
                        config.set("camarote.location.y", p.getLocation().getY());
                        config.set("camarote.location.z", p.getLocation().getZ());
                        config.set("camarote.location.world-name", p.getLocation().getWorld().getName());
                        Coffe_Gladiators.getInstance().saveConfig();
                        titles.sendFullTitle(p, 10,10,10, "Spawn", "Setado com sucesso");

                    }
                } catch (Exception es) {
                    p.sendMessage(ChatColor.RED + "Houve um erro ao salvar o spawn na config!");
                    es.printStackTrace();
                }
            }
        }
        return false;
    }
}
