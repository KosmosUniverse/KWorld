package fr.kosmosuniverse.kworld.crafts.chim;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

import fr.kosmosuniverse.kworld.KWorldMain;
import fr.kosmosuniverse.kworld.crafts.chim.elements.Element;
import fr.kosmosuniverse.kworld.crafts.chim.elements.Elements;
import fr.kosmosuniverse.kworld.crafts.chim.essences.AEssence;
import fr.kosmosuniverse.kworld.crafts.chim.essences.Essences;
import fr.kosmosuniverse.kworld.crafts.chim.molecules.Molecule;
import fr.kosmosuniverse.kworld.crafts.chim.molecules.Molecules;

public class ChimList {
	
	private HashMap<String, ItemStack> chimMap;
	private ArrayList<ShapedRecipe> chimRecipes;
	
	public ChimList(KWorldMain main, Elements Elems, Molecules Mols, Essences Ess) {
		chimMap = new HashMap<String, ItemStack>();
		chimRecipes = new ArrayList<ShapedRecipe>();
		
		for (Element e : Elems.getList()) {
			chimMap.put(e.getName(), e.getElem());
		}
		
		for (Molecule m : Mols.getList()) {
			chimMap.put(m.getName(), m.getMol());
		}
		
		chimMap.put("Activator", ChimActivator.ActivatorBuilder());
		
		chimRecipes.add(new ChimActivator(main).getActivator());
		
		for (AEssence e : Ess.getList()) {
			for (ShapedRecipe s : e.getRecipes()) {
				chimRecipes.add(s);
			}
		}
	}
	
	public HashMap<String, ItemStack> getChimMap() {
		return chimMap;
	}
	
	public ArrayList<ShapedRecipe> getChimRecipes() {
		return chimRecipes;
	}
}
