package fr.kosmosuniverse.kworld;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemBuilder {
	
	private ItemStack it;
	
	public ItemBuilder(Material m, String name, Integer nb) {
		it = new ItemStack(m, nb);
		ItemMeta itM = it.getItemMeta();
		
		itM.setDisplayName(name);
		it.setItemMeta(itM);
	}
	
	public ItemStack getItem() {
		return it;
	}
}