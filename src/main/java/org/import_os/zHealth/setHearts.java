package org.import_os.zHealth;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class setHearts implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length < 2) {
            sender.sendMessage(ChatColor.RED + "Usage: /setmaxhearths <player> <hearts>");
        }
        Player player = Bukkit.getPlayer(args[0]);
        if (player == null) {
            sender.sendMessage(ChatColor.RED + "Player not found");
            return true;
        }
        if (hearts < 1 || hearts > 100) {
            sender.sendMessage(ChatColor.RED + "The hearts value must be between 1 and 100");
            return true;
        }
        
        int hearts;
        try {
            hearts = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            sender.sendMessage(ChatColor.RED + "Hearts value not valid");
            return true;
        }
        double maxhearts = hearts * 2;
        AttributeInstance attribute = player.getAttribute(Attribute.GENERIC_MAX_HEALTH);
        if (attribute != null) {
            attribute.setBaseValue(maxhearts);
        }
        player.setHealth(Math.min(maxhearts, player.getHealth()));

        sender.sendMessage(org.bukkit.ChatColor.GREEN + "The Hearts amount of " + player.getName() + " has been set to " + maxhearts);
        return true;
    }
}
