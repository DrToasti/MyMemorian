package org.drtoasti.mymemorian.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.drtoasti.mymemorian.MyMemorian;

public class Command_teamchat implements CommandExecutor {
	
	private MyMemorian plugin;
	
	public Command_teamchat(MyMemorian mymemorian) {
		plugin = mymemorian;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(plugin.getServer().getOnlinePlayers().length == 0) {
			sender.sendMessage(ChatColor.RED + "Selbstgespräche?");
			return true;
		}
		if(args.length == 0) {
			sender.sendMessage(ChatColor.RED + "Sprich dich aus..");
			return true;
		}
		
		String sender_key = sender.getName();
		if(!MyMemorian.TeamHM.containsKey(sender_key)) {
			sender.sendMessage(ChatColor.RED + "Erst ein Team wählen!" + ChatColor.GRAY + "(/join <team>");
			return true;
		}
		String sender_team = MyMemorian.TeamHM.get(sender_key);
		
		StringBuilder nachricht = new StringBuilder();
		for(int i = 0; i < args.length; i++) {
			nachricht.append(args[i]).append(" ");
		}
		
		for(Player p : plugin.getServer().getOnlinePlayers()) {
			String empfaenger_key = p.getName();
			if(MyMemorian.TeamHM.containsKey(empfaenger_key)) {
				String empfaenger_team = MyMemorian.TeamHM.get(empfaenger_key);
				if(sender_team.equalsIgnoreCase(empfaenger_team)) {
					p.sendMessage(ChatColor.BLUE + "[" + ChatColor.AQUA + sender_team + ChatColor.BLUE + "] " 
							+ ChatColor.YELLOW + sender.getName() + " " + ChatColor.AQUA + nachricht);
				}
				
			}
			
		}
		return true;
	}
	

}
