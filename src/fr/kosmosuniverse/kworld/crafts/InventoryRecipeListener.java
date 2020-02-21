package fr.kosmosuniverse.kworld.crafts;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import fr.kosmosuniverse.kworld.ItemBuilder;
import fr.kosmosuniverse.kworld.KWorldMain;
import fr.kosmosuniverse.kworld.MultiBlocks.utils.IMultiBlock;
import fr.kosmosuniverse.kworld.crafts.chim.ChimActivator;
import fr.kosmosuniverse.kworld.crafts.fun.stick.AStick3T;
import fr.kosmosuniverse.kworld.crafts.fun.stick.EarthStick;
import fr.kosmosuniverse.kworld.crafts.fun.stick.FireStick;
import fr.kosmosuniverse.kworld.crafts.fun.stick.WaterStick;
import fr.kosmosuniverse.kworld.crafts.fun.stick.WindStick;
import fr.kosmosuniverse.kworld.crafts.fun.xp.ExpBottle;
import fr.kosmosuniverse.kworld.crafts.fun.xp.XpStorage;

public class InventoryRecipeListener implements Listener {

	private KWorldMain main;
	private Inventory inv;
	private Player player;
	private ItemStack item;
	
	public InventoryRecipeListener(KWorldMain main) {
		this.main = main;
		Inventory smallInv = Bukkit.createInventory(null, 27);
		
		smallInv.setItem(12, new ItemBuilder(Material.CRAFTING_TABLE, "§eWORKBENCH RECIPES").getItem());
		smallInv.setItem(13, new ItemBuilder(Material.FURNACE, "§eFURNACE RECIPES").getItem());
		smallInv.setItem(14, new ItemBuilder(Material.CHEST, "§eMultiBlocks").getItem());
		this.main.invs.put("§8Guide", smallInv);
		this.main.invsActions.put("§8Guide", () -> guideClick());
		
		smallInv = Bukkit.createInventory(null, 27);
		smallInv.setItem(0, new ItemStack(Material.EXPERIENCE_BOTTLE));
		smallInv.setItem(1, new FireStick(this.main).StickSample());
		smallInv.setItem(2, new WindStick(this.main).StickSample());
		smallInv.setItem(3, new EarthStick(this.main).StickSample());
		smallInv.setItem(4, new WaterStick(this.main).StickSample());
		smallInv.setItem(5, XpStorage.xpStorageSampleBuilder());
		smallInv.setItem(6, ChimActivator.ActivatorBuilder());
		smallInv.setItem(26, new ItemBuilder(Material.BARRIER, "§cBack <-", 1).getItem());
		this.main.invs.put("§8Crafts", smallInv);
		this.main.invsActions.put("§8Crafts", () -> craftsClick());
		
		smallInv = Bukkit.createInventory(null, 27);
		smallInv.setItem(0, new ItemBuilder(Material.CHISELED_STONE_BRICKS, "Decomposer").getItem());
		smallInv.setItem(1, new ItemBuilder(Material.CHISELED_QUARTZ_BLOCK, "Synthetiser").getItem());
		smallInv.setItem(26, new ItemBuilder(Material.BARRIER, "§cBack <-", 1).getItem());
		this.main.invs.put("§8MultiBlocks", smallInv);
		this.main.invsActions.put("§8MultiBlocks", () -> multiblocksClick());
		
		smallInv = Bukkit.createInventory(null, 27);
		for (AStick3T a : this.main.funItems.getStickList()) {
			this.main.invs.put(a.getColor() + a.getName(), a.getInventory());
			this.main.invsActions.put(a.getColor() + a.getName(), () -> stickClick());
		}
		
		this.main.invs.put("§8XP Bottle", ExpBottle.getExpBottleRecipe());
		this.main.invsActions.put("§8XP Bottle", () -> xpBottleClick());
		
		for (IMultiBlock mb : this.main.MBList) {
			int cnt = 1;
			for (int i : mb.getInventory().keySet()) {
				this.main.invs.put("§8" + mb.getName() + "_" + cnt, mb.getInventory().get(i));
				this.main.invsActions.put("§8" + mb.getName() + "_" + cnt, () -> multiblocksClick());
				cnt++;
			}
		}
	}
	
	private void guideClick() {
		switch (item.getType()) {
		case CRAFTING_TABLE:
			player.openInventory(this.main.invs.get("§8Crafts"));
			break ;
		case FURNACE:
			player.sendMessage("Yo furnace mamène");
			break;
		case CHEST:
			player.openInventory(this.main.invs.get("§8MultiBlocks"));
			break;
		default:
			break;
		}
	}
	
	private void craftsClick() {
		
		switch (item.getType()) {
		case BARRIER:
			player.openInventory(this.main.invs.get("§8Guide"));
			break;
		case EXPERIENCE_BOTTLE:
			player.openInventory(ExpBottle.getExpBottleRecipe());
			break;
		case STICK:
			player.openInventory(this.main.invs.get(item.getItemMeta().getDisplayName()));
			break;
		case EMERALD:
			player.openInventory(XpStorage.getXpStorageRecipe());
			break;
		case END_ROD:
			player.openInventory(ChimActivator.getActivatorRecipe());
			break;
		default:
			break;
		}
	}

	private void multiblocksClick() {
		switch (item.getType()) {
		case BARRIER:
			if (item.getItemMeta().getDisplayName().contains("Back"))
				player.openInventory(this.main.invs.get("§8MultiBlocks"));
			else {
				for (String s : this.main.invs.keySet())
					if (this.main.invs.get(s).equals(inv)) {
						player.openInventory(this.main.invs.get(getPreviousNum(s)));	
					}
			}
			break ;
		case CHISELED_STONE_BRICKS:
			player.openInventory(this.main.invs.get("§8Decomposer_1"));
			break ;
		case CHISELED_QUARTZ_BLOCK:
			player.openInventory(this.main.invs.get("§8Synthetiser_1"));
			break ;
		case LIME_STAINED_GLASS_PANE:
			for (String s : this.main.invs.keySet())
				if (this.main.invs.get(s).equals(inv)) {
					player.openInventory(this.main.invs.get(getNextNum(s)));	
				}
			break;
		default:
			break ;
		}
	}
	
	private String getPreviousNum(String s) {
		String ret;
		for (int i = 2; i <= 5; i++) {
			if (s.endsWith("_" + i)) {
				ret = s.split("_")[0] + "_" + (i - 1);
				return ret;
			}
		}
		return s;
	}
	
	private String getNextNum(String s) {
		String ret;
		for (int i = 1; i < 5; i++) {
			if (s.endsWith("_" + i)) {
				ret = s.split("_")[0] + "_" + (i + 1);
				return ret;
			}
		}
		return s;
	}
	
	public void stickClick() {
		if (item.getType() == Material.BARRIER)
			player.openInventory(this.main.invs.get("§8Crafts"));
	}
	
	public void xpBottleClick() {
		if (item.getType() == Material.BARRIER)
			player.openInventory(this.main.invs.get("§8Crafts"));
	}

/*	public static Inventory getGuideInventory() {
		Inventory inv = Bukkit.createInventory(null, 54, "§8Guide");
		
		inv.setItem(20, new ItemBuilder(Material.CRAFTING_TABLE, "§eWORKBENCH RECIPES").getItem());
		inv.setItem(21, new ItemBuilder(Material.FURNACE, "§eFURNACE RECIPES").getItem());
		inv.setItem(22, new ItemBuilder(Material.CHEST, "§eMultiBlocks").getItem());
		
		return inv;
	}*/
	
/*	public Inventory getCraftsInventory() {
		Inventory inv = Bukkit.createInventory(null, 27);
		
		inv.setItem(0, new ItemStack(Material.EXPERIENCE_BOTTLE));
		inv.setItem(1, new FireStick(this.main).StickSample());
		inv.setItem(2, new WindStick(this.main).StickSample());
		inv.setItem(3, new EarthStick(this.main).StickSample());
		inv.setItem(4, new WaterStick(this.main).StickSample());
		inv.setItem(5, XpStorage.xpStorageSampleBuilder());
		inv.setItem(6, ChimActivator.ActivatorBuilder());
		inv.setItem(26, new ItemBuilder(Material.BARRIER, "§cBack <-", 1).getItem());
		
		return inv;
	}*/
	
/*	public static Inventory getMultiBlockInventory() {
		Inventory inv = Bukkit.createInventory(null, 27, "§8MultiBlocks");
		
		inv.setItem(0, new ItemBuilder(Material.CHISELED_STONE_BRICKS, "Decomposer").getItem());
		inv.setItem(1, new ItemBuilder(Material.CHISELED_QUARTZ_BLOCK, "Synthetiser").getItem());
		inv.setItem(26, new ItemBuilder(Material.BARRIER, "§cBack <-", 1).getItem());
		
		return inv;
	}*/
	
	@EventHandler
	public void onGuideClick(InventoryClickEvent event) {
		inv = event.getInventory();
		player = (Player) event.getWhoClicked();
		item = event.getCurrentItem();
		
		if (item == null)
			return ;
		event.setCancelled(true);
		if (this.main.invs.containsValue(inv)) {
			for (String s : this.main.invs.keySet()) {
				if (this.main.invs.get(s).equals(inv))
					this.main.invsActions.get(s).run();
			}
		}
	}
/*	
	@EventHandler
	public void onCraftClick(InventoryClickEvent event) {
		Inventory inv = event.getInventory();
		Player player = (Player) event.getWhoClicked();
		ItemStack item = event.getCurrentItem();
		
		if (item == null)
			return ;
		
		if (!inv.getName().equals("§8Craft"))
			return ;
		event.setCancelled(true);
		
		Inventory newInv = null;
		
		switch (item.getType()) {
		case BARRIER:
			player.openInventory(getGuideInventory());
			break;
		case EXPERIENCE_BOTTLE:
			newInv = ExpBottle.getExpBottleRecipe();
			player.openInventory(newInv);
			break;
		case STICK:
			if (item.getItemMeta().getDisplayName().equals("§cFIRE"))
				newInv = new FireStick(this.main).getInventory();
			else if (item.getItemMeta().getDisplayName().equals("§bWIND"))
				newInv = new WindStick(this.main).getInventory();
			else if (item.getItemMeta().getDisplayName().equals("§aEARTH"))
				newInv = new EarthStick(this.main).getInventory();
			else if (item.getItemMeta().getDisplayName().equals("§1WATER"))
				newInv = new WaterStick(this.main).getInventory();
			player.openInventory(newInv);
			break;
		case EMERALD:
			newInv = XpStorage.getXpStorageRecipe();
			player.openInventory(newInv);
			break;
		case END_ROD:
			newInv = ChimActivator.getActivatorRecipe();
			player.openInventory(newInv);
			break;
		default:
			break;
		}
	}
	*/
	/*@EventHandler
	public void onMultiBlockClick(InventoryClickEvent event) {
		Inventory inv = event.getInventory();
		Player player = (Player) event.getWhoClicked();
		ItemStack item = event.getCurrentItem();
		
		if (item == null)
			return ;
		
		if (inv.getName().equals("§8MultiBlocks")) {
			event.setCancelled(true);
			switch (item.getType()) {
			case BARRIER:
				player.openInventory(getGuideInventory());
				break ;
			case CHISELED_STONE_BRICKS:
				player.openInventory(new Decomposer().getInventory(inv, item.getType(), getMultiBlockInventory()));
				break ;
			case CHISELED_QUARTZ_BLOCK:
				player.openInventory(new Synthetiser().getInventory(inv, item.getType(), getMultiBlockInventory()));
				break ;
			default:
				break ;
			}
			return ;
		}
		
		else if (!inv.getName().contains("§8[MultiBlock]"))
			return ;
		
		event.setCancelled(true);
		
		if (inv.getName().contains("Decomposer"))
			player.openInventory(new Decomposer().getInventory(inv, item.getType(), getMultiBlockInventory()));
		if (inv.getName().contains("Synthetiser"))
			player.openInventory(new Synthetiser().getInventory(inv, item.getType(), getMultiBlockInventory()));
	}
	*/
/*	@EventHandler
	public void onXpCraftClick(InventoryClickEvent event) {
		Inventory inv = event.getInventory();
		Player player = (Player) event.getWhoClicked();
		ItemStack item = event.getCurrentItem();
		
		if (item == null)
			return ;
		
		if (!inv.getName().equals("§8XP Bottle"))
			return ;
		event.setCancelled(true);
		if (item.getType() == Material.BARRIER) {
			player.openInventory(getCraftsInventory());
		}
	}*/
/*	
	@EventHandler
	public void onStickCraftClick(InventoryClickEvent event) {
		Inventory inv = event.getInventory();
		Player player = (Player) event.getWhoClicked();
		ItemStack item = event.getCurrentItem();
		
		if (item == null)
			return ;
		
		if (inv.getName().equals("§8Fire Stick") || inv.getName().equals("§8Wind Stick") ||
				inv.getName().equals("§8Earth Stick") || inv.getName().equals("§8Water Stick")) {
			event.setCancelled(true);
			if (item.getType() == Material.BARRIER)
				player.openInventory(getCraftsInventory());
		}
	}
	*/
/*	@EventHandler
	public void onXpStorageCraftClick(InventoryClickEvent event) {
		Inventory inv = event.getInventory();
		Player player = (Player) event.getWhoClicked();
		ItemStack item = event.getCurrentItem();
		
		if (item == null)
			return ;
		
		if (inv.getName().equals("§8XP STORAGE 1")) {
			event.setCancelled(true);
			if (item.getType() == Material.BARRIER)
				player.openInventory(getCraftsInventory());
			else if (item.getType() == Material.LIME_STAINED_GLASS_PANE)
				player.openInventory(XpStorage.getXpStorageRecipe2());
		}
		else if (inv.getName().equals("§8XP STORAGE 2")) {
			event.setCancelled(true);
			if (item.getType() == Material.BARRIER)
				player.openInventory(XpStorage.getXpStorageRecipe());
		}
	}
	
	@EventHandler
	public void onActivatorClick(InventoryClickEvent event) {
		Inventory inv = event.getInventory();
		Player player = (Player) event.getWhoClicked();
		ItemStack item = event.getCurrentItem();
		
		if (item == null)
			return ;
		
		if (inv.getName().equals("§8Activator")) {
			event.setCancelled(true);
			if (item.getType() == Material.BARRIER)
				player.openInventory(getCraftsInventory());
		}
	}*/
}
