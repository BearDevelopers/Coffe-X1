package org.coffegladiator.commands.x1;

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
import org.coffegladiator.apis.TitleAPI;


public class CamaroteTeleport implements CommandExecutor {
    TitleAPI titles = new TitleAPI();
    public static Integer cooldown = 5;
    FileConfiguration config = Coffe_Gladiators.getInstance().getConfig();
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Apenas no jogo!");
        }
        else {
            if (cmd.getName().equalsIgnoreCase("camarote")) {
                Player p = (Player) sender;
                if (p.hasPermission(config.getString("camarote.permission"))) {
                    try {
                        if (Coffe_Gladiators.cooldown.containsKey(p.getUniqueId())) {
                            p.sendMessage(ChatColor.RED + "Você está em cooldown!");
                            return true;
                        } else {
                            Coffe_Gladiators.cooldown.put(p.getUniqueId(), p);
                            double x = config.getDouble("camarote.location.x");
                            double y = config.getDouble("camarote.location.y");
                            double z = config.getDouble("camarote.location.z");
                            String words = config.getString("camarote.location.world-name");
                            World world = Bukkit.getWorld(words);
                            Location loc = new Location(world, x, y, z);

                            new BukkitRunnable() {
                                @Override
                                public void run() {
                                    p.teleport(loc);
                                }
                            }.runTaskLater(Coffe_Gladiators.getInstance(), 20L * cooldown);

                            new BukkitRunnable() {
                                @Override
                                public void run() {
                                    cooldown--;
                                    int time = (cooldown * 20) / 20;
                                    titles.sendFullTitle(p, 1, 1, 10, "Cooldown", "Você sera teletranportado em " + time);
                                }
                            }.runTaskTimer(Coffe_Gladiators.getInstance(), 20, 20L * 5);

                            new BukkitRunnable() {
                                @Override
                                public void run() {
                                    Coffe_Gladiators.cooldown.remove(p.getUniqueId());
                                }
                            }.runTaskLater(Coffe_Gladiators.getInstance(), 20 * 25);

                        }
                    }catch (Exception es) {
                        p.sendMessage(ChatColor.RED + "Houve um erro ao teletranportar!");
                        es.printStackTrace();
                    }
                }
            }
        }
        return false;
    }
}
