package fr.kosmosuniverse.kworld.crafts.fun;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

import fr.kosmosuniverse.kworld.KWorldMain;
import fr.kosmosuniverse.kworld.crafts.fun.stick.AStick3T;
import fr.kosmosuniverse.kworld.crafts.fun.stick.EarthStick;
import fr.kosmosuniverse.kworld.crafts.fun.stick.FireStick;
import fr.kosmosuniverse.kworld.crafts.fun.stick.WaterStick;
import fr.kosmosuniverse.kworld.crafts.fun.stick.WindStick;
import fr.kosmosuniverse.kworld.crafts.fun.xp.ExpBottle;
import fr.kosmosuniverse.kworld.crafts.fun.xp.XpStorage;

public class FunList {
	private KWorldMain main;
	private ExpBottle expBot;
	private XpStorage xpStore;

	private ArrayList<AStick3T> stickList;
	private ArrayList<ShapedRecipe> recipeList;
	
	private HashMap<String, ItemStack> itemMap;
	
	public FunList(KWorldMain main) {
		this.main = main;
		
		expBot = new ExpBottle(main);
		xpStore = new XpStorage(main);
		stickList = new ArrayList<AStick3T>();
		recipeList = new ArrayList<ShapedRecipe>();
		itemMap = new HashMap<String, ItemStack>();
		
		stickList.add(new EarthStick(this.main));
		stickList.add(new FireStick(this.main));
		stickList.add(new WaterStick(this.main));
		stickList.add(new WindStick(this.main));
		
		for (AStick3T s : stickList) {
			itemMap.put(s.getName() + "_TIER_I", s.StickBuilder(1));
			itemMap.put(s.getName() + "_TIER_II", s.StickBuilder(2));
			itemMap.put(s.getName() + "_TIER_III", s.StickBuilder(3));
		}
		
		itemMap.put("Experience Bottle", new ItemStack(Material.EXPERIENCE_BOTTLE));
		itemMap.put("XP_STORAGE_TIER_I", XpStorage.xpStorageBuilder(1));
		itemMap.put("XP_STORAGE_TIER_II", XpStorage.xpStorageBuilder(2));
		itemMap.put("XP_STORAGE_TIER_III", XpStorage.xpStorageBuilder(3));
		itemMap.put("XP_STORAGE_TIER_IV", XpStorage.xpStorageBuilder(4));
		itemMap.put("XP_STORAGE_TIER_V", XpStorage.xpStorageBuilder(5));
		
		for (ShapedRecipe s : expBot.getRecipes()) {
			recipeList.add(s);
		}
		
		for (ShapedRecipe s : xpStore.getRecipes()) {
			recipeList.add(s);
		}
		
		for (AStick3T a : stickList) {
			for (ShapedRecipe s : a.getRecipes()) {
				recipeList.add(s);
			}
		}
	}
	
	public ArrayList<AStick3T> getStickList() {
		return stickList;
	}
	
	public HashMap<String, ItemStack> getItemMap() {
		return itemMap;
	}
	
	public ArrayList<ShapedRecipe> getRecipes() {
		return recipeList;
	}
	
	public ExpBottle getExpBottle() {
		return expBot;
	}
	
	public XpStorage getXpStorage() {
		return xpStore;
	}
}
