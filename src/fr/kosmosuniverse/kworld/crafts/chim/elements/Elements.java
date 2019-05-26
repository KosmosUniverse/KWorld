package fr.kosmosuniverse.kworld.crafts.chim.elements;

import java.util.ArrayList;

public class Elements {
	private ArrayList<Element> list;

	public Elements() {
		list = new ArrayList<Element>();
		
		list.add(new Element("Hydrogen", "H", 1));
		list.add(new Element("Helium", "He", 2));
		list.add(new Element("Lithium", "Li", 3));
		list.add(new Element("Berylium", "Be", 4));
		list.add(new Element("Boron", "B", 5));
		list.add(new Element("Carbon", "C", 6));
		list.add(new Element("Nitrogen", "N", 7));
		list.add(new Element("Oxygen", "O", 8));
		list.add(new Element("Fluorine", "F", 9));
		list.add(new Element("Neon", "Ne", 10));
		list.add(new Element("Sodium", "Na", 11));
		list.add(new Element("Magnesium", "Mg", 12));
		list.add(new Element("Aluminium", "Al", 13));
		list.add(new Element("Silicium", "Si", 14));
		list.add(new Element("Phosphorus", "P", 15));
		list.add(new Element("Sulfur", "S", 16));
		list.add(new Element("Chlorine", "Cl", 17));
		list.add(new Element("Argon", "Ar", 18));
		list.add(new Element("Potassium", "K", 19));
		list.add(new Element("Calcium", "Ca", 20));
		list.add(new Element("Scandium", "Sc", 21));
		list.add(new Element("Titanium", "Ti", 22));
		list.add(new Element("Vanadium", "V", 23));
		list.add(new Element("Chromium", "Cr", 24));
		list.add(new Element("Manganese", "Mn", 25));
		list.add(new Element("Iron", "Fe", 26));
		list.add(new Element("Cobalt", "Co", 27));
		list.add(new Element("Nickel", "Ni", 28));
		list.add(new Element("Copper", "Cu", 29));
		list.add(new Element("Zinc", "Zn", 30));
		list.add(new Element("Gallium", "Ga", 31));
		list.add(new Element("Germanium", "Ge", 32));
		list.add(new Element("Arsenic", "As", 33));
		list.add(new Element("Selenium", "Se", 34));
		list.add(new Element("Bromine", "Br", 35));
		list.add(new Element("Krypton", "Kr", 36));
		list.add(new Element("Rubidium", "Rb", 37));
		list.add(new Element("Strontium", "Sr", 38));
		list.add(new Element("Yttrium", "Y", 39));
		list.add(new Element("Zirconium", "Zr", 40));
		list.add(new Element("Niobium", "Nb", 41));
		list.add(new Element("Molybdenum", "Mo", 42));
		list.add(new Element("Technetium", "Tc", 43));
		list.add(new Element("Ruthenium", "Ru", 44));
		list.add(new Element("Rhodium", "Rh", 45));
		list.add(new Element("Palladium", "Pd", 46));
		list.add(new Element("Silver", "Ag", 47));
		list.add(new Element("Cadmium", "Cd", 48));
		list.add(new Element("Indium", "In", 49));
		list.add(new Element("Tin", "Sn", 50));
		list.add(new Element("Antimony", "Sb", 51));
		list.add(new Element("Tellurium", "Te", 52));
		list.add(new Element("Iodine", "I", 53));
		list.add(new Element("Xenon", "Xe", 54));
	}
	
	public ArrayList<Element> getList() {
		return list;
	}
	
	public Element searchElemByName(String name) {
		for (Element e : list) {
			if (e.getName().equals(name))
				return e;
		}
		return null;
	}
	
	public Element searchElemBySymbol(String symbol) {
		for (Element e : list) {
			if (e.getSymbol().equals(symbol))
				return e;
		}
		return null;
	}
	
	public Element searchElemByProtons(Integer protons) {
		for (Element e : list) {
			if (e.getProtons() == protons)
				return e;
		}
		return null;
	}
}
