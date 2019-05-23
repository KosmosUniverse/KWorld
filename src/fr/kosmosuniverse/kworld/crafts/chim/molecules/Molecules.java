package fr.kosmosuniverse.kworld.crafts.chim.molecules;

import java.util.ArrayList;
import java.util.HashMap;

import fr.kosmosuniverse.kworld.KWorldMain;
import fr.kosmosuniverse.kworld.crafts.chim.elements.Element;

public class Molecules {
	private ArrayList<Molecule> molecules;
	private HashMap<Integer, Element> elements;
	
	public Molecules(KWorldMain main, HashMap<Integer, Element> elems) {
		
		this.elements = elems;
		
		molecules = new ArrayList<Molecule>();
		
		molecules.add(new Molecule("Cellulose", "C6H10O5",
				new Compose(this.elements.get(6), 6),
				new Compose(this.elements.get(1), 10),
				new Compose(this.elements.get(8), 5)));
		
		molecules.add(new Molecule("Water", "H2O",
				new Compose(this.elements.get(1), 2),
				new Compose(this.elements.get(8), 1)));
		
		molecules.add(new Molecule("Hydrogen Peroxide", "H2O2",
				new Compose(this.elements.get(1), 2),
				new Compose(this.elements.get(8), 2)));
		
		molecules.add(new Molecule("Potassium Oxide", "K2O",
				new Compose(this.elements.get(19), 2),
				new Compose(this.elements.get(8), 1)));
		
		molecules.add(new Molecule("Carbon Dioxide", "CO2",
				new Compose(this.elements.get(6), 1),
				new Compose(this.elements.get(8), 2)));
		
		molecules.add(new Molecule("Nitrogen Dioxide", "NO2",
				new Compose(this.elements.get(7), 1),
				new Compose(this.elements.get(8), 2)));
		
		molecules.add(new Molecule("Toluene", "C7H8",
				new Compose(this.elements.get(6), 7),
				new Compose(this.elements.get(1), 8)));
		
		molecules.add(new Molecule("Potassium Nitrate", "KNO3",
				new Compose(this.elements.get(19), 1),
				new Compose(this.elements.get(7), 1),
				new Compose(this.elements.get(8), 3)));
		
		molecules.add(new Molecule("Silicon Dioxide", "SiO2",
				new Compose(this.elements.get(14), 1),
				new Compose(this.elements.get(8), 2)));
		
		molecules.add(new Molecule("Calcicpyroxene", "CaCrSi2O6",
				new Compose(this.elements.get(20), 1),
				new Compose(this.elements.get(24), 1),
				new Compose(this.elements.get(14), 2),
				new Compose(this.elements.get(8), 6)));
		
		molecules.add(new Molecule("Pyrite", "FeS2",
				new Compose(this.elements.get(26), 1),
				new Compose(this.elements.get(16), 2)));
		
		molecules.add(new Molecule("Nepheline", "AlSiO4",
				new Compose(this.elements.get(13), 1),
				new Compose(this.elements.get(14), 1),
				new Compose(this.elements.get(8), 4)));
		
		molecules.add(new Molecule("Sulfate", "SO4",
				new Compose(this.elements.get(16), 1),
				new Compose(this.elements.get(8), 4	)));
	}
	
	public ArrayList<Molecule> getMoleculeList() {
		return molecules;
	}
}
