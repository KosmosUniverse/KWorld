package fr.kosmosuniverse.kworld.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import fr.kosmosuniverse.kworld.MultiBlocks.utils.IMultiBlock;

public class KSpawnTab implements TabCompleter {

	private ArrayList<IMultiBlock> MBList;
	
	public KSpawnTab(ArrayList<IMultiBlock> MBList) {
		this.MBList = MBList;
	}
	
	@Override
	public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("kspawn")) {
			if (!(sender instanceof Player))
				return null;
			//Player player = (Player) sender;
			
			List<String> list = new ArrayList<String>();
			
			for (IMultiBlock m : MBList) {
				list.add(m.getName());
			}
			
			///list.add("Decomposer");
			///list.add("Synthetiser");
			
			return list;
		}
		return null;
	}
}
