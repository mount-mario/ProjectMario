package me.mountmario.projectmario.skyblock.commands;

import me.mountmario.projectmario.ProjectMario;
import me.mountmario.projectmario.skyblock.skyblockmenu;
import me.mountmario.projectmario.util.config.SkyblockManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.ArrayList;

public class menucmd implements CommandExecutor {

    public SkyblockManager data;


    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player player = (Player) sender;
        this.data = new SkyblockManager(ProjectMario.getPlugin());
        Inventory menu = Bukkit.createInventory(null, 54, "skyblock");

        //Create the placeholder item
        ItemStack placeholder = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        //Create the Skyblock Profile
        ItemStack profile = new ItemStack(Material.PLAYER_HEAD);
        ItemMeta profileMeta = profile.getItemMeta();
        SkullMeta skull = (SkullMeta) profileMeta;
        skull.setDisplayName(ChatColor.GREEN + "Your Skyblock Stats");
        ArrayList<String> lore = new ArrayList<String>();
        lore.add("  " + ChatColor.RED + "❤ Health " + ChatColor.WHITE + data.getConfig().get("players." + player.getUniqueId().toString() + ".health"));
        lore.add("  " + ChatColor.GREEN + "❈ Defense " + ChatColor.WHITE + data.getConfig().get("players." + player.getUniqueId().toString() + ".defense"));
        lore.add("  " + ChatColor.RED + "❁ Strength " + ChatColor.WHITE + data.getConfig().get("players." + player.getUniqueId().toString() + ".strength"));
        lore.add("  " + ChatColor.WHITE + "✦ Speed " + ChatColor.WHITE + data.getConfig().get("players." + player.getUniqueId().toString() + ".speed"));
        lore.add("  " + ChatColor.BLUE + "☣ Crit Chance " + ChatColor.WHITE + data.getConfig().get("players." + player.getUniqueId().toString() + ".critchance") + "%");
        lore.add("  " + ChatColor.BLUE + "☠ Crit Damage " + ChatColor.WHITE + data.getConfig().get("players." + player.getUniqueId().toString() + ".critdamage") + "%");
        lore.add("  " + ChatColor.AQUA + "✎ Intelligence " + ChatColor.WHITE + data.getConfig().get("players." + player.getUniqueId().toString() + ".intelligence"));
        lore.add("  " + ChatColor.GOLD + "⸕ Mining Speed " + ChatColor.WHITE + data.getConfig().get("players." + player.getUniqueId().toString() + ".miningspeed"));
        lore.add("  " + ChatColor.DARK_AQUA + "α Sea Creature Chance " + ChatColor.WHITE + data.getConfig().get("players." + player.getUniqueId().toString() + ".seachance") + "%");
        lore.add("  " + ChatColor.AQUA + "✯ Magic Find " + ChatColor.WHITE + data.getConfig().get("players." + player.getUniqueId().toString() + ".magicfind"));
        lore.add("  " + ChatColor.LIGHT_PURPLE + "♣ Pet Luck " + ChatColor.WHITE + data.getConfig().get("players." + player.getUniqueId().toString() + ".petluck"));
        lore.add("  " + ChatColor.WHITE  + "❂ True Defense " + ChatColor.WHITE +  data.getConfig().get("players." + player.getUniqueId().toString() + ".truedefense"));
        lore.add("  " + ChatColor.RED  + "⫽ Ferocity " + ChatColor.WHITE +  data.getConfig().get("players." + player.getUniqueId().toString() + ".ferocity"));
        lore.add("  " + ChatColor.RED  + "๑ Ability Damage " + ChatColor.WHITE +  data.getConfig().get("players." + player.getUniqueId().toString() + ".abilitydamage") + "%");
        lore.add("  " + ChatColor.GOLD  + "☘ Mining Fortune " + ChatColor.WHITE +  data.getConfig().get("players." + player.getUniqueId().toString() + ".miningfortune"));
        lore.add("  " + ChatColor.GOLD  + "☘ Farming Fortune " + ChatColor.WHITE +  data.getConfig().get("players." + player.getUniqueId().toString() + ".farmingfortune"));
        lore.add("  " + ChatColor.GOLD  + "☘ Foraging Fortune " + ChatColor.WHITE +  data.getConfig().get("players." + player.getUniqueId().toString() + ".foragingfortune"));
        lore.add("");
        lore.add(ChatColor.YELLOW + "Click to view your profile!");

        skull.setOwner(player.getName());
        skull.setLore(lore);
        profile.setItemMeta(skull);

        for (int i = 0; i <= 53; i++) {
            if (i == 13 || i == 19 || i == 20 || i == 21 || i == 22 || i == 23 || i == 24 || i == 25 || i == 29 || i == 30 || i == 31 || i == 32 || i == 33 ||  i == 36 || i == 43 || i == 44 || i == 45 || i == 47 || i == 48 || i == 49 || i == 50 || i == 51 || i == 52 || i == 53) {

            } else {
                menu.setItem(i, placeholder);
            }
        }
        menu.setItem(13,profile);

        //Skills
        ItemStack skills = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta skillsmeta = skills.getItemMeta();
        lore.clear();
        skillsmeta.setDisplayName(ChatColor.GREEN + "Your Skills");
        lore.add(ChatColor.GRAY + "View your Skill progression and");
        lore.add(ChatColor.GRAY + "rewards.");
        lore.add("");
        lore.add(ChatColor.GOLD + "" +  data.getConfig().get("players." + player.getUniqueId() + ".skills" + ".skillaverage") + " Skill Avg. " + ChatColor.DARK_GRAY + "(non-cosmetic)");
        lore.add("");
        lore.add(ChatColor.YELLOW + "Click to view!");
        skillsmeta.setLore(lore);
        skills.setItemMeta(skillsmeta);
        menu.setItem(19,skills);

        player.openInventory(menu);
        return true;
    }
}
