package fr.kosmosuniverse.kworld.MultiBlocks;

import java.util.ArrayList;

import fr.kosmosuniverse.kworld.MultiBlocks.utils.IMultiBlock;

public class MultiBlockList {
	private ArrayList<IMultiBlock> MBList;
	
	public MultiBlockList() {
		this.MBList = new ArrayList<IMultiBlock>();
		
		this.MBList.add(new Decomposer());
		this.MBList.add(new Synthetiser());
	}
	
	public ArrayList<IMultiBlock> getList() {
		return MBList;
	}
}
