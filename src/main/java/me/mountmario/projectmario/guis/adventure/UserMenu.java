package me.mountmario.projectmario.guis.adventure;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.entity.Spider;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.awt.*;
import java.util.ArrayList;

public class UserMenu implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof  Player))
            return false;

        Player player = (Player) sender;


        Inventory menu  = Bukkit.createInventory(null, 45, "Adventure Stats");

        //placeholder item for blank areas
        ItemStack placeholder = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);

        ItemStack playerHead = new ItemStack(Material.PLAYER_HEAD);
        ItemMeta playerHeadMeta = playerHead.getItemMeta();
        SkullMeta skull = (SkullMeta) playerHeadMeta;
        //skull.setDisplayName("Your Statistics");
        skull.displayName(Component.text("Your Stats"));
        skull.setOwningPlayer(player);

        playerHead.setItemMeta(skull);
        //skills item

        ItemStack skillsItem = new ItemStack(Material.DIAMOND_PICKAXE);
        ItemMeta skillsMeta = skillsItem.getItemMeta();

        //skillsMeta.setDisplayName("Your Skills");

        skillsMeta.displayName(Component.text("Skills"));

        ArrayList<String> lore = new ArrayList<String>();

        lore.add("" + ChatColor.GOLD + "This area of the menu contains a");
        lore.add(ChatColor.GOLD + "list of all your skills!");
        lore.add("\n");
        lore.add(ChatColor.LIGHT_PURPLE + "These are useful for fighting in dungeons. Click now for more info.");
        lore.add(ChatColor.LIGHT_PURPLE + "Click now for more info.");
        skillsMeta.setLore(lore);
        lore.clear();

        skillsItem.setItemMeta(skillsMeta);

        //adventures

        ItemStack dungeonsItem = new ItemStack(Material.DIAMOND_SWORD);

        ItemMeta dungeonsMeta = dungeonsItem.getItemMeta();

        //dungeonsMeta.setDisplayName("Adventures");

        dungeonsMeta.displayName(Component.text("Adventures"));

        lore.add(ChatColor.GOLD + "This is your adventure tab, in here you make");
        lore.add(ChatColor.GOLD + "or join an adventure.");
        lore.add("\n");
        lore.add(ChatColor.LIGHT_PURPLE + "This is the main attraction, these allow you");
        lore.add(ChatColor.LIGHT_PURPLE + "you to level up and progress.");

        dungeonsMeta.setLore(lore);
        lore.clear();

        dungeonsItem.setItemMeta(dungeonsMeta);

        //rewards

        ItemStack rewardsItem = new ItemStack(Material.GOLD_INGOT);
        ItemMeta rewardsMeta = rewardsItem.getItemMeta();

        //rewardsMeta.setDisplayName("Rewards");

        rewardsMeta.displayName(Component.text("Rewards"));

        lore.add(ChatColor.GOLD + "All of your rewards in one tab.");
        lore.add("\n");
        lore.add(ChatColor.LIGHT_PURPLE + "Click here to open your rewards.");

        rewardsMeta.setLore(lore);
        lore.clear();

        rewardsItem.setItemMeta(rewardsMeta);

        //rank

        ItemStack rankItem = new ItemStack(Material.BEACON);
        ItemMeta rankMeta = rankItem.getItemMeta();

        //rankMeta.setDisplayName("Rank");

        rankMeta.displayName(Component.text("Rank"));

        lore.add(ChatColor.GOLD + "A rank, an authentic way to progress without paying.");
        lore.add("\n");
        lore.add(ChatColor.LIGHT_PURPLE + "Click here to view your rank!");

        rankMeta.setLore(lore);
        lore.clear();

        rankItem.setItemMeta(rankMeta);

        //previous dungeons

        ItemStack adventuresItem = new ItemStack(Material.WRITABLE_BOOK);
        ItemMeta adventuresMeta = adventuresItem.getItemMeta();



        menu.setItem(0,placeholder);
        menu.setItem(1,placeholder);
        menu.setItem(2,placeholder);
        menu.setItem(3,placeholder);
        menu.setItem(5,placeholder);
        menu.setItem(6,placeholder);
        menu.setItem(7,placeholder);
        menu.setItem(8,placeholder);
        menu.setItem(9,placeholder);
        menu.setItem(10,placeholder);
        menu.setItem(11,placeholder);
        menu.setItem(12,placeholder);
        menu.setItem(13,placeholder);
        menu.setItem(14,placeholder);
        menu.setItem(15,placeholder);
        menu.setItem(16,placeholder);
        menu.setItem(17,placeholder);
        menu.setItem(18,placeholder);
        menu.setItem(21,placeholder);
        menu.setItem(22,placeholder);
        menu.setItem(23,placeholder);
        menu.setItem(26,placeholder);
        menu.setItem(27,placeholder);
        menu.setItem(30,placeholder);
        menu.setItem(31,placeholder);
        menu.setItem(32,placeholder);
        menu.setItem(35,placeholder);
        menu.setItem(36,placeholder);
        menu.setItem(37,placeholder);
        menu.setItem(38,placeholder);
        menu.setItem(39,placeholder);
        menu.setItem(40,placeholder);
        menu.setItem(41,placeholder);
        menu.setItem(42,placeholder);
        menu.setItem(43,placeholder);
        menu.setItem(44,placeholder);

        menu.setItem(4,playerHead);
        menu.setItem(19,skillsItem);
        menu.setItem(20,dungeonsItem);
        menu.setItem(28,rewardsItem);
        menu.setItem(29,rankItem);







        player.openInventory(menu);



        return true;
    }
}