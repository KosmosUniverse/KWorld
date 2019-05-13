package fr.kosmosuniverse.kworld;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;

import fr.kosmosuniverse.kworld.crafts.InventoryRecipeListener;

public class KWorldListener implements Listener {

	private KWorldMain main;

	public KWorldListener(KWorldMain main) {
		this.main = main;
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent event) {

		Player player = event.getPlayer();

		event.setJoinMessage("§3[KWorld] : §2" + (main.getConfig().getStringList("general.messages.join").get(new Random().nextInt(3)).replace("Player", "§6" + player.getName() + "§2")));
	}

	@EventHandler
	public void onQuit(PlayerQuitEvent event) {
		Player player = event.getPlayer();

		event.setQuitMessage("§3[KWorld] : §2" + (main.getConfig().getStringList("general.messages.quit").get(new Random().nextInt(3)).replace("Player", "§6" + player.getName() + "§2")));
	}

	@EventHandler
	public void onRightClick(PlayerInteractEvent event) {

		Player player = event.getPlayer();
		Action action = event.getAction();
		ItemStack item = event.getItem();

		if (item == null)
			return ;

		if ((action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK) &&
				item.getType() == Material.ENCHANTED_BOOK &&
				item.getItemMeta().hasDisplayName() &&
				item.getItemMeta().getDisplayName().equals("§6§l§nKWorld Guide")) {

			player.openInventory(InventoryRecipeListener.getGuideInventory());
		}
	}
}
