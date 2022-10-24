package me.mountmario.projectmario;

import me.mountmario.projectmario.commands.dev;
import me.mountmario.projectmario.commands.lobby;
import me.mountmario.projectmario.commands.smp;
import me.mountmario.projectmario.guis.ServerGUI;
import me.mountmario.projectmario.skyblock.commands.menucmd;
import me.mountmario.projectmario.util.config.DataManager;
import me.mountmario.projectmario.util.config.PlayerManager;
import me.mountmario.projectmario.util.config.SkyblockManager;
import me.mountmario.projectmario.worldcreator.CustomWorldCreator;
import me.mountmario.projectmario.worldcreator.CustomWorldDeleter;
import me.mountmario.projectmario.worldcreator.WorldList;
import me.mountmario.projectmario.worldcreator.WorldTeleport;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.WorldCreator;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.messaging.PluginMessageListener;
import org.jetbrains.annotations.NotNull;

public final class ProjectMario extends JavaPlugin implements PluginMessageListener, Listener {

    public static ProjectMario plugin;

    public DataManager data;
    public PlayerManager pdata;
    public SkyblockManager sbdata;
    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getCommand("wc").setExecutor(new CustomWorldCreator());
        this.getCommand("wtp").setExecutor(new WorldTeleport());
        this.getCommand("wd").setExecutor(new CustomWorldDeleter());
        this.getCommand("smp").setExecutor(new smp());
        this.getCommand("creative").setExecutor(new lobby());
        Bukkit.getServer().getPluginManager().registerEvents(this,this);
        this.getCommand("menu").setExecutor(new ServerGUI());
        this.getCommand("wlist").setExecutor(new WorldList());
        this.getCommand("sbmenu").setExecutor(new menucmd());
        this.getCommand("dev").setExecutor(new dev());
        plugin = this;
        getServer().getMessenger().registerOutgoingPluginChannel(this,"BungeeCord");

        this.data = new DataManager(this);
        this.pdata = new PlayerManager(this);
        this.sbdata = new SkyblockManager(this);
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
                case 16:
                    p.sendMessage(ChatColor.RED + "" + "That server doesn't exist!");
                    break;

            }
        }
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        if (!this.pdata.getConfig().contains("players." +player.getUniqueId().toString())) {
            this.pdata.getConfig().set("players.", player.getUniqueId().toString());
            this.pdata.saveConfig();
        } else {
            Location location = new Location(Bukkit.getWorld(this.pdata.getConfig().get("players." + player.getUniqueId().toString() + ".logoutWorld").toString()), this.pdata.getConfig().getDouble("players." + player.getUniqueId() + ".logoutx"),pdata.getConfig().getDouble("players." + player.getUniqueId() + ".logoutY"),pdata.getConfig().getDouble("players." + player.getUniqueId() + ".logoutZ"));
            Bukkit.createWorld(new WorldCreator(this.pdata.getConfig().get("players." + player.getUniqueId().toString() + ".logoutWorld").toString()));
            player.teleport(location);
        }
        if (!this.sbdata.getConfig().contains("players." + player.getUniqueId().toString())) {
            this.sbdata.getConfig().set("players." + player.getUniqueId().toString() + ".health", 100);
            this.sbdata.getConfig().set("players." + player.getUniqueId().toString() + ".defense", 100);
            this.sbdata.getConfig().set("players." + player.getUniqueId().toString() + ".strength", 100);
            this.sbdata.getConfig().set("players." + player.getUniqueId().toString() + ".speed", 100);
            this.sbdata.getConfig().set("players." + player.getUniqueId().toString() + ".critchance", 30);
            this.sbdata.getConfig().set("players." + player.getUniqueId().toString() + ".critdamage", 100);
            this.sbdata.getConfig().set("players." + player.getUniqueId().toString() + ".intelligence", 100);
            this.sbdata.getConfig().set("players." + player.getUniqueId().toString() + ".miningspeed",100);
            this.sbdata.getConfig().set("players." + player.getUniqueId().toString() + ".seachance", 10);
            this.sbdata.getConfig().set("players." + player.getUniqueId().toString() + ".magicfind", 100);
            this.sbdata.getConfig().set("players." + player.getUniqueId().toString() + ".petluck", 10);
            this.sbdata.getConfig().set("players." + player.getUniqueId().toString() + ".truedefense", 10);
            this.sbdata.getConfig().set("players." + player.getUniqueId().toString() + ".ferocity", 0);
            this.sbdata.getConfig().set("players." + player.getUniqueId().toString() + ".abilitydamage", 10);
            this.sbdata.getConfig().set("players." + player.getUniqueId().toString() + ".miningfortune", 100);
            this.sbdata.getConfig().set("players." + player.getUniqueId().toString() + ".farmingfortune", 100);
            this.sbdata.getConfig().set("players." + player.getUniqueId().toString() + ".foragingfortune", 100);
            this.sbdata.getConfig().set("players." + player.getUniqueId().toString() + ".skills" + ".skillaverage" , 1);
            this.sbdata.saveConfig();
        }

    }

    @EventHandler
    public void onLeave(PlayerQuitEvent e) {
        Player player = e.getPlayer();
        this.pdata.getConfig().set("players." + player.getUniqueId().toString() + ".logoutWorld", player.getLocation().getWorld().getName());
        this.pdata.getConfig().set("players." + player.getUniqueId().toString() + ".logoutX", player.getLocation().getX());
        this.pdata.getConfig().set("players." + player.getUniqueId().toString() + ".logoutY", player.getLocation().getY());
        this.pdata.getConfig().set("players." + player.getUniqueId().toString() + ".logoutZ", player.getLocation().getZ());
        this.pdata.saveConfig();
    }
}
