package fr.kosmosuniverse.kworld;


import org.bukkit.plugin.java.JavaPlugin;

import fr.kosmosuniverse.kworld.MultiBlocks.MultiBlockListener;
import fr.kosmosuniverse.kworld.commands.KGive;
import fr.kosmosuniverse.kworld.commands.KGuide;
import fr.kosmosuniverse.kworld.commands.KGiveTab;
import fr.kosmosuniverse.kworld.commands.KSpawn;
import fr.kosmosuniverse.kworld.commands.KSpawnTab;
import fr.kosmosuniverse.kworld.crafts.AddRecipes;
import fr.kosmosuniverse.kworld.crafts.InventoryRecipeListener;
import fr.kosmosuniverse.kworld.crafts.XpStorageListener;

public class KWorldMain extends JavaPlugin {
	@Override
	public void onEnable() {
		saveDefaultConfig();
		
		System.out.println("[KWorld] : " + getConfig().getString("general.messages.start"));
		
		getServer().getPluginManager().registerEvents(new KWorldListener(this), this);
		getServer().getPluginManager().registerEvents(new InventoryRecipeListener(/*this*/), this);
		getServer().getPluginManager().registerEvents(new CustomItemListener(this), this);
		getServer().getPluginManager().registerEvents(new EntityListener(/*this*/), this);
		getServer().getPluginManager().registerEvents(new XpStorageListener(/*this*/), this);
		getServer().getPluginManager().registerEvents(new MultiBlockListener(this), this);
		
		getCommand("kguide").setExecutor(new KGuide(/*this*/));
		getCommand("kgive").setExecutor(new KGive(/*this*/));
		getCommand("kspawn").setExecutor(new KSpawn());
		
		getCommand("kgive").setTabCompleter(new KGiveTab());
		getCommand("kspawn").setTabCompleter(new KSpawnTab());
		
		AddRecipes recipes = new AddRecipes(this);
		recipes.addAll();
	}
	
	@Override
	public void onDisable() {
		System.out.println("[KWorld] : " + getConfig().getString("general.messages.end"));
	}
}
