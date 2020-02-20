package fr.kosmosuniverse.kworld.crafts.chim.essences;

import java.util.ArrayList;

import fr.kosmosuniverse.kworld.KWorldMain;
import fr.kosmosuniverse.kworld.crafts.chim.molecules.Molecules;

public class Essences {
	private ArrayList<AEssence> EssenceList;
	
	public Essences(KWorldMain main, Molecules mols) {
		EssenceList = new ArrayList<AEssence>();
		
		EssenceList.add(new WoodEssence(main, mols));
	}
	
	public ArrayList<AEssence> getList() {
		return EssenceList;
	}
}
