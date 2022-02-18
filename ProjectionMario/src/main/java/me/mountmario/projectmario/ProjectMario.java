package me.mountmario.projectmario;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;
import me.mountmario.projectmario.commands.lobby;
import me.mountmario.projectmario.commands.smp;
import me.mountmario.projectmario.guis.ServerGUI;
import me.mountmario.projectmario.worldcreator.CustomWorldCreator;
import me.mountmario.projectmario.worldcreator.CustomWorldDeleter;
import me.mountmario.projectmario.worldcreator.WorldTeleport;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.messaging.PluginMessageListener;
import org.jetbrains.annotations.NotNull;

public final class ProjectMario extends JavaPlugin implements PluginMessageListener, Listener {

    public static ProjectMario plugin;

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getCommand("wc").setExecutor(new CustomWorldCreator());
        this.getCommand("wtp").setExecutor(new WorldTeleport());
        this.getCommand("wd").setExecutor(new CustomWorldDeleter());
        this.getCommand("smp").setExecutor(new smp());
        this.getCommand("lobby").setExecutor(new lobby());
        Bukkit.getServer().getPluginManager().registerEvents(this,this);
        this.getCommand("menu").setExecutor(new ServerGUI());
        plugin = this;
        getServer().getMessenger().registerOutgoingPluginChannel(this,"BungeeCord");
    }

    @Override
    public void onDisable() {

    }

    public void loadWorlds() {

    }

    public static ProjectMario getPlugin() {
        return plugin;
    }

    @Override
    public void onPluginMessageReceived(@NotNull String channel, @NotNull Player player, @NotNull byte[] message) {

    }

    @EventHandler
    public void OnInventoryClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();

        if(e.getView().getTitle().equals("menu")) {
            e.setCancelled(true);

            switch (e.getSlot()) {
                case 10:
                    p.performCommand("lobby");
                    break;
                case 12:
                    p.performCommand("smp");
                    break;
                case 14:
                    p.sendMessage(ChatColor.RED + "" + "That server doesn't exist!");
                    break;
                case 16:
                    p.sendMessage(ChatColor.RED + "" + "That server doesn't exist!");
                    break;

            }
        }
    }
}
