package org.drtoasti.mymemorian;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CE_Test implements CommandExecutor {
	
	@SuppressWarnings("unused")
	private MyMemorian plugin;
	
	public CE_Test(MyMemorian mymemorian) {
		plugin = mymemorian;
	}
	
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String args[]) {
		if(cmd.getName().equalsIgnoreCase("test")) {
			if(!(sender instanceof Player)) {
				System.err.println("Dieser Befehl ist nur für Spieler");
				return true;
			}
			Player p = (Player) sender;
			p.setFlying(true);
			p.sendMessage(ChatColor.GREEN + "Test erfolgreich ausgeführt.");
			return true;
		}
		
		return true;
	}

}
