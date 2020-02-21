package fr.kosmosuniverse.kworld;


import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.inventory.Inventory;
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
import fr.kosmosuniverse.kworld.crafts.chim.ChimList;
import fr.kosmosuniverse.kworld.crafts.chim.elements.Elements;
import fr.kosmosuniverse.kworld.crafts.chim.equivalence.MMEquivalence;
import fr.kosmosuniverse.kworld.crafts.chim.essences.Essences;
import fr.kosmosuniverse.kworld.crafts.chim.molecules.Molecules;
import fr.kosmosuniverse.kworld.crafts.fun.FunList;
import fr.kosmosuniverse.kworld.crafts.fun.xp.XpStorageListener;

public class KWorldMain extends JavaPlugin {
	
	private Elements Elems = new Elements();
	private Molecules Mols = new Molecules(this, Elems);
	private Essences Ess = new Essences(this, Mols);
	private MMEquivalence Equiv = new MMEquivalence(Mols);
	public ArrayList<IMultiBlock> MBList = new MultiBlockList().getList();
	public FunList funItems = new FunList(this);
	private ChimList chimItems = new ChimList(this, Elems, Mols, Ess);
	public HashMap<String, Inventory> invs = new HashMap<String, Inventory>();
	public HashMap<String, Runnable> invsActions = new HashMap<String, Runnable>();
	
	@Override
	public void onEnable() {
		saveDefaultConfig();
		
		System.out.println("[KWorld] : " + getConfig().getString("general.messages.start"));
		
		boolean KFun = getConfig().getBoolean("general.plugin.KFun");
		boolean KChim = getConfig().getBoolean("general.plugin.KChim");
		
		if (KFun) {
			getServer().getPluginManager().registerEvents(new CustomItemListener(this), this);
			getServer().getPluginManager().registerEvents(new EntityListener(/*this*/), this);
			getServer().getPluginManager().registerEvents(new XpStorageListener(/*this*/), this);	
		}
		if (KChim) {
			getServer().getPluginManager().registerEvents(new MultiBlockListener(this, MBList, Elems, Mols, Equiv), this);
			getCommand("kspawn").setExecutor(new KSpawn(this.MBList));
			getCommand("kspawn").setTabCompleter(new KSpawnTab(this.MBList));
		}
		
		getServer().getPluginManager().registerEvents(new KWorldListener(this), this);
		getServer().getPluginManager().registerEvents(new InventoryRecipeListener(this), this);
		
		getCommand("kguide").setExecutor(new KGuide(/*this*/));
		getCommand("kgive").setExecutor(new KGive(this, funItems.getItemMap(), chimItems.getChimMap()));
		
		getCommand("kgive").setTabCompleter(new KGiveTab(this, funItems.getItemMap(), chimItems.getChimMap()));
		
		AddRecipes recipes = new AddRecipes(this, this.funItems.getRecipes());
		recipes.addAll();
	}
	
	@Override
	public void onDisable() {
		System.out.println("[KWorld] : " + getConfig().getString("general.messages.end"));

		MBList.clear();
	}
}
