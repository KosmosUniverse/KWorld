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
		inv.setItem(1, new ItemStack(Material.STICK));
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
				newInv = FireStick.getFireStickRecipe();
				
				player.openInventory(newInv);
				break;
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
		
		if (inv.getName().equals("§8Fire Stick")) {
			event.setCancelled(true);
			if (item.getType() == Material.BARRIER)
				player.closeInventory();
			player.openInventory(getCraftsInventory());
		}
	}
}
