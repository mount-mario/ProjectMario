package me.mountmario.projectmario.worldcreator;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class worldtab implements TabCompleter {
    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
        if (args.length == 2) {
            List<String> worldOptions = new ArrayList<>();
            worldOptions.add("normal");
            worldOptions.add("flat");
            worldOptions.add("void");

            return worldOptions;
        }
        return null;
    }
}
