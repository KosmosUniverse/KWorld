package fr.kosmosuniverse.kworld.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

public class KSpawnTab implements TabCompleter {

	@Override
	public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("kspawn")) {
			if (!(sender instanceof Player))
				return null;
			//Player player = (Player) sender;
			
			List<String> list = new ArrayList<String>();
			
			//Sticks
			list.add("Decomposer");
			
			return list;
		}
		return null;
	}
}