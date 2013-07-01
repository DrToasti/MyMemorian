package org.drtoasti.mymemorian;


import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CE_gamemode implements CommandExecutor {
	
	private MyMemorian plugin;
	
	public CE_gamemode(MyMemorian mymemorian) {
		plugin = mymemorian;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String args[]) {
		if(cmd.getName().equalsIgnoreCase("gamemode")) {
			
			Player p = (Player) sender;
			
			if(args.length == 0) {
				if(!(sender instanceof Player)) {
					System.err.println("Dieser Befehl ist nur für Spieler");
					return true;
				}
					p.sendMessage(ChatColor.RED + "Fehler! Gibt /gamemode <GameMode> ein");
					return true;
				}
				
			int mode = Integer.parseInt(args[0]);
			if(args.length == 1 && mode == 0 || args[0].equalsIgnoreCase("survival")) {
				p.setGameMode(GameMode.SURVIVAL);
				p.sendMessage(ChatColor.DARK_GREEN + "GameMode auf " + ChatColor.GOLD + "Survival" + ChatColor.DARK_GREEN
						+ " gesetzt!");
					
				return true;
			}
			else if(args.length == 1 && mode == 1 || args[0].equalsIgnoreCase("creative")) {
				p.setGameMode(GameMode.CREATIVE);
				p.sendMessage(ChatColor.DARK_GREEN + "GameMode auf " + ChatColor.GOLD + "Creative" + ChatColor.DARK_GREEN
						+ " gesetzt!");
				
				return true;
			}
			else if(args.length == 1 && mode == 2 || args[0].equalsIgnoreCase("adventure")) {
				p.setGameMode(GameMode.ADVENTURE);
				p.sendMessage(ChatColor.DARK_GREEN + "GameMode auf " + ChatColor.GOLD + "Adventure" + ChatColor.DARK_GREEN
						+ " gesetzt!");
			}
			
			if(args.length == 2) {
				Player ziel = plugin.getServer().getPlayer(args[1]);
				if(mode == 0 || args[0].equalsIgnoreCase("survival")) {
					ziel.setGameMode(GameMode.SURVIVAL);
					ziel.sendMessage(ChatColor.RED + sender.getName() + ChatColor.DARK_GREEN +
							" hat deine GameMode auf" + ChatColor.GOLD + " Survival " + ChatColor.DARK_GREEN + "gesetzt.");
					sender.sendMessage(ChatColor.DARK_GREEN + "Du hast " + ChatColor.RED + 
							ziel.getName() + ChatColor.DARK_GREEN + "´s GameMode auf " + ChatColor.GOLD + "Survival" +
									ChatColor.DARK_GREEN + " gesetzt.");
					
					return true;
				}
				else if(mode == 1 || args[0].equalsIgnoreCase("creative")) {
					ziel.setGameMode(GameMode.CREATIVE);
					ziel.sendMessage(ChatColor.RED + sender.getName() + ChatColor.DARK_GREEN +
							" hat deine GameMode auf" + ChatColor.GOLD + " Creative " + ChatColor.DARK_GREEN + "gesetzt.");
					sender.sendMessage(ChatColor.DARK_GREEN + "Du hast " + ChatColor.RED + 
							ziel.getName() + ChatColor.DARK_GREEN + "´s GameMode auf" + ChatColor.GOLD + " Creative" +
									ChatColor.DARK_GREEN + " gesetzt.");
					
					return true;
				}
				else if(mode == 2 || args[0].equalsIgnoreCase("adventure")) {
					ziel.setGameMode(GameMode.ADVENTURE);
					ziel.sendMessage(ChatColor.RED + sender.getName() + ChatColor.DARK_GREEN +
							" hat deine GameMode auf" + ChatColor.GOLD +  " Adventure " + ChatColor.DARK_GREEN + "gesetzt.");
					sender.sendMessage(ChatColor.DARK_GREEN + "Du hast " + ChatColor.RED + 
							ziel.getName() + ChatColor.DARK_GREEN + "´s GameMode auf" + ChatColor.GOLD +" Adventure " + 
							ChatColor.DARK_GREEN + "gesetzt.");
					
					return true;
				}
				return true;
			}
		}
		return true;
	}

}
