package fr.kosmosuniverse.kworld.crafts.stick;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import fr.kosmosuniverse.kworld.ItemBuilder;
import fr.kosmosuniverse.kworld.KWorldMain;

public class WindStick {
	private KWorldMain main;
	private ShapedRecipe WindStickTierI;
	private ShapedRecipe WindStickTierII;
	private ShapedRecipe WindStickTierIII;
	
	public WindStick(KWorldMain main) {
		this.main = main;
		
		WindStickTierI = new ShapedRecipe(new NamespacedKey(this.main, "WindStick1"), WindStickBuilder(1));
		WindStickTierII = new ShapedRecipe(new NamespacedKey(this.main, "WindStick2"), WindStickBuilder(2));
		WindStickTierIII = new ShapedRecipe(new NamespacedKey(this.main, "WindStick3"), WindStickBuilder(3));
		
		WindStickTierI.shape("BBB", "BSB", "BBB");
		WindStickTierI.setIngredient('B', Material.NETHER_BRICK_FENCE);
		WindStickTierI.setIngredient('S', Material.STICK);
		
		WindStickTierII.shape("BBB", "TST", "BBB");
		WindStickTierII.setIngredient('B', Material.NETHER_BRICK_FENCE);
		WindStickTierII.setIngredient('S', new ItemBuilder(Material.STICK, "§bWIND STICK TIER I", 1).getItem().getData());
		WindStickTierII.setIngredient('T', Material.GHAST_TEAR);
		
		WindStickTierIII.shape("BHB", "TST", "BHB");
		WindStickTierIII.setIngredient('B', Material.NETHER_BRICK_FENCE);
		WindStickTierIII.setIngredient('S', new ItemBuilder(Material.STICK, "§bWIND STICK TIER II", 1).getItem().getData());
		WindStickTierIII.setIngredient('T', Material.GHAST_TEAR);
		WindStickTierIII.setIngredient('H', Material.WITHER_SKELETON_SKULL);
	}
	
	public ShapedRecipe getWindStickTierI() {
		return WindStickTierI;
	}
	
	public ShapedRecipe getWindStickTierII() {
		return WindStickTierII;
	}
	
	public ShapedRecipe getWindStickTierIII() {
		return WindStickTierIII;
	}
	
	public static ItemStack WindStickBuilder(int tier) {
		ItemStack stick = new ItemStack(Material.STICK);
		ItemMeta stickM = stick.getItemMeta();
		
		switch (tier) {
		case 1:
			stickM.setDisplayName("§bWIND STICK TIER I");
			stickM.addEnchant(Enchantment.KNOCKBACK, 0, true);
			stickM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			stickM.setLore(Arrays.asList("Durability:200/200"));
			break;
		case 2:
			stickM.setDisplayName("§bWIND STICK TIER II");
			stickM.addEnchant(Enchantment.KNOCKBACK, 3, true);
			stickM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			stickM.setLore(Arrays.asList("Durability:400/400"));
			break;
		case 3:
			stickM.setDisplayName("§bWIND STICK TIER III");
			stickM.addEnchant(Enchantment.KNOCKBACK, 5, true);
			stickM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			stickM.setLore(Arrays.asList("Durability:600/600"));
			break;
		}
		
		stick.setItemMeta(stickM);
		
		return stick;
	}
	
	public static ItemStack WindStickSampleBuilder() {
		ItemStack stick = new ItemStack(Material.STICK);
		ItemMeta stickM = stick.getItemMeta();
		
		stickM.setDisplayName("§bWIND STICK");
		stickM.addEnchant(Enchantment.KNOCKBACK, 5, true);
		stickM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		
		stick.setItemMeta(stickM);
		
		return stick;
	}

	public static Inventory getWindStickRecipe() {
		Inventory inv = Bukkit.createInventory(null, 54, "§8Fire Stick");
		
		inv.setItem(0, new ItemBuilder(Material.BARRIER, "§cBack <-", 1).getItem());
		
		inv.setItem(9, new ItemStack(Material.NETHER_BRICK_FENCE));
		inv.setItem(10, new ItemStack(Material.NETHER_BRICK_FENCE));
		inv.setItem(11, new ItemStack(Material.NETHER_BRICK_FENCE));
		inv.setItem(18, new ItemStack(Material.NETHER_BRICK_FENCE));
		inv.setItem(19, new ItemStack(Material.STICK));
		inv.setItem(20, new ItemStack(Material.NETHER_BRICK_FENCE));
		inv.setItem(27, new ItemStack(Material.NETHER_BRICK_FENCE));
		inv.setItem(28, new ItemStack(Material.NETHER_BRICK_FENCE));
		inv.setItem(29, new ItemStack(Material.NETHER_BRICK_FENCE));
		inv.setItem(46, WindStickBuilder(1));
		
		inv.setItem(12, new ItemStack(Material.NETHER_BRICK_FENCE));
		inv.setItem(13, new ItemStack(Material.NETHER_BRICK_FENCE));
		inv.setItem(14, new ItemStack(Material.NETHER_BRICK_FENCE));
		inv.setItem(21, new ItemStack(Material.GHAST_TEAR));
		inv.setItem(22, WindStickBuilder(1));
		inv.setItem(23, new ItemStack(Material.GHAST_TEAR));
		inv.setItem(30, new ItemStack(Material.NETHER_BRICK_FENCE));
		inv.setItem(31, new ItemStack(Material.NETHER_BRICK_FENCE));
		inv.setItem(32, new ItemStack(Material.NETHER_BRICK_FENCE));
		inv.setItem(49, WindStickBuilder(2));
		
		inv.setItem(15, new ItemStack(Material.NETHER_BRICK_FENCE));
		inv.setItem(16, new ItemStack(Material.WITHER_SKELETON_SKULL));
		inv.setItem(17, new ItemStack(Material.NETHER_BRICK_FENCE));
		inv.setItem(24, new ItemStack(Material.GHAST_TEAR));
		inv.setItem(25, WindStickBuilder(2));
		inv.setItem(26, new ItemStack(Material.GHAST_TEAR));
		inv.setItem(33, new ItemStack(Material.NETHER_BRICK_FENCE));
		inv.setItem(34, new ItemStack(Material.WITHER_SKELETON_SKULL));
		inv.setItem(35, new ItemStack(Material.NETHER_BRICK_FENCE));
		inv.setItem(52, WindStickBuilder(3));
		
		return inv;
	}
}
