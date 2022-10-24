package me.mountmario.projectmario.skyblock;

import me.mountmario.projectmario.ProjectMario;
import me.mountmario.projectmario.util.config.SkyblockManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;

public class skyblockmenu {

    public SkyblockManager data;

    public void createSbMenu(Player player) {
        this.data = new SkyblockManager(ProjectMario.getPlugin());
        Inventory menu = Bukkit.createInventory(null,54,"skyblock");

        //Create the placeholder item
        ItemStack placeholder = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        //Create the Skyblock Profile
        ItemStack profile = new ItemStack(Material.PLAYER_HEAD);
        ItemMeta profileMeta = profile.getItemMeta();
        SkullMeta skull = (SkullMeta) profileMeta;
        skull.setDisplayName(ChatColor.GREEN + "Your Skyblock Stats");
        ArrayList<String> lore = new ArrayList<String>();
        lore.add(ChatColor.RED + "Health " + ChatColor.WHITE +  data.getConfig().get("players." + player.getUniqueId().toString() + ".health"));
        lore.add(ChatColor.GREEN + "Defense " + ChatColor.WHITE + data.getConfig().get("players." + player.getUniqueId().toString() + ".defense"));
        lore.add(ChatColor.RED  + "Strength " + ChatColor.WHITE +  data.getConfig().get("players." + player.getUniqueId().toString() + ".strength"));
        lore.add(ChatColor.WHITE  + "Speed " + ChatColor.WHITE +  data.getConfig().get("players." + player.getUniqueId().toString() + ".speed"));
        lore.add(ChatColor.BLUE  + "Crit Chance " + ChatColor.WHITE +  data.getConfig().get("players." + player.getUniqueId().toString() + ".critchance"));



        for(int i = 0; i == 54; i++) {
            if (i == 13 || i == 19 || i == 19 || i == 20 || i == 21 || i == 22 || i == 23 || i == 24 || i == 29 || i == 30 || i == 31 || i == 32 || i == 33 || i == 36 || i == 43 || i == 44 || i == 45 || i == 47 || i == 48 || i == 49 || i == 50 || i == 51 || i == 52 || i == 53) {
                return;
            } else {
                menu.setItem(i, placeholder);
            }
        }
    }




















}
