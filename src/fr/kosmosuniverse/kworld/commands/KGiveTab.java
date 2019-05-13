package fr.kosmosuniverse.kworld.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

public class KGiveTab implements TabCompleter {

	@Override
	public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("kgive")) {
			if (!(sender instanceof Player))
				return null;

			List<String> list = new ArrayList<String>();
			
			//Sticks
			list.add("FireStickTierI");
			list.add("FireStickTierII");
			list.add("FireStickTierIII");
			
			list.add("WindStickTierI");
			list.add("WindStickTierII");
			list.add("WindStickTierIII");
			
			list.add("EarthStickTierI");
			list.add("EarthStickTierII");
			list.add("EarthStickTierIII");
			
			list.add("WaterStickTierI");
			list.add("WaterStickTierII");
			list.add("WaterStickTierIII");
			
			//XP Storage
			list.add("XpStorageTierI");
			list.add("XpStorageTierII");
			list.add("XpStorageTierIII");
			list.add("XpStorageTierIV");
			list.add("XpStorageTierV");
			
			//Activator
			list.add("Activator");
			
			return list;
		}
		return null;
	}

}
