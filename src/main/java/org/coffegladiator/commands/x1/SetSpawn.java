package org.coffegladiator.commands.x1;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.coffegladiator.Coffe_Gladiators;
import org.coffegladiator.apis.TitleAPI;
import org.coffegladiator.manager.Utils;
import org.graalvm.compiler.core.common.util.Util;

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
                        Utils.saveSpawn(p);
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
