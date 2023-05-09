package org.coffegladiator.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.coffegladiator.Coffe_Gladiators;
import org.coffegladiator.apis.Tablist;
import org.coffegladiator.apis.TitleAPI;
import org.coffegladiator.itens.CreateItens;


public class CamaroteTeleport implements CommandExecutor {
    FileConfiguration config = Coffe_Gladiators.getInstance().getConfig();

    TitleAPI titles = new TitleAPI();
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Apenas no jogo!");
        }
        else {
            if (cmd.getName().equalsIgnoreCase("camarote")) {
                Player p = (Player) sender;
                if (p.hasPermission(config.getString("camarote.permission"))) {
                    if (Coffe_Gladiators.cooldown.containsKey(p.getUniqueId())) {
                        p.sendMessage(ChatColor.RED + "Você está em cooldown!");
                        return true;
                    }
                    else {
                        Coffe_Gladiators.cooldown.put(p.getUniqueId(), p);
                        double x = config.getDouble("camarote.location.x");
                        double y = config.getDouble("camarote.location.y");
                        double z = config.getDouble("camarote.location.z");
                        String words = config.getString("camarote.location.world-name");
                        World world = Bukkit.getWorld(words);
                        Location loc = new Location(world, x, y, z);
                        titles.sendFullTitle(p, 10,10,10, ChatColor.GREEN + "Teletranportado", "Com sucesso para o camarote");
                        Tablist.sendTablist(p, "Teletranportando...", "!");

                        p.teleport(loc);
                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                Coffe_Gladiators.cooldown.remove(p.getUniqueId());
                            }
                        }.runTaskLater(Coffe_Gladiators.getInstance(), 20*15);

                    }
                }
            }
        }
        return false;
    }
}
