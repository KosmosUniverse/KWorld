package fr.kosmosuniverse.kworld.MultiBlocks;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import fr.kosmosuniverse.kworld.ItemBuilder;
import fr.kosmosuniverse.kworld.MultiBlocks.utils.ActivationType;
import fr.kosmosuniverse.kworld.MultiBlocks.utils.IMultiBlock;
import fr.kosmosuniverse.kworld.MultiBlocks.utils.MultiBlock;
import fr.kosmosuniverse.kworld.MultiBlocks.utils.Pattern;

public class Decomposer extends IMultiBlock{

	public Decomposer() {
		this.name = "Decomposer";
		this.invs = new ArrayList<Inventory>();
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
		Inventory inv = Bukkit.createInventory(null, 45, "§8[MultiBlock]Decomposer Layer 1");
		
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
		
		this.invs.add(inv);
		
		inv = Bukkit.createInventory(null, 45, "§8[MultiBlock]Decomposer Layer 2");
		
		inv.setItem(0, new ItemBuilder(Material.BARRIER, "§c<- Previous Layer").getItem());
		inv.setItem(44, new ItemBuilder(Material.LIME_STAINED_GLASS_PANE, "§aNext Layer ->").getItem());
		
		inv.setItem(2, new ItemStack(Material.DARK_OAK_LOG));
		inv.setItem(6, new ItemStack(Material.DARK_OAK_LOG));
		inv.setItem(38, new ItemStack(Material.DARK_OAK_LOG));
		inv.setItem(42, new ItemStack(Material.DARK_OAK_LOG));
		inv.setItem(22, new ItemBuilder(Material.CHISELED_STONE_BRICKS, "Chiseled Stone Brick §cCore").getItem());
		
		this.invs.add(inv);
		
		inv = Bukkit.createInventory(null, 45, "§8[MultiBlock]Decomposer Layer 3");
		
		inv.setItem(0, new ItemBuilder(Material.BARRIER, "§c<- Previous Layer").getItem());
		inv.setItem(44, new ItemBuilder(Material.LIME_STAINED_GLASS_PANE, "§aNext Layer ->").getItem());
		
		inv.setItem(2, new ItemStack(Material.DARK_OAK_LOG));
		inv.setItem(6, new ItemStack(Material.DARK_OAK_LOG));
		inv.setItem(38, new ItemStack(Material.DARK_OAK_LOG));
		inv.setItem(42, new ItemStack(Material.DARK_OAK_LOG));
		inv.setItem(22, new ItemStack(Material.CHEST));
		
		this.invs.add(inv);
		
		inv = Bukkit.createInventory(null, 45, "§8[MultiBlock]Decomposer Layer 4");
		
		inv.setItem(0, new ItemBuilder(Material.BARRIER, "§c<- Previous Layer").getItem());
		inv.setItem(44, new ItemBuilder(Material.LIME_STAINED_GLASS_PANE, "§aNext Layer ->").getItem());
		
		inv.setItem(2, new ItemStack(Material.DARK_OAK_LOG));
		inv.setItem(6, new ItemStack(Material.DARK_OAK_LOG));
		inv.setItem(38, new ItemStack(Material.DARK_OAK_LOG));
		inv.setItem(42, new ItemStack(Material.DARK_OAK_LOG));
		inv.setItem(22, new ItemStack(Material.IRON_BARS));
		
		this.invs.add(inv);
		
		inv = Bukkit.createInventory(null, 45, "§8[MultiBlock]Decomposer Layer 5");
		
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
		
		this.invs.add(inv);
	}

	@Override
	public void onActivate(Plugin plugin, Player player, Location location, ActivationType type) {
		if (type == ActivationType.ASSEMBLE) {
			player.sendMessage("You just constructed Decomposer !");
		}
		else if (type == ActivationType.ACTIVATE) {
			player.sendMessage("You just activated Decomposer !");
		}
	}
}
