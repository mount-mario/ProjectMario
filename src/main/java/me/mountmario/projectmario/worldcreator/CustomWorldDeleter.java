package me.mountmario.projectmario.worldcreator;

import me.mountmario.projectmario.ProjectMario;
import me.mountmario.projectmario.util.config.DataManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.FileUtil;
import org.jetbrains.annotations.NotNull;

import javax.xml.crypto.Data;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

public class CustomWorldDeleter implements CommandExecutor {
    public DataManager data;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (Bukkit.getWorld(args[0]) != null) {
            World deletionWorld = Bukkit.getWorld(args[0]);
            for(Player player : deletionWorld.getPlayers()) {

                Location location = new Location(Bukkit.getWorld("world"),Bukkit.getWorld("world").getSpawnLocation().getX(), Bukkit.getWorld("world").getSpawnLocation().getY(), Bukkit.getWorld("world").getSpawnLocation().getZ());
                player.teleport(location);
                player.sendMessage(ChatColor.RED + "The world you were in has been deleted! You have been teleported to a safe spot!");
            }
        }
        Bukkit.unloadWorld(args[0], false);
        String directory = "C:/Users/Tyler/Desktop/TylerSMP/Creative" + args[0];
        File worldDir = new File(directory);
        deleteDirectory(worldDir);
        String directory1 = "C:/Users/Tyler/Desktop/TylerSMP/Creative" + args[0];
        File test = new File(directory1);
        test.delete();
        Player p = (Player) sender;
        p.sendMessage(ChatColor.GREEN + "Your world has been deleted.");
        data = new DataManager(ProjectMario.getPlugin());
        this.data.getConfig().set("worlds." + args[0], "DELETED");
        return true;
    }

    // function to delete subdirectories and files
    public static void deleteDirectory(File file) {
        // store all the paths of files and folders present
        // inside directory
        for (File subfile : file.listFiles()) {

            // if it is a subfolder,e.g Rohan and Ritik,
            // recursiley call function to empty subfolder
            if (subfile.isDirectory()) {
                deleteDirectory(subfile);
            }

            // delete files and empty subfolders
            subfile.delete();
        }
    }
}
