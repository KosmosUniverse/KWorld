package fr.kosmosuniverse.kworld.crafts.fun.stick;

import java.util.ArrayList;
import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import fr.kosmosuniverse.kworld.KWorldMain;

public abstract class AStick3T {
	protected KWorldMain main;
	protected ShapedRecipe StickTierI;
	protected ShapedRecipe StickTierII;
	protected ShapedRecipe StickTierIII;
	protected String name;
	protected String color;
	protected Enchantment[] echants;
	protected Inventory inv;

	public abstract void Shapes();
	public abstract void StickInventory();
	
	public AStick3T(KWorldMain main, String name, String color, Enchantment... enchantments) {
		this.main = main;
		this.name = name;
		this.color = color;
		this.echants = enchantments;
		
		StickTierI = new ShapedRecipe(new NamespacedKey(this.main, name + "1"), StickBuilder(1));
		StickTierII = new ShapedRecipe(new NamespacedKey(this.main, name + "2"), StickBuilder(2));
		StickTierIII = new ShapedRecipe(new NamespacedKey(this.main, name + "3"), StickBuilder(3));
		
		Shapes();
		StickInventory();
	}
	
	public ArrayList<ShapedRecipe> getRecipes() {
		ArrayList<ShapedRecipe> recipes = new ArrayList<ShapedRecipe>();
		
		recipes.add(StickTierI);
		recipes.add(StickTierII);
		recipes.add(StickTierIII);
		
		return recipes;
	}
	
	public ItemStack StickSample() {
		ItemStack item = new ItemStack(Material.STICK);
		ItemMeta itM = item.getItemMeta();
		
		itM.setDisplayName(this.color + this.name);
		itM.addEnchant(Enchantment.ARROW_DAMAGE, 0, true);
		itM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		
		item.setItemMeta(itM);
		
		return item;
	}
	
	public ItemStack StickBuilder(int tier) {
		ItemStack stick = new ItemStack(Material.STICK);
		
		ItemMeta stickM = stick.getItemMeta();
		
		switch (tier) {
		case 1:
			stickM.setDisplayName(this.color + this.name + " STICK TIER I");
			
			for (Enchantment e : this.echants) {
				stickM.addEnchant(e, 0, true);				
			}

			stickM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			stickM.setLore(Arrays.asList("Durability:200/200"));
			break;
		case 2:
			stickM.setDisplayName(this.color + this.name + " STICK TIER II");
			
			for (Enchantment e : this.echants) {
				stickM.addEnchant(e, 3, true);
			}
			
			stickM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			stickM.setLore(Arrays.asList("Durability:400/400"));
			break;
		case 3:
			stickM.setDisplayName(this.color + this.name + " STICK TIER III");
			
			for (Enchantment e : this.echants) {
				stickM.addEnchant(e, 5, true);
			}
			
			stickM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			stickM.setLore(Arrays.asList("Durability:600/600"));
			break;
		}
		
		stick.setItemMeta(stickM);
		
		return stick;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getColor() {
		return this.color;
	}
	
	public Inventory getInventory() {
		return this.inv;
	}
}
