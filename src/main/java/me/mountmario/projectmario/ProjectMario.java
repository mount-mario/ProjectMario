package me.mountmario.projectmario;

import me.mountmario.projectmario.guis.adventure.UserMenu;
import me.mountmario.projectmario.util.config.DataManager;
import me.mountmario.projectmario.util.config.PlayerManager;
import me.mountmario.projectmario.worldcreator.*;
import net.kyori.adventure.text.Component;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class ProjectMario extends JavaPlugin implements Listener {

    public static ProjectMario plugin;

    public DataManager data;
    public PlayerManager pdata;
    @Override
    public void onEnable() {
        plugin = this;
        this.data = new DataManager(this);
        // Plugin startup logic
        this.getCommand("wc").setExecutor(new CustomWorldCreator());
        this.getCommand("wc").setTabCompleter(new worldtab());
        this.getCommand("wtp").setExecutor(new WorldTeleport());
        this.getCommand("wtp").setTabCompleter(new wtptab());
        this.getCommand("wd").setExecutor(new CustomWorldDeleter());
        Bukkit.getServer().getPluginManager().registerEvents(this,this);
        this.getCommand("wlist").setExecutor(new WorldList());
        this.getCommand("menu").setExecutor(new UserMenu());
        getServer().getMessenger().registerOutgoingPluginChannel(this,"BungeeCord");

        this.pdata = new PlayerManager(this);
    }

    @Override
    public void onDisable() {
        for(Player player : Bukkit.getOnlinePlayers()){
            this.pdata.getConfig().set("players." + player.getUniqueId().toString() + ".logoutWorld", player.getLocation().getWorld().getName());
            this.pdata.getConfig().set("players." + player.getUniqueId().toString() + ".logoutX", player.getLocation().getX());
            this.pdata.getConfig().set("players." + player.getUniqueId().toString() + ".logoutY", player.getLocation().getY());
            this.pdata.getConfig().set("players." + player.getUniqueId().toString() + ".logoutZ", player.getLocation().getZ());
            this.pdata.saveConfig();
            player.kick(Component.text(ChatColor.RED + "This server has been stopped or the Project Mario plugin has been disabled.\n\n" + ChatColor.GREEN + "If you belive something is wrong please contact TTTyler, Wither_Builder13, or minegear.fox. If we aren't available, use our discord server (LINK)"));
        }

    }

    public static ProjectMario getPlugin() {
        return plugin;
    }


    @EventHandler
    public void onPlayerKick(PlayerKickEvent e) {
        Player player = e.getPlayer();
        this.pdata.getConfig().set("players." + player.getUniqueId().toString() + ".logoutWorld", player.getLocation().getWorld().getName());
        this.pdata.getConfig().set("players." + player.getUniqueId().toString() + ".logoutX", player.getLocation().getX());
        this.pdata.getConfig().set("players." + player.getUniqueId().toString() + ".logoutY", player.getLocation().getY());
        this.pdata.getConfig().set("players." + player.getUniqueId().toString() + ".logoutZ", player.getLocation().getZ());
        this.pdata.getConfig().set("players." + player.getUniqueId().toString() + ".logoutYaw", player.getLocation().getYaw());
        this.pdata.getConfig().set("players." + player.getUniqueId().toString() + ".logoutPitch", player.getLocation().getPitch());
        this.pdata.saveConfig();
    }

    @EventHandler
    public void OnInventoryClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();

        //e.getClickedInventory()

        if(e.getView().getTitle().equals("Adventure Stats")) {
            e.setCancelled(true);

            switch (e.getSlot()) {
                case 19:
                    p.sendMessage(ChatColor.GREEN + "You selected skills! Unfortunately we haven't finished this page yet! Check back another time to see if it is finished!");
                    p.closeInventory();
                    break;
                case 20:
                    p.sendMessage(ChatColor.GREEN + "You selected adventures! Unfortunately we haven't finished this page yet! Check back another time to see if it is finished!");
                    p.closeInventory();
                    break;
                case 28:
                    p.sendMessage(ChatColor.GREEN + "You selected rewards! Unfortunately we haven't finished this page yet! Check back another time to see if it is finished!");
                    p.closeInventory();
                    break;
                case 29:
                    p.sendMessage(ChatColor.GREEN + "You selected rank! Unfortunately we haven't finished this page yet! Check back another time to see if it is finished!");
                    p.closeInventory();
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
            World world = Bukkit.createWorld(new WorldCreator(this.pdata.getConfig().get("players." + player.getUniqueId().toString() + ".logoutWorld").toString()));
            Location location = new Location(world, this.pdata.getConfig().getDouble("players." + player.getUniqueId() + ".logoutX"),pdata.getConfig().getDouble("players." + player.getUniqueId() + ".logoutY"),pdata.getConfig().getDouble("players." + player.getUniqueId() + ".logoutZ"), pdata.getConfig().getLong("players." + player.getUniqueId() + ".logoutYaw"),  pdata.getConfig().getLong("players." + player.getUniqueId() + ".logoutPitch"));
            player.teleport(location);
        }
    }

    @EventHandler
    public void onLeave(PlayerQuitEvent e) {
        Player player = e.getPlayer();
        this.pdata.getConfig().set("players." + player.getUniqueId().toString() + ".logoutWorld", player.getLocation().getWorld().getName());
        this.pdata.getConfig().set("players." + player.getUniqueId().toString() + ".logoutX", player.getLocation().getX());
        this.pdata.getConfig().set("players." + player.getUniqueId().toString() + ".logoutY", player.getLocation().getY());
        this.pdata.getConfig().set("players." + player.getUniqueId().toString() + ".logoutZ", player.getLocation().getZ());
        this.pdata.getConfig().set("players." + player.getUniqueId().toString() + ".logoutYaw", player.getLocation().getYaw());
        this.pdata.getConfig().set("players." + player.getUniqueId().toString() + ".logoutPitch", player.getLocation().getPitch());
        this.pdata.saveConfig();
    }
}
