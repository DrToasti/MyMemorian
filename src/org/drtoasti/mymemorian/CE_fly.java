package org.drtoasti.mymemorian;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CE_fly implements CommandExecutor {
	
	private MyMemorian plugin;
	
	private ArrayList <String> flyEnabled = new ArrayList<String>();
	
	public CE_fly(MyMemorian mymemorian) {
		plugin = mymemorian;
	}
	
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String args[]) {
		if(cmd.getName().equalsIgnoreCase("Fly")) {
			if(args.length == 0) {
				if(!(sender instanceof Player)) {
					System.err.println("Dieser Befehl ist nur für Spieler");
					return true;
				}
				Player p = (Player) sender;
				if(flyEnabled.contains(p.getName())) {
					flyEnabled.remove(p.getName());
					p.setAllowFlight(false);
					p.sendMessage(ChatColor.RED + "Fliegen deaktiviert.");
					return true;
				}
				else {
					p.setAllowFlight(true);
					flyEnabled.add(p.getName());
					p.sendMessage(ChatColor.GREEN + "Fliegen aktiviert!");
				}
			}
			
			if(args.length == 1) {
				Player ziel = plugin.getServer().getPlayer(args[0]);
				if(ziel == null) {
					sender.sendMessage(ChatColor.RED + "Spieler nicht gefunden!");
				}
				if(flyEnabled.contains(ziel.getName())) {
					flyEnabled.remove(ziel.getName());
					ziel.setAllowFlight(false);
					sender.sendMessage(ChatColor.DARK_AQUA + ziel.getName() + ChatColor.RED +  
							" kann nun nichtmehr fliegen");
					ziel.sendMessage(ChatColor.DARK_AQUA + sender.getName() + ChatColor.RED + 
							" entfernte dir fliegen");
				}
				else {
					ziel.setAllowFlight(true);
					flyEnabled.add(ziel.getName());
					sender.sendMessage(ChatColor.DARK_AQUA + ziel.getName() + ChatColor.GREEN +  
							" kann nun fliegen");
					ziel.sendMessage(ChatColor.DARK_AQUA + sender.getName() + ChatColor.GREEN + 
							" gab dir fliegen");
				}
						
			}
		}
		
		return true;
	}

}
