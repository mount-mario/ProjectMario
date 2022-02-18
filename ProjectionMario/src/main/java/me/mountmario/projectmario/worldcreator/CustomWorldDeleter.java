package me.mountmario.projectmario.worldcreator;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CustomWorldDeleter implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender,Command cmd,String label,String[] args) {
        Bukkit.getServer().getWorld(args[0]).getWorldFolder().delete();
        Player p = (Player) sender;
        p.sendMessage(ChatColor.GREEN + "Your world has been deleted.");
        return true;
    }
}
