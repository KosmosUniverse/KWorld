package fr.kosmosuniverse.kworld.crafts.fun.stick;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

import fr.kosmosuniverse.kworld.ItemBuilder;
import fr.kosmosuniverse.kworld.KWorldMain;

public class WindStick extends AStick3T {
	
	public WindStick(KWorldMain main) {
		super(main, "WIND", "§b" , Enchantment.KNOCKBACK);
	}
	
	@Override
	public void StickInventory() {
		this.inv = Bukkit.createInventory(null, 54, "§8Fire Stick");
		
		this.inv.setItem(0, new ItemBuilder(Material.BARRIER, "§cBack <-", 1).getItem());
		
		this.inv.setItem(9, new ItemStack(Material.NETHER_BRICK_FENCE));
		this.inv.setItem(10, new ItemStack(Material.NETHER_BRICK_FENCE));
		this.inv.setItem(11, new ItemStack(Material.NETHER_BRICK_FENCE));
		this.inv.setItem(18, new ItemStack(Material.NETHER_BRICK_FENCE));
		this.inv.setItem(19, new ItemStack(Material.STICK));
		this.inv.setItem(20, new ItemStack(Material.NETHER_BRICK_FENCE));
		this.inv.setItem(27, new ItemStack(Material.NETHER_BRICK_FENCE));
		this.inv.setItem(28, new ItemStack(Material.NETHER_BRICK_FENCE));
		this.inv.setItem(29, new ItemStack(Material.NETHER_BRICK_FENCE));
		this.inv.setItem(46, StickBuilder(1));
		
		this.inv.setItem(12, new ItemStack(Material.NETHER_BRICK_FENCE));
		this.inv.setItem(13, new ItemStack(Material.NETHER_BRICK_FENCE));
		this.inv.setItem(14, new ItemStack(Material.NETHER_BRICK_FENCE));
		this.inv.setItem(21, new ItemStack(Material.GHAST_TEAR));
		this.inv.setItem(22, StickBuilder(1));
		this.inv.setItem(23, new ItemStack(Material.GHAST_TEAR));
		this.inv.setItem(30, new ItemStack(Material.NETHER_BRICK_FENCE));
		this.inv.setItem(31, new ItemStack(Material.NETHER_BRICK_FENCE));
		this.inv.setItem(32, new ItemStack(Material.NETHER_BRICK_FENCE));
		this.inv.setItem(49, StickBuilder(2));
		
		this.inv.setItem(15, new ItemStack(Material.NETHER_BRICK_FENCE));
		this.inv.setItem(16, new ItemStack(Material.WITHER_SKELETON_SKULL));
		this.inv.setItem(17, new ItemStack(Material.NETHER_BRICK_FENCE));
		this.inv.setItem(24, new ItemStack(Material.GHAST_TEAR));
		this.inv.setItem(25, StickBuilder(2));
		this.inv.setItem(26, new ItemStack(Material.GHAST_TEAR));
		this.inv.setItem(33, new ItemStack(Material.NETHER_BRICK_FENCE));
		this.inv.setItem(34, new ItemStack(Material.WITHER_SKELETON_SKULL));
		this.inv.setItem(35, new ItemStack(Material.NETHER_BRICK_FENCE));
		this.inv.setItem(52, StickBuilder(3));
	}
	
	@Override
	public void Shapes() {
		StickTierI.shape("BBB", "BSB", "BBB");
		StickTierI.setIngredient('B', Material.NETHER_BRICK_FENCE);
		StickTierI.setIngredient('S', Material.STICK);
		
		StickTierII.shape("BBB", "TST", "BBB");
		StickTierII.setIngredient('B', Material.NETHER_BRICK_FENCE);
		StickTierII.setIngredient('S', new ItemBuilder(Material.STICK, "§bWIND STICK TIER I", 1).getItem().getData());
		StickTierII.setIngredient('T', Material.GHAST_TEAR);
		
		StickTierIII.shape("BHB", "TST", "BHB");
		StickTierIII.setIngredient('B', Material.NETHER_BRICK_FENCE);
		StickTierIII.setIngredient('S', new ItemBuilder(Material.STICK, "§bWIND STICK TIER II", 1).getItem().getData());
		StickTierIII.setIngredient('T', Material.GHAST_TEAR);
		StickTierIII.setIngredient('H', Material.WITHER_SKELETON_SKULL);
	}
}
