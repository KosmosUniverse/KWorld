package fr.kosmosuniverse.kworld.crafts.chim.elements;

import java.util.HashMap;

public class Elements {
	private HashMap<Integer, Element> map;

	public Elements() {
		map = new HashMap<Integer, Element>();
		
		map.put(1, new Element("Hydrogen", "H", 1));
		map.put(2, new Element("Helium", "He", 2));
		map.put(3, new Element("Lithium", "Li", 3));
		map.put(4, new Element("Berylium", "Be", 4));
		map.put(5, new Element("Boron", "B", 5));
		map.put(6, new Element("Carbon", "C", 6));
		map.put(7, new Element("Nitrogen", "N", 7));
		map.put(8, new Element("Oxygen", "O", 8));
		map.put(9, new Element("Fluorine", "F", 9));
		map.put(10, new Element("Neon", "Ne", 10));
		map.put(11, new Element("Sodium", "Na", 11));
		map.put(12, new Element("Magnesium", "Mg", 12));
		map.put(13, new Element("Aluminium", "Al", 13));
		map.put(14, new Element("Silicium", "Si", 14));
		map.put(15, new Element("Phosphorus", "P", 15));
		map.put(16, new Element("Sulfur", "S", 16));
		map.put(17, new Element("Chlorine", "Cl", 17));
		map.put(18, new Element("Argon", "Ar", 18));
		map.put(19, new Element("Potassium", "K", 19));
		map.put(20, new Element("Calcium", "Ca", 20));
		map.put(21, new Element("Scandium", "Sc", 21));
		map.put(22, new Element("Titanium", "Ti", 22));
		map.put(23, new Element("Vanadium", "V", 23));
		map.put(24, new Element("Chromium", "Cr", 24));
		map.put(25, new Element("Manganese", "Mn", 25));
		map.put(26, new Element("Iron", "Fe", 26));
		map.put(27, new Element("Cobalt", "Co", 27));
		map.put(28, new Element("Nickel", "Ni", 28));
		map.put(29, new Element("Copper", "Cu", 29));
		map.put(30, new Element("Zinc", "Zn", 30));
		map.put(31, new Element("Gallium", "Ga", 31));
		map.put(32, new Element("Germanium", "Ge", 32));
		map.put(33, new Element("Arsenic", "As", 33));
		map.put(34, new Element("Selenium", "Se", 34));
		map.put(35, new Element("Bromine", "Br", 35));
		map.put(36, new Element("Krypton", "Kr", 36));
		map.put(37, new Element("Rubidium", "Rb", 37));
		map.put(38, new Element("Strontium", "Sr", 38));
		map.put(39, new Element("Yttrium", "Y", 39));
		map.put(40, new Element("Zirconium", "Zr", 40));
		map.put(41, new Element("Niobium", "Nb", 41));
		map.put(42, new Element("Molybdenum", "Mo", 42));
		map.put(43, new Element("Technetium", "Tc", 43));
		map.put(44, new Element("Ruthenium", "Ru", 44));
		map.put(45, new Element("Rhodium", "Rh", 45));
		map.put(46, new Element("Palladium", "Pd", 46));
		map.put(47, new Element("Silver", "Ag", 47));
		map.put(48, new Element("Cadmium", "Cd", 48));
		map.put(49, new Element("Indium", "In", 49));
		map.put(50, new Element("Tin", "Sn", 50));
		map.put(51, new Element("Antimony", "Sb", 51));
		map.put(52, new Element("Tellurium", "Te", 52));
		map.put(53, new Element("Iodine", "I", 53));
		map.put(54, new Element("Xenon", "Xe", 54));
	}
	
	public HashMap<Integer, Element> getMap() {
		return map;
	}
}
