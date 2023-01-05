package me.mountmario.projectmario.worldcreator;

import me.mountmario.projectmario.ProjectMario;
import me.mountmario.projectmario.util.config.DataManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.configuration.ConfigurationSection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class wtptab implements TabCompleter {

    DataManager data = new DataManager(ProjectMario.getPlugin());

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
    if (args.length == 1) {
        List<String> options = new ArrayList<>();
        ConfigurationSection worldsSection = data.getConfig().getConfigurationSection("worlds");
        for (String world : worldsSection.getKeys(false)) {
            ConfigurationSection worldSection = worldsSection.getConfigurationSection(world);
            options.add(worldSection.getString("name"));
            System.out.println("" + world.toString());
        }
        return options;
    }
        return null;
    }
}
