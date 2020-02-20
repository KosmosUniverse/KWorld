package fr.kosmosuniverse.kworld.crafts.chim.essences;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import fr.kosmosuniverse.kworld.KWorldMain;
import fr.kosmosuniverse.kworld.crafts.chim.molecules.Molecules;

public abstract class AEssence {
	protected ArrayList<String> names;
	protected ArrayList<String> itemNames;
	protected ArrayList<ShapedRecipe> recipes;
	protected ArrayList<ItemStack> item;
	protected KWorldMain main;
	protected ArrayList<Inventory> invs;
	protected Molecules mols;
	
	public abstract void Shape();
	public abstract void createInventories();
	
	public AEssence(KWorldMain main, Molecules mols, String... names) {
		this.main = main;
		
		this.mols = mols;
		this.names = new ArrayList<String>();
		this.itemNames = new ArrayList<String>();
		this.item = new ArrayList<ItemStack>();
		this.recipes = new ArrayList<ShapedRecipe>();
		this.invs = new ArrayList<Inventory>();
		
		for (String n : names) {
			this.names.add(n);
			this.itemNames.add(n.toLowerCase().replace(' ', '_'));
		}
		
		EssenceBuilder();
		
		Shape();
		createInventories();
	}

	private void EssenceBuilder() {
		
		for (String n : names) {
			ItemStack it = new ItemStack(Material.BONE_MEAL);
			ItemMeta itM = it.getItemMeta();
			
			itM.setDisplayName("§a" + n + " Essence");
			
			it.setItemMeta(itM);
			
			item.add(it);
		}
	}

	public ItemStack SampleBuilder() {
		ItemStack it = new ItemStack(Material.BONE_MEAL);
		ItemMeta itM = it.getItemMeta();
		
		itM.setDisplayName("§aEssence");
		
		it.setItemMeta(itM);
		
		return it;
	}
	
	public ArrayList<String> getNames() {
		return this.names;
	}
	
	public ArrayList<ItemStack> getEssence() {
		return this.item;
	}
	
	public ArrayList<ShapedRecipe> getRecipes() {
		return this.recipes;
	}
	
	public ArrayList<Inventory> getInv() {
		return invs;
	}
}
