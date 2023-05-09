package org.coffegladiator.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.coffegladiator.Coffe_Gladiators;
import org.coffegladiator.gui.AcceptGUI;

public class GladiatorDesafiar implements CommandExecutor {
    FileConfiguration config = Coffe_Gladiators.getInstance().getConfig();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Apenas no jogo!");
        }
        if (cmd.getName().equalsIgnoreCase("desafiar")) {
            Player ps = Bukkit.getPlayerExact(args[0]);
            Player p = (Player) sender;
            if (p.hasPermission(config.getString("desafiar.permission"))) {
                ps.sendMessage(ChatColor.RED + "Você foi desafiado por " + p.getName() + "uma gui ira abrir em 15 segundos, Nela você podera escolher sera ira querer ir o pvp!");
                p.sendMessage(ChatColor.GREEN + "Jogador desafiado com sucesso!, Mal uso do comando ira causar banimento!");
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        AcceptGUI.createGuiAccept(ps);
            }
                }.runTaskLater(Coffe_Gladiators.getInstance(), 20*15);
            }
        }
        return false;
    }
}
