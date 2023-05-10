package org.coffegladiator.commands.kills;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.coffegladiator.Coffe_Gladiators;

public class ReloadCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender.hasPermission("coffe1v1.reload.use")) {
            Coffe_Gladiators.getInstance().reloadConfig();
            commandSender.sendMessage(ChatColor.GREEN + "Config recarregada com sucesso");
        }
        else {
            commandSender.sendMessage(ChatColor.RED + "Sem permissão!");
            return true;
        }
        return false;
    }
}
