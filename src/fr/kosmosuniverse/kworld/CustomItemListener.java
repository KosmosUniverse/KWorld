package fr.kosmosuniverse.kworld;

import java.util.Arrays;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import fr.kosmosuniverse.kworld.crafts.fun.xp.XpStorage;

public class CustomItemListener implements Listener {

	private KWorldMain main;
	
	public CustomItemListener(KWorldMain main) {
		this.main = main;
	}
	
	@EventHandler
	public void onStickClick(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		Action action = event.getAction();
		ItemStack item = event.getItem();
		
		if (action != Action.RIGHT_CLICK_AIR && action != Action.RIGHT_CLICK_BLOCK)
			return ;
		
		if (item == null || !item.hasItemMeta() || !item.getItemMeta().hasDisplayName() || !item.getItemMeta().hasLore())
			return ;
		
		if (!item.getItemMeta().getDisplayName().contains("§") || !item.getItemMeta().getDisplayName().contains("STICK TIER I")) {
			return ;
		}
		
		ItemMeta itM = item.getItemMeta();
		
		String name = itM.getDisplayName();
		
		String Lore = itM.getLore().get(0).split(":")[1];
		String max = Lore.split("/")[1];
		Integer dur = Integer.parseInt(Lore.split("/")[0]) - 1;
		
		String newLore = "Durability:" + Integer.toString(dur) + "/" + max;
		itM.setLore(Arrays.asList(newLore));
		item.setItemMeta(itM);
		
		if (dur == 0)
			player.getInventory().remove(item);
		
		Integer time = 0;
		Integer power = 0;
		PotionEffectType potion = PotionEffectType.ABSORPTION;
		
		if (name.contains("TIER III")) {
			if (action == Action.RIGHT_CLICK_BLOCK) {
				spawnBlocks(name, event.getClickedBlock(), player);
				return ;
			}
			time = 60;
			power = 4;
		}
		else if (name.contains("TIER II")) {
			time = 40;
			power = 2;
		}
		else if (name.contains("TIER I")) {
			time = 20;
			power = 1;
		}
		
		if (name.contains("FIRE")) {
			potion = PotionEffectType.FIRE_RESISTANCE;
		}
		else if (name.contains("WIND")) {
			potion = PotionEffectType.SPEED;
		}
		else if (name.contains("EARTH")) {
			potion = PotionEffectType.DAMAGE_RESISTANCE;
		}
		else if (name.contains("WATER")) {
			potion = PotionEffectType.WATER_BREATHING;
		}
		player.addPotionEffect(new PotionEffect(potion, 20 * time, power));
	}
	
	private void spawnBlocks(String name, Block block, Player player) {
		Location locs[] = new Location[] {
				block.getLocation().add(1, 1, 0), block.getLocation().add(2, 1, 0),
				block.getLocation().add(-1, 1, 0), block.getLocation().add(-2, 1, 0),
				block.getLocation().add(0, 1, -1), block.getLocation().add(0, 1, -2),
				block.getLocation().add(0, 1, 1), block.getLocation().add(0, 1, 2),
				block.getLocation().add(1, 1, 1), block.getLocation().add(1, 1, -1),
				block.getLocation().add(-1, 1, 1), block.getLocation().add(-1, 1, -1),
				block.getLocation().add(0, 1, 0)
		};
		
		Material toPut;
		
		if (name.contains("FIRE"))
			toPut = Material.FIRE;
		else if (name.contains("WIND"))
			toPut = Material.COBWEB;
		else if (name.contains("EARTH"))
			toPut = Material.MAGMA_BLOCK;
		else if (name.contains("WATER"))
			toPut = Material.WATER;
		else
			toPut = Material.AIR;
		
		for (Location loc : locs) {
			if (loc.getBlock().getType() == Material.AIR &&
					loc.getBlock().getRelative(BlockFace.DOWN).getType() != Material.AIR &&
					!(loc.getBlockX() == player.getLocation().getBlockX() &&
					loc.getBlockY() == player.getLocation().getBlockY() &&
					loc.getBlockZ() == player.getLocation().getBlockZ())) {
				loc.getBlock().setType(toPut);
			}
		}
	}
	
	@EventHandler
	public void onXpStorageClickEvent(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		ItemStack item = event.getItem();
		Action action = event.getAction();
		
		if (item == null || !item.getItemMeta().getDisplayName().contains("§2XP STORAGE TIER"))
			return ;
		
		XpStorage xp = new XpStorage(this.main);
		if (action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK) {
		
			int currentStored = XpStorage.getXpStored(item);
			int maxStorable = XpStorage.getMaxXpStorable(item);
		
			xp.storeXp(player, item, currentStored, maxStorable);
			xp.reloadXpLevel(item, maxStorable == 0);
		}
		else if (action == Action.LEFT_CLICK_AIR || action == Action.LEFT_CLICK_BLOCK) {
			int maxStorable = XpStorage.getMaxXpStorable(item);
			
			xp.giveBackXpLevels(player, item, maxStorable == 0);
		}
	}
}
