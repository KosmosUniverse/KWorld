package fr.kosmosuniverse.kworld.crafts.xp;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.entity.ItemMergeEvent;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

public class XpStorageListener implements Listener {
	/*private KWorldMain main;
	
	public XpStorageListener(KWorldMain main) {
		this.main = main;
	}*/
	
	@EventHandler
	public void onItemPickup(EntityPickupItemEvent event) {
		if (event.getEntityType() != EntityType.PLAYER)
			return ;
		Player player = (Player) event.getEntity();
		ItemStack item = event.getItem().getItemStack();
		
		if (!item.getItemMeta().hasDisplayName() || !item.getItemMeta().getDisplayName().contains("§2XP STORAGE TIER"))
			return ;
		
		for (ItemStack it : player.getInventory()) {
			if (it != null && it.getItemMeta().getDisplayName().contains("§2XP STORAGE TIER")) {
				event.setCancelled(true);
				return ;
			}
		}
	}
	
	@EventHandler
	public void onCraftXpStorage(CraftItemEvent event) {
		if (!(event.getRecipe() instanceof ShapedRecipe))
			return ;
		
		ShapedRecipe shRep = (ShapedRecipe) event.getRecipe();
		Player player = (Player) event.getWhoClicked();
		
		if (shRep.getKey().getKey().equals("xpstorage1") || shRep.getKey().getKey().equals("xpstorage2") ||
				shRep.getKey().getKey().equals("xpstorage3") || shRep.getKey().getKey().equals("xpstorage4") ||
				shRep.getKey().getKey().equals("xpstorage5")) {
			ItemStack storageTierI = XpStorage.xpStorageBuilder(1);
			ItemStack storageTierII = XpStorage.xpStorageBuilder(2);
			ItemStack storageTierIII = XpStorage.xpStorageBuilder(3);
			ItemStack storageTierIV = XpStorage.xpStorageBuilder(4);
			ItemStack storageTierV = XpStorage.xpStorageBuilder(5);
			if (player.getInventory().contains(storageTierI) || player.getInventory().contains(storageTierII) ||
					player.getInventory().contains(storageTierIII) || player.getInventory().contains(storageTierIV) ||
					player.getInventory().contains(storageTierV)) {
				event.setCancelled(true);
				player.closeInventory();
				player.sendMessage("§3[KWorld] : §rYou can't have more than one xpStorage in your inventory.");
			}
		}
	}
	
	@EventHandler
	public void onItemMerge(ItemMergeEvent event) {
		ItemStack item1 = event.getTarget().getItemStack();
		ItemStack item2 = event.getEntity().getItemStack();
		
		if (item1.getItemMeta().getDisplayName().equals(item2.getItemMeta().getDisplayName()))
			event.setCancelled(true);
	}
}
