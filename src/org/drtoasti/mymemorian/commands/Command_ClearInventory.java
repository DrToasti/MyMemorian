package org.drtoasti.mymemorian.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

public class Command_ClearInventory {
	
	Command cmd;
	String[] args;
	Player p;
	
	public Command_ClearInventory(Command cmd, String[] args, Player p) {
		this.cmd = cmd;
		this.args = args;
		this.p = p;
		
	}
	
	public boolean execute() {
		
		p.getInventory().clear();
		p.sendMessage(ChatColor.DARK_PURPLE + "Dein Inventar wurde geleert.");
		
		return true;
	}
	
}
