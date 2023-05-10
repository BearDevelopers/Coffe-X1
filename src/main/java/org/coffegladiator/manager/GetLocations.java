package org.coffegladiator.manager;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import org.coffegladiator.Coffe_Gladiators;


public class GetLocations {
    static FileConfiguration config = Coffe_Gladiators.getInstance().getConfig();
    public static void tp(Player p, Player ps) {
        World world = Bukkit.getWorld(config.getString("player.pos1.positions.world"));
        double x = config.getDouble("player.pos1.positions.x");
        double y = config.getDouble("player.pos1.positions.y");
        double z = config.getDouble("player.pos1.positions.z");
        World world2 = Bukkit.getWorld(config.getString("player.pos2.positions.world"));
        double x2 = config.getDouble("player.pos2.positions.x");
        double y2 = config.getDouble("player.pos2.positions.y");
        double z2 = config.getDouble("player.pos2.positions.z");

        Location loc2 = new Location(world2, x2, y2, z2);
        Location loc1 = new Location(world, x, y, z);

        BukkitTask task = new BukkitRunnable() {
            @Override
            public void run() {
                p.teleport(loc1);
                ps.teleport(loc2);
            }
        }.runTaskLater(Coffe_Gladiators.getInstance(), 20*15);
    }

}
