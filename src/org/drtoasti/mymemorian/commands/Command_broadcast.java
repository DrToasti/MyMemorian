package org.drtoasti.mymemorian.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.drtoasti.mymemorian.MyMemorian;

public class Command_broadcast implements CommandExecutor {
	
	@SuppressWarnings("unused")
	private MyMemorian plugin;
	
	public Command_broadcast(MyMemorian mymemorian) {
		plugin = mymemorian;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String args[]) {
		if(cmd.getName().equalsIgnoreCase("broadcast")) {
			Player p = (Player) sender;
			StringBuilder builder = new StringBuilder();
			for (int i = 0; i < args.length; i++) {
				builder.append(args[i]).append(" ");
			}
			
			if(args[0].equalsIgnoreCase("magic")) {
				p.getServer().broadcastMessage(ChatColor.DARK_PURPLE + "[" + ChatColor.BLUE + "BROADCAST" 
						+ ChatColor.DARK_PURPLE + "] " + ChatColor.YELLOW + ChatColor.MAGIC + builder);
				p.getServer().broadcastMessage(ChatColor.DARK_GREEN + "It´s Magic :o");
			}
			
			else if(args.length >= 1) {
				p.getServer().broadcastMessage(ChatColor.DARK_PURPLE + "[" + ChatColor.BLUE + "BROADCAST" 
						+ ChatColor.DARK_PURPLE + "] " + ChatColor.RESET + builder);
				return true;
			}
			
			return true;
		}
		
		return true;
	}

}
