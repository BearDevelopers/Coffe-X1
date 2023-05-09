package org.coffegladiator;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import org.coffegladiator.manager.ConfigManager;

public class Coffe_Gladiators extends JavaPlugin {
    public static JDA jda;

    @Override
    public void onEnable() {
        try {
            jda = JDABuilder.createDefault("MTAxNzQyMzE2MDQ2OTEwNjc2OQ.GNyaRo.GSFODlLDz2FBv-kHoie7s7tpuc6pG2EWR_6zLQ")
                    .setStatus(OnlineStatus.DO_NOT_DISTURB)
                    .setActivity(Activity.playing("Trabalhando Em melhorar nossos plugins!"))
                    .build();
            jda.awaitReady();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDisable () {
        saveConfig();
        getLogger().info("Plugin desabilitado");
        }
    }
}
