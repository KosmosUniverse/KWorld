package fr.kosmosuniverse.kworld;


import org.bukkit.plugin.java.JavaPlugin;

import fr.kosmosuniverse.kworld.commands.KGive;
import fr.kosmosuniverse.kworld.commands.KGuide;
import fr.kosmosuniverse.kworld.commands.KGuiveTab;
import fr.kosmosuniverse.kworld.crafts.AddRecipes;
import fr.kosmosuniverse.kworld.crafts.InventoryRecipeListener;

public class KWorldMain extends JavaPlugin {
	@Override
	public void onEnable() {
		saveDefaultConfig();
		
		System.out.println("[KWorld] : " + getConfig().getString("general.messages.start"));
		
		getServer().getPluginManager().registerEvents(new KWorldListener(this), this);
		getServer().getPluginManager().registerEvents(new InventoryRecipeListener(/*this*/), this);
		getServer().getPluginManager().registerEvents(new CustomItemListener(/*this*/), this);
		
		getCommand("kguide").setExecutor(new KGuide(/*this*/));
		getCommand("kgive").setExecutor(new KGive(/*this*/));
		getCommand("kgive").setTabCompleter(new KGuiveTab());
		
		AddRecipes recipes = new AddRecipes(this);
		recipes.addAll();
	}
	
	@Override
	public void onDisable() {
		System.out.println("[KWorld] : " + getConfig().getString("general.messages.end"));
	}
}
