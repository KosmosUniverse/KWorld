package fr.kosmosuniverse.kworld;

import java.util.Arrays;

import org.bukkit.Location;
import org.bukkit.Material;
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

import fr.kosmosuniverse.kworld.crafts.xp.XpStorage;

public class CustomItemListener implements Listener {

	private KWorldMain main;
	
	public CustomItemListener(KWorldMain main) {
		this.main = main;
	}
	
	@EventHandler
	public void onFireStickClick(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		Action action = event.getAction();
		ItemStack item = event.getItem();
		
		if (item == null)
			return ;
		
		if (item.getItemMeta().getDisplayName().contains("§cFIRE STICK TIER I")) {
			if (item.getItemMeta().getDisplayName().equals("§cFIRE STICK TIER I") &&
					(action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK)) {
				ItemMeta itM = item.getItemMeta();
				String lore = itM.getLore().get(0).split(":")[1].split("/")[0];
				int dur = Integer.parseInt(lore) - 1;
				String newLore = "Durability:" + Integer.toString(dur) + "/200";
				itM.setLore(Arrays.asList(newLore));
				item.setItemMeta(itM);
				if (dur == 0)
					player.getInventory().remove(item);
						
				player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 20 * 20, 1));
				}
			else if (item.getItemMeta().getDisplayName().equals("§cFIRE STICK TIER II") &&
					(action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK)) {
				ItemMeta itM = item.getItemMeta();
				String lore = itM.getLore().get(0).split(":")[1].split("/")[0];
				int dur = Integer.parseInt(lore) - 1;
				String newLore = "Durability:" + Integer.toString(dur) + "/400";
				itM.setLore(Arrays.asList(newLore));
				item.setItemMeta(itM);
				if (dur == 0)
					player.getInventory().remove(item);
				
				player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 20 * 40, 2));
				}
			else if (item.getItemMeta().getDisplayName().equals("§cFIRE STICK TIER III")) {
				if (action == Action.RIGHT_CLICK_AIR) {
					ItemMeta itM = item.getItemMeta();
					String lore = itM.getLore().get(0).split(":")[1].split("/")[0];
					int dur = Integer.parseInt(lore) - 1;
					String newLore = "Durability:" + Integer.toString(dur) + "/600";
					itM.setLore(Arrays.asList(newLore));
					item.setItemMeta(itM);
					if (dur == 0)
						player.getInventory().remove(item);
					
					player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 20 * 60, 4));
					}
				else if (action == Action.RIGHT_CLICK_BLOCK) {
					ItemMeta itM = item.getItemMeta();
					String lore = itM.getLore().get(0).split(":")[1].split("/")[0];
					int dur = Integer.parseInt(lore) - 1;
					String newLore = "Durability:" + Integer.toString(dur) + "/600";
					itM.setLore(Arrays.asList(newLore));
					item.setItemMeta(itM);
					if (dur == 0)
						player.getInventory().remove(item);
					
					Location fireLocs[] = new Location[] {
							event.getClickedBlock().getLocation().add(1, 1, 0), event.getClickedBlock().getLocation().add(2, 1, 0),
							event.getClickedBlock().getLocation().add(-1, 1, 0), event.getClickedBlock().getLocation().add(-2, 1, 0),
							event.getClickedBlock().getLocation().add(0, 1, -1), event.getClickedBlock().getLocation().add(0, 1, -2),
							event.getClickedBlock().getLocation().add(0, 1, 1), event.getClickedBlock().getLocation().add(0, 1, 2),
							event.getClickedBlock().getLocation().add(1, 1, 1), event.getClickedBlock().getLocation().add(1, 1, -1),
							event.getClickedBlock().getLocation().add(-1, 1, 1), event.getClickedBlock().getLocation().add(-1, 1, -1),
							event.getClickedBlock().getLocation().add(0, 1, 0)
					};
						
					for (Location fireLoc : fireLocs ) {
						if (fireLoc.getBlock().getType() == Material.AIR &&
								fireLoc.getBlock().getRelative(BlockFace.DOWN).getType() != Material.AIR &&
								!(fireLoc.getBlockX() == player.getLocation().getBlockX() &&
								fireLoc.getBlockY() == player.getLocation().getBlockY() &&
								fireLoc.getBlockZ() == player.getLocation().getBlockZ())) {
							fireLoc.getBlock().setType(Material.FIRE);
						}
					}
				}
			}
		}
	}
	
	@EventHandler
	public void onWindStickClick(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		Action action = event.getAction();
		ItemStack item = event.getItem();
		
		if (item == null)
			return ;
		
		if (item.getItemMeta().getDisplayName().contains("§bWIND STICK TIER I")) {
			if (item.getItemMeta().getDisplayName().equals("§bWIND STICK TIER I") &&
					(action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK)) {
				ItemMeta itM = item.getItemMeta();
				String lore = itM.getLore().get(0).split(":")[1].split("/")[0];
				int dur = Integer.parseInt(lore) - 1;
				String newLore = "Durability:" + Integer.toString(dur) + "/200";
				itM.setLore(Arrays.asList(newLore));
				item.setItemMeta(itM);
				if (dur == 0)
					player.getInventory().remove(item);
						
				player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 20 * 20, 1));
				}
			else if (item.getItemMeta().getDisplayName().equals("§bWIND STICK TIER II") &&
					(action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK)) {
				ItemMeta itM = item.getItemMeta();
				String lore = itM.getLore().get(0).split(":")[1].split("/")[0];
				int dur = Integer.parseInt(lore) - 1;
				String newLore = "Durability:" + Integer.toString(dur) + "/400";
				itM.setLore(Arrays.asList(newLore));
				item.setItemMeta(itM);
				if (dur == 0)
					player.getInventory().remove(item);
				
				player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 20 * 40, 2));
				}
			else if (item.getItemMeta().getDisplayName().equals("§bWIND STICK TIER III")) {
				if (action == Action.RIGHT_CLICK_AIR) {
					ItemMeta itM = item.getItemMeta();
					String lore = itM.getLore().get(0).split(":")[1].split("/")[0];
					int dur = Integer.parseInt(lore) - 1;
					String newLore = "Durability:" + Integer.toString(dur) + "/600";
					itM.setLore(Arrays.asList(newLore));
					item.setItemMeta(itM);
					if (dur == 0)
						player.getInventory().remove(item);
					
					player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 20 * 60, 4));
					}
				else if (action == Action.RIGHT_CLICK_BLOCK) {
					ItemMeta itM = item.getItemMeta();
					String lore = itM.getLore().get(0).split(":")[1].split("/")[0];
					int dur = Integer.parseInt(lore) - 1;
					String newLore = "Durability:" + Integer.toString(dur) + "/600";
					itM.setLore(Arrays.asList(newLore));
					item.setItemMeta(itM);
					if (dur == 0)
						player.getInventory().remove(item);
					
					Location windLocs[] = new Location[] {
							event.getClickedBlock().getLocation().add(1, 1, 0), event.getClickedBlock().getLocation().add(2, 1, 0),
							event.getClickedBlock().getLocation().add(-1, 1, 0), event.getClickedBlock().getLocation().add(-2, 1, 0),
							event.getClickedBlock().getLocation().add(0, 1, -1), event.getClickedBlock().getLocation().add(0, 1, -2),
							event.getClickedBlock().getLocation().add(0, 1, 1), event.getClickedBlock().getLocation().add(0, 1, 2),
							event.getClickedBlock().getLocation().add(1, 1, 1), event.getClickedBlock().getLocation().add(1, 1, -1),
							event.getClickedBlock().getLocation().add(-1, 1, 1), event.getClickedBlock().getLocation().add(-1, 1, -1),
							event.getClickedBlock().getLocation().add(0, 1, 0)
					};
						
					for (Location windLoc : windLocs ) {
						if (windLoc.getBlock().getType() == Material.AIR && windLoc.getBlock().getRelative(BlockFace.DOWN).getType() != Material.AIR &&
								!(windLoc.getBlockX() == player.getLocation().getBlockX() &&
								windLoc.getBlockY() == player.getLocation().getBlockY() &&
								windLoc.getBlockZ() == player.getLocation().getBlockZ())) {
							windLoc.getBlock().setType(Material.COBWEB);
						}
					}
				}
			}
		}
	}
	
	@EventHandler
	public void onEarthStickClick(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		Action action = event.getAction();
		ItemStack item = event.getItem();
		
		if (item == null)
			return ;
		
		if (item.getItemMeta().getDisplayName().contains("§aEARTH STICK TIER I")) {
			if (item.getItemMeta().getDisplayName().equals("§aEARTH STICK TIER I") &&
					(action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK)) {
				ItemMeta itM = item.getItemMeta();
				String lore = itM.getLore().get(0).split(":")[1].split("/")[0];
				int dur = Integer.parseInt(lore) - 1;
				String newLore = "Durability:" + Integer.toString(dur) + "/200";
				itM.setLore(Arrays.asList(newLore));
				item.setItemMeta(itM);
				if (dur == 0)
					player.getInventory().remove(item);
						
				player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 20 * 20, 1));
				}
			else if (item.getItemMeta().getDisplayName().equals("§aEARTH STICK TIER II") &&
					(action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK)) {
				ItemMeta itM = item.getItemMeta();
				String lore = itM.getLore().get(0).split(":")[1].split("/")[0];
				int dur = Integer.parseInt(lore) - 1;
				String newLore = "Durability:" + Integer.toString(dur) + "/400";
				itM.setLore(Arrays.asList(newLore));
				item.setItemMeta(itM);
				if (dur == 0)
					player.getInventory().remove(item);
				
				player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 20 * 40, 2));
				}
			else if (item.getItemMeta().getDisplayName().equals("§aEARTH STICK TIER III")) {
				if (action == Action.RIGHT_CLICK_AIR) {
					ItemMeta itM = item.getItemMeta();
					String lore = itM.getLore().get(0).split(":")[1].split("/")[0];
					int dur = Integer.parseInt(lore) - 1;
					String newLore = "Durability:" + Integer.toString(dur) + "/600";
					itM.setLore(Arrays.asList(newLore));
					item.setItemMeta(itM);
					if (dur == 0)
						player.getInventory().remove(item);
					
					player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 20 * 60, 4));
					}
				else if (action == Action.RIGHT_CLICK_BLOCK) {
					ItemMeta itM = item.getItemMeta();
					String lore = itM.getLore().get(0).split(":")[1].split("/")[0];
					int dur = Integer.parseInt(lore) - 1;
					String newLore = "Durability:" + Integer.toString(dur) + "/600";
					itM.setLore(Arrays.asList(newLore));
					item.setItemMeta(itM);
					if (dur == 0)
						player.getInventory().remove(item);
					
					Location earthLocs[] = new Location[] {
							event.getClickedBlock().getLocation().add(1, 1, 0), event.getClickedBlock().getLocation().add(2, 1, 0),
							event.getClickedBlock().getLocation().add(-1, 1, 0), event.getClickedBlock().getLocation().add(-2, 1, 0),
							event.getClickedBlock().getLocation().add(0, 1, -1), event.getClickedBlock().getLocation().add(0, 1, -2),
							event.getClickedBlock().getLocation().add(0, 1, 1), event.getClickedBlock().getLocation().add(0, 1, 2),
							event.getClickedBlock().getLocation().add(1, 1, 1), event.getClickedBlock().getLocation().add(1, 1, -1),
							event.getClickedBlock().getLocation().add(-1, 1, 1), event.getClickedBlock().getLocation().add(-1, 1, -1),
							event.getClickedBlock().getLocation().add(0, 1, 0)
					};
						
					for (Location earthLoc : earthLocs ) {
						if (earthLoc.getBlock().getType() == Material.AIR && earthLoc.getBlock().getRelative(BlockFace.DOWN).getType() != Material.AIR &&
								!(earthLoc.getBlockX() == player.getLocation().getBlockX() &&
								earthLoc.getBlockY() == player.getLocation().getBlockY() &&
								earthLoc.getBlockZ() == player.getLocation().getBlockZ())) {
							earthLoc.getBlock().setType(Material.MAGMA_BLOCK);
						}
					}
				}
			}
		}
	}

	@EventHandler
	public void onWaterStickClick(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		Action action = event.getAction();
		ItemStack item = event.getItem();
		
		if (item == null)
			return ;
		
		if (item.getItemMeta().getDisplayName().contains("§1WATER STICK TIER I")) {
			if (item.getItemMeta().getDisplayName().equals("§1WATER STICK TIER I") &&
					(action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK)) {
				ItemMeta itM = item.getItemMeta();
				String lore = itM.getLore().get(0).split(":")[1].split("/")[0];
				int dur = Integer.parseInt(lore) - 1;
				String newLore = "Durability:" + Integer.toString(dur) + "/200";
				itM.setLore(Arrays.asList(newLore));
				item.setItemMeta(itM);
				if (dur == 0)
					player.getInventory().remove(item);
						
				player.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, 20 * 20, 1));
				}
			else if (item.getItemMeta().getDisplayName().equals("§1WATER STICK TIER II") &&
					(action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK)) {
				ItemMeta itM = item.getItemMeta();
				String lore = itM.getLore().get(0).split(":")[1].split("/")[0];
				int dur = Integer.parseInt(lore) - 1;
				String newLore = "Durability:" + Integer.toString(dur) + "/400";
				itM.setLore(Arrays.asList(newLore));
				item.setItemMeta(itM);
				if (dur == 0)
					player.getInventory().remove(item);
				
				player.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, 20 * 40, 2));
				}
			else if (item.getItemMeta().getDisplayName().equals("§1WATER STICK TIER III")) {
				if (action == Action.RIGHT_CLICK_AIR) {
					ItemMeta itM = item.getItemMeta();
					String lore = itM.getLore().get(0).split(":")[1].split("/")[0];
					int dur = Integer.parseInt(lore) - 1;
					String newLore = "Durability:" + Integer.toString(dur) + "/600";
					itM.setLore(Arrays.asList(newLore));
					item.setItemMeta(itM);
					if (dur == 0)
						player.getInventory().remove(item);
					
					player.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, 20 * 60, 4));
					}
				else if (action == Action.RIGHT_CLICK_BLOCK) {
					ItemMeta itM = item.getItemMeta();
					String lore = itM.getLore().get(0).split(":")[1].split("/")[0];
					int dur = Integer.parseInt(lore) - 1;
					String newLore = "Durability:" + Integer.toString(dur) + "/600";
					itM.setLore(Arrays.asList(newLore));
					item.setItemMeta(itM);
					if (dur == 0)
						player.getInventory().remove(item);
					
					Location waterLocs[] = new Location[] {
							event.getClickedBlock().getLocation().add(1, 1, 0), event.getClickedBlock().getLocation().add(2, 1, 0),
							event.getClickedBlock().getLocation().add(-1, 1, 0), event.getClickedBlock().getLocation().add(-2, 1, 0),
							event.getClickedBlock().getLocation().add(0, 1, -1), event.getClickedBlock().getLocation().add(0, 1, -2),
							event.getClickedBlock().getLocation().add(0, 1, 1), event.getClickedBlock().getLocation().add(0, 1, 2),
							event.getClickedBlock().getLocation().add(1, 1, 1), event.getClickedBlock().getLocation().add(1, 1, -1),
							event.getClickedBlock().getLocation().add(-1, 1, 1), event.getClickedBlock().getLocation().add(-1, 1, -1),
							event.getClickedBlock().getLocation().add(0, 1, 0)
					};
						
					for (Location waterLoc : waterLocs ) {
						if (waterLoc.getBlock().getType() == Material.AIR && waterLoc.getBlock().getRelative(BlockFace.DOWN).getType() != Material.AIR &&
								!(waterLoc.getBlockX() == player.getLocation().getBlockX() &&
								waterLoc.getBlockY() == player.getLocation().getBlockY() &&
								waterLoc.getBlockZ() == player.getLocation().getBlockZ())) {
							waterLoc.getBlock().setType(Material.WATER);
						}
					}
				}
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
		
			if (xp.storeXp(player, item, currentStored, maxStorable))
				xp.reloadXpLevel(item);
		}
		else if (action == Action.LEFT_CLICK_AIR || action == Action.LEFT_CLICK_BLOCK) {
			int maxStorable = XpStorage.getMaxXpStorable(item);
			
			xp.giveBackXpLevels(player, item, maxStorable == 0);
		}
	}
}
