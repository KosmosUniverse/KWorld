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
import fr.kosmosuniverse.kworld.MultiBlocks.Decomposer;
import fr.kosmosuniverse.kworld.MultiBlocks.Synthetiser;
import fr.kosmosuniverse.kworld.crafts.chim.ChimActivator;
import fr.kosmosuniverse.kworld.crafts.fun.stick.EarthStick;
import fr.kosmosuniverse.kworld.crafts.fun.stick.FireStick;
import fr.kosmosuniverse.kworld.crafts.fun.stick.WaterStick;
import fr.kosmosuniverse.kworld.crafts.fun.stick.WindStick;
import fr.kosmosuniverse.kworld.crafts.fun.xp.ExpBottle;
import fr.kosmosuniverse.kworld.crafts.fun.xp.XpStorage;

public class InventoryRecipeListener implements Listener {

	private KWorldMain main;
	
	public InventoryRecipeListener(KWorldMain main) {
		this.main = main;
	}

	public static Inventory getGuideInventory() {
		Inventory inv = Bukkit.createInventory(null, 54, "�8Guide");
		
		inv.setItem(20, new ItemBuilder(Material.CRAFTING_TABLE, "�eWORKBENCH RECIPES").getItem());
		inv.setItem(21, new ItemBuilder(Material.FURNACE, "�eFURNACE RECIPES").getItem());
		inv.setItem(22, new ItemBuilder(Material.CHEST, "�eMultiBlocks").getItem());
		
		return inv;
	}
	
	public Inventory getCraftsInventory() {
		Inventory inv = Bukkit.createInventory(null, 27, "�8Craft");
		
		inv.setItem(0, new ItemStack(Material.EXPERIENCE_BOTTLE));
		inv.setItem(1, new FireStick(this.main).StickSample());
		inv.setItem(2, new WindStick(this.main).StickSample());
		inv.setItem(3, new EarthStick(this.main).StickSample());
		inv.setItem(4, new WaterStick(this.main).StickSample());
		inv.setItem(5, XpStorage.xpStorageSampleBuilder());
		inv.setItem(6, ChimActivator.ActivatorBuilder());
		inv.setItem(26, new ItemBuilder(Material.BARRIER, "�cBack <-", 1).getItem());
		
		return inv;
	}
	
	public static Inventory getMultiBlockInventory() {
		Inventory inv = Bukkit.createInventory(null, 27, "�8MultiBlocks");
		
		inv.setItem(0, new ItemBuilder(Material.CHISELED_STONE_BRICKS, "Decomposer").getItem());
		inv.setItem(1, new ItemBuilder(Material.CHISELED_QUARTZ_BLOCK, "Synthetiser").getItem());
		inv.setItem(26, new ItemBuilder(Material.BARRIER, "�cBack <-", 1).getItem());
		
		return inv;
	}
	
	@EventHandler
	public void onGuideClick(InventoryClickEvent event) {
		Inventory inv = event.getInventory();
		Player player = (Player) event.getWhoClicked();
		ItemStack item = event.getCurrentItem();
		
		if (item == null)
			return ;
		
		
		if (inv.getName().equals("�8Guide")) {
			event.setCancelled(true);
			
			switch (item.getType()) {
			case CRAFTING_TABLE:
				player.openInventory(getCraftsInventory());
				break ;
			case FURNACE:
				player.sendMessage("Yo furnace mam�ne");
				break;
			case CHEST:
				player.openInventory(getMultiBlockInventory());
				break;
			default:
				break;
			}
		}
	}
	
	@EventHandler
	public void onCraftClick(InventoryClickEvent event) {
		Inventory inv = event.getInventory();
		Player player = (Player) event.getWhoClicked();
		ItemStack item = event.getCurrentItem();
		
		if (item == null)
			return ;
		
		if (!inv.getName().equals("�8Craft"))
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
			if (item.getItemMeta().getDisplayName().equals("�cFIRE"))
				newInv = new FireStick(this.main).getInventory();
			else if (item.getItemMeta().getDisplayName().equals("�bWIND"))
				newInv = new WindStick(this.main).getInventory();
			else if (item.getItemMeta().getDisplayName().equals("�aEARTH"))
				newInv = new EarthStick(this.main).getInventory();
			else if (item.getItemMeta().getDisplayName().equals("�1WATER"))
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
	
	@EventHandler
	public void onMultiBlockClick(InventoryClickEvent event) {
		Inventory inv = event.getInventory();
		Player player = (Player) event.getWhoClicked();
		ItemStack item = event.getCurrentItem();
		
		if (item == null)
			return ;
		
		if (inv.getName().equals("�8MultiBlocks")) {
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
		
		else if (!inv.getName().contains("�8[MultiBlock]"))
			return ;
		
		event.setCancelled(true);
		
		if (inv.getName().contains("Decomposer"))
			player.openInventory(new Decomposer().getInventory(inv, item.getType(), getMultiBlockInventory()));
		if (inv.getName().contains("Synthetiser"))
			player.openInventory(new Synthetiser().getInventory(inv, item.getType(), getMultiBlockInventory()));
	}
	
	@EventHandler
	public void onXpCraftClick(InventoryClickEvent event) {
		Inventory inv = event.getInventory();
		Player player = (Player) event.getWhoClicked();
		ItemStack item = event.getCurrentItem();
		
		if (item == null)
			return ;
		
		if (!inv.getName().equals("�8XP Bottle"))
			return ;
		event.setCancelled(true);
		if (item.getType() == Material.BARRIER) {
			player.openInventory(getCraftsInventory());
		}
	}
	
	@EventHandler
	public void onStickCraftClick(InventoryClickEvent event) {
		Inventory inv = event.getInventory();
		Player player = (Player) event.getWhoClicked();
		ItemStack item = event.getCurrentItem();
		
		if (item == null)
			return ;
		
		if (inv.getName().equals("�8Fire Stick") || inv.getName().equals("�8Wind Stick") ||
				inv.getName().equals("�8Earth Stick") || inv.getName().equals("�8Water Stick")) {
			event.setCancelled(true);
			if (item.getType() == Material.BARRIER)
				player.openInventory(getCraftsInventory());
		}
	}
	
	@EventHandler
	public void onXpStorageCraftClick(InventoryClickEvent event) {
		Inventory inv = event.getInventory();
		Player player = (Player) event.getWhoClicked();
		ItemStack item = event.getCurrentItem();
		
		if (item == null)
			return ;
		
		if (inv.getName().equals("�8XP STORAGE 1")) {
			event.setCancelled(true);
			if (item.getType() == Material.BARRIER)
				player.openInventory(getCraftsInventory());
			else if (item.getType() == Material.LIME_STAINED_GLASS_PANE)
				player.openInventory(XpStorage.getXpStorageRecipe2());
		}
		else if (inv.getName().equals("�8XP STORAGE 2")) {
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
		
		if (inv.getName().equals("�8Activator")) {
			event.setCancelled(true);
			if (item.getType() == Material.BARRIER)
				player.openInventory(getCraftsInventory());
		}
	}
}
