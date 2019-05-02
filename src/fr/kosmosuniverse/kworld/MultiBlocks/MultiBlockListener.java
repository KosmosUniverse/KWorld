package fr.kosmosuniverse.kworld.MultiBlocks;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import fr.kosmosuniverse.kworld.MultiBlocks.utils.ActivationType;
import fr.kosmosuniverse.kworld.MultiBlocks.utils.IMultiBlock;

public class MultiBlockListener implements Listener {
	private ArrayList<IMultiBlock> MBList;
	private ArrayList<Material> Cores;
	private Plugin plugin;
	
	public MultiBlockListener(Plugin _plugin) {
		this.plugin = _plugin;
		MBList = new ArrayList<IMultiBlock>();
		Cores = new ArrayList<Material>();
		
		this.MBList.add(new Decomposer());
		
		for (IMultiBlock mb : MBList) {
			if (!Cores.contains(mb.getMultiblock().getCore()))
				Cores.add(mb.getMultiblock().getCore());
		}
	}
	
	@EventHandler
	public void onCorePlaced(BlockPlaceEvent event) {
		Player player = event.getPlayer();
		Block block = event.getBlockPlaced();
		
		if (!Cores.contains(block.getType()))
			return ;
		
		for (IMultiBlock mb : MBList) {
			if (mb.getMultiblock().getCore() == block.getType()) {
				if (mb.getMultiblock().checkMultiBlock(block.getLocation(), player)) {
					mb.onActivate(this.plugin, player, block.getLocation(), ActivationType.ASSEMBLE);
					return ;
				}
			}
		}
	}
	
	@EventHandler
	public void onCoreInteract(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		Action action = event.getAction();
		ItemStack item = event.getItem();
		
		if (action != Action.RIGHT_CLICK_BLOCK || item == null)
			return ;
		
		Block block = event.getClickedBlock();
		
		if (!Cores.contains(block.getType()))
			return ;
		
		for (IMultiBlock mb : MBList) {
			if (mb.getMultiblock().getCore() == block.getType()) {
				if (mb.getMultiblock().checkMultiBlock(block.getLocation(), player)) {
					mb.onActivate(this.plugin, player, block.getLocation(), ActivationType.ACTIVATE);
					return ;
				}
			}
		}
	}
}
