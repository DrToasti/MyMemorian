package org.drtoasti.mymemorian;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CE_msg implements CommandExecutor {
	
	private MyMemorian plugin;
	
	public CE_msg(MyMemorian mymemorian) {
		plugin = mymemorian;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String args[]) {
		if(cmd.getName().equalsIgnoreCase("msg")) {
			
			if(args.length == 0) {
				sender.sendMessage(ChatColor.RED + "Fehler! Nutze /msg <Name>");
				return true;
			}
			
			Player p = (Player) sender;
			StringBuilder builder = new StringBuilder();
			for (int i = 1; i < args.length; i++) {
				builder.append(args[i]).append(" ");
			}
			
			if(args.length >= 1) {
				Player ziel = plugin.getServer().getPlayer(args[0]);
				if(ziel == null) {
					p.sendMessage(ChatColor.RED + "Spieler nicht gefunden");
				}
				ziel.sendMessage(ChatColor.BLUE + sender.getName() + ChatColor.RESET + ": " + builder.toString());
				sender.sendMessage(ChatColor.BLUE + sender.getName() + ChatColor.RESET + ": " + builder.toString());
				return true;
			}
			return true;
			}

		return true;
	}
	

}
