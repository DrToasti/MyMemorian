package org.drtoasti.mymemorian.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class MainCommand {
	
	public static boolean onCommand(CommandSender sender, Command cmd, String args[]) {
		
		Player p = (Player) sender;
		
		//Ausführen externe Command-Klassen
		
		if(cmd.getName().equalsIgnoreCase("Clearinventory")) {
			return new Command_ClearInventory(cmd, args, p).execute();
		}
		
		return false;
	}
	
}
