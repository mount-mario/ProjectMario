package me.mountmario.projectmario.guis;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class ServerGUI implements CommandExecutor {
    @Override
    public boolean onCommand( CommandSender sender,  Command command,  String label,  String[] args) {
        Inventory inv = Bukkit.createInventory(null,27, "menu");

        ItemStack server1 = new ItemStack(Material.ORANGE_CONCRETE);

        ItemMeta metaServer1 = server1.getItemMeta();
        ArrayList<String> lore = new ArrayList<String>();

        metaServer1.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        server1.setItemMeta(metaServer1);
        lore.add("Connect to the Creative server!");

        metaServer1.setLore(lore);
        metaServer1.setDisplayName("Creative");

        server1.setItemMeta(metaServer1);
        inv.setItem(10,server1);

        lore.clear();
        ///////////////////////////////////////
        ItemStack server2 = new ItemStack(Material.CYAN_CONCRETE);

        ItemMeta metaServer2 = server2.getItemMeta();

        metaServer2.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        server2.setItemMeta(metaServer2);
        lore.add("Connect to the SMP server!");

        metaServer2.setLore(lore);
        metaServer2.setDisplayName("SMP");

        server2.setItemMeta(metaServer2);
        inv.setItem(12,server2);
        lore.clear();
        //

        ItemStack server3 = new ItemStack(Material.GRAY_CONCRETE);

        ItemMeta metaServer3 = server3.getItemMeta();

        metaServer3.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        server3.setItemMeta(metaServer3);
        lore.add("This server doesn't exist!");

        metaServer3.setLore(lore);
        metaServer3.setDisplayName("N/A");

        server3.setItemMeta(metaServer3);
        inv.setItem(14,server3);
        lore.clear();
        //
        ItemStack server4 = new ItemStack(Material.GRAY_CONCRETE);

        ItemMeta metaServer4 = server4.getItemMeta();

        metaServer4.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        server4.setItemMeta(metaServer4);
        lore.add("This server doesn't exist!");

        metaServer4.setLore(lore);
        metaServer4.setDisplayName("N/A");

        server4.setItemMeta(metaServer4);
        inv.setItem(16,server4);

        //
        // PLACEHOLDER
        //

        ItemStack placeholder = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);

        inv.setItem(0,placeholder);
        inv.setItem(1,placeholder);
        inv.setItem(2,placeholder);
        inv.setItem(3,placeholder);
        inv.setItem(4,placeholder);
        inv.setItem(5,placeholder);
        inv.setItem(6,placeholder);
        inv.setItem(7,placeholder);
        inv.setItem(8,placeholder);
        inv.setItem(9,placeholder);
        inv.setItem(11,placeholder);
        inv.setItem(13,placeholder);
        inv.setItem(15,placeholder);
        inv.setItem(17,placeholder);
        inv.setItem(18,placeholder);
        inv.setItem(19,placeholder);
        inv.setItem(20,placeholder);
        inv.setItem(21,placeholder);
        inv.setItem(22,placeholder);
        inv.setItem(23,placeholder);
        inv.setItem(24,placeholder);
        inv.setItem(25,placeholder);
        inv.setItem(26,placeholder);

        Player player = (Player) sender;
        player.openInventory(inv);

        return true;
    }

}
