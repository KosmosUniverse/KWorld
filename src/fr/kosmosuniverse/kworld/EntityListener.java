package fr.kosmosuniverse.kworld;

import java.util.Arrays;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class EntityListener implements Listener {

	//private KWorldMain main;
	
	/*public EntityListener(KWorldMain main) {
		this.main = main;
	}*/

	@EventHandler
	public void onStickHit(EntityDamageByEntityEvent event) {
		Entity entity = event.getEntity();
		Entity damager = event.getDamager();
		
		if (damager instanceof Player && entity.getType().isAlive()) {
			Player player = (Player) damager;
			
			ItemStack item = player.getInventory().getItemInMainHand();
			
			if (item.getItemMeta().getDisplayName().contains("STICK TIER I") &&
					(item.getItemMeta().getDisplayName().contains("FIRE") ||
							item.getItemMeta().getDisplayName().contains("WIND") ||
							item.getItemMeta().getDisplayName().contains("EARTH") ||
							item.getItemMeta().getDisplayName().contains("WATER"))) {
				ItemMeta itM = item.getItemMeta();
				String lore = itM.getLore().get(0).split(":")[1].split("/")[0];
				int dur = Integer.parseInt(lore) - 1;
				String newLore = "Durability:" + Integer.toString(dur) + "/600";
				itM.setLore(Arrays.asList(newLore));
				item.setItemMeta(itM);
				if (dur == 0)
					player.getInventory().remove(item);
			}
		}
	}
}
