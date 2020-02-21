package fr.kosmosuniverse.kworld.crafts.fun.xp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import fr.kosmosuniverse.kworld.ItemBuilder;
import fr.kosmosuniverse.kworld.KWorldMain;

public class XpStorage {
	
	private KWorldMain main;
	private ShapedRecipe xpStorageTierI;
	private ShapedRecipe xpStorageTierII;
	private ShapedRecipe xpStorageTierIII;
	private ShapedRecipe xpStorageTierIV;
	private ShapedRecipe xpStorageTierV;
	private HashMap<Integer, Inventory> invs = new HashMap<Integer, Inventory>();
	
	public XpStorage(KWorldMain main) {
		this.main = main;
		
		xpStorageTierI = new ShapedRecipe(new NamespacedKey(this.main, "XpStorage1"), xpStorageBuilder(1));
		xpStorageTierII = new ShapedRecipe(new NamespacedKey(this.main, "XpStorage2"), xpStorageBuilder(2));
		xpStorageTierIII = new ShapedRecipe(new NamespacedKey(this.main, "XpStorage3"), xpStorageBuilder(3));
		xpStorageTierIV = new ShapedRecipe(new NamespacedKey(this.main, "XpStorage4"), xpStorageBuilder(4));
		xpStorageTierV = new ShapedRecipe(new NamespacedKey(this.main, "XpStorage5"), xpStorageBuilder(5));
		
		xpStorageTierI.shape("GGG", "GBG", "GGG");
		xpStorageTierI.setIngredient('G', Material.GLASS);
		xpStorageTierI.setIngredient('B', Material.EXPERIENCE_BOTTLE);
		
		xpStorageTierII.shape("GGG", "TBT", "GGG");
		xpStorageTierII.setIngredient('G', Material.GLASS);
		xpStorageTierII.setIngredient('T', Material.GHAST_TEAR);
		xpStorageTierII.setIngredient('B', xpStorageBuilder(1).getData());
		
		xpStorageTierIII.shape("GHG", "TBT", "GHG");
		xpStorageTierIII.setIngredient('G', Material.GLASS);
		xpStorageTierIII.setIngredient('T', Material.GHAST_TEAR);
		xpStorageTierIII.setIngredient('H', Material.WITHER_SKELETON_SKULL);
		xpStorageTierIII.setIngredient('B', xpStorageBuilder(2).getData());
		
		xpStorageTierIV.shape("GSG", "SBS", "GSG");
		xpStorageTierIV.setIngredient('G', Material.GLASS);
		xpStorageTierIV.setIngredient('B', Material.EXPERIENCE_BOTTLE);
		xpStorageTierIV.setIngredient('S', xpStorageBuilder(3).getData());
		
		xpStorageTierV.shape("GSG", "SNS", "GSG");
		xpStorageTierV.setIngredient('G', Material.GLASS);
		xpStorageTierV.setIngredient('N', Material.NETHER_STAR);
		xpStorageTierV.setIngredient('S', xpStorageBuilder(4).getData());
	}

	public ArrayList<ShapedRecipe> getRecipes() {
		ArrayList<ShapedRecipe> recipes = new ArrayList<ShapedRecipe>();
		
		recipes.add(xpStorageTierI);
		recipes.add(xpStorageTierII);
		recipes.add(xpStorageTierIII);
		recipes.add(xpStorageTierIV);
		recipes.add(xpStorageTierV);
		
		return recipes;
	}
	
	public static ItemStack xpStorageBuilder(int tier) {
		ItemStack item = new ItemStack(Material.EMERALD);
		ItemMeta itM = item.getItemMeta();
		itM.addEnchant(Enchantment.DIG_SPEED, 0, true);
		itM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		switch (tier) {
		case 1:
			itM.setDisplayName("§2XP STORAGE TIER I");
			itM.setLore(Arrays.asList("XP Stored:0/216", "XP Level:0/12"));
			break;
		case 2:
			itM.setDisplayName("§2XP STORAGE TIER II");
			itM.setLore(Arrays.asList("XP Stored:0/828", "XP Level:0/24"));
			break;
		case 3:
			itM.setDisplayName("§2XP STORAGE TIER III");
			itM.setLore(Arrays.asList("XP Stored:0/1395", "XP Level:0/30"));
			break;
		case 4:
			itM.setDisplayName("§2XP STORAGE TIER IV");
			itM.setLore(Arrays.asList("XP Stored:0/2920", "XP Level:0/40"));
			break;
		case 5:
			itM.setDisplayName("§2XP STORAGE TIER V");
			itM.setLore(Arrays.asList("XP Stored:0", "XP Level:0"));
			break;
		default:
			return null;
		}
		
		item.setItemMeta(itM);
		return (item);
	}
	
	public static ItemStack xpStorageSampleBuilder() {
		ItemStack item = new ItemStack(Material.EMERALD);
		ItemMeta itM = item.getItemMeta();
		
		itM.setDisplayName("§2XP STORAGE");
		itM.addEnchant(Enchantment.DIG_SPEED, 0, true);
		itM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(itM);

		return item;
	}
	
	public HashMap<Integer, Inventory> getXpStorageRecipe() {
		Inventory inv = Bukkit.createInventory(null, 27, "§8XP Storage Tier I");
		
		inv.setItem(0, new ItemBuilder(Material.BARRIER, "§cBack <-", 1).getItem());
		inv.setItem(8, new ItemBuilder(Material.LIME_STAINED_GLASS_PANE, "§aNext ->", 1).getItem());
		
		inv.setItem(2, new ItemStack(Material.GLASS));
		inv.setItem(3, new ItemStack(Material.GLASS));
		inv.setItem(4, new ItemStack(Material.GLASS));
		inv.setItem(11, new ItemStack(Material.GLASS));
		inv.setItem(12, new ItemStack(Material.EXPERIENCE_BOTTLE));
		inv.setItem(13, new ItemStack(Material.GLASS));
		inv.setItem(20, new ItemStack(Material.GLASS));
		inv.setItem(21, new ItemStack(Material.GLASS));
		inv.setItem(22, new ItemStack(Material.GLASS));
		inv.setItem(15, xpStorageBuilder(1));
		this.invs.put(1, inv);
		
		inv = Bukkit.createInventory(null, 27, "§8XP Storage Tier II");
		inv.setItem(0, new ItemBuilder(Material.BARRIER, "§cPrevious <-", 1).getItem());
		inv.setItem(8, new ItemBuilder(Material.LIME_STAINED_GLASS_PANE, "§aNext ->", 1).getItem());
		
		inv.setItem(2, new ItemStack(Material.GLASS));
		inv.setItem(3, new ItemStack(Material.GLASS));
		inv.setItem(4, new ItemStack(Material.GLASS));
		inv.setItem(11, new ItemStack(Material.GHAST_TEAR));
		inv.setItem(12, xpStorageBuilder(1));
		inv.setItem(13, new ItemStack(Material.GHAST_TEAR));
		inv.setItem(20, new ItemStack(Material.GLASS));
		inv.setItem(21, new ItemStack(Material.GLASS));
		inv.setItem(22, new ItemStack(Material.GLASS));
		inv.setItem(15, xpStorageBuilder(2));
		this.invs.put(2, inv);
		
		inv = Bukkit.createInventory(null, 27, "§8XP Storage Tier III");
		inv.setItem(0, new ItemBuilder(Material.BARRIER, "§cPrevious <-", 1).getItem());
		inv.setItem(8, new ItemBuilder(Material.LIME_STAINED_GLASS_PANE, "§aNext ->", 1).getItem());
		
		inv.setItem(2, new ItemStack(Material.GLASS));
		inv.setItem(3, new ItemStack(Material.WITHER_SKELETON_SKULL));
		inv.setItem(4, new ItemStack(Material.GLASS));
		inv.setItem(11, new ItemStack(Material.GHAST_TEAR));
		inv.setItem(12, xpStorageBuilder(2));
		inv.setItem(13, new ItemStack(Material.GHAST_TEAR));
		inv.setItem(20, new ItemStack(Material.GLASS));
		inv.setItem(21, new ItemStack(Material.WITHER_SKELETON_SKULL));
		inv.setItem(22, new ItemStack(Material.GLASS));
		inv.setItem(15, xpStorageBuilder(3));
		this.invs.put(3, inv);
		
		inv = Bukkit.createInventory(null, 27, "§8XP Storage Tier IV");
		inv.setItem(0, new ItemBuilder(Material.BARRIER, "§cPrevious <-", 1).getItem());
		inv.setItem(8, new ItemBuilder(Material.LIME_STAINED_GLASS_PANE, "§aNext ->", 1).getItem());
		
		inv.setItem(2, new ItemStack(Material.GLASS));
		inv.setItem(3, xpStorageBuilder(3));
		inv.setItem(4, new ItemStack(Material.GLASS));
		inv.setItem(11, xpStorageBuilder(3));
		inv.setItem(12, new ItemStack(Material.EXPERIENCE_BOTTLE));
		inv.setItem(13, xpStorageBuilder(3));
		inv.setItem(20, new ItemStack(Material.GLASS));
		inv.setItem(21, xpStorageBuilder(3));
		inv.setItem(22, new ItemStack(Material.GLASS));
		inv.setItem(15, xpStorageBuilder(4));
		this.invs.put(4, inv);
		
		
		inv = Bukkit.createInventory(null, 27, "§8XP Storage Tier V");
		inv.setItem(0, new ItemBuilder(Material.BARRIER, "§cPrevious <-", 1).getItem());
		
		inv.setItem(2, new ItemStack(Material.GLASS));
		inv.setItem(3, xpStorageBuilder(4));
		inv.setItem(4, new ItemStack(Material.GLASS));
		inv.setItem(11, xpStorageBuilder(4));
		inv.setItem(12, new ItemStack(Material.NETHER_STAR));
		inv.setItem(13, xpStorageBuilder(4));
		inv.setItem(20, new ItemStack(Material.GLASS));
		inv.setItem(21, xpStorageBuilder(4));
		inv.setItem(22, new ItemStack(Material.GLASS));
		inv.setItem(15, xpStorageBuilder(5));
		this.invs.put(5, inv);
		
		return invs;
	}
	
	public static int getXpStored(ItemStack item) {
		ItemMeta itM = item.getItemMeta();
		String lore;
		
		if (item.getItemMeta().getDisplayName().equals("§2XP STORAGE TIER V"))
			lore = itM.getLore().get(0).split(":")[1];
		else
			lore = itM.getLore().get(0).split(":")[1].split("/")[0];
		
		return (Integer.parseInt(lore));
	}
	
	public static int getMaxXpStorable(ItemStack item) {
		if (item.getItemMeta().getDisplayName().equals("§2XP STORAGE TIER V"))
			return 0;
		ItemMeta itM = item.getItemMeta();
		String lore = itM.getLore().get(0).split(":")[1].split("/")[1];
		
		
		return (Integer.parseInt(lore));
	}
	
	public void storeXp(Player player, ItemStack item, int currentStored, int maxStorable) {
		if (getPlayerExp(player) == 0) {
			player.sendMessage("§3[KWorld] : §rYou don't have any xp to store");
			return ;
		}
		
		int playerxp = getPlayerExp(player);
		if (maxStorable == 0) {
			player.setExp(0);
			player.setLevel(0);
			addXp(item, playerxp, true);
			return ;
		}
		if (currentStored == maxStorable) {
			player.sendMessage("§3[KWorld] : §rThis XP STORAGE already contains max XP possible");
			return ;
		}
		
		int xpStorable = maxStorable - currentStored;
		int xpDiff = playerxp - xpStorable;
		
		if (xpDiff <= 0) {
			player.setExp(0);
			player.setLevel(0);
			addXp(item, playerxp, false);
		}
		else if (xpDiff > 0) {
			int level = 0;
			for (; ; level++) {
				if (xpDiff < getExpAtLevel(level))
					break ;
				level++;
			}
			player.setLevel(level - 1);

			float expLevel;
			float expNext;
			float expRest;
			
			if (level == 0)
				expRest = xpDiff / getExpAtLevel(1);
			else {
				expLevel = getExpAtLevel(level - 1);
				expNext = getExpAtLevel(level - 1);
				expRest = (xpDiff - expLevel) / expNext;
				addXp(item, xpStorable, false);
			}

			player.setExp((float) Math.round(expRest * 10f) / 10f);
		}

		return ;
	}
	
	public static void addXp(ItemStack item, int xpAmount, boolean infinite) {
		ItemMeta itM = item.getItemMeta();
		String preLoreXp = itM.getLore().get(0).split(":")[0];
		int currentXp;
		String MaxXp;
		int newCurrent;
		String newLore;
		
		if (infinite) {
			currentXp = Integer.parseInt(itM.getLore().get(0).split(":")[1]);
			newCurrent = currentXp + xpAmount;
			newLore = preLoreXp + ":" + Integer.toString(newCurrent);
		}
		else {
			currentXp = Integer.parseInt(itM.getLore().get(0).split(":")[1].split("/")[0]);
			MaxXp = itM.getLore().get(0).split(":")[1].split("/")[1];
			newCurrent = currentXp + xpAmount;
			newLore = preLoreXp + ":" + Integer.toString(newCurrent) + "/" + MaxXp; 
		}
		
		itM.setLore(Arrays.asList(newLore, itM.getLore().get(1)));
		
		item.setItemMeta(itM);
	}
	
	public static void removeXp(ItemStack item, boolean infinite) {
		ItemMeta itM = item.getItemMeta();
		String preLoreXp = itM.getLore().get(0).split(":")[0];
		String preLoreLevel = itM.getLore().get(1).split(":")[0];
		String newLoreXp;
		String newLoreLevel;
		
		if (infinite) {
			newLoreXp = preLoreXp + ":0";
			newLoreLevel = preLoreLevel + ":0";
		}
		else {
			String MaxXp = itM.getLore().get(0).split(":")[1].split("/")[1];
			String MaxLevel = itM.getLore().get(1).split(":")[1].split("/")[1];
			newLoreXp = preLoreXp + ":0/" + MaxXp; 
			newLoreLevel = preLoreLevel + ":0/" + MaxLevel; 
		}
		
		itM.setLore(Arrays.asList(newLoreXp, newLoreLevel));
		
		item.setItemMeta(itM);
	}
	
	public void reloadXpLevel(ItemStack item, boolean infinite) {		
		ItemMeta itM = item.getItemMeta();
		String preLoreLevel = itM.getLore().get(1).split(":")[0];
		int currentXp;
		String MaxLevel;
		
		if (infinite) {
			currentXp = Integer.parseInt(itM.getLore().get(0).split(":")[1]);
			MaxLevel = "";
		}
		else {
			currentXp = Integer.parseInt(itM.getLore().get(0).split(":")[1].split("/")[0]);
			MaxLevel = itM.getLore().get(1).split(":")[1].split("/")[1];
		}
		
		if (currentXp < 7)
			return ;
		
		int level = 0;
		
		for (; ; level++) {
			if (currentXp < getExpAtLevel(level))
				break ;
		}
		
		String newLore;
		
		if (infinite) {
			newLore = preLoreLevel + ":" + (level - 1);
		}
		else {
			newLore = preLoreLevel + ":" + (level - 1) + "/" + MaxLevel;
		}
		
		itM.setLore(Arrays.asList(itM.getLore().get(0), newLore));
		
		item.setItemMeta(itM);
	}
	
	public void giveBackXpLevels(Player player, ItemStack item, boolean infinite) {
		int currentStoredXp = getXpStored(item);
		if (currentStoredXp == 0)
			return ;
		int playerXp = getPlayerExp(player);
		
		int totalXp = currentStoredXp + playerXp;
		
		player.setExp(0);
		player.setLevel(0);
		
		player.giveExp(totalXp);
		
		removeXp(item, infinite);
	}
	
	// Calculate amount of EXP needed to level up
    public static int getExpToLevelUp(int level){
        if(level <= 15){
            return 2*level+7;
        } else if(level <= 30){
            return 5*level-38;
        } else {
            return 9*level-158;
        }
    }
  
    // Calculate total experience up to a level
    public static int getExpAtLevel(int level){
        if(level <= 16){
            return (int) (Math.pow(level,2) + 6*level);
        } else if(level <= 31){
            return (int) (2.5*Math.pow(level,2) - 40.5*level + 360.0);
        } else {
            return (int) (4.5*Math.pow(level,2) - 162.5*level + 2220.0);
        }
    }
  
    // Calculate player's current EXP amount
    public static int getPlayerExp(Player player){
        int exp = 0;
        int level = player.getLevel();
      
        // Get the amount of XP in past levels
        exp += getExpAtLevel(level);
      
        // Get amount of XP towards next level
        exp += Math.round(getExpToLevelUp(level) * player.getExp());
      
        return exp;
    }
}
