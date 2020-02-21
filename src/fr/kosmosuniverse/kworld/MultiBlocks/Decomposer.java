package fr.kosmosuniverse.kworld.MultiBlocks;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import fr.kosmosuniverse.kworld.ItemBuilder;
import fr.kosmosuniverse.kworld.MultiBlocks.utils.ActivationType;
import fr.kosmosuniverse.kworld.MultiBlocks.utils.IMultiBlock;
import fr.kosmosuniverse.kworld.MultiBlocks.utils.MultiBlock;
import fr.kosmosuniverse.kworld.MultiBlocks.utils.Pattern;
import fr.kosmosuniverse.kworld.commands.KGive;
import fr.kosmosuniverse.kworld.crafts.chim.elements.Elements;
import fr.kosmosuniverse.kworld.crafts.chim.equivalence.ComposeIN;
import fr.kosmosuniverse.kworld.crafts.chim.equivalence.MMEquivalence;
import fr.kosmosuniverse.kworld.crafts.chim.molecules.Compose;
import fr.kosmosuniverse.kworld.crafts.chim.molecules.Molecule;
import fr.kosmosuniverse.kworld.crafts.chim.molecules.Molecules;

public class Decomposer extends IMultiBlock{
	
	public Decomposer() {
		this.name = "Decomposer";
		this.invs = new HashMap<Integer, Inventory>();
		createInventories();
		this.multiblock = new MultiBlock(Material.CHISELED_STONE_BRICKS,
				new Pattern(Material.STONE_BRICKS, -1, -1, -1),
				new Pattern(Material.STONE_BRICKS, -1, -1, 0),
				new Pattern(Material.STONE_BRICKS, -1, -1, 1),
				new Pattern(Material.STONE_BRICKS, 0, -1, -1),
				new Pattern(Material.STONE_BRICKS, 0, -1, 1),
				new Pattern(Material.STONE_BRICKS, 1, -1, -1),
				new Pattern(Material.STONE_BRICKS, 1, -1, 0),
				new Pattern(Material.STONE_BRICKS, 1, -1, 1),
				
				new Pattern(Material.DARK_OAK_LOG, -2, 0, -2),
				new Pattern(Material.DARK_OAK_LOG, -2, 0, 2),
				new Pattern(Material.DARK_OAK_LOG, 2, 0, -2),
				new Pattern(Material.DARK_OAK_LOG, 2, 0, 2),
				
				new Pattern(Material.CHEST, 0, 1, 0),
				new Pattern(Material.DARK_OAK_LOG, -2, 1, -2),
				new Pattern(Material.DARK_OAK_LOG, -2, 1, 2),
				new Pattern(Material.DARK_OAK_LOG, 2, 1, -2),
				new Pattern(Material.DARK_OAK_LOG, 2, 1, 2),
				
				new Pattern(Material.DARK_OAK_LOG, -2, 2, -2),
				new Pattern(Material.DARK_OAK_LOG, -2, 2, 2),
				new Pattern(Material.DARK_OAK_LOG, 2, 2, -2),
				new Pattern(Material.DARK_OAK_LOG, 2, 2, 2),
				new Pattern(Material.IRON_BARS, 0, 2, 0),
				
				new Pattern(Material.DARK_OAK_WOOD, -2, 3, -2),
				new Pattern(Material.DARK_OAK_WOOD, -2, 3, 2),
				new Pattern(Material.DARK_OAK_WOOD, 2, 3, -2),
				new Pattern(Material.DARK_OAK_WOOD, 2, 3, 2),
				new Pattern(Material.DARK_OAK_LOG, 1, 3, -2),
				new Pattern(Material.DARK_OAK_LOG, 0, 3, 2),
				new Pattern(Material.DARK_OAK_LOG, -1, 3, -2),
				new Pattern(Material.DARK_OAK_LOG, -1, 3, 2),
				new Pattern(Material.DARK_OAK_LOG, 0, 3, -2),
				new Pattern(Material.DARK_OAK_LOG, 1, 3, 2),
				new Pattern(Material.DARK_OAK_LOG, -2, 3, -1),
				new Pattern(Material.DARK_OAK_LOG, -2, 3, 0),
				new Pattern(Material.DARK_OAK_LOG, -2, 3, 1),
				new Pattern(Material.DARK_OAK_LOG, 2, 3, -1),
				new Pattern(Material.DARK_OAK_LOG, 2, 3, 0),
				new Pattern(Material.DARK_OAK_LOG, 2, 3, 1),
				new Pattern(Material.IRON_BARS, -1, 3, 0),
				new Pattern(Material.IRON_BARS, 0, 3, -1),
				new Pattern(Material.IRON_BARS, 0, 3, 0),
				new Pattern(Material.IRON_BARS, 1, 3, 0),
				new Pattern(Material.IRON_BARS, 0, 3, 1));
	}
	
	@Override
	public void createInventories() {
		Inventory inv = Bukkit.createInventory(null, 45, "§8Decomposer Layer 1");
		
		inv.setItem(0, new ItemBuilder(Material.BARRIER, "§c<- Back").getItem());
		inv.setItem(44, new ItemBuilder(Material.LIME_STAINED_GLASS_PANE, "§aNext Layer ->").getItem());
		
		inv.setItem(12, new ItemStack(Material.STONE_BRICKS));
		inv.setItem(13, new ItemStack(Material.STONE_BRICKS));
		inv.setItem(14, new ItemStack(Material.STONE_BRICKS));
		inv.setItem(21, new ItemStack(Material.STONE_BRICKS));
		inv.setItem(23, new ItemStack(Material.STONE_BRICKS));
		inv.setItem(30, new ItemStack(Material.STONE_BRICKS));
		inv.setItem(31, new ItemStack(Material.STONE_BRICKS));
		inv.setItem(32, new ItemStack(Material.STONE_BRICKS));
		
		this.invs.put(1, inv);
		
		inv = Bukkit.createInventory(null, 45, "§8Decomposer Layer 2");
		
		inv.setItem(0, new ItemBuilder(Material.BARRIER, "§c<- Previous Layer").getItem());
		inv.setItem(44, new ItemBuilder(Material.LIME_STAINED_GLASS_PANE, "§aNext Layer ->").getItem());
		
		inv.setItem(2, new ItemStack(Material.DARK_OAK_LOG));
		inv.setItem(6, new ItemStack(Material.DARK_OAK_LOG));
		inv.setItem(38, new ItemStack(Material.DARK_OAK_LOG));
		inv.setItem(42, new ItemStack(Material.DARK_OAK_LOG));
		inv.setItem(22, new ItemBuilder(Material.CHISELED_STONE_BRICKS, "Chiseled Stone Brick §cCore").getItem());
		
		this.invs.put(2, inv);
		
		inv = Bukkit.createInventory(null, 45, "§8Decomposer Layer 3");
		
		inv.setItem(0, new ItemBuilder(Material.BARRIER, "§c<- Previous Layer").getItem());
		inv.setItem(44, new ItemBuilder(Material.LIME_STAINED_GLASS_PANE, "§aNext Layer ->").getItem());
		
		inv.setItem(2, new ItemStack(Material.DARK_OAK_LOG));
		inv.setItem(6, new ItemStack(Material.DARK_OAK_LOG));
		inv.setItem(38, new ItemStack(Material.DARK_OAK_LOG));
		inv.setItem(42, new ItemStack(Material.DARK_OAK_LOG));
		inv.setItem(22, new ItemStack(Material.CHEST));
		
		this.invs.put(3, inv);
		
		inv = Bukkit.createInventory(null, 45, "§8Decomposer Layer 4");
		
		inv.setItem(0, new ItemBuilder(Material.BARRIER, "§c<- Previous Layer").getItem());
		inv.setItem(44, new ItemBuilder(Material.LIME_STAINED_GLASS_PANE, "§aNext Layer ->").getItem());
		
		inv.setItem(2, new ItemStack(Material.DARK_OAK_LOG));
		inv.setItem(6, new ItemStack(Material.DARK_OAK_LOG));
		inv.setItem(38, new ItemStack(Material.DARK_OAK_LOG));
		inv.setItem(42, new ItemStack(Material.DARK_OAK_LOG));
		inv.setItem(22, new ItemStack(Material.IRON_BARS));
		
		this.invs.put(4, inv);
		
		inv = Bukkit.createInventory(null, 45, "§8Decomposer Layer 5");
		
		inv.setItem(0, new ItemBuilder(Material.BARRIER, "§c<- Previous Layer").getItem());
		
		inv.setItem(2, new ItemStack(Material.DARK_OAK_WOOD));
		inv.setItem(6, new ItemStack(Material.DARK_OAK_WOOD));
		inv.setItem(38, new ItemStack(Material.DARK_OAK_WOOD));
		inv.setItem(42, new ItemStack(Material.DARK_OAK_WOOD));
		
		inv.setItem(3, new ItemStack(Material.DARK_OAK_LOG));
		inv.setItem(4, new ItemStack(Material.DARK_OAK_LOG));
		inv.setItem(5, new ItemStack(Material.DARK_OAK_LOG));
		inv.setItem(11, new ItemStack(Material.DARK_OAK_LOG));
		inv.setItem(15, new ItemStack(Material.DARK_OAK_LOG));
		inv.setItem(20, new ItemStack(Material.DARK_OAK_LOG));
		inv.setItem(24, new ItemStack(Material.DARK_OAK_LOG));
		inv.setItem(29, new ItemStack(Material.DARK_OAK_LOG));
		inv.setItem(33, new ItemStack(Material.DARK_OAK_LOG));
		inv.setItem(39, new ItemStack(Material.DARK_OAK_LOG));
		inv.setItem(40, new ItemStack(Material.DARK_OAK_LOG));
		inv.setItem(41, new ItemStack(Material.DARK_OAK_LOG));
		
		inv.setItem(13, new ItemStack(Material.IRON_BARS));
		inv.setItem(21, new ItemStack(Material.IRON_BARS));
		inv.setItem(22, new ItemStack(Material.IRON_BARS));
		inv.setItem(23, new ItemStack(Material.IRON_BARS));
		inv.setItem(31, new ItemStack(Material.IRON_BARS));
		
		this.invs.put(5, inv);
	}

	@Override
	public void onActivate(Plugin plugin, Player player, Block block, ActivationType type, Elements Elems, Molecules Mols, MMEquivalence Equiv) {
		if (type == ActivationType.ASSEMBLE) {
			player.sendMessage("You just constructed Decomposer !");
		}
		else if (type == ActivationType.ACTIVATE) {
			player.sendMessage("You just activated Decomposer !");
			
			Chest chest = (Chest) block.getLocation().getBlock().getRelative(0, 1, 0).getState();
			ItemStack item;
			Molecule mol = null;
			ComposeIN[] comp = null;
			
			if ((item = checkChest(chest, player, Equiv)) == null)
				return ;
			
			
			if (item.getType().equals(Material.GLASS_BOTTLE)) {
				if ((mol = Mols.duplicateMoleculeByItem(item)) == null) {
					player.sendMessage("[KWorld] : You need to put only available Molecules in the Decomposer !");
					return ;
				}
			}
			else {
				if ((comp = Equiv.getItemsByMaterial(item.getType())) == null) {
					player.sendMessage("[KWorld] : This is impossible.");
					return ;
				}
					
			}
			
			Inventory inv = chest.getInventory();
			Integer count = item.getAmount();
			inv.clear();
			
			if (item.getType().equals(Material.GLASS_BOTTLE)) {
				for (Compose c : mol.getCompose()) {
					inv.addItem(KGive.itemMultiplier(c.elem.getElem(), c.number * count));
				}
			}
			else {
				for (ComposeIN c : comp) {
					inv.addItem(KGive.itemMultiplier(c.item, c.nb * count));
				}
			}
			
			player.playSound(player.getLocation(), Sound.ENTITY_LIGHTNING_BOLT_THUNDER, 4f, 4f);
		}
	}

	private ItemStack checkChest(Chest chest, Player player, MMEquivalence Equiv) {
		Inventory inv = chest.getInventory();
		ItemStack decomp = null;

		Integer i = 0;
		
		for (ItemStack item : inv.getContents()) {
			if (item != null)
				i += 1;
		}
		
		if (i == 0) {
			player.sendMessage("[KWorld] : If you want to use Decomposer you need to put something to decompose in the chest before activate it !");
			return null;
		}
		else if (i > 1) {
			player.sendMessage("[KWorld] : For now, just put one type of item !");
			return null;
		}
		
		for (ItemStack item : inv.getContents()) {
			if (item != null && item.getType() != Material.GLASS_BOTTLE && !Equiv.checkMaterial(item.getType())) {
				player.sendMessage("[KWorld] : For now, you need to put a Molecule or a natural Material only !");
				return null;
			}
			if (item != null && (item.getType() == Material.GLASS_BOTTLE || Equiv.checkMaterial(item.getType())))
				decomp = item;
		}
		
		return decomp;
	}
}
