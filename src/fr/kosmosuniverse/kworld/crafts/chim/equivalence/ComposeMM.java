package fr.kosmosuniverse.kworld.crafts.chim.equivalence;


import org.bukkit.Material;

public class ComposeMM {
	public Material material;
	public ComposeIN[] items;
	
	@SafeVarargs
	public ComposeMM(Material material, ComposeIN... items) {
		this.material = material;
		this.items = items;
	}
}
