package me.mountmario.projectmario.util.config;

import me.mountmario.projectmario.ProjectMario;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class SkyblockManager {

    private ProjectMario plugin;
    private FileConfiguration skyblockConfig = null;
    private File configFile = null;

    public SkyblockManager(ProjectMario plugin) {
        this.plugin = plugin;
        saveDefaultConfig();
    }

    public void reloadConfig() {
        if(this.configFile == null) {
            this.configFile = new File(this.plugin.getDataFolder(), "skyblock.yml");
        }

        this.skyblockConfig = YamlConfiguration.loadConfiguration(this.configFile);

        InputStream defaultStream = this.plugin.getResource("skyblock.yml");
        if(defaultStream != null) {
            YamlConfiguration defaultConfig = YamlConfiguration.loadConfiguration(new InputStreamReader(defaultStream));
            this.skyblockConfig.setDefaults(defaultConfig);

        }
    }

    public FileConfiguration getConfig() {
        if (this.skyblockConfig == null)
            reloadConfig();
        return this.skyblockConfig;
    }

    public void saveConfig() {
        if (this.skyblockConfig == null || this.configFile == null) {
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
            this.configFile = new File(this.plugin.getDataFolder(), "skyblock.yml");
        }

        if (!this.configFile.exists()) {
            this.plugin.saveResource("skyblock.yml", false);
        }
    }
}
