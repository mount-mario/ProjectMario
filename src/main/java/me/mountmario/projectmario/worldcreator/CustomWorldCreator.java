package me.mountmario.projectmario.worldcreator;

import me.mountmario.projectmario.ProjectMario;
import me.mountmario.projectmario.util.config.DataManager;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

import static org.bukkit.Bukkit.getLogger;

public class CustomWorldCreator implements CommandExecutor {

    public DataManager data;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {

            //./wc (name) (worldtype)
            if(args.length == 1) {
                WorldCreator wc = new WorldCreator(args[0]);
                wc.createWorld();
                Player player = (Player) sender;
                assert player != null;
                player.sendMessage(ChatColor.GREEN + "World created!");
                UUID WORLDID =  UUID.randomUUID();
                this.data = new DataManager(ProjectMario.getPlugin());
                this.data.getConfig().set("worlds." + args[0] + ".id",WORLDID.toString());
                this.data.getConfig().set("worlds." + args[0] + ".name", args[0]);
                player.sendMessage("Created a world with id: " + ChatColor.DARK_GRAY + WORLDID);
                this.data.saveConfig();
                return true;
            }
            WorldCreator wc = new WorldCreator(args[0]);
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

        Player player = (Player) sender;
        assert player != null;
        player.sendMessage(ChatColor.GREEN + "World created!");
        UUID WORLDID =  UUID.randomUUID();
        this.data = new DataManager(ProjectMario.getPlugin());
        this.data.getConfig().set("worlds." + args[0] + "",WORLDID.toString());
        player.sendMessage("Created a world with id: " + ChatColor.DARK_GRAY + WORLDID);
        this.data.saveConfig();
        return true;
    }
}
