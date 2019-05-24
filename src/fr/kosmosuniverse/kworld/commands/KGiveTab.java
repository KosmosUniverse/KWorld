package fr.kosmosuniverse.kworld.commands;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import fr.kosmosuniverse.kworld.KWorldMain;

public class KGiveTab implements TabCompleter {
	
	private KWorldMain main;
	private ArrayList<String> list;
	
	public KGiveTab(KWorldMain main, HashMap<String, ItemStack> funMap, HashMap<String, ItemStack> chimMap) {
		this.main = main;
		
		list = new ArrayList<String>();
		
		boolean KFun = this.main.getConfig().getBoolean("general.plugin.KFun");
		boolean KChim = this.main.getConfig().getBoolean("general.plugin.KChim");

		if (KFun) {
			for (String s : funMap.keySet()) {
				list.add(s);
			}
		}
		if (KChim) {
			for (String s : chimMap.keySet()) {
				list.add(s);
			}
		}
		
	}
	
	@Override
	public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("kgive")) {
			if (!(sender instanceof Player))
				return null;
			return list;
		}
		return null;
	}

}
