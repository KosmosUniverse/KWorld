package fr.kosmosuniverse.kworld.MultiBlocks.utils;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.Plugin;

import fr.kosmosuniverse.kworld.crafts.chim.elements.Elements;
import fr.kosmosuniverse.kworld.crafts.chim.equivalence.MMEquivalence;
import fr.kosmosuniverse.kworld.crafts.chim.molecules.Molecules;

public abstract class IMultiBlock {
	protected String name;
	protected MultiBlock multiblock;
	protected ArrayList<Inventory> invs;
	
	public abstract void onActivate(Plugin plugin, Player player, Block block, ActivationType type, Elements Elems, Molecules Mols, MMEquivalence Equiv);
	public abstract void createInventories();
	
	public Inventory getInventory(Inventory before, Material material, Inventory upInv) {
		int i = 0;
		boolean found = false;
		
		for (Inventory tmp : this.invs) {
			if (tmp.getName().equals(before.getName())) {
				found = true;
				break ;
			}
			i++;
		}

		if (!found)
			return this.invs.get(0);

		if (material == Material.LIME_STAINED_GLASS_PANE)
			return this.invs.get(i + 1);
		else if (material == Material.BARRIER) {
			if (i != 0)
				return this.invs.get(i - 1);
			return upInv;
		}
		return before;
	}
	
	public String getName() {
		return name;
	}
	
	public MultiBlock getMultiblock() {
		return multiblock;
	}
}