package me.mountmario.projectmario;

import me.mountmario.projectmario.worldcreator.CustomWorldCreator;
import me.mountmario.projectmario.worldcreator.CustomWorldDeleter;
import me.mountmario.projectmario.worldcreator.WorldTeleport;
import org.bukkit.plugin.java.JavaPlugin;

public final class ProjectMario extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getCommand("wc").setExecutor(new CustomWorldCreator());
        this.getCommand("wtp").setExecutor(new WorldTeleport());
        this.getCommand("wd").setExecutor(new CustomWorldDeleter());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void loadWorlds() {

    }
}
