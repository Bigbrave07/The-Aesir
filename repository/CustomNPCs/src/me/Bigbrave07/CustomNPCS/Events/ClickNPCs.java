package me.Bigbrave07.CustomNPCS.Events;

import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import net.md_5.bungee.api.ChatColor;


public class ClickNPCs implements Listener {

	@EventHandler
	public void onNPCClick(RightClickNPC e) {
		Player player = e.getPlayer();
		if(e.getNPC().getName().equalsIgnoreCase("Bigbrave07")) {
			player.sendMessage("<" + e.getNPC().getName() + ">" + ChatColor.YELLOW + " You Stink!");
			Location loc = player.getLocation();
			player.playSound(loc, Sound.ENTITY_VILLAGER_YES, 1, 0);
		} else if(e.getNPC().getName().equalsIgnoreCase("_Odinn")) {
		    player.sendMessage("<" + e.getNPC().getName() + ">" + ChatColor.YELLOW + " I Stink!");
		}else if(e.getNPC().getName().equalsIgnoreCase("TeamChanger")) {
	}else {
			player.sendMessage("<" + e.getNPC().getName() + ">" + "I have no purpose!");
		}
	}
}
