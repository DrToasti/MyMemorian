package org.drtoasti.mymemorian;

import java.util.HashMap;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class MyMemorian extends JavaPlugin {
	
	static HashMap<String, String> TeamHM = new HashMap<String, String>();
	
	@Override
	public void onEnable() {
		System.out.println("[MyMemorian] v" + this.getDescription().getVersion()+ " enabled!");
		this.getCommand("heal").setPermissionMessage(ChatColor.RED + "Dazu fehlt dir die Berechtigung!");
		this.getCommand("heal").setExecutor(new CE_heal(this));
		this.getCommand("gladi").setPermissionMessage(ChatColor.RED + "Dazu fehlt dir die Berechtigung!");
		this.getCommand("gladi").setExecutor(new CE_gladi(this));
		this.getCommand("kill").setPermissionMessage(ChatColor.RED + "Dazu fehlt dir die Berechtigung!");
		this.getCommand("kill").setExecutor(new CE_kill(this));
	}
	
	@Override
	public void onDisable() {
		System.out.println("[MyMemorian] v" + this.getDescription().getVersion()+ " disabled!");
	}
	
}