package org.drtoasti.mymemorian.listener;

import java.net.InetSocketAddress;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.drtoasti.mymemorian.MyMemorian;

public class Listener_JoinEvent implements Listener {
	
	private MyMemorian plugin;
	
	
	public Listener_JoinEvent(MyMemorian mymemorian) {
		plugin = mymemorian;
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		Player eventPlayer = event.getPlayer();
		plugin.getServer().broadcastMessage(ChatColor.YELLOW + eventPlayer.getName() + " hat sich auf MyMemorian eingeloggt!");
		
		InetSocketAddress IP = eventPlayer.getAddress();
		Location test = eventPlayer.getLocation();
		
		eventPlayer.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 200, 0));
		eventPlayer.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 200, 4));
		
		plugin.getServer().broadcastMessage(ChatColor.GREEN + eventPlayer.getName() + ChatColor.AQUA + " hat folgende IP Adresse: " + 
				IP);
		plugin.getServer().broadcastMessage(ChatColor.GREEN + eventPlayer.getName() + ChatColor.AQUA + " befindet sich: " + 
				test);
		
	}
	
	//org.bukkit.event.player.

}
