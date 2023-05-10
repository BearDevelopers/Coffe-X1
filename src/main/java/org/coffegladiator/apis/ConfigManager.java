package org.coffegladiator.apis;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.coffegladiator.Coffe_Gladiators;


public class ConfigManager {

	public static void createConfig(String file) {
		if (!new File(Coffe_Gladiators.getInstance().getDataFolder(), file + ".yml").exists()) {
			Coffe_Gladiators.getInstance().saveResource(file + ".yml", false);
		}
	}
	
	public static FileConfiguration getConfig(String file) {
		try {
			File arquivo = new File(Coffe_Gladiators.getInstance().getDataFolder() + File.separator + "kills.yml");
			return (FileConfiguration) YamlConfiguration.loadConfiguration(arquivo);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}