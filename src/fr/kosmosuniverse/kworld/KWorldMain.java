package fr.kosmosuniverse.kworld;


import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.plugin.java.JavaPlugin;

import fr.kosmosuniverse.kworld.MultiBlocks.MultiBlockList;
import fr.kosmosuniverse.kworld.MultiBlocks.MultiBlockListener;
import fr.kosmosuniverse.kworld.MultiBlocks.utils.IMultiBlock;
import fr.kosmosuniverse.kworld.commands.KGive;
import fr.kosmosuniverse.kworld.commands.KGuide;
import fr.kosmosuniverse.kworld.commands.KGiveTab;
import fr.kosmosuniverse.kworld.commands.KSpawn;
import fr.kosmosuniverse.kworld.commands.KSpawnTab;
import fr.kosmosuniverse.kworld.crafts.AddRecipes;
import fr.kosmosuniverse.kworld.crafts.InventoryRecipeListener;
import fr.kosmosuniverse.kworld.crafts.chim.elements.Element;
import fr.kosmosuniverse.kworld.crafts.chim.elements.Elements;
import fr.kosmosuniverse.kworld.crafts.chim.molecules.Molecule;
import fr.kosmosuniverse.kworld.crafts.chim.molecules.Molecules;
import fr.kosmosuniverse.kworld.crafts.xp.XpStorageListener;

public class KWorldMain extends JavaPlugin {
	
	private HashMap<Integer, Element> Elems;
	private ArrayList<Molecule> Mols;
	private ArrayList<IMultiBlock> MBList;
	
	@Override
	public void onEnable() {
		saveDefaultConfig();
		
		System.out.println("[KWorld] : " + getConfig().getString("general.messages.start"));
		
		getServer().getPluginManager().registerEvents(new KWorldListener(this), this);
		getServer().getPluginManager().registerEvents(new InventoryRecipeListener(/*this*/), this);
		
		getCommand("kguide").setExecutor(new KGuide(/*this*/));
		getCommand("kgive").setExecutor(new KGive(/*this*/));
		
		getCommand("kgive").setTabCompleter(new KGiveTab());
		
		boolean KFun = getConfig().getBoolean("general.plugin.KFun");
		boolean KChim = getConfig().getBoolean("general.plugin.KChim");
		
		if (KFun) {
			getServer().getPluginManager().registerEvents(new CustomItemListener(this), this);
			getServer().getPluginManager().registerEvents(new EntityListener(/*this*/), this);
			getServer().getPluginManager().registerEvents(new XpStorageListener(/*this*/), this);	
		}
		if (KChim) {
			Elems = new Elements().getMap();
			Mols = new Molecules(this, Elems).getMoleculeList();
			MBList = new MultiBlockList().getList();
			
			getServer().getPluginManager().registerEvents(new MultiBlockListener(this, MBList, Elems, Mols), this);
			getCommand("kspawn").setExecutor(new KSpawn(this.MBList));
			getCommand("kspawn").setTabCompleter(new KSpawnTab(this.MBList));
		}
		
		AddRecipes recipes = new AddRecipes(this);
		recipes.addAll();
	}
	
	@Override
	public void onDisable() {
		System.out.println("[KWorld] : " + getConfig().getString("general.messages.end"));
	}
}
