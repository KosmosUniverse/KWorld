package fr.kosmosuniverse.kworld.crafts;

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

public class EarthStick {
	
	private KWorldMain main;
	private ShapedRecipe EarthStickTierI;
	private ShapedRecipe EarthStickTierII;
	private ShapedRecipe EarthStickTierIII;
	
	public EarthStick(KWorldMain main) {
		this.main = main;
		
		EarthStickTierI = new ShapedRecipe(new NamespacedKey(this.main, "EarthStick1"), EarthStickBuilder(1));
		EarthStickTierII = new ShapedRecipe(new NamespacedKey(this.main, "EarthStick2"), EarthStickBuilder(2));
		EarthStickTierIII = new ShapedRecipe(new NamespacedKey(this.main, "EarthStick3"), EarthStickBuilder(3));
		
		EarthStickTierI.shape("FFF", "FSF", "FFF");
		EarthStickTierI.setIngredient('F', Material.SOUL_SAND);
		EarthStickTierI.setIngredient('S', Material.STICK);
		
		EarthStickTierII.shape("FFF", "GSG", "FFF");
		EarthStickTierII.setIngredient('F', Material.SOUL_SAND);
		EarthStickTierII.setIngredient('G', Material.GHAST_TEAR);
		EarthStickTierII.setIngredient('S', new ItemBuilder(Material.STICK, "§aEARTH STICK TIER I", 1).getItem().getData());

		EarthStickTierIII.shape("FHF", "GSG", "FHF");
		EarthStickTierIII.setIngredient('F', Material.SOUL_SAND);
		EarthStickTierIII.setIngredient('G', Material.GHAST_TEAR);
		EarthStickTierIII.setIngredient('H', Material.WITHER_SKELETON_SKULL);
		EarthStickTierIII.setIngredient('S', new ItemBuilder(Material.STICK, "§aEARTH STICK TIER II", 1).getItem().getData());

	}
	
	public ShapedRecipe getEarthStickTierI() {
		return EarthStickTierI;
	}
	
	public ShapedRecipe getEarthStickTierII() {
		return EarthStickTierII;
	}
	
	public ShapedRecipe getEarthStickTierIII() {
		return EarthStickTierIII;
	}
	
	public static ItemStack EarthStickBuilder(int tier) {
		ItemStack stick = new ItemStack(Material.STICK);
		ItemMeta stickM = stick.getItemMeta();
		
		switch (tier) {
		case 1:
			stickM.setDisplayName("§aEARTH STICK TIER I");
			stickM.addEnchant(Enchantment.DAMAGE_ARTHROPODS, 0, true);
			stickM.addEnchant(Enchantment.DAMAGE_UNDEAD, 0, true);
			stickM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			stickM.setLore(Arrays.asList("Durability:200/200"));
			break;
		case 2:
			stickM.setDisplayName("§aEARTH STICK TIER II");
			stickM.addEnchant(Enchantment.DAMAGE_ARTHROPODS, 3, true);
			stickM.addEnchant(Enchantment.DAMAGE_UNDEAD, 3, true);
			stickM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			stickM.setLore(Arrays.asList("Durability:400/400"));
			break;
		case 3:
			stickM.setDisplayName("§aEARTH STICK TIER III");
			stickM.addEnchant(Enchantment.DAMAGE_ARTHROPODS, 5, true);
			stickM.addEnchant(Enchantment.DAMAGE_UNDEAD, 5, true);
			stickM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			stickM.setLore(Arrays.asList("Durability:600/600"));
			break;
		}
		
		stick.setItemMeta(stickM);
		
		return stick;
	}
	
	public static Inventory getEarthStickRecipe() {
		Inventory inv = Bukkit.createInventory(null, 54, "§8Earth Stick");
		
		inv.setItem(0, new ItemBuilder(Material.BARRIER, "§cBack <-", 1).getItem());
		
		inv.setItem(9, new ItemStack(Material.SOUL_SAND));
		inv.setItem(10, new ItemStack(Material.SOUL_SAND));
		inv.setItem(11, new ItemStack(Material.SOUL_SAND));
		inv.setItem(18, new ItemStack(Material.SOUL_SAND));
		inv.setItem(19, new ItemStack(Material.STICK));
		inv.setItem(20, new ItemStack(Material.SOUL_SAND));
		inv.setItem(27, new ItemStack(Material.SOUL_SAND));
		inv.setItem(28, new ItemStack(Material.SOUL_SAND));
		inv.setItem(29, new ItemStack(Material.SOUL_SAND));
		inv.setItem(46, EarthStickBuilder(1));
		
		inv.setItem(12, new ItemStack(Material.SOUL_SAND));
		inv.setItem(13, new ItemStack(Material.SOUL_SAND));
		inv.setItem(14, new ItemStack(Material.SOUL_SAND));
		inv.setItem(21, new ItemStack(Material.GHAST_TEAR));
		inv.setItem(22, EarthStickBuilder(1));
		inv.setItem(23, new ItemStack(Material.GHAST_TEAR));
		inv.setItem(30, new ItemStack(Material.SOUL_SAND));
		inv.setItem(31, new ItemStack(Material.SOUL_SAND));
		inv.setItem(32, new ItemStack(Material.SOUL_SAND));
		inv.setItem(49, EarthStickBuilder(2));
		
		inv.setItem(15, new ItemStack(Material.SOUL_SAND));
		inv.setItem(16, new ItemStack(Material.WITHER_SKELETON_SKULL));
		inv.setItem(17, new ItemStack(Material.SOUL_SAND));
		inv.setItem(24, new ItemStack(Material.GHAST_TEAR));
		inv.setItem(25, EarthStickBuilder(2));
		inv.setItem(26, new ItemStack(Material.GHAST_TEAR));
		inv.setItem(33, new ItemStack(Material.SOUL_SAND));
		inv.setItem(34, new ItemStack(Material.WITHER_SKELETON_SKULL));
		inv.setItem(35, new ItemStack(Material.SOUL_SAND));
		inv.setItem(52, EarthStickBuilder(3));
		
		return inv;
	}
}
