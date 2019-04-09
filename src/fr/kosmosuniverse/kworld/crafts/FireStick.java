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

public class FireStick {
	
	private KWorldMain main;
	private ShapedRecipe FireStickTierI;
	private ShapedRecipe FireStickTierII;
	private ShapedRecipe FireStickTierIII;
	
	public FireStick(KWorldMain main) {
		this.main = main;
		
		FireStickTierI = new ShapedRecipe(new NamespacedKey(this.main, "FireStick1"), FireStickBuilder(1));
		FireStickTierII = new ShapedRecipe(new NamespacedKey(this.main, "FireStick2"), FireStickBuilder(2));
		FireStickTierIII = new ShapedRecipe(new NamespacedKey(this.main, "FireStick3"), FireStickBuilder(3));
		
		FireStickTierI.shape("FFF", "FSF", "FFF");
		FireStickTierI.setIngredient('F', Material.FIRE_CHARGE);
		FireStickTierI.setIngredient('S', Material.STICK);
		
		FireStickTierII.shape("FFF", "GSG", "FFF");
		FireStickTierII.setIngredient('F', Material.FIRE_CHARGE);
		FireStickTierII.setIngredient('G', Material.GHAST_TEAR);
		FireStickTierII.setIngredient('S', new ItemBuilder(Material.STICK, "§cFIRE STICK TIER I", 1).getItem().getData());

		FireStickTierIII.shape("FHF", "GSG", "FHF");
		FireStickTierIII.setIngredient('F', Material.FIRE_CHARGE);
		FireStickTierIII.setIngredient('G', Material.GHAST_TEAR);
		FireStickTierIII.setIngredient('H', Material.WITHER_SKELETON_SKULL);
		FireStickTierIII.setIngredient('S', new ItemBuilder(Material.STICK, "§cFIRE STICK TIER II", 1).getItem().getData());

	}
	
	public ShapedRecipe getFireStickTierI() {
		return FireStickTierI;
	}
	
	public ShapedRecipe getFireStickTierII() {
		return FireStickTierII;
	}
	
	public ShapedRecipe getFireStickTierIII() {
		return FireStickTierIII;
	}
	
	private static ItemStack FireStickBuilder(int tier) {
		ItemStack stick = new ItemStack(Material.STICK);
		ItemMeta stickM = stick.getItemMeta();
		
		switch (tier) {
		case 1:
			stickM.setDisplayName("§cFIRE STICK TIER I");
			stickM.addEnchant(Enchantment.FIRE_ASPECT, 0, true);
			stickM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			stickM.setLore(Arrays.asList("Durability:200/200"));
			break;
		case 2:
			stickM.setDisplayName("§cFIRE STICK TIER II");
			stickM.addEnchant(Enchantment.FIRE_ASPECT, 3, true);
			stickM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			stickM.setLore(Arrays.asList("Durability:400/400"));
			break;
		case 3:
			stickM.setDisplayName("§cFIRE STICK TIER III");
			stickM.addEnchant(Enchantment.FIRE_ASPECT, 5, true);
			stickM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			stickM.setLore(Arrays.asList("Durability:600/600"));
			break;
		}
		
		stick.setItemMeta(stickM);
		
		return stick;
	}
	
	public static Inventory getFireStickRecipe() {
		Inventory inv = Bukkit.createInventory(null, 54, "§8Fire Stick");
		
		inv.setItem(0, new ItemBuilder(Material.BARRIER, "§cBack <-", 1).getItem());
		
		inv.setItem(9, new ItemStack(Material.FIRE_CHARGE));
		inv.setItem(10, new ItemStack(Material.FIRE_CHARGE));
		inv.setItem(11, new ItemStack(Material.FIRE_CHARGE));
		inv.setItem(18, new ItemStack(Material.FIRE_CHARGE));
		inv.setItem(19, new ItemStack(Material.STICK));
		inv.setItem(20, new ItemStack(Material.FIRE_CHARGE));
		inv.setItem(27, new ItemStack(Material.FIRE_CHARGE));
		inv.setItem(28, new ItemStack(Material.FIRE_CHARGE));
		inv.setItem(29, new ItemStack(Material.FIRE_CHARGE));
		inv.setItem(46, FireStickBuilder(1));
		
		inv.setItem(12, new ItemStack(Material.FIRE_CHARGE));
		inv.setItem(13, new ItemStack(Material.FIRE_CHARGE));
		inv.setItem(14, new ItemStack(Material.FIRE_CHARGE));
		inv.setItem(21, new ItemStack(Material.GHAST_TEAR));
		inv.setItem(22, FireStickBuilder(1));
		inv.setItem(23, new ItemStack(Material.GHAST_TEAR));
		inv.setItem(30, new ItemStack(Material.FIRE_CHARGE));
		inv.setItem(31, new ItemStack(Material.FIRE_CHARGE));
		inv.setItem(32, new ItemStack(Material.FIRE_CHARGE));
		inv.setItem(49, FireStickBuilder(2));
		
		inv.setItem(15, new ItemStack(Material.FIRE_CHARGE));
		inv.setItem(16, new ItemStack(Material.WITHER_SKELETON_SKULL));
		inv.setItem(17, new ItemStack(Material.FIRE_CHARGE));
		inv.setItem(24, new ItemStack(Material.GHAST_TEAR));
		inv.setItem(25, FireStickBuilder(2));
		inv.setItem(26, new ItemStack(Material.GHAST_TEAR));
		inv.setItem(33, new ItemStack(Material.FIRE_CHARGE));
		inv.setItem(34, new ItemStack(Material.WITHER_SKELETON_SKULL));
		inv.setItem(35, new ItemStack(Material.FIRE_CHARGE));
		inv.setItem(52, FireStickBuilder(3));
		
		return inv;
	}
}
