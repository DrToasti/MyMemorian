package org.drtoasti.mymemorian;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CE_heal implements CommandExecutor {

	private MyMemorian plugin;

	public CE_heal(MyMemorian mymemorian) {
		plugin = mymemorian;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if (cmd.getName().equalsIgnoreCase("heal")) {
			if (args.length == 0) {
				if (!(sender instanceof Player)) {
					System.out.println("Dieser Befehl ist nur für Spieler!");
					return true;
				}
				sender.sendMessage(ChatColor.RED + "Fehler!");
				sender.sendMessage(ChatColor.RED + "Für Hilfe gib /heal help ein");
				return true;
			}
			if(args.length > 1 && args[0].equalsIgnoreCase("help")) {
				sender.sendMessage(ChatColor.GREEN + "Benutzung:" + ChatColor.RED + " /heal <life|food>" + ChatColor.GREEN
						+ " heilt sein Leben oder Essen");
				sender.sendMessage(ChatColor.GREEN + "Benutzung:" + ChatColor.RED + " /heal <life|food> all" + ChatColor.GREEN
						+ " heilt Leben oder Essen von allen");
				sender.sendMessage(ChatColor.GREEN + "Benutzung:" + ChatColor.RED  + " /heal <life|food> <Name>" + ChatColor.GREEN
						+ " heilt Leben oder Essen eines anderen Spielers.");
				return true;
			}
			
			if(args[0].equalsIgnoreCase("life")) {
					Player p = (Player) sender;
					p.setHealth(20);
					p.sendMessage(ChatColor.GOLD + "Du wurdest geheilt :)");
				
					if (args.length > 1 && args[1].equalsIgnoreCase("all")) {
						if (plugin.getServer().getOnlinePlayers().length == 0) {
							System.out.println("Langeweile? Kein Spieler online");
							return false;
						}
						for (Player pl : plugin.getServer().getOnlinePlayers()) {
							pl.setHealth(20);
						}
						plugin.getServer().broadcastMessage(
								ChatColor.RED + sender.getName() + ChatColor.GREEN
										+ " hat alle Spieler geheilt!");
						return true;
					}
					if (args.length == 2) {
						Player ziel = plugin.getServer().getPlayer(args[1]);
						if (ziel == null) {
							sender.sendMessage(ChatColor.RED
									+ "Heilung fehlgeschlagen! Spieler nicht gefunden!");
							return false;
						}
						ziel.setHealth(20);
						ziel.sendMessage(ChatColor.GREEN + "Du wurdest von "
								+ ChatColor.RED + sender.getName() + ChatColor.GREEN
								+ " geheilt!");
						return true;
					}
					return true;
				}
				
				if(args[0].equalsIgnoreCase("food")) {
					Player p = (Player) sender;
					p.setFoodLevel(20);
					p.sendMessage(ChatColor.DARK_AQUA + "Du wurdest geheilt :)");
					
					if(args.length > 1 && args[1].equalsIgnoreCase("all")) {
						if(plugin.getServer().getOfflinePlayers().length == 0) {
							System.out.println("Langeweile? Kein Spieler ist online.");
							return false;
						}
						for(Player pl : plugin.getServer().getOnlinePlayers()) {
							pl.setFoodLevel(20);
						}
						plugin.getServer().broadcastMessage(ChatColor.RED + sender.getName() + 
								ChatColor.DARK_AQUA + " hat alle Spieler geheilt");
						return true;
					}
					if(args.length == 2) {
						Player ziel = plugin.getServer().getPlayer(args[1]);
						if (ziel == null) {
							sender.sendMessage(ChatColor.RED
									+ "Heilung fehlgeschlagen! Spieler nicht gefunden!");
							return false;
						}
						ziel.setFoodLevel(20);
						ziel.sendMessage(ChatColor.DARK_AQUA + "Du wurdest von " + ChatColor.RED +
								ziel.getName() + ChatColor.DARK_AQUA + " geheilt!");
						return true;
					}
					return true;
				}
			
			}
		

		return false;
	}

}
