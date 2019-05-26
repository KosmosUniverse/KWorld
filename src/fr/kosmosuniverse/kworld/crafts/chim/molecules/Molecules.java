package fr.kosmosuniverse.kworld.crafts.chim.molecules;

import java.util.ArrayList;

import org.bukkit.inventory.ItemStack;

import fr.kosmosuniverse.kworld.KWorldMain;
import fr.kosmosuniverse.kworld.commands.KGive;
import fr.kosmosuniverse.kworld.crafts.chim.elements.Elements;

public class Molecules {
	private ArrayList<Molecule> molecules;
	private Elements elements;
	
	public Molecules(KWorldMain main, Elements elems) {
		
		this.elements = elems;
		
		molecules = new ArrayList<Molecule>();
		
		molecules.add(new Molecule("Cellulose", "C6H10O5",
				new Compose(this.elements.searchElemBySymbol("C"), 6),
				new Compose(this.elements.searchElemBySymbol("H"), 10),
				new Compose(this.elements.searchElemBySymbol("O"), 5)));
		
		molecules.add(new Molecule("Water", "H2O",
				new Compose(this.elements.searchElemBySymbol("H"), 2),
				new Compose(this.elements.searchElemBySymbol("O"), 1)));
		
		molecules.add(new Molecule("Hydrogen_Peroxide", "H2O2",
				new Compose(this.elements.searchElemBySymbol("H"), 2),
				new Compose(this.elements.searchElemBySymbol("O"), 2)));
		
		molecules.add(new Molecule("Potassium_Oxide", "K2O",
				new Compose(this.elements.searchElemBySymbol("K"), 2),
				new Compose(this.elements.searchElemBySymbol("O"), 1)));
		
		molecules.add(new Molecule("Carbon_Dioxide", "CO2",
				new Compose(this.elements.searchElemBySymbol("C"), 1),
				new Compose(this.elements.searchElemBySymbol("O"), 2)));
		
		molecules.add(new Molecule("Nitrogen_Dioxide", "NO2",
				new Compose(this.elements.searchElemBySymbol("N"), 1),
				new Compose(this.elements.searchElemBySymbol("O"), 2)));
		
		molecules.add(new Molecule("Toluene", "C7H8",
				new Compose(this.elements.searchElemBySymbol("C"), 7),
				new Compose(this.elements.searchElemBySymbol("H"), 8)));
		
		molecules.add(new Molecule("Potassium_Nitrate", "KNO3",
				new Compose(this.elements.searchElemBySymbol("K"), 1),
				new Compose(this.elements.searchElemBySymbol("N"), 1),
				new Compose(this.elements.searchElemBySymbol("O"), 3)));
		
		molecules.add(new Molecule("Silicon_Dioxide", "SiO2",
				new Compose(this.elements.searchElemBySymbol("Si"), 1),
				new Compose(this.elements.searchElemBySymbol("O"), 2)));
		
		molecules.add(new Molecule("Calcicpyroxene", "CaCrSi2O6",
				new Compose(this.elements.searchElemBySymbol("Ca"), 1),
				new Compose(this.elements.searchElemBySymbol("Cr"), 1),
				new Compose(this.elements.searchElemBySymbol("Si"), 2),
				new Compose(this.elements.searchElemBySymbol("O"), 6)));
		
		molecules.add(new Molecule("Pyrite", "FeS2",
				new Compose(this.elements.searchElemBySymbol("Fe"), 1),
				new Compose(this.elements.searchElemBySymbol("S"), 2)));
		
		molecules.add(new Molecule("Nepheline", "AlSiO4",
				new Compose(this.elements.searchElemBySymbol("Al"), 1),
				new Compose(this.elements.searchElemBySymbol("Si"), 1),
				new Compose(this.elements.searchElemBySymbol("O"), 4)));
		
		molecules.add(new Molecule("Sulfate", "SO4",
				new Compose(this.elements.searchElemBySymbol("S"), 1),
				new Compose(this.elements.searchElemBySymbol("O"), 4	)));
	}
	
	public ArrayList<Molecule> getList() {
		return molecules;
	}
	
	public Molecule searchMolByName(String name) {
		for (Molecule m : molecules) {
			if (m.getName().equals(name))
				return m;
		}
		
		return null;
	}
	
	public Molecule searchMolBySymbols(String symbols) {
		for (Molecule m : molecules) {
			if (m.getSymbols().equals(symbols))
				return m;
		}
		
		return null;
	}
	
	public Molecule searchMolByCompose(Compose... comp) {
		for (Molecule m : molecules) {
			if (m.checkCompose(comp))
				return m;
		}
		
		return null;
	}
	
	public Molecule duplicateMoleculeByItem(ItemStack item) {
		if (item == null || !item.hasItemMeta() || !item.getItemMeta().hasDisplayName()) {
			return null;
		}
		
		ItemStack sample = KGive.itemMultiplier(item, 1);
		
		for (Molecule m : molecules) {
			if (m.getMol().equals(sample))
				return m;
		}
		
		return null;
	}
}
