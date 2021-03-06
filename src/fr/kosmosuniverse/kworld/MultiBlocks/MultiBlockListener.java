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
import fr.kosmosuniverse.kworld.crafts.chim.ChimActivator;
import fr.kosmosuniverse.kworld.crafts.chim.elements.Elements;
import fr.kosmosuniverse.kworld.crafts.chim.equivalence.MMEquivalence;
import fr.kosmosuniverse.kworld.crafts.chim.molecules.Molecules;

public class MultiBlockListener implements Listener {
	private ArrayList<Material> Cores;
	private ArrayList<IMultiBlock> MBList;
	private Plugin plugin;
	
	private Elements Elems;
	private Molecules Mols;
	private MMEquivalence Equiv;
	
	public MultiBlockListener(Plugin _plugin, ArrayList<IMultiBlock> MBList, Elements Elems, Molecules Mols, MMEquivalence Equiv) {
		Cores = new ArrayList<Material>();
		
		this.plugin = _plugin;
		this.MBList = MBList;
		this.Elems = Elems;
		this.Mols = Mols;
		this.Equiv = Equiv;
		
		this.MBList.add(new Decomposer());
		this.MBList.add(new Synthetiser());
		
		for (IMultiBlock mb : this.MBList) {
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
		
		for (IMultiBlock mb : this.MBList) {
			if (mb.getMultiblock().getCore() == block.getType()) {
				if (mb.getMultiblock().checkMultiBlock(block.getLocation(), player)) {
					mb.onActivate(this.plugin, player, block, ActivationType.ASSEMBLE, this.Elems, this.Mols, this.Equiv);
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
		
		if (!(item.getType() == Material.END_ROD && item.hasItemMeta() && item.getItemMeta().hasDisplayName() && item.getItemMeta().getDisplayName().equals("Activator"))) { 
			return ;
		}
		
		Block block = event.getClickedBlock();
		
		if (!Cores.contains(block.getType()))
			return ;
		
		for (IMultiBlock mb : this.MBList) {
			if (mb.getMultiblock().getCore() == block.getType()) {
				if (mb.getMultiblock().checkMultiBlock(block.getLocation(), player)) {
					mb.onActivate(this.plugin, player, block, ActivationType.ACTIVATE, this.Elems, this.Mols, this.Equiv);
					return ;
				}
			}
		}
	}
	
	@EventHandler
	public void onActivatorPlaced(BlockPlaceEvent event) {
		ItemStack item = event.getItemInHand();
		
		if (item.equals(ChimActivator.ActivatorBuilder()))
			event.setCancelled(true);
	}
}
