package org.coffegladiator.commands.x1;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.coffegladiator.Coffe_Gladiators;
import org.coffegladiator.apis.TitleAPI;
public class Pos1 implements CommandExecutor {
    FileConfiguration config = Coffe_Gladiators.getInstance().getConfig();
    TitleAPI titles = new TitleAPI();
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Apenas in-game!");
            return false;
        }
        else {
            Player p = (Player) sender;
            if (p.hasPermission(config.getString("player.permission"))) {
                try {
                    config.set("player.pos1.positions.y", p.getLocation().getY());
                    config.set("player.pos1.positions.z", p.getLocation().getZ());
                    config.set("player.pos1.positions.x", p.getLocation().getX());
                    config.set("player.pos1.positions.world", p.getLocation().getWorld().getName());
                    Coffe_Gladiators.getInstance().saveConfig();
                    titles.sendFullTitle(p, 10,10,10, "Spawn", "Para o jogador 1 setado com sucesso");
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
