package org.drtoasti.mymemorian.commands;

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.drtoasti.mymemorian.MyMemorian;

public class Command_gladi implements CommandExecutor {
	
	@SuppressWarnings("unused")
	private MyMemorian plugin;
	
	public Command_gladi(MyMemorian mymemorian) {
		plugin = mymemorian;
	}
	
	Random random = new Random();
	ChatColor[] colors = new ChatColor[6];
		
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String [] args) {
		if(cmd.getName().equalsIgnoreCase("gladi")) {
			if(args.length == 0) {
				if(!(sender instanceof Player)) {
					System.out.println("Dieser Befehl ist nur für _gladiator86_");
					return true;
				}
				colors[0] = ChatColor.MAGIC;
				colors[1] = ChatColor.BLUE;
				colors[2] = ChatColor.GOLD;
				colors[3] = ChatColor.DARK_GREEN;
				colors[4] = ChatColor.RED;
				colors[5] = ChatColor.LIGHT_PURPLE;
				int i = 0;
				while(i < 100) {
					int x = random.nextInt(6);
					sender.sendMessage(colors[x] + "kp");
					i++;
				}
				return true;
			}
		}
		return true;
	}

}

