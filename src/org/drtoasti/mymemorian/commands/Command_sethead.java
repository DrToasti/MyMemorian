package org.drtoasti.mymemorian.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.drtoasti.mymemorian.MyMemorian;

public class Command_sethead implements CommandExecutor {
	
	@SuppressWarnings("unused")
	private MyMemorian plugin;
	
	public Command_sethead(MyMemorian mymemorian) {
		plugin = mymemorian;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String args[]) {
		
		if(cmd.getName().equalsIgnoreCase("sethead")) {
			if(args.length == 0) {
				if(!(sender instanceof Player)) {
					System.out.println("Dieser Befehl ist nur für Spieler!");
					
					return false;
				}
				Player p = (Player) sender;
				p.getEquipment().setHelmet(p.getItemInHand());
				p.setItemInHand(null);
				p.sendMessage(ChatColor.GREEN + "Block wurde aufgestzt!");
				return true;
				
			}
		}
		return true;
	}
}
