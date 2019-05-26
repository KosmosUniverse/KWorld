package fr.kosmosuniverse.kworld.crafts.chim.molecules;

import java.util.ArrayList;
import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.kosmosuniverse.kworld.crafts.chim.elements.Element;

public class Molecule {
	private String name;
	private String symbols;
	private ArrayList<Compose> compose;
	private ArrayList<Element> elems;
	private ItemStack item;
	
	public Molecule(String name, String symbols, Compose... comp) {
		this.name = name;
		this.symbols = symbols;
		this.compose = new ArrayList<Compose>();
		this.elems = new ArrayList<Element>();
		
		for (Compose c : comp) {
			this.compose.add(c);
			this.elems.add(c.elem);
		}
		
		item = new ItemStack(Material.GLASS_BOTTLE);
		
		ItemMeta itM = item.getItemMeta();
		
		itM.setDisplayName("§c" + this.name);
		itM.setLore(Arrays.asList("Compose : " + this.symbols));
		
		item.setItemMeta(itM);
	}
	
	public Molecule(Molecule mol) {
		this.name = mol.name;
		this.symbols = mol.symbols;
		this.item = mol.item;
		this.compose = mol.compose;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getSymbols() {
		return this.symbols;
	}
		
	public ItemStack getMol() {
		return this.item;
	}
	
	public ArrayList<Compose> getCompose() {
		return this.compose;
	}
	
	public boolean checkElements(Element... e) {
		for (Element elem : e) {
			if (elems.indexOf(elem) == -1)
				return false;
		}
		return true;
	}
	
	public boolean checkCompose(ArrayList<Compose> comp) {
		
		if (compose.size() != comp.size())
			return false;
		
		for (Integer i = 0; i < compose.size(); i++) {
			if (compose.get(i) != comp.get(i))
				return false;
		}
		
		return true;
	}
	
	public boolean checkCompose(Compose[] comp) {
		
		if (compose.toArray().length != comp.length)
			return false;
		
		for (Integer i = 0; i < compose.size(); i++) {
			if (compose.get(i) != comp[i])
				return false;
		}
		
		return true;
	}
}
