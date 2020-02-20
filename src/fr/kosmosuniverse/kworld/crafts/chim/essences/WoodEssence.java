package fr.kosmosuniverse.kworld.crafts.chim.essences;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ShapedRecipe;

import fr.kosmosuniverse.kworld.ItemBuilder;
import fr.kosmosuniverse.kworld.KWorldMain;
import fr.kosmosuniverse.kworld.crafts.chim.molecules.Molecules;

public class WoodEssence extends AEssence {
	
	public WoodEssence(KWorldMain main, Molecules mols) {
		super(main, mols, "Oak Wood", "Dark Oak Wood", "Birch Wood", "Acacia Wood", "Spruce Woor","Jungle Wood");
	}

	@Override
	public void Shape() {
		ShapedRecipe temp;
		
		temp = new ShapedRecipe(new NamespacedKey(this.main, itemNames.get(0) + "_essence_oak"), item.get(0));
		temp.shape("CCC", "RRC", "RRC");
		temp.setIngredient('C', mols.searchMolByName("Cellulose").getMol().getData());
		recipes.add(temp);
		
		temp = new ShapedRecipe(new NamespacedKey(this.main, itemNames.get(1) + "_essence_darkoak"), item.get(1));
		temp.shape("CCR", "RCC", "RRC");
		temp.setIngredient('C', mols.searchMolByName("Cellulose").getMol().getData());
		recipes.add(temp);
		
		temp = new ShapedRecipe(new NamespacedKey(this.main, itemNames.get(2) + "_essence_acacia"), item.get(2));
		temp.shape("CRR", "CCR", "RCC");
		temp.setIngredient('C', mols.searchMolByName("Cellulose").getMol().getData());
		recipes.add(temp);
		
		temp = new ShapedRecipe(new NamespacedKey(this.main, itemNames.get(3) + "_essence_birch"), item.get(3));
		temp.shape("CRR", "CRR", "CCC");
		temp.setIngredient('C', mols.searchMolByName("Cellulose").getMol().getData());
		recipes.add(temp);
		
		temp = new ShapedRecipe(new NamespacedKey(this.main, itemNames.get(4) + "_essence_spruce"), item.get(4));
		temp.shape("RCR", "CCC", "RCR");
		temp.setIngredient('C', mols.searchMolByName("Cellulose").getMol().getData());
		recipes.add(temp);
		
		temp = new ShapedRecipe(new NamespacedKey(this.main, itemNames.get(5) + "_essence_jungle"), item.get(5));
		temp.shape("CRC", "RCR", "CRC");
		temp.setIngredient('C', mols.searchMolByName("Cellulose").getMol().getData());
		recipes.add(temp);
	}

	@Override
	public void createInventories() {
		Inventory inv = Bukkit.createInventory(null, 27, "§8Wood Essence 1");
		
		inv.setItem(0,  new ItemBuilder(Material.BARRIER, "§c<- Back").getItem());
		inv.setItem(26, new ItemBuilder(Material.LIME_STAINED_GLASS_PANE, "§aNext Page ->").getItem());
		
		inv.setItem(2, this.mols.searchMolByName("Cellulose").getMol());
		inv.setItem(3, this.mols.searchMolByName("Cellulose").getMol());
		inv.setItem(4, this.mols.searchMolByName("Cellulose").getMol());
		inv.setItem(13, this.mols.searchMolByName("Cellulose").getMol());
		inv.setItem(22, this.mols.searchMolByName("Cellulose").getMol());
		
		this.invs.add(inv);
		
		inv = Bukkit.createInventory(null, 27, "§8Wood Essence 2");
		
		inv.setItem(0,  new ItemBuilder(Material.BARRIER, "§c<- Back").getItem());
		inv.setItem(26, new ItemBuilder(Material.LIME_STAINED_GLASS_PANE, "§aNext Page ->").getItem());
		
		inv.setItem(2, this.mols.searchMolByName("Cellulose").getMol());
		inv.setItem(3, this.mols.searchMolByName("Cellulose").getMol());
		inv.setItem(12, this.mols.searchMolByName("Cellulose").getMol());
		inv.setItem(13, this.mols.searchMolByName("Cellulose").getMol());
		inv.setItem(22, this.mols.searchMolByName("Cellulose").getMol());
		
		this.invs.add(inv);
		
		inv = Bukkit.createInventory(null, 27, "§8Wood Essence 3");
		
		inv.setItem(0,  new ItemBuilder(Material.BARRIER, "§c<- Back").getItem());
		inv.setItem(26, new ItemBuilder(Material.LIME_STAINED_GLASS_PANE, "§aNext Page ->").getItem());
		
		inv.setItem(2, this.mols.searchMolByName("Cellulose").getMol());
		inv.setItem(11, this.mols.searchMolByName("Cellulose").getMol());
		inv.setItem(12, this.mols.searchMolByName("Cellulose").getMol());
		inv.setItem(21, this.mols.searchMolByName("Cellulose").getMol());
		inv.setItem(22, this.mols.searchMolByName("Cellulose").getMol());
		
		this.invs.add(inv);
		
		inv = Bukkit.createInventory(null, 27, "§8Wood Essence 4");
		
		inv.setItem(0,  new ItemBuilder(Material.BARRIER, "§c<- Back").getItem());
		inv.setItem(26, new ItemBuilder(Material.LIME_STAINED_GLASS_PANE, "§aNext Page ->").getItem());
		
		inv.setItem(2, this.mols.searchMolByName("Cellulose").getMol());
		inv.setItem(11, this.mols.searchMolByName("Cellulose").getMol());
		inv.setItem(20, this.mols.searchMolByName("Cellulose").getMol());
		inv.setItem(21, this.mols.searchMolByName("Cellulose").getMol());
		inv.setItem(22, this.mols.searchMolByName("Cellulose").getMol());
		
		this.invs.add(inv);
		
		inv = Bukkit.createInventory(null, 27, "§8Wood Essence 5");
		
		inv.setItem(0,  new ItemBuilder(Material.BARRIER, "§c<- Back").getItem());
		inv.setItem(26, new ItemBuilder(Material.LIME_STAINED_GLASS_PANE, "§aNext Page ->").getItem());
		
		inv.setItem(3, this.mols.searchMolByName("Cellulose").getMol());
		inv.setItem(10, this.mols.searchMolByName("Cellulose").getMol());
		inv.setItem(11, this.mols.searchMolByName("Cellulose").getMol());
		inv.setItem(12, this.mols.searchMolByName("Cellulose").getMol());
		inv.setItem(21, this.mols.searchMolByName("Cellulose").getMol());
		
		this.invs.add(inv);
		
		inv = Bukkit.createInventory(null, 27, "§8Wood Essence 6");
		
		inv.setItem(0,  new ItemBuilder(Material.BARRIER, "§c<- Back").getItem());
		
		inv.setItem(2, this.mols.searchMolByName("Cellulose").getMol());
		inv.setItem(4, this.mols.searchMolByName("Cellulose").getMol());
		inv.setItem(12, this.mols.searchMolByName("Cellulose").getMol());
		inv.setItem(20, this.mols.searchMolByName("Cellulose").getMol());
		inv.setItem(22, this.mols.searchMolByName("Cellulose").getMol());
		
		this.invs.add(inv);
	}

}
