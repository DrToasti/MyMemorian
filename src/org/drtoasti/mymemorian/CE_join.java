package org.drtoasti.mymemorian;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CE_join implements CommandExecutor {
	
	private MyMemorian plugin;
	
	public CE_join(MyMemorian mymemorian) {
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
