package org.drtoasti.mymemorian.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.drtoasti.mymemorian.MyMemorian;

public class Command_exp implements CommandExecutor {

	private MyMemorian plugin;
	
	public Command_exp(MyMemorian mymemorian) {
		plugin = mymemorian;
	}
	
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String args[]) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("exp")) {
			if(args.length == 0) {
				p.sendMessage(ChatColor.RED + "Nutze: /exp <level>");
				return true;
			}
			int exp = Integer.parseInt(args[0]);
			if(args.length == 1) {
				p.setLevel(exp);
				p.sendMessage(ChatColor.AQUA + "Du hast " + ChatColor.RED + exp + ChatColor.AQUA + " Level erhalten.");
				return true;
			}
			
			else if(args[1].equalsIgnoreCase("all")) {
				if(plugin.getServer().getOnlinePlayers().length == 0) {
					System.err.println("Fehler! Keiner Spieler online!");
					return true;
				}
				else {
					for(Player pl : plugin.getServer().getOnlinePlayers()) {
						pl.setLevel(exp);
						plugin.getServer().broadcastMessage(ChatColor.YELLOW + "" + sender.getName() + ChatColor.DARK_PURPLE + " hat allen Spielern "
								+ ChatColor.RED + exp + ChatColor.DARK_PURPLE + " Level gegeben.");
						return true;
					}
				}
			}
			
			else if(args.length == 2) {
				 Player ziel = plugin.getServer().getPlayer(args[1]);
				 if(ziel == null) {
					 p.sendMessage(ChatColor.RED + "Spieler nicht gefunden.");
					 return true;
				 }
				 else {
					 ziel.setLevel(exp);
					 ziel.sendMessage(ChatColor.AQUA + "Du hast von " + ChatColor.DARK_PURPLE + sender.getName() + " " +
							 ChatColor.RED + exp + ChatColor.AQUA + " Level bekommen.");
					 sender.sendMessage(ChatColor.AQUA + "Du hast " + ChatColor.DARK_PURPLE + ziel.getName() + " " + ChatColor.RED + exp
							 + ChatColor.AQUA + " Level gegeben.");
					 return true;
				 }
			}
			return true;
		}
		
		
		return true;
	}

}
