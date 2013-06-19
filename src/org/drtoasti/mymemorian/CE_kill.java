package org.drtoasti.mymemorian;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CE_kill implements CommandExecutor {
	
	@SuppressWarnings("unused")
	private MyMemorian plugin;
	public CE_kill(MyMemorian mymemorian) {
		plugin = mymemorian;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("kill")) {
			if(args.length == 0) {
				if(!(sender instanceof Player)) {
					System.out.println("Dieser Befehl ist nur für Spieler..");
				}
				Player p = (Player) sender;
				p.setHealth(0);
			}
		}
		return true;
	}

}
