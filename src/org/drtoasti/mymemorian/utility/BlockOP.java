package org.drtoasti.mymemorian.utility;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.drtoasti.mymemorian.MyMemorian;

public class BlockOP implements CommandExecutor {
	
	private ArrayList <String> OPList = new ArrayList<String>();
	
	private MyMemorian plugin;
	
	public BlockOP(MyMemorian mymemorian) {
		
		plugin = mymemorian;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String labels, String args[]) {
		
		Player p = (Player) sender;
		
		if(cmd.getName().equalsIgnoreCase("op")) {
			if(sender instanceof Player) {
				sender.sendMessage(ChatColor.RED + "OP aus sicherheitsgründen blockiert!");
				return true;
			}
			if(args.length == 0) {
				sender.sendMessage(ChatColor.RED + "Fehler! Bitte nutze /op <Spieler>");
				
				return true;
			}
			if(args.length == 1) {
				Player ziel = plugin.getServer().getPlayer(args[0]);
				OPList.add(args[0]);
				ziel.setOp(true);
				ziel.sendMessage(ChatColor.DARK_PURPLE + "Du bist nun OP");
				return true;
			}
			
			return true;
		}
		
		//Um den Spieler OP wieder zu nehmen
		if(cmd.getName().equalsIgnoreCase("deop")) {
			if(args.length == 0 && !(sender instanceof Player)) {//wenn der Befehl ohne Argument von der Konsole ausgeführt wird.
				System.out.println("Der Konsole ist es nicht erlaubt diesen Befehl so zu benutzen!");
				return true;
			}
			else if(args.length == 0 && sender instanceof Player && OPList.contains(sender)) {
				p.setOp(false);
				p.sendMessage(ChatColor.DARK_PURPLE + "Du bist nun nichtmehr OP"); 
				return true;
			}
			
			if(args.length == 1) {
				Player ziel = plugin.getServer().getPlayer(args[0]);
				if(ziel == null) {
					
					p.sendMessage(ChatColor.RED + "Spieler nicht gefunden!");
					return true;
				}
				if(OPList.contains(args[0])) {
					OPList.remove(args[0]);
					ziel.setOp(false);
					ziel.sendMessage(ChatColor.DARK_PURPLE + "Du bist nun nichtmehr OP");
					
					return true;
				}
				else if(!(OPList.contains(args[0]))) {
					sender.sendMessage(ChatColor.RED + "Fehler! Der Spieler ist nicht OP!");
					return true;
				}
			}
			
			return true;
		}
		
		return true;
	}

}