package me.mountmario.projectmario.worldcreator;

import me.mountmario.projectmario.ProjectMario;
import me.mountmario.projectmario.util.config.DataManager;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class WorldList implements CommandExecutor {
    public DataManager data;
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        this.data = new DataManager(ProjectMario.getPlugin());
        Player player = (Player) sender;
        List<String> worlds = new ArrayList<>();
        for (final String world : data.getConfig().getConfigurationSection("worlds").getKeys(false)) {
            worlds.add(world);
        }
        player.sendMessage("" + ChatColor.GREEN + worlds);
        return true;
    }
}
