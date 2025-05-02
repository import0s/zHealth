package org.import_os.zHealth;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class setHunger implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = Bukkit.getPlayer(args[0]);
        if (args.length < 2) {
            sender.sendMessage(ChatColor.RED + "Usage: /sethunger <player> <hunger>");
            return true;
        }
        if (player == null) {
            sender.sendMessage(ChatColor.RED + "Player not found");
            return true;
        }
        int hunger = Integer.parseInt(args[1]);
        if (hunger < 0 || hunger > 20) {
            sender.sendMessage(ChatColor.RED + "The Food level value must be between 0 and 20");
            return true;
        }
        if (args[2].matches("\\d+")) {
            sender.sendMessage(ChatColor.RED + "Usage: /sethunger <player> <hunger>");
            return true;
        }

        player.setFoodLevel(hunger);
        sender.sendMessage(ChatColor.GREEN + "The Food level of " + player.getName() + " has been set to " + hunger);

        return true;
    }
}
