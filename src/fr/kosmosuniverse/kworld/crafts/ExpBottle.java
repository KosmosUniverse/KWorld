package fr.kosmosuniverse.kworld.crafts;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

import fr.kosmosuniverse.kworld.ItemBuilder;
import fr.kosmosuniverse.kworld.KWorldMain;

public class ExpBottle {
	private KWorldMain main;
	private ShapedRecipe expBottleCoal;
	private ShapedRecipe expBottleRed;
	private ShapedRecipe expBottleLap;
	private ShapedRecipe expBottleDiam;
	
	public ExpBottle(KWorldMain main) {
		this.main = main;
		
		expBottleCoal = new ShapedRecipe(new NamespacedKey(this.main, "ExpCoal"), new ItemStack(Material.EXPERIENCE_BOTTLE));
		expBottleRed = new ShapedRecipe(new NamespacedKey(this.main, "ExpRed"), new ItemStack(Material.EXPERIENCE_BOTTLE, 10));
		expBottleLap = new ShapedRecipe(new NamespacedKey(this.main, "ExpLap"), new ItemStack(Material.EXPERIENCE_BOTTLE, 15));
		expBottleDiam = new ShapedRecipe(new NamespacedKey(this.main, "ExpDiam"), new ItemStack(Material.EXPERIENCE_BOTTLE, 20));
		
		expBottleCoal.shape("DSD", "SCS", "DSD");
		expBottleCoal.setIngredient('D', Material.DIRT);
		expBottleCoal.setIngredient('S', Material.SAND);
		expBottleCoal.setIngredient('C', Material.COAL_ORE);

		expBottleRed.shape("DSD", "SCS", "DSD");
		expBottleRed.setIngredient('D', Material.DIRT);
		expBottleRed.setIngredient('S', Material.SAND);
		expBottleRed.setIngredient('C', Material.REDSTONE_ORE);
		
		expBottleLap.shape("DSD", "SCS", "DSD");
		expBottleLap.setIngredient('D', Material.DIRT);
		expBottleLap.setIngredient('S', Material.SAND);
		expBottleLap.setIngredient('C', Material.LAPIS_ORE);
		
		expBottleDiam.shape("DSD", "SCS", "DSD");
		expBottleDiam.setIngredient('D', Material.DIRT);
		expBottleDiam.setIngredient('S', Material.SAND);
		expBottleDiam.setIngredient('C', Material.DIAMOND_ORE);
	}
	
	public ShapedRecipe getBottleCoal() {
		return expBottleCoal;
	}
	
	public ShapedRecipe getBottleRed() {
		return expBottleRed;
	}
	
	public ShapedRecipe getBottleLap() {
		return expBottleLap;
	}
	
	public ShapedRecipe getBottleDiam() {
		return expBottleDiam;
	}
	
	public static Inventory getExpBottleRecipe() {
		Inventory inv = Bukkit.createInventory(null, 54, "§8XP Bottle");
		
		inv.setItem(0, new ItemBuilder(Material.BARRIER, "§cBack <-", 1).getItem());
		
		inv.setItem(2, new ItemStack(Material.DIRT));
		inv.setItem(3, new ItemStack(Material.SAND));
		inv.setItem(4, new ItemStack(Material.DIRT));
		
		inv.setItem(11, new ItemStack(Material.SAND));
		inv.setItem(12, new ItemStack(Material.COAL_ORE));
		inv.setItem(13, new ItemStack(Material.SAND));
		
		inv.setItem(20, new ItemStack(Material.DIRT));
		inv.setItem(21, new ItemStack(Material.SAND));
		inv.setItem(22, new ItemStack(Material.DIRT));
		
		inv.setItem(15, new ItemStack(Material.EXPERIENCE_BOTTLE));
		
		for (int i = 27; i < 36; i++) {
			inv.setItem(i, new ItemBuilder(Material.LIME_STAINED_GLASS_PANE, "More possibilities ...", 1).getItem());
		}
		
		inv.setItem(36, new ItemStack(Material.COAL_ORE));
		inv.setItem(45, new ItemStack(Material.EXPERIENCE_BOTTLE));
		
		inv.setItem(37, new ItemStack(Material.REDSTONE_ORE));
		inv.setItem(46, new ItemStack(Material.EXPERIENCE_BOTTLE, 10));
		
		inv.setItem(38, new ItemStack(Material.LAPIS_ORE));
		inv.setItem(47, new ItemStack(Material.EXPERIENCE_BOTTLE, 15));
		
		inv.setItem(39, new ItemStack(Material.DIAMOND_ORE));
		inv.setItem(48, new ItemStack(Material.EXPERIENCE_BOTTLE, 20));
		
		return inv;
	}
}
