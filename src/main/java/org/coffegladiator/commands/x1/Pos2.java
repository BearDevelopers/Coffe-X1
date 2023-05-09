package org.coffegladiator.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.coffegladiator.Coffe_Gladiators;
import org.coffegladiator.apis.TitleAPI;
import org.coffegladiator.manager.IfPlayer;

import javax.swing.text.AttributeSet;

public class Pos2 implements CommandExecutor {
    FileConfiguration config = Coffe_Gladiators.getInstance().getConfig();
    TitleAPI titles = new TitleAPI();
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (IfPlayer.verifyPlayer(sender)) {
            sender.sendMessage(ChatColor.RED + "Apenas in-game!");
        }
        else {
            Player p = (Player) sender;
            if (p.hasPermission(config.getString("player.pos2.permission"))) {
                try {
                    config.set("player.pos2.positions.y", p.getLocation().getY());
                    config.set("player.pos2.positions.z", p.getLocation().getZ());
                    config.set("player.pos2.positions.x", p.getLocation().getX());
                    config.set("player.pos2.positions.world", p.getLocation().getWorld().getName());
                    Coffe_Gladiators.getInstance().saveConfig();
                    Coffe_Gladiators.getInstance().reloadConfig();
                    titles.sendFullTitle(p, 10,10,10, "Spawn", "Para o jogador 2 setado com sucesso");
                }
                catch (Exception e) {
                    titles.sendFullTitle(p, 10,10,10, ChatColor.RED + "Erro", "Houve um erro ao salvar a config.yml!");
                    e.printStackTrace();
                }
            }
            else {
                p.sendMessage(ChatColor.RED + "Você não tem permissão!");
            }
        }
        return false;
    }
}
