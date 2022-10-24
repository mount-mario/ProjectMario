package me.mountmario.projectmario.util.config;

import me.mountmario.projectmario.ProjectMario;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class PlayerManager {

    private ProjectMario plugin;
    private FileConfiguration playerConfig = null;
    private File configFile = null;

    public PlayerManager(ProjectMario plugin) {
        this.plugin = plugin;
        saveDefaultConfig();
    }

    public void reloadConfig() {
        if(this.configFile == null) {
            this.configFile = new File(this.plugin.getDataFolder(), "players.yml");
        }

        this.playerConfig = YamlConfiguration.loadConfiguration(this.configFile);

        InputStream defaultStream = this.plugin.getResource("players.yml");
        if(defaultStream != null) {
            YamlConfiguration defaultConfig = YamlConfiguration.loadConfiguration(new InputStreamReader(defaultStream));
            this.playerConfig.setDefaults(defaultConfig);

        }
    }

    public FileConfiguration getConfig() {
        if (this.playerConfig == null)
            reloadConfig();
        return this.playerConfig;
    }

    public void saveConfig() {
        if (this.playerConfig == null || this.configFile == null) {
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
            this.configFile = new File(this.plugin.getDataFolder(), "players.yml");
        }

        if (!this.configFile.exists()) {
            this.plugin.saveResource("players.yml", false);
        }
    }
}
