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
//import fr.kosmosuniverse.kworld.KWorldMain;
import fr.kosmosuniverse.kworld.crafts.stick.EarthStick;
import fr.kosmosuniverse.kworld.crafts.stick.FireStick;
import fr.kosmosuniverse.kworld.crafts.stick.WaterStick;
import fr.kosmosuniverse.kworld.crafts.stick.WindStick;
import fr.kosmosuniverse.kworld.crafts.xp.ExpBottle;
import fr.kosmosuniverse.kworld.crafts.xp.XpStorage;

public class InventoryRecipeListener implements Listener {

	//private KWorldMain main;
	
	public InventoryRecipeListener(/*KWorldMain main*/) {
		//this.main = main;
	}

	public static Inventory getGuideInventory() {
		Inventory inv = Bukkit.createInventory(null, 54, "§8Guide");
		
		inv.setItem(20, new ItemBuilder(Material.CRAFTING_TABLE, "§eWORKBENCH RECIPES", 1).getItem());
		inv.setItem(21, new ItemBuilder(Material.FURNACE, "§eFURNACE RECIPES", 1).getItem());
		
		return inv;
	}
	
	public static Inventory getCraftsInventory() {
		Inventory inv = Bukkit.createInventory(null, 27, "§8Craft");
		
		inv.setItem(0, new ItemStack(Material.EXPERIENCE_BOTTLE));
		inv.setItem(1, new ItemBuilder(Material.STICK, "§cFIRE STICK", 1).getItem());
		inv.setItem(2, new ItemBuilder(Material.STICK, "§bWIND STICK", 1).getItem());
		inv.setItem(3, new ItemBuilder(Material.STICK, "§aEARTH STICK", 1).getItem());
		inv.setItem(4, new ItemBuilder(Material.STICK, "§1WATER STICK", 1).getItem());
		inv.setItem(5, XpStorage.xpStorageSampleBuilder());
		inv.setItem(26, new ItemBuilder(Material.BARRIER, "§cBack <-", 1).getItem());
		
		return inv;
	}
	
	@EventHandler
	public void onGuideClick(InventoryClickEvent event) {
		Inventory inv = event.getInventory();
		Player player = (Player) event.getWhoClicked();
		ItemStack item = event.getCurrentItem();
		
		if (item == null)
			return ;
		
		
		if (inv.getName().equals("§8Guide")) {
			event.setCancelled(true);
			
			switch (item.getType()) {
			case CRAFTING_TABLE:
				player.openInventory(getCraftsInventory());
				break ;
			case FURNACE:
				player.sendMessage("Yo furnace mamène");
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
		
		if (inv.getName().equals("§8Craft")) {
			event.setCancelled(true);
			
			Inventory newInv;
			
			switch (item.getType()) {
			case BARRIER:
				player.closeInventory();
				player.openInventory(getGuideInventory());
				break;
			case EXPERIENCE_BOTTLE:
				newInv = ExpBottle.getExpBottleRecipe();
				player.openInventory(newInv);
				break;
			case STICK:
				if (item.getItemMeta().getDisplayName().equals("§cFIRE STICK")) {
					newInv = FireStick.getFireStickRecipe();
					player.openInventory(newInv);
				}
				else if (item.getItemMeta().getDisplayName().equals("§bWIND STICK")) {
					newInv = WindStick.getWindStickRecipe();
					player.openInventory(newInv);
				}
				else if (item.getItemMeta().getDisplayName().equals("§aEARTH STICK")) {
					newInv = EarthStick.getEarthStickRecipe();
					player.openInventory(newInv);
				}
				else if (item.getItemMeta().getDisplayName().equals("§1WATER STICK")) {
					newInv = WaterStick.getWaterStickRecipe();
					player.openInventory(newInv);
				}
				break;
			case EMERALD:
				newInv = XpStorage.getXpStorageRecipe();
				player.openInventory(newInv);
			default:
				break;
			}
		}
	}
	
	@EventHandler
	public void onXpCraftClick(InventoryClickEvent event) {
		Inventory inv = event.getInventory();
		Player player = (Player) event.getWhoClicked();
		ItemStack item = event.getCurrentItem();
		
		if (item == null)
			return ;
		
		if (inv.getName().equals("§8XP Bottle")) {
			event.setCancelled(true);
			if (item.getType() == Material.BARRIER) {
				player.closeInventory();
				player.openInventory(getCraftsInventory());
			}
		}
	}
	
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
				player.closeInventory();
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
		
		if (inv.getName().equals("§8XP STORAGE 1")) {
			event.setCancelled(true);
			if (item.getType() == Material.BARRIER) {
				player.closeInventory();
				player.openInventory(getCraftsInventory());
			}
			else if (item.getType() == Material.LIME_STAINED_GLASS_PANE) {
				player.closeInventory();
				player.openInventory(XpStorage.getXpStorageRecipe2());
			}
		}
		else if (inv.getName().equals("§8XP STORAGE 2")) {
			event.setCancelled(true);
			if (item.getType() == Material.BARRIER) {
				player.closeInventory();
				player.openInventory(XpStorage.getXpStorageRecipe());
			}
		}
	}
}
