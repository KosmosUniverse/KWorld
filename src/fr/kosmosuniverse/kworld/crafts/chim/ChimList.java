package fr.kosmosuniverse.kworld.crafts.chim;

import java.util.HashMap;

import org.bukkit.inventory.ItemStack;

import fr.kosmosuniverse.kworld.crafts.chim.elements.Element;
import fr.kosmosuniverse.kworld.crafts.chim.elements.Elements;
import fr.kosmosuniverse.kworld.crafts.chim.molecules.Molecule;
import fr.kosmosuniverse.kworld.crafts.chim.molecules.Molecules;

public class ChimList {
	
	private HashMap<String, ItemStack> chimMap;
	
	public ChimList(Elements Elems, Molecules Mols) {
		chimMap = new HashMap<String, ItemStack>();
		
		for (Element e : Elems.getList()) {
			chimMap.put(e.getName(), e.getElem());
		}
		
		for (Molecule m : Mols.getList()) {
			chimMap.put(m.getName(), m.getMol());
		}
		
		chimMap.put("Activator", ChimActivator.ActivatorBuilder());
	}
	
	public HashMap<String, ItemStack> getChimMap() {
		return chimMap;
	}
}
