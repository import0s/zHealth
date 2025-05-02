package org.import_os.zHealth;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ShowHealth implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = Bukkit.getPlayer(args[0]);
        if (args[0].isEmpty()) {
            sender.sendMessage(ChatColor.RED + "Usage: /showhealth <player>");
            return true;
        }
        if (player == null) {
            sender.sendMessage(ChatColor.RED + "Player not found");
            return true;
        }

        sender.sendMessage(ChatColor.GREEN + "The health of " + player.getName() + " is " + player.getHealth());

        return true;
    }
}
