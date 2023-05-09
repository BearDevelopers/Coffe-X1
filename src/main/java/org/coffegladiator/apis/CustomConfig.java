package config;

import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Set;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class CustomConfig
{
    private int comments;
    private File file;
    private FileConfiguration config;
    
	public CustomConfig(InputStream configStream, File configFile, int comments, JavaPlugin plugin) {
        this.comments = comments;
        this.file = configFile;
        this.config = (FileConfiguration)YamlConfiguration.loadConfiguration(configStream);
    }
    
    public Object get(String path) {
        return this.config.get(path);
    }
    
    public Object get(String path, Object def) {
        return this.config.get(path, def);
    }
    
    public String getString(String path) {
        return this.config.getString(path);
    }
    
    public String getString(String path, String def) {
        return this.config.getString(path, def);
    }
    
    public int getInt(String path) {
        return this.config.getInt(path);
    }
    
    public int getInt(String path, int def) {
        return this.config.getInt(path, def);
    }
    
    public boolean getBoolean(String path) {
        return this.config.getBoolean(path);
    }
    
    public boolean getBoolean(String path, boolean def) {
        return this.config.getBoolean(path, def);
    }
    
    public void createSection(String path) {
        this.config.createSection(path);
    }
    
    public ConfigurationSection getConfigurationSection(String path) {
        return this.config.getConfigurationSection(path);
    }
    
    public long getLong(String path) {
        return this.config.getLong(path);
    }
    
    public double getDouble(String path) {
        return this.config.getDouble(path);
    }
    
    public double getDouble(String path, double def) {
        return this.config.getDouble(path, def);
    }
    
    public float getFloat(String path) {
        return Float.parseFloat(this.getDouble(path) + "");
    }
    
    public List<?> getList(String path) {
        return (List<?>)this.config.getList(path);
    }
    
    public List<?> getList(String path, List<?> def) {
        return (List<?>)this.config.getList(path, def);
    }
    
    public List<String> getStringList(String path) {
        return (List<String>)this.config.getStringList(path);
    }
    
    public boolean contains(String path) {
        return this.config.contains(path);
    }
    
    public void removeKey(String path) {
        this.config.set(path, (Object)null);
    }
    
    public void set(String path, Object value) {
        this.config.set(path, value);
    }
    
    public void set(String path, Object value, String comment) {
        if (!this.config.contains(path)) {
            this.config.set(CustomConfigManager.getPluginName() + "_COMMENT_" + this.comments, (Object)(" " + comment));
            ++this.comments;
        }
        this.config.set(path, value);
    }
    
    public void set(String path, Object value, String[] comment) {
        for (String comm : comment) {
            if (!this.config.contains(path)) {
                this.config.set(CustomConfigManager.getPluginName() + "_COMMENT_" + this.comments, (Object)(" " + comm));
                ++this.comments;
            }
        }
        this.config.set(path, value);
    }
    
    public void setHeader(String[] header) {
        CustomConfigManager.setHeader(this.file, header);
        this.comments = header.length + 2;
        this.reloadConfig();
    }
    
	public void reloadConfig() {
        this.config = (FileConfiguration)YamlConfiguration.loadConfiguration(CustomConfigManager.getConfigContent(this.file));
    }
    
    public void saveConfig() {
        String config = this.config.saveToString();
        CustomConfigManager.saveConfig(config, this.file);
    }
    
    public Set<String> getKeys() {
        return (Set<String>)this.config.getKeys(false);
    }
}
