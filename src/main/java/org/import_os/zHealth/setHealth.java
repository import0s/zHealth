package org.import_os.zHealth;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class setHealth implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length < 2) {
            sender.sendMessage(ChatColor.RED + "Usage: /sethealth <player> <health>");
        }
        Player player = Bukkit.getPlayer(args[0]);
        if (player == null) {
            sender.sendMessage(ChatColor.RED + "Player not found");
            return true;
        }
        double health = Double.parseDouble(args[1]);
        if (health < 0 || health >player.getMaxHealth()) {
            sender.sendMessage(ChatColor.RED + "The health value must be between 0 and " + player.getMaxHealth());
            return true;
        }

        player.setHealth(health);
        sender.sendMessage(ChatColor.GREEN + "The health of " + player.getName() + " has been set to " + health);

        return true;
    }
}
