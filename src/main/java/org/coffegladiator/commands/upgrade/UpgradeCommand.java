package org.coffegladiator.commands.upgrade;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.coffegladiator.gui.UpgradeGuiCreate;

public class UpgradeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (cmd.getName().equalsIgnoreCase("upgrade")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(ChatColor.RED + "Apenas in-game");
            } else {
                Player p = (Player) sender;
                UpgradeGuiCreate.createUpgradeGui(p);
            }
        }
        return false;
    }
}
