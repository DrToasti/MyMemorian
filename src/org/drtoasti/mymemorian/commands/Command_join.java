package org.drtoasti.mymemorian.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.drtoasti.mymemorian.MyMemorian;

public class Command_join implements CommandExecutor {
	
	private MyMemorian plugin;
	
	public Command_join(MyMemorian mymemorian) {
		plugin = mymemorian;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String args[]) {
		if(cmd.getName().equalsIgnoreCase("join")) {
			MyMemorian.TeamHM.put(sender.getName(), args[0]);
			plugin.getServer().broadcastMessage(sender.getName() + ChatColor.AQUA + " ist jetzt in Team "
					+ ChatColor.GREEN + args[0] + "!");
		}
		return true;
	}

}
