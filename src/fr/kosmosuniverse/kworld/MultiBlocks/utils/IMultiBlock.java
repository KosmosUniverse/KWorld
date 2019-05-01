package fr.kosmosuniverse.kworld.MultiBlocks.utils;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public abstract class IMultiBlock {
	protected String name;
	protected MultiBlock multiblock;
	
	public abstract void onActivate(Plugin plugin, Player player, Location location, ActivationType type);
	
	public String getName() {
		return name;
	}
	
	public MultiBlock getMultiblock() {
		return multiblock;
	}
}