package fr.kosmosuniverse.kworld.crafts.chim.equivalence;

import java.util.ArrayList;

import org.bukkit.Material;
import fr.kosmosuniverse.kworld.crafts.chim.molecules.Molecules;

public class MMEquivalence {
	private ArrayList<ComposeMM> eqList;
	private Molecules molecules;
	
	public MMEquivalence(Molecules mols) {
		this.molecules = mols;

		eqList = new ArrayList<ComposeMM>();
		
		//CELLULOSE		
		eqList.add(new ComposeMM(Material.OAK_WOOD, new ComposeIN(this.molecules.searchMolByName("Cellulose").getMol(), 5)));
		eqList.add(new ComposeMM(Material.DARK_OAK_WOOD, new ComposeIN(this.molecules.searchMolByName("Cellulose").getMol(), 5)));
		eqList.add(new ComposeMM(Material.ACACIA_WOOD, new ComposeIN(this.molecules.searchMolByName("Cellulose").getMol(), 5)));
		eqList.add(new ComposeMM(Material.SPRUCE_WOOD, new ComposeIN(this.molecules.searchMolByName("Cellulose").getMol(), 5)));
		eqList.add(new ComposeMM(Material.BIRCH_WOOD, new ComposeIN(this.molecules.searchMolByName("Cellulose").getMol(), 5)));
		eqList.add(new ComposeMM(Material.JUNGLE_WOOD, new ComposeIN(this.molecules.searchMolByName("Cellulose").getMol(), 5)));
		
		eqList.add(new ComposeMM(Material.OAK_LOG, new ComposeIN(this.molecules.searchMolByName("Cellulose").getMol(), 4)));
		eqList.add(new ComposeMM(Material.DARK_OAK_LOG, new ComposeIN(this.molecules.searchMolByName("Cellulose").getMol(), 4)));
		eqList.add(new ComposeMM(Material.ACACIA_LOG, new ComposeIN(this.molecules.searchMolByName("Cellulose").getMol(), 4)));
		eqList.add(new ComposeMM(Material.SPRUCE_LOG, new ComposeIN(this.molecules.searchMolByName("Cellulose").getMol(), 4)));
		eqList.add(new ComposeMM(Material.BIRCH_LOG, new ComposeIN(this.molecules.searchMolByName("Cellulose").getMol(), 4)));
		eqList.add(new ComposeMM(Material.JUNGLE_LOG, new ComposeIN(this.molecules.searchMolByName("Cellulose").getMol(), 4)));

		eqList.add(new ComposeMM(Material.OAK_STAIRS, new ComposeIN(this.molecules.searchMolByName("Cellulose").getMol(), 3)));
		eqList.add(new ComposeMM(Material.DARK_OAK_STAIRS, new ComposeIN(this.molecules.searchMolByName("Cellulose").getMol(), 3)));
		eqList.add(new ComposeMM(Material.ACACIA_STAIRS, new ComposeIN(this.molecules.searchMolByName("Cellulose").getMol(), 3)));
		eqList.add(new ComposeMM(Material.SPRUCE_STAIRS, new ComposeIN(this.molecules.searchMolByName("Cellulose").getMol(), 3)));
		eqList.add(new ComposeMM(Material.BIRCH_STAIRS, new ComposeIN(this.molecules.searchMolByName("Cellulose").getMol(), 3)));
		eqList.add(new ComposeMM(Material.JUNGLE_STAIRS, new ComposeIN(this.molecules.searchMolByName("Cellulose").getMol(), 3)));
		
		eqList.add(new ComposeMM(Material.OAK_PLANKS, new ComposeIN(this.molecules.searchMolByName("Cellulose").getMol(), 2)));
		eqList.add(new ComposeMM(Material.DARK_OAK_PLANKS, new ComposeIN(this.molecules.searchMolByName("Cellulose").getMol(), 2)));
		eqList.add(new ComposeMM(Material.ACACIA_PLANKS, new ComposeIN(this.molecules.searchMolByName("Cellulose").getMol(), 2)));
		eqList.add(new ComposeMM(Material.SPRUCE_PLANKS, new ComposeIN(this.molecules.searchMolByName("Cellulose").getMol(), 2)));
		eqList.add(new ComposeMM(Material.BIRCH_PLANKS, new ComposeIN(this.molecules.searchMolByName("Cellulose").getMol(), 2)));
		eqList.add(new ComposeMM(Material.JUNGLE_PLANKS, new ComposeIN(this.molecules.searchMolByName("Cellulose").getMol(), 2)));
		
		eqList.add(new ComposeMM(Material.OAK_SLAB, new ComposeIN(this.molecules.searchMolByName("Cellulose").getMol(), 1)));
		eqList.add(new ComposeMM(Material.DARK_OAK_SLAB, new ComposeIN(this.molecules.searchMolByName("Cellulose").getMol(), 1)));
		eqList.add(new ComposeMM(Material.ACACIA_SLAB, new ComposeIN(this.molecules.searchMolByName("Cellulose").getMol(), 1)));
		eqList.add(new ComposeMM(Material.SPRUCE_SLAB, new ComposeIN(this.molecules.searchMolByName("Cellulose").getMol(), 1)));
		eqList.add(new ComposeMM(Material.BIRCH_SLAB, new ComposeIN(this.molecules.searchMolByName("Cellulose").getMol(), 1)));
		eqList.add(new ComposeMM(Material.JUNGLE_SLAB, new ComposeIN(this.molecules.searchMolByName("Cellulose").getMol(), 1)));
		
		//WATER
		eqList.add(new ComposeMM(Material.WATER_BUCKET, new ComposeIN(this.molecules.searchMolByName("Water").getMol(), 4)));
	}
	
	public ArrayList<ComposeMM> getEquivalenceList() {
		return eqList;
	}
	
	public ComposeIN[] getItemsByMaterial(Material m) {

		for (ComposeMM c : eqList) {
			if (c.material.equals(m))
				return c.items;
		}

		return null;
	}
		
	public boolean checkMaterial(Material m) {
		
		for (ComposeMM c : eqList) {
			if (c.material.equals(m))
				return true;
		}
		
		return false;
	}
}
