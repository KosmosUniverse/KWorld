package fr.kosmosuniverse.kworld.crafts.xp;

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

public class XpStorage {
	
	private KWorldMain main;
	private ShapedRecipe xpStorageTierI;
	private ShapedRecipe xpStorageTierII;
	private ShapedRecipe xpStorageTierIII;
	private ShapedRecipe xpStorageTierIV;
	private ShapedRecipe xpStorageTierV;
	
	public XpStorage(KWorldMain main) {
		this.main = main;
		
		xpStorageTierI = new ShapedRecipe(new NamespacedKey(this.main, "XpStorage1"), xpStorageBuilder(1));
		xpStorageTierII = new ShapedRecipe(new NamespacedKey(this.main, "XpStorage2"), xpStorageBuilder(2));
		xpStorageTierIII = new ShapedRecipe(new NamespacedKey(this.main, "XpStorage3"), xpStorageBuilder(3));
		xpStorageTierIV = new ShapedRecipe(new NamespacedKey(this.main, "XpStorage4"), xpStorageBuilder(4));
		xpStorageTierV = new ShapedRecipe(new NamespacedKey(this.main, "XpStorage5"), xpStorageBuilder(5));
		
		xpStorageTierI.shape("GGG", "GBG", "GGG");
		xpStorageTierI.setIngredient('G', Material.GLASS);
		xpStorageTierI.setIngredient('B', Material.EXPERIENCE_BOTTLE);
		
		xpStorageTierII.shape("GGG", "TBT", "GGG");
		xpStorageTierII.setIngredient('G', Material.GLASS);
		xpStorageTierII.setIngredient('T', Material.GHAST_TEAR);
		xpStorageTierII.setIngredient('B', xpStorageBuilder(1).getData());
		
		xpStorageTierIII.shape("GHG", "TBT", "GHG");
		xpStorageTierIII.setIngredient('G', Material.GLASS);
		xpStorageTierIII.setIngredient('T', Material.GHAST_TEAR);
		xpStorageTierIII.setIngredient('H', Material.WITHER_SKELETON_SKULL);
		xpStorageTierIII.setIngredient('B', xpStorageBuilder(2).getData());
		
		xpStorageTierIV.shape("GSG", "SBS", "GSG");
		xpStorageTierIV.setIngredient('G', Material.GLASS);
		xpStorageTierIV.setIngredient('B', Material.EXPERIENCE_BOTTLE);
		xpStorageTierIV.setIngredient('S', xpStorageBuilder(3).getData());
		
		xpStorageTierV.shape("GSG", "SNS", "GSG");
		xpStorageTierV.setIngredient('G', Material.GLASS);
		xpStorageTierV.setIngredient('N', Material.NETHER_STAR);
		xpStorageTierV.setIngredient('S', xpStorageBuilder(4).getData());
	}
	
	public ShapedRecipe getXpStorageTierI() {
		return xpStorageTierI;
	}
	
	public ShapedRecipe getXpStorageTierII() {
		return xpStorageTierII;
	}
	
	public ShapedRecipe getXpStorageTierIII() {
		return xpStorageTierIII;
	}
	
	public ShapedRecipe getXpStorageTierIV() {
		return xpStorageTierIV;
	}
	
	public ShapedRecipe getXpStorageTierV() {
		return xpStorageTierV;
	}
	
	public static ItemStack xpStorageBuilder(int tier) {
		ItemStack item = new ItemStack(Material.EMERALD);
		ItemMeta itM = item.getItemMeta();
		itM.addEnchant(Enchantment.DIG_SPEED, 0, true);
		itM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		switch (tier) {
		case 1:
			itM.setDisplayName("§2XP STORAGE TIER I");
			itM.setLore(Arrays.asList("XP Stored:0/216", "XP Level:0/12"));
			break;
		case 2:
			itM.setDisplayName("§2XP STORAGE TIER II");
			itM.setLore(Arrays.asList("XP Stored:0/828", "XP Level:0/24"));
			break;
		case 3:
			itM.setDisplayName("§2XP STORAGE TIER III");
			itM.setLore(Arrays.asList("XP Stored:0/1395", "XP Level:0/30"));
			break;
		case 4:
			itM.setDisplayName("§2XP STORAGE TIER IV");
			itM.setLore(Arrays.asList("XP Stored:0/2920", "XP Level:0/40"));
			break;
		case 5:
			itM.setDisplayName("§2XP STORAGE TIER V");
			itM.setLore(Arrays.asList("XP Stored:0", "XP Level:0"));
			break;
		default:
			return null;
		}
		
		item.setItemMeta(itM);
		return (item);
	}
	
	public static ItemStack xpStorageSampleBuilder() {
		ItemStack item = new ItemStack(Material.EMERALD);
		ItemMeta itM = item.getItemMeta();
		
		itM.setDisplayName("§2XP STORAGE");
		itM.addEnchant(Enchantment.DIG_SPEED, 0, true);
		itM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(itM);

		return item;
	}
	
	public static Inventory getXpStorageRecipe() {
		Inventory inv = Bukkit.createInventory(null, 54, "§8XP STORAGE 1");
		
		inv.setItem(0, new ItemBuilder(Material.BARRIER, "§cBack <-", 1).getItem());
		inv.setItem(8, new ItemBuilder(Material.LIME_STAINED_GLASS_PANE, "§aNext ->", 1).getItem());
		
		inv.setItem(9, new ItemStack(Material.GLASS));
		inv.setItem(10, new ItemStack(Material.GLASS));
		inv.setItem(11, new ItemStack(Material.GLASS));
		inv.setItem(18, new ItemStack(Material.GLASS));
		inv.setItem(19, new ItemStack(Material.EXPERIENCE_BOTTLE));
		inv.setItem(20, new ItemStack(Material.GLASS));
		inv.setItem(27, new ItemStack(Material.GLASS));
		inv.setItem(28, new ItemStack(Material.GLASS));
		inv.setItem(29, new ItemStack(Material.GLASS));
		inv.setItem(46, xpStorageBuilder(1));
		
		inv.setItem(12, new ItemStack(Material.GLASS));
		inv.setItem(13, new ItemStack(Material.GLASS));
		inv.setItem(14, new ItemStack(Material.GLASS));
		inv.setItem(21, new ItemStack(Material.GHAST_TEAR));
		inv.setItem(22, xpStorageBuilder(1));
		inv.setItem(23, new ItemStack(Material.GHAST_TEAR));
		inv.setItem(30, new ItemStack(Material.GLASS));
		inv.setItem(31, new ItemStack(Material.GLASS));
		inv.setItem(32, new ItemStack(Material.GLASS));
		inv.setItem(49, xpStorageBuilder(2));
		
		inv.setItem(15, new ItemStack(Material.GLASS));
		inv.setItem(16, new ItemStack(Material.WITHER_SKELETON_SKULL));
		inv.setItem(17, new ItemStack(Material.GLASS));
		inv.setItem(24, new ItemStack(Material.GHAST_TEAR));
		inv.setItem(25, xpStorageBuilder(2));
		inv.setItem(26, new ItemStack(Material.GHAST_TEAR));
		inv.setItem(33, new ItemStack(Material.GLASS));
		inv.setItem(34, new ItemStack(Material.WITHER_SKELETON_SKULL));
		inv.setItem(35, new ItemStack(Material.GLASS));
		inv.setItem(52, xpStorageBuilder(3));
		
		return inv;
	}
	
	public static Inventory getXpStorageRecipe2() {
		Inventory inv = Bukkit.createInventory(null, 54, "§8XP STORAGE 2");
		
		inv.setItem(0, new ItemBuilder(Material.BARRIER, "§cBack <-", 1).getItem());
		
		inv.setItem(10, new ItemStack(Material.GLASS));
		inv.setItem(11, xpStorageBuilder(3));
		inv.setItem(12, new ItemStack(Material.GLASS));
		inv.setItem(19, xpStorageBuilder(3));
		inv.setItem(20, new ItemStack(Material.EXPERIENCE_BOTTLE));
		inv.setItem(21, xpStorageBuilder(3));
		inv.setItem(28, new ItemStack(Material.GLASS));
		inv.setItem(29, xpStorageBuilder(3));
		inv.setItem(30, new ItemStack(Material.GLASS));
		inv.setItem(47, xpStorageBuilder(4));
				
		inv.setItem(14, new ItemStack(Material.GLASS));
		inv.setItem(15, xpStorageBuilder(4));
		inv.setItem(16, new ItemStack(Material.GLASS));
		inv.setItem(23, xpStorageBuilder(4));
		inv.setItem(24, new ItemStack(Material.NETHER_STAR));
		inv.setItem(25, xpStorageBuilder(4));
		inv.setItem(32, new ItemStack(Material.GLASS));
		inv.setItem(33, xpStorageBuilder(4));
		inv.setItem(34, new ItemStack(Material.GLASS));
		inv.setItem(51, xpStorageBuilder(5));
		
		return inv;
	}
}
