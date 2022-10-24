package me.mountmario.projectmario.util.config;

import me.mountmario.projectmario.ProjectMario;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class DataManager {

    private ProjectMario plugin;
    private FileConfiguration dataConfig = null;
    private File configFile = null;

    public DataManager(ProjectMario plugin) {
        this.plugin = plugin;
        saveDefaultConfig();
    }

    public void reloadConfig() {
        if(this.configFile == null) {
            this.configFile = new File(this.plugin.getDataFolder(), "worlds.yml");
        }

        this.dataConfig = YamlConfiguration.loadConfiguration(this.configFile);

        InputStream defaultStream = this.plugin.getResource("worlds.yml");
        if(defaultStream != null) {
            YamlConfiguration defaultConfig = YamlConfiguration.loadConfiguration(new InputStreamReader(defaultStream));
            this.dataConfig.setDefaults(defaultConfig);

        }
    }

    public FileConfiguration getConfig() {
        if (this.dataConfig == null)
            reloadConfig();
        return this.dataConfig;
    }

    public void saveConfig() {
        if (this.dataConfig == null || this.configFile == null) {
            return;
        }
        try {
            this.getConfig().save(configFile);
        } catch (IOException e) {
            System.out.println("An error occured! Couldn't save, error code: Luigi");
        }
    }

    public void saveDefaultConfig() {
        if(this.configFile == null) {
            this.configFile = new File(this.plugin.getDataFolder(), "worlds.yml");
        }

        if (!this.configFile.exists()) {
            this.plugin.saveResource("worlds.yml", false);
        }
    }
}
