package fr.kosmosuniverse.kworld.crafts.chim;

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

public class ChimActivator {

	private KWorldMain main;
	private ShapedRecipe activator;
	
	public ChimActivator(KWorldMain main) {
		this.main = main;
		
		activator = new ShapedRecipe(new NamespacedKey(this.main, "Activator"), ActivatorBuilder());
		
		activator.shape("BTB", "REW", "BFB");
		activator.setIngredient('T', Material.TRIPWIRE_HOOK);
		activator.setIngredient('R', Material.BLAZE_ROD);
		activator.setIngredient('E', Material.END_ROD);
		activator.setIngredient('W', Material.BONE);
		activator.setIngredient('F', Material.FIREWORK_ROCKET);
	}
	
	public ShapedRecipe getActivator() {
		return activator;
	}
	
	public static ItemStack ActivatorBuilder() {
		ItemStack item = new ItemBuilder(Material.END_ROD, "Activator").getItem();
		ItemMeta itM = item.getItemMeta();
		
		itM.addEnchant(Enchantment.ARROW_DAMAGE, 0, true);
		itM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		
		item.setItemMeta(itM);
		
		return item;
	}
	
	public static Inventory getActivatorRecipe() {
		Inventory inv = Bukkit.createInventory(null, 27, "§8Activator");
		
		inv.setItem(0, new ItemBuilder(Material.BARRIER, "§cBack <-").getItem());
		
		inv.setItem(4, new ItemStack(Material.TRIPWIRE_HOOK));
		inv.setItem(12, new ItemStack(Material.BLAZE_ROD));
		inv.setItem(13, new ItemStack(Material.END_ROD));
		inv.setItem(14, new ItemStack(Material.BONE));
		inv.setItem(22, new ItemStack(Material.FIREWORK_ROCKET));
		
		return inv;
	}
}
