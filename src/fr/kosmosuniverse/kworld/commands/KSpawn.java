package fr.kosmosuniverse.kworld.commands;

import java.util.ArrayList;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.kosmosuniverse.kworld.MultiBlocks.utils.IMultiBlock;

public class KSpawn implements CommandExecutor{

	private ArrayList<IMultiBlock> MBList;
	
	public KSpawn(ArrayList<IMultiBlock> MBList) {
		this.MBList = MBList;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (!(sender instanceof Player)) 
			return false;

		Player player = (Player) sender;

		if (args.length != 1)
			return false;

		for (IMultiBlock mb : this.MBList) {
			if (mb.getName().equalsIgnoreCase(args[0])) {
				mb.getMultiblock().spawnMultiBlock(player);
			}
		}
		return true;
	}

}
