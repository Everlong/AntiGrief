package me.everlong.AntiGrief;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockIgniteEvent;
import org.bukkit.event.block.BlockListener;
import org.bukkit.event.block.BlockPlaceEvent;

public class MyBlockListener implements Listener {

	public static AntiGrief plugin;
	public static Material[] placedBlacklist = {Material.TNT, Material.LAVA_BUCKET};
	public static Material[] destroyedBlacklist = {Material.TNT, Material.DIAMOND_BLOCK};
	
	public MyBlockListener(AntiGrief instance) {
		plugin = instance;
	}
	
	@EventHandler
	public void onBlockPlace (BlockPlaceEvent event) {
		Material block = event.getBlock().getType();
		Player player = event.getPlayer();
		for (Material blockedBlock : placedBlacklist) {
			if(blockedBlock == block) {
				player.sendMessage(ChatColor.DARK_RED + "I'm afraid I can't let you do that, "  + player.getDisplayName());
				event.setCancelled(true);
			}
		}
	}
	
	public void onBlockBreak (BlockBreakEvent event) {
		Material block = event.getBlock().getType();
		Player player = event.getPlayer();
		for (Material blockedBlock : destroyedBlacklist) {
			if(blockedBlock == block) {
				player.sendMessage(ChatColor.DARK_RED + "I'm afraid I can't let you do that, "  + player.getDisplayName());
				event.setCancelled(true);
			}
		}
	}
}
