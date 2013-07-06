package org.drtoasti.mymemorian.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.drtoasti.mymemorian.MyMemorian;

public class Command_kill implements CommandExecutor {
	
	private MyMemorian plugin;
	public Command_kill(MyMemorian mymemorian) {
		plugin = mymemorian;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("kill")) {
			if(args.length == 0) {
				if(!(sender instanceof Player)) {
					System.out.println("Dieser Befehl ist nur für Spieler..");
				}
				Player p = (Player) sender;
				p.setHealth(0.0);
				plugin.getServer().broadcastMessage(ChatColor.RED + p.getName() + ChatColor.DARK_AQUA + " " +
						" hat sich selbst getötet.");
				return true;
			}
			
			if(args[0].equalsIgnoreCase("all")) {
				if(plugin.getServer().getOnlinePlayers().length == 0) {
					System.err.println("Fehler! Kein Spieler online!");
					return true;
				}
				for(Player pl : plugin.getServer().getOnlinePlayers()) {
					pl.setHealth(0.0);
				}
				plugin.getServer().broadcastMessage(ChatColor.RED + sender.getName() + ChatColor.DARK_AQUA + " hat alle Spieler getötet.");
				return true;
			}
			
			if(args.length == 1) {
				Player ziel = plugin.getServer().getPlayer(args[0]);
				if(ziel == null) {
					sender.sendMessage(ChatColor.RED + "Fehler! Spieler nicht gefunden.");
					return false;
				}
				ziel.setHealth(0.0);
				sender.sendMessage(ChatColor.DARK_AQUA + "Du hast " + ChatColor.GREEN + ziel.getName() + 
						ChatColor.DARK_AQUA + " getötet.");
				ziel.sendMessage(ChatColor.DARK_PURPLE + "Du wurdest von " + ChatColor.RED + sender.getName() + 
						ChatColor.DARK_PURPLE + " getötet.");
				return true;
			}
		}
		return false;
	}

}
