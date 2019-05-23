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

public class WaterStick {
	
	private KWorldMain main;
	private ShapedRecipe WaterStickTierI;
	private ShapedRecipe WaterStickTierII;
	private ShapedRecipe WaterStickTierIII;
	
	public WaterStick(KWorldMain main) {
		this.main = main;
		
		WaterStickTierI = new ShapedRecipe(new NamespacedKey(this.main, "WaterStick1"), WaterStickBuilder(1));
		WaterStickTierII = new ShapedRecipe(new NamespacedKey(this.main, "WaterStick2"), WaterStickBuilder(2));
		WaterStickTierIII = new ShapedRecipe(new NamespacedKey(this.main, "WaterStick3"), WaterStickBuilder(3));
		
		WaterStickTierI.shape("FFF", "FSF", "FFF");
		WaterStickTierI.setIngredient('F', Material.DARK_PRISMARINE);
		WaterStickTierI.setIngredient('S', Material.STICK);
		
		WaterStickTierII.shape("FFF", "GSG", "FFF");
		WaterStickTierII.setIngredient('F', Material.DARK_PRISMARINE);
		WaterStickTierII.setIngredient('G', Material.GHAST_TEAR);
		WaterStickTierII.setIngredient('S', new ItemBuilder(Material.STICK, "§aWATER STICK TIER I", 1).getItem().getData());

		WaterStickTierIII.shape("FHF", "GSG", "FHF");
		WaterStickTierIII.setIngredient('F', Material.DARK_PRISMARINE);
		WaterStickTierIII.setIngredient('G', Material.GHAST_TEAR);
		WaterStickTierIII.setIngredient('H', Material.WITHER_SKELETON_SKULL);
		WaterStickTierIII.setIngredient('S', new ItemBuilder(Material.STICK, "§aWATER STICK TIER II", 1).getItem().getData());

	}
	
	public ShapedRecipe getWaterStickTierI() {
		return WaterStickTierI;
	}
	
	public ShapedRecipe getWaterStickTierII() {
		return WaterStickTierII;
	}
	
	public ShapedRecipe getWaterStickTierIII() {
		return WaterStickTierIII;
	}
	
	public static ItemStack WaterStickBuilder(int tier) {
		ItemStack stick = new ItemStack(Material.STICK);
		ItemMeta stickM = stick.getItemMeta();
		
		switch (tier) {
		case 1:
			stickM.setDisplayName("§1WATER STICK TIER I");
			stickM.addEnchant(Enchantment.DAMAGE_ALL, 0, true);
			stickM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			stickM.setLore(Arrays.asList("Durability:200/200"));
			break;
		case 2:
			stickM.setDisplayName("§1WATER STICK TIER II");
			stickM.addEnchant(Enchantment.DAMAGE_ALL, 3, true);
			stickM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			stickM.setLore(Arrays.asList("Durability:400/400"));
			break;
		case 3:
			stickM.setDisplayName("§1WATER STICK TIER III");
			stickM.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
			stickM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			stickM.setLore(Arrays.asList("Durability:600/600"));
			break;
		}
		
		stick.setItemMeta(stickM);
		
		return stick;
	}
	
	public static ItemStack WaterStickSampleBuilder() {
		ItemStack stick = new ItemStack(Material.STICK);
		ItemMeta stickM = stick.getItemMeta();
		
		stickM.setDisplayName("§1WATER STICK");
		stickM.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
		stickM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		
		stick.setItemMeta(stickM);
		
		return stick;
	}
	
	public static Inventory getWaterStickRecipe() {
		Inventory inv = Bukkit.createInventory(null, 54, "§8Water Stick");
		
		inv.setItem(0, new ItemBuilder(Material.BARRIER, "§cBack <-", 1).getItem());
		
		inv.setItem(9, new ItemStack(Material.DARK_PRISMARINE));
		inv.setItem(10, new ItemStack(Material.DARK_PRISMARINE));
		inv.setItem(11, new ItemStack(Material.DARK_PRISMARINE));
		inv.setItem(18, new ItemStack(Material.DARK_PRISMARINE));
		inv.setItem(19, new ItemStack(Material.STICK));
		inv.setItem(20, new ItemStack(Material.DARK_PRISMARINE));
		inv.setItem(27, new ItemStack(Material.DARK_PRISMARINE));
		inv.setItem(28, new ItemStack(Material.DARK_PRISMARINE));
		inv.setItem(29, new ItemStack(Material.DARK_PRISMARINE));
		inv.setItem(46, WaterStickBuilder(1));
		
		inv.setItem(12, new ItemStack(Material.DARK_PRISMARINE));
		inv.setItem(13, new ItemStack(Material.DARK_PRISMARINE));
		inv.setItem(14, new ItemStack(Material.DARK_PRISMARINE));
		inv.setItem(21, new ItemStack(Material.GHAST_TEAR));
		inv.setItem(22, WaterStickBuilder(1));
		inv.setItem(23, new ItemStack(Material.GHAST_TEAR));
		inv.setItem(30, new ItemStack(Material.DARK_PRISMARINE));
		inv.setItem(31, new ItemStack(Material.DARK_PRISMARINE));
		inv.setItem(32, new ItemStack(Material.DARK_PRISMARINE));
		inv.setItem(49, WaterStickBuilder(2));
		
		inv.setItem(15, new ItemStack(Material.DARK_PRISMARINE));
		inv.setItem(16, new ItemStack(Material.WITHER_SKELETON_SKULL));
		inv.setItem(17, new ItemStack(Material.DARK_PRISMARINE));
		inv.setItem(24, new ItemStack(Material.GHAST_TEAR));
		inv.setItem(25, WaterStickBuilder(2));
		inv.setItem(26, new ItemStack(Material.GHAST_TEAR));
		inv.setItem(33, new ItemStack(Material.DARK_PRISMARINE));
		inv.setItem(34, new ItemStack(Material.WITHER_SKELETON_SKULL));
		inv.setItem(35, new ItemStack(Material.DARK_PRISMARINE));
		inv.setItem(52, WaterStickBuilder(3));
		
		return inv;
	}
}
