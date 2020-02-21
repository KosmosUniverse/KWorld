package fr.kosmosuniverse.kworld.MultiBlocks;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import fr.kosmosuniverse.kworld.ItemBuilder;
import fr.kosmosuniverse.kworld.MultiBlocks.utils.ActivationType;
import fr.kosmosuniverse.kworld.MultiBlocks.utils.IMultiBlock;
import fr.kosmosuniverse.kworld.MultiBlocks.utils.MultiBlock;
import fr.kosmosuniverse.kworld.MultiBlocks.utils.Pattern;
import fr.kosmosuniverse.kworld.crafts.chim.elements.Elements;
import fr.kosmosuniverse.kworld.crafts.chim.equivalence.MMEquivalence;
import fr.kosmosuniverse.kworld.crafts.chim.molecules.Molecules;

public class Synthetiser extends IMultiBlock {

	public Synthetiser() {
		this.name = "Synthetiser";
		this.invs = new HashMap<Integer, Inventory>();
		createInventories();
		this.multiblock = new MultiBlock(Material.CHISELED_QUARTZ_BLOCK,
				new Pattern(Material.QUARTZ_BLOCK, -1, -1, -1),
				new Pattern(Material.QUARTZ_BLOCK, -1, -1, 0),
				new Pattern(Material.QUARTZ_BLOCK, -1, -1, 1),
				new Pattern(Material.QUARTZ_BLOCK, 0, -1, -1),
				new Pattern(Material.QUARTZ_BLOCK, 0, -1, 1),
				new Pattern(Material.QUARTZ_BLOCK, 1, -1, -1),
				new Pattern(Material.QUARTZ_BLOCK, 1, -1, 0),
				new Pattern(Material.QUARTZ_BLOCK, 1, -1, 1),

				new Pattern(Material.QUARTZ_PILLAR, -2, 0, -2),
				new Pattern(Material.QUARTZ_PILLAR, -2, 0, 2),
				new Pattern(Material.QUARTZ_PILLAR, 2, 0, -2),
				new Pattern(Material.QUARTZ_PILLAR, 2, 0, 2),

				new Pattern(Material.CHEST, 0, 1, 0),
				new Pattern(Material.QUARTZ_PILLAR, -2, 1, -2),
				new Pattern(Material.QUARTZ_PILLAR, -2, 1, 2),
				new Pattern(Material.QUARTZ_PILLAR, 2, 1, -2),
				new Pattern(Material.QUARTZ_PILLAR, 2, 1, 2),
				new Pattern(Material.PISTON, -2, 1, 0),
				new Pattern(Material.PISTON, 0, 1, -2),
				new Pattern(Material.PISTON, 2, 1, 0),
				new Pattern(Material.PISTON, 0, 1, 2),
				
				new Pattern(Material.QUARTZ_PILLAR, -2, 2, -2),
				new Pattern(Material.QUARTZ_PILLAR, -2, 2, 2),
				new Pattern(Material.QUARTZ_PILLAR, 2, 2, -2),
				new Pattern(Material.QUARTZ_PILLAR, 2, 2, 2),
				new Pattern(Material.IRON_BARS, -2, 2, 0),
				new Pattern(Material.IRON_BARS, 0, 2, -2),
				new Pattern(Material.IRON_BARS, 2, 2, 0),
				new Pattern(Material.IRON_BARS, 0, 2, 2),
				
				new Pattern(Material.QUARTZ_BLOCK, -2, 3, -2),
				new Pattern(Material.QUARTZ_BLOCK, -2, 3, 2),
				new Pattern(Material.QUARTZ_BLOCK, 2, 3, -2),
				new Pattern(Material.QUARTZ_BLOCK, 2, 3, 2),
				new Pattern(Material.QUARTZ_PILLAR, -2, 3, -1),
				new Pattern(Material.QUARTZ_PILLAR, -2, 3, 0),
				new Pattern(Material.QUARTZ_PILLAR, -2, 3, 1),
				new Pattern(Material.QUARTZ_PILLAR, 2, 3, -1),
				new Pattern(Material.QUARTZ_PILLAR, 2, 3, 0),
				new Pattern(Material.QUARTZ_PILLAR, 2, 3, 1),
				new Pattern(Material.QUARTZ_PILLAR, -1, 3, -2),
				new Pattern(Material.QUARTZ_PILLAR, 0, 3, -2),
				new Pattern(Material.QUARTZ_PILLAR, 1, 3, -2),
				new Pattern(Material.QUARTZ_PILLAR, -1, 3, 2),
				new Pattern(Material.QUARTZ_PILLAR, 0, 3, 2),
				new Pattern(Material.QUARTZ_PILLAR, 1, 3, 2));
	}

	@Override
	public void createInventories() {
		Inventory inv = Bukkit.createInventory(null, 45, "§8[MultiBlock]Synthetiser Layer 1");
		
		inv.setItem(0, new ItemBuilder(Material.BARRIER, "§c<- Back").getItem());
		inv.setItem(44, new ItemBuilder(Material.LIME_STAINED_GLASS_PANE, "§aNext Layer ->").getItem());
		
		inv.setItem(12, new ItemStack(Material.QUARTZ_BLOCK));
		inv.setItem(13, new ItemStack(Material.QUARTZ_BLOCK));
		inv.setItem(14, new ItemStack(Material.QUARTZ_BLOCK));
		inv.setItem(21, new ItemStack(Material.QUARTZ_BLOCK));
		inv.setItem(23, new ItemStack(Material.QUARTZ_BLOCK));
		inv.setItem(30, new ItemStack(Material.QUARTZ_BLOCK));
		inv.setItem(31, new ItemStack(Material.QUARTZ_BLOCK));
		inv.setItem(32, new ItemStack(Material.QUARTZ_BLOCK));
		
		this.invs.put(1, inv);
		
		inv = Bukkit.createInventory(null, 45, "§8[MultiBlock]Synthetiser Layer 2");
		
		inv.setItem(0, new ItemBuilder(Material.BARRIER, "§c<- Previous Layer").getItem());
		inv.setItem(44, new ItemBuilder(Material.LIME_STAINED_GLASS_PANE, "§aNext Layer ->").getItem());
		
		inv.setItem(2, new ItemStack(Material.QUARTZ_PILLAR));
		inv.setItem(6, new ItemStack(Material.QUARTZ_PILLAR));
		inv.setItem(38, new ItemStack(Material.QUARTZ_PILLAR));
		inv.setItem(42, new ItemStack(Material.QUARTZ_PILLAR));
		inv.setItem(22, new ItemBuilder(Material.CHISELED_QUARTZ_BLOCK, "Chiseled Quartz Block §cCore").getItem());
		
		this.invs.put(2, inv);
		
		inv = Bukkit.createInventory(null, 45, "§8[MultiBlock]Synthetiser Layer 3");
		
		inv.setItem(0, new ItemBuilder(Material.BARRIER, "§c<- Previous Layer").getItem());
		inv.setItem(44, new ItemBuilder(Material.LIME_STAINED_GLASS_PANE, "§aNext Layer ->").getItem());
		
		inv.setItem(2, new ItemStack(Material.QUARTZ_PILLAR));
		inv.setItem(6, new ItemStack(Material.QUARTZ_PILLAR));
		inv.setItem(4, new ItemStack(Material.PISTON));
		inv.setItem(20, new ItemStack(Material.PISTON));
		inv.setItem(24, new ItemStack(Material.PISTON));
		inv.setItem(40, new ItemStack(Material.PISTON));
		inv.setItem(38, new ItemStack(Material.QUARTZ_PILLAR));
		inv.setItem(42, new ItemStack(Material.QUARTZ_PILLAR));
		inv.setItem(22, new ItemStack(Material.CHEST));
		
		this.invs.put(3, inv);
		
		inv = Bukkit.createInventory(null, 45, "§8[MultiBlock]Synthetiser Layer 4");
		
		inv.setItem(0, new ItemBuilder(Material.BARRIER, "§c<- Previous Layer").getItem());
		inv.setItem(44, new ItemBuilder(Material.LIME_STAINED_GLASS_PANE, "§aNext Layer ->").getItem());
		
		inv.setItem(2, new ItemStack(Material.QUARTZ_PILLAR));
		inv.setItem(6, new ItemStack(Material.QUARTZ_PILLAR));
		inv.setItem(4, new ItemStack(Material.IRON_BARS));
		inv.setItem(20, new ItemStack(Material.IRON_BARS));
		inv.setItem(24, new ItemStack(Material.IRON_BARS));
		inv.setItem(40, new ItemStack(Material.IRON_BARS));
		inv.setItem(38, new ItemStack(Material.QUARTZ_PILLAR));
		inv.setItem(42, new ItemStack(Material.QUARTZ_PILLAR));
		
		this.invs.put(4, inv);
		
		inv = Bukkit.createInventory(null, 45, "§8[MultiBlock]Synthetiser Layer 5");
		
		inv.setItem(0, new ItemBuilder(Material.BARRIER, "§c<- Previous Layer").getItem());
		
		inv.setItem(2, new ItemStack(Material.QUARTZ_BLOCK));
		inv.setItem(6, new ItemStack(Material.QUARTZ_BLOCK));
		inv.setItem(38, new ItemStack(Material.QUARTZ_BLOCK));
		inv.setItem(42, new ItemStack(Material.QUARTZ_BLOCK));
		
		inv.setItem(3, new ItemStack(Material.QUARTZ_PILLAR));
		inv.setItem(4, new ItemStack(Material.QUARTZ_PILLAR));
		inv.setItem(5, new ItemStack(Material.QUARTZ_PILLAR));
		inv.setItem(11, new ItemStack(Material.QUARTZ_PILLAR));
		inv.setItem(15, new ItemStack(Material.QUARTZ_PILLAR));
		inv.setItem(20, new ItemStack(Material.QUARTZ_PILLAR));
		inv.setItem(24, new ItemStack(Material.QUARTZ_PILLAR));
		inv.setItem(29, new ItemStack(Material.QUARTZ_PILLAR));
		inv.setItem(33, new ItemStack(Material.QUARTZ_PILLAR));
		inv.setItem(39, new ItemStack(Material.QUARTZ_PILLAR));
		inv.setItem(40, new ItemStack(Material.QUARTZ_PILLAR));
		inv.setItem(41, new ItemStack(Material.QUARTZ_PILLAR));
				
		this.invs.put(5, inv);
	}

	@Override
	public void onActivate(Plugin plugin, Player player, Block block, ActivationType type, Elements Elems, Molecules Mols, MMEquivalence Equiv) {
		if (type == ActivationType.ASSEMBLE) {
			player.sendMessage("You just constructed Synthetiser !");
		}
		else if (type == ActivationType.ACTIVATE) {
			player.sendMessage("You just activated Synthetiser !");
		}
	}
}
