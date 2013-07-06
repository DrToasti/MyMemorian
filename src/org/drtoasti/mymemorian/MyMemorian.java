package org.drtoasti.mymemorian;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;
import org.drtoasti.mymemorian.commands.Command_broadcast;
import org.drtoasti.mymemorian.commands.Command_exp;
import org.drtoasti.mymemorian.commands.Command_fly;
import org.drtoasti.mymemorian.commands.Command_gamemode;
import org.drtoasti.mymemorian.commands.Command_give;
import org.drtoasti.mymemorian.commands.Command_gladi;
import org.drtoasti.mymemorian.commands.Command_heal;
import org.drtoasti.mymemorian.commands.Command_kill;
import org.drtoasti.mymemorian.commands.Command_msg;
import org.drtoasti.mymemorian.commands.Command_sethead;
import org.drtoasti.mymemorian.commands.MainCommand;
import org.drtoasti.mymemorian.listener.Listener_JoinEvent;
import org.drtoasti.mymemorian.utility.BlockOP;

public class MyMemorian extends JavaPlugin {
	
	public static HashMap<String, String> TeamHM = new HashMap<String, String>();

	public boolean onCommand(CommandSender sender, Command cmd, String args[]) {
		
			MainCommand.onCommand(sender, cmd, args);
		
		return true;
	}
    
	
	@Override
	public void onEnable() {
		
		registerEvent();
		
		System.out.println("[MyMemorian] v" + this.getDescription().getVersion()+ " enabled!");
		this.getCommand("heal").setPermissionMessage(ChatColor.RED + "Dazu fehlt dir die Berechtigung!");
		this.getCommand("heal").setExecutor(new Command_heal(this));
		this.getCommand("gladi").setPermissionMessage(ChatColor.RED + "Dazu fehlt dir die Berechtigung!");
		this.getCommand("gladi").setExecutor(new Command_gladi(this));
		this.getCommand("kill").setPermissionMessage(ChatColor.RED + "Dazu fehlt dir die Berechtigung!");
		this.getCommand("kill").setExecutor(new Command_kill(this));
		this.getCommand("give").setPermission(ChatColor.RED + "Dazu fehlt dir die Berechtigung");
		this.getCommand("give").setExecutor(new Command_give(this));
		this.getCommand("msg").setPermission(ChatColor.RED + "Dazu fehlt dir die Berechtigung");
		this.getCommand("msg").setExecutor(new Command_msg(this));
		this.getCommand("broadcast").setPermission(ChatColor.RED + "Dazu fehlt dir die Berechtigung");
		this.getCommand("broadcast").setExecutor(new Command_broadcast(this));
		this.getCommand("exp").setPermission(ChatColor.RED + "Dazu fehlt dir die Berechtigung");
		this.getCommand("exp").setExecutor(new Command_exp(this));
		this.getCommand("fly").setPermission(ChatColor.RED + "Dazu fehlt dir die Berechtigung");
		this.getCommand("fly").setExecutor(new Command_fly(this));
		this.getCommand("gamemode").setPermission(ChatColor.RED + "Dazu fehlt dir die Berechtigung");
		this.getCommand("gamemode").setExecutor(new Command_gamemode(this));
		this.getCommand("OP").setPermission(ChatColor.RED + "Dazu fehlt dir die Berechtigung");
		this.getCommand("OP").setExecutor(new BlockOP(this));
		this.getCommand("sethead").setPermission(ChatColor.RED + "Dazu fehlt dir die Berechtigung");
		this.getCommand("sethead").setExecutor(new Command_sethead(this));
		
		
		ItemStack IronHArmor = new ItemStack(Material.IRON_BARDING);
		ItemStack GoldHArmor = new ItemStack(Material.GOLD_BARDING);
		ItemStack DiamondHArmor = new ItemStack(Material.DIAMOND_BARDING);
		
		ShapedRecipe IronHorseArmor = new ShapedRecipe(IronHArmor);
		IronHorseArmor.shape("$%$", "$^$", "$%$")
		.setIngredient('$', Material.DIRT)
		.setIngredient('%', Material.FIRE)
		.setIngredient('^', Material.IRON_BLOCK);
		ShapedRecipe GoldHorseArmor = new ShapedRecipe(GoldHArmor);
		IronHorseArmor.shape("$%$", "$^$", "$%$")
		.setIngredient('$', Material.GOLD_INGOT)
		.setIngredient('%', Material.FIRE)
		.setIngredient('^', Material.GOLD_BLOCK);
		ShapedRecipe DiamondHorseArmor = new ShapedRecipe(DiamondHArmor);
		DiamondHorseArmor.shape("$%$", "$^$", "$%$")
		.setIngredient('$', Material.DIAMOND)
		.setIngredient('%', Material.FIRE)
		.setIngredient('^', Material.DIAMOND_BLOCK);
		
		Bukkit.addRecipe(IronHorseArmor);
		Bukkit.addRecipe(GoldHorseArmor);
		Bukkit.addRecipe(DiamondHorseArmor);
		
		
		/*ItemStack IronHArmor = new ItemStack(Material.IRON_BARDING);
		ShapedRecipe IronHorseArmor = new ShapedRecipe(IronHArmor);
		IronHorseArmor.shape("ABA", "ACA", "ABA");
		.setIngredient('A', Material.IRON_INGOT);
		.setIngredient('B', Material.IRON_BLOCK);
		.setIngredient('C', Material.LEASH);
		*/
	}
	
	@Override
	public void onDisable() {
		System.out.println("[MyMemorian] v" + this.getDescription().getVersion()+ " disabled!");
	}
	
	
	
	@EventHandler
	private void registerEvent() {
		LJE = new Listener_JoinEvent(this);
	}
	
	@SuppressWarnings("unused")
	private Listener_JoinEvent LJE;
}