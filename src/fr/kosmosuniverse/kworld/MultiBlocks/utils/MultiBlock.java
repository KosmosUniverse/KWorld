package fr.kosmosuniverse.kworld.MultiBlocks.utils;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class MultiBlock {
	private Material Core;
	private Pattern[] patterns;
	
	public MultiBlock(Material _m, Pattern... _patterns) {
		Core = _m;
		patterns = _patterns;
	}
	
	public Material getCore() {
		return Core;
	}
	
	public Pattern[] getPatterns() {
		return patterns;
	}
	
	public List<Material> getBlockTypes() {
		ArrayList<Material> types = new ArrayList<Material>();
		
		types.add(Core);
		
		for (Pattern p : patterns) {
			if (!types.contains(p.getMaterial()))
				types.add(p.getMaterial());
			}
		
		return types;
	}
	
	public boolean checkMultiBlock(Location CoreLoc, Player player) {
		Location newLoc = new Location(CoreLoc.getWorld(), CoreLoc.getBlockX(), CoreLoc.getBlockY(), CoreLoc.getBlockZ());
		Location tmp;
		
		for (Pattern p : patterns) {
			tmp = newLoc.clone();
			tmp.add(p.getX(), p.getY(), p.getZ());
			if (tmp.getBlock().getType() != p.getMaterial())
				return false;
		}
		return true;
	}
}