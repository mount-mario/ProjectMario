package me.mountmario.projectmario.worldcreator;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.WorldType;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static org.bukkit.Bukkit.getLogger;

public class CustomWorldCreator implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            //./wc (name) (worldtype)
            WorldCreator wc = new WorldCreator(args[0]);
            getLogger().info(args[0]);
            getLogger().info(args[1]);
            getLogger().info("Name: " +wc.name());
            switch (args[1]) {
                case "void":
                    getLogger().info("void");
                    wc.generator(new EmptyChunckGenerator());
                    wc.createWorld();
                    break;
                case "flat":
                    wc.environment(World.Environment.NORMAL);
                    wc.type(WorldType.FLAT);
                    wc.createWorld();
                    break;
                case "normal":
                    wc.environment(World.Environment.NORMAL);
                    wc.type(WorldType.NORMAL);
                    wc.createWorld();
                    break;
            }

        }
        return true;
    }
}
