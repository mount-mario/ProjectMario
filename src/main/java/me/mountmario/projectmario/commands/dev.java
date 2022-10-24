package me.mountmario.projectmario.commands;

import me.mountmario.projectmario.ProjectMario;
import me.mountmario.projectmario.util.config.SkyblockManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class dev implements CommandExecutor {

    public SkyblockManager data;
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player player = (Player) sender;
        if (args.length == 0) {
            player.sendMessage(ChatColor.RED + "Please have at least 1 argument, if you need syntax do /help dev.");
        } else if (args.length == 1) {
            if (args[0] == "restart" || args[0] == "reload") {
                ProjectMario plugin = ProjectMario.getPlugin();
                plugin.getServer().reload();
            }
            if (args[0] == "disable" || args[0] == "off") {
                ProjectMario plugin = ProjectMario.getPlugin();
                player.sendMessage(ChatColor.GREEN + "Disabling the plugin!");
                Bukkit.getPluginManager().disablePlugin(plugin);
            }
        } else if(args.length == 5) {
            if (args[0] == "sb" && args[1] == "yml") {
                // /dev sb yml mountmario skillaverage 2
                this.data = new SkyblockManager(ProjectMario.getPlugin());
                Player actionuser = Bukkit.getPlayer(args[2]);
                this.data.getConfig().set("players." + actionuser.getUniqueId().toString() + "." + args[3], args[4]);
            }
        } else if (args.length == 6) {
            this.data = new SkyblockManager(ProjectMario.getPlugin());
            Player actionuser = Bukkit.getPlayer(args[2]);
            this.data.getConfig().set("players." + actionuser.getUniqueId().toString() + "." + args[3] + "." + args[4], args[5]);
        }

        return true;
    }
}
