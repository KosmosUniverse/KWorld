package fr.kosmosuniverse.kworld.MultiBlocks;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import fr.kosmosuniverse.kworld.MultiBlocks.utils.ActivationType;
import fr.kosmosuniverse.kworld.MultiBlocks.utils.IMultiBlock;
import fr.kosmosuniverse.kworld.MultiBlocks.utils.MultiBlock;
import fr.kosmosuniverse.kworld.MultiBlocks.utils.Pattern;

public class Decomposer extends IMultiBlock{

	public Decomposer() {
		this.name = "Decomposer";
		this.multiblock = new MultiBlock(Material.CHISELED_STONE_BRICKS,
				new Pattern(Material.STONE, -1, -1, -1),
				new Pattern(Material.STONE, -1, -1, 0),
				new Pattern(Material.STONE, -1, -1, 1),
				new Pattern(Material.STONE, 0, -1, -1),
				new Pattern(Material.STONE, 0, -1, 1),
				new Pattern(Material.STONE, 1, -1, -1),
				new Pattern(Material.STONE, 1, -1, 0),
				new Pattern(Material.STONE, 1, -1, 1),
				
				new Pattern(Material.CHEST, 0, 1, 0));
	}
	
	@Override
	public void onActivate(Plugin plugin, Player player, Location location, ActivationType type) {
		if (type == ActivationType.ASSEMBLE) {
			player.sendMessage("You just constructed Decomposer !");
		}
		else if (type == ActivationType.ACTIVATE) {
			player.sendMessage("You just activated Decomposer !");
		}
	}

}
