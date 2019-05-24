package fr.kosmosuniverse.kworld.crafts.chim;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.inventory.ItemStack;

import fr.kosmosuniverse.kworld.crafts.chim.elements.Element;
import fr.kosmosuniverse.kworld.crafts.chim.molecules.Molecule;

public class ChimList {
	
	private HashMap<String, ItemStack> chimMap;
	
	public ChimList(HashMap<Integer, Element> Elems, ArrayList<Molecule> Mols) {
		chimMap = new HashMap<String, ItemStack>();
		
		for (Integer i : Elems.keySet()) {
			chimMap.put(Elems.get(i).getName(), Elems.get(i).getElem());
		}
		
		for (Molecule m : Mols) {
			chimMap.put(m.getName(), m.getMol());
		}
		
		chimMap.put("Activator", ChimActivator.ActivatorBuilder());
	}
	
	public HashMap<String, ItemStack> getChimMap() {
		return chimMap;
	}
}
