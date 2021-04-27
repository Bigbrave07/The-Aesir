package me.Bigbrave07.CustomNPCS;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import me.Bigbrave07.CustomNPCS.Events.ClickNPCs;
import me.Bigbrave07.CustomNPCS.Events.Join;
import net.md_5.bungee.api.ChatColor;

public class Main extends JavaPlugin implements Listener {

	@Override
	public void onEnable() {
		this.getServer().getPluginManager().registerEvents(new Join(), this);
		this.getServer().getPluginManager().registerEvents(new ClickNPCs(), this);
		
		if(!Bukkit.getOnlinePlayers().isEmpty())
			for(Player player : Bukkit.getOnlinePlayers()) {
				PacketReader reader = new PacketReader();
				reader.inject(player);
			}
		
	}
	
	@Override
	public void onDisable() {
		for(Player player : Bukkit.getOnlinePlayers()) {
			PacketReader reader = new PacketReader();
			reader.uninject(player);
		}
	
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (label.equalsIgnoreCase("createnpc")) {
			if (!(sender instanceof Player)) {
				return true;
			}
			Player player = (Player) sender;
			if (args.length == 0) {
				NPC.createNPC(player, player.getName(), args[1]);
				player.sendMessage(ChatColor.DARK_AQUA + "NPC Created!");
				return true;
			}
			NPC.createNPC(player, args[0], args[1]);
			
			player.sendMessage(ChatColor.DARK_AQUA + "NPC Created!");
			return true;
		}
		
		return false;
	}
}
