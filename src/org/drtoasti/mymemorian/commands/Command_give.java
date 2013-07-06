package org.drtoasti.mymemorian.commands;
     
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.drtoasti.mymemorian.MyMemorian;
     
    public class Command_give implements CommandExecutor {
    	
    	@SuppressWarnings("unused")
    	private MyMemorian plugin;
    	
    	public Command_give(MyMemorian mymemorian) {
    		plugin = mymemorian;
    	}
     
			@SuppressWarnings("deprecation")
			@Override
            public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
                    if (!(sender instanceof Player)) {
                            sender.sendMessage("Befehl nur fuer Spieler!");
                            return true;
                    }
                   
                    Player player = (Player) sender;
                    int id = 2;
                    
                    try {
                        id = Integer.parseInt(args[0]);
                } catch (NumberFormatException e) {
                        player.sendMessage(ChatColor.RED + "Fehler: " + args[0] + " ist keine Zahl!");
                        return true;
                }
                   
                    if (args.length <= 1) {
                    	if(id > 158 && id < 255) {
                    		player.sendMessage(ChatColor.RED + "Item " + ChatColor.BLUE + args[0] + ChatColor.RED
                    				+ " gibt es nicht!");
                    		return true;
                    	}
                        ItemStack item = new ItemStack(id, 64);
                        player.getInventory().addItem(item);
                        player.updateInventory();
                            return true;
                    }
                   
                    int menge = 1;
                   
                    if (args.length > 1) {
                            try {
                                    menge = Integer.parseInt(args[1]);
                            } catch (NumberFormatException e) {
                                    player.sendMessage(ChatColor.RED + "Fehler: " + args[1] + " ist keine Zahl!");
                            }
                            ItemStack item = new ItemStack(id, menge);
                            player.getInventory().addItem(item);
                            player.updateInventory();
                           
                            return true;
                    }
                    return true;
                   
            }
           
    }

