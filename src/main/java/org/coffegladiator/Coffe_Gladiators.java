package org.coffegladiator;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang.enums.Enum;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.coffegladiator.commands.kills.ReloadCommand;
import org.coffegladiator.commands.kills.SoulsCommand;
import org.coffegladiator.commands.upgrade.UpgradeCommand;
import org.coffegladiator.commands.x1.CamaroteTeleport;
import org.coffegladiator.commands.x1.Pos1;
import org.coffegladiator.commands.x1.Pos2;
import org.coffegladiator.commands.x1.SetSpawn;
import org.coffegladiator.commands.desafiar.GladiatorDesafiar;
import org.coffegladiator.database.MongoDBConnection;
import org.coffegladiator.events.*;
import org.coffegladiator.manager.MongoDBUtils;


public class Coffe_Gladiators extends JavaPlugin {
    public static Coffe_Gladiators instance;
    public static Map<UUID, Player> cooldown = new HashMap<>();
    public static Map<UUID, Player> battleplayers = new HashMap<>();
    public static Map<UUID, Player> intime = new HashMap<>();
    public static Map<UUID, Player> top_players = new HashMap<>();
    private MongoDBConnection mongoDBConnection;

    @Override
    public void onEnable() {
        mongoDBConnection = new MongoDBConnection();
        instance=this;
        PluginManager pl = Bukkit.getPluginManager();
        saveDefaultConfig();
        getLogger().info("Plugin habilitado");
        registerCommands();
        registerEvents(pl);
    }
    public void registerCommands() {
        getCommand("setspawn").setExecutor(new SetSpawn());
        getCommand("camarote").setExecutor(new CamaroteTeleport());
        getCommand("desafiar").setExecutor(new GladiatorDesafiar());
        getCommand("pos1").setExecutor(new Pos1());
        getCommand("pos2").setExecutor(new Pos2());
        getCommand("souls").setExecutor(new SoulsCommand());
        getCommand("rl1v1").setExecutor(new ReloadCommand());
        getCommand("upgrade").setExecutor(new UpgradeCommand());
    }
    public void registerEvents(PluginManager pl) {
        pl.registerEvents(new PlayerJoinListener(), this);
        pl.registerEvents(new MoveEventListener(), this);
        pl.registerEvents(new OnDeathListener(), this);
        pl.registerEvents(new DesafioEvent(), this);
        pl.registerEvents(new UpgradeGUIEvent(), this);
    }
    @Override
    public void onDisable () {
        mongoDBConnection.close();
        saveConfig();
        getLogger().info("Plugin desabilitado");
    }

    public static Coffe_Gladiators getInstance() {
        return instance;
    }
}

