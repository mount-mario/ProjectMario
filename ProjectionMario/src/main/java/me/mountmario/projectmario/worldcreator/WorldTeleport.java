package me.mountmario.projectmario.worldcreator;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import static org.bukkit.Bukkit.getBannedPlayers;
import static org.bukkit.Bukkit.getServer;

public class WorldTeleport implements CommandExecutor {
    @Override
    public boolean onCommand( CommandSender sender, Command cmd, String label, String[] args) {
        Bukkit.createWorld(new WorldCreator(args[0]));
        Location spawnpoint = getServer().getWorld(args[0]).getSpawnLocation();
        Player player = Bukkit.getPlayer(sender.getName());
        player.teleport(spawnpoint);
        player.sendMessage("Sending you to the world!");
        return false;
    }
}
