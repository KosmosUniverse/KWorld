package fr.kosmosuniverse.kworld.crafts.chim.elements;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Element {
	private String name;
	private String symbol;
	private Integer protons;
	private ItemStack item;
	
	public Element(String name, String symbol, Integer protons) {
		item = new ItemStack(Material.GLASS_BOTTLE);
		
		ItemMeta itM = item.getItemMeta();
		
		itM.setDisplayName("§b" + symbol);
		itM.setLore(Arrays.asList("Name : " + name, "Protons : " + protons));
		
		item.setItemMeta(itM);
		
		this.name = name;
		this.symbol = symbol;
		this.protons = protons;
	}
	
	public Element(Element elem) {
		this.name = elem.name;
		this.symbol = elem.symbol;
		this.protons = elem.protons;
		this.item = elem.item;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getSymbol() {
		return this.symbol;
	}
	
	public Integer getProtons() {
		return this.protons;
	}
	
	public ItemStack getElem() {
		return this.item;
	}
}
