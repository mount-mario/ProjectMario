package me.mountmario.projectmario.worldcreator;

import me.mountmario.projectmario.ProjectMario;
import me.mountmario.projectmario.util.config.DataManager;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;


import static org.bukkit.Bukkit.getBannedPlayers;
import static org.bukkit.Bukkit.getServer;

public class WorldTeleport implements CommandExecutor {
    public DataManager data;
    @Override
    public boolean onCommand( CommandSender sender, Command cmd, String label, String[] args) {
        this.data = new DataManager(ProjectMario.getPlugin());
        if (this.data.getConfig().contains("worlds." + args[0])) {
            Bukkit.createWorld(new WorldCreator(args[0]));
            Location spawnpoint = getServer().getWorld(args[0]).getSpawnLocation();
            Player player = Bukkit.getPlayer(sender.getName());
            player.teleport(spawnpoint);
            //player.sendMessage(ChatColor.GREEN + "Sending you to the world " + args[0] + " " + ChatColor.DARK_GRAY +  "(" + this.data.getConfig().get("worlds." + args[0]) + ").");
            player.performCommand("tellraw @p [\"\",{\"text\":\"Sending you to world " + args[0] + "\",\"color\":\"green\"},{\"text\":\"("+ this.data.getConfig().get("worlds." + args[0]) + ")\",\"color\":\"dark_gray\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"" + this.data.getConfig().get("worlds." + args[0]) + "\"},\"hoverEvent\":{\"action\":\"show_text\",\"contents\":[{\"text\":\"" + this.data.getConfig().get("worlds." + args[0]) + "\",\"italic\":true,\"color\":\"dark_gray\"}]}}]");
            return true;
        }
        Player player = (Player) sender;
        player.performCommand("tellraw @p [\"\",{\"text\":\"That world doesn't exist!\",\"color\":\"dark_red\"},{\"text\":\" [CREATE]\",\"color\":\"dark_green\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"/wc " + args[0] + "\"},\"hoverEvent\":{\"action\":\"show_text\",\"contents\":[{\"text\":\"Click to create the world!\",\"color\":\"dark_green\"}]}}]");
        return true;
    }
}
