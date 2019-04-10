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

public class CustomItemListener implements Listener {

	//private KWorldMain main;
	
	public CustomItemListener(/*KWorldMain main*/) {
		//this.main = main;
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
					Location fireLocs[] = new Location[] {
							player.getLocation().add(1, 0, 0), player.getLocation().add(2, 0, 0),
							player.getLocation().add(-1, 0, 0), player.getLocation().add(-2, 0, 0),
							player.getLocation().add(0, 0, -1), player.getLocation().add(0, 0, -2),
							player.getLocation().add(0, 0, 1), player.getLocation().add(0, 0, 2),
							player.getLocation().add(1, 0, 1), player.getLocation().add(1, 0, -1),
							player.getLocation().add(-1, 0, 1), player.getLocation().add(-1, 0, -1)
					};
						
					for (Location fireLoc : fireLocs ) {
						if (fireLoc.getBlock().getType() == Material.AIR && fireLoc.getBlock().getRelative(BlockFace.DOWN).getType() != Material.AIR) {
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
						
				player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 20 * 20, 1));
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
				
				player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 20 * 40, 2));
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
					
					player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 20 * 60, 4));
					}
				else if (action == Action.RIGHT_CLICK_BLOCK) {
					Location windLocs[] = new Location[] {
							player.getLocation().add(1, 0, 0), player.getLocation().add(2, 0, 0),
							player.getLocation().add(-1, 0, 0), player.getLocation().add(-2, 0, 0),
							player.getLocation().add(0, 0, -1), player.getLocation().add(0, 0, -2),
							player.getLocation().add(0, 0, 1), player.getLocation().add(0, 0, 2),
							player.getLocation().add(1, 0, 1), player.getLocation().add(1, 0, -1),
							player.getLocation().add(-1, 0, 1), player.getLocation().add(-1, 0, -1)
					};
						
					for (Location windLoc : windLocs ) {
						if (windLoc.getBlock().getType() == Material.AIR && windLoc.getBlock().getRelative(BlockFace.DOWN).getType() != Material.AIR) {
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
						
				player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 20 * 20, 1));
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
				
				player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 20 * 40, 2));
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
					
					player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 20 * 60, 4));
					}
				else if (action == Action.RIGHT_CLICK_BLOCK) {
					Location earthLocs[] = new Location[] {
							player.getLocation().add(1, 0, 0), player.getLocation().add(2, 0, 0),
							player.getLocation().add(-1, 0, 0), player.getLocation().add(-2, 0, 0),
							player.getLocation().add(0, 0, -1), player.getLocation().add(0, 0, -2),
							player.getLocation().add(0, 0, 1), player.getLocation().add(0, 0, 2),
							player.getLocation().add(1, 0, 1), player.getLocation().add(1, 0, -1),
							player.getLocation().add(-1, 0, 1), player.getLocation().add(-1, 0, -1)
					};
						
					for (Location earthLoc : earthLocs ) {
						if (earthLoc.getBlock().getType() == Material.AIR && earthLoc.getBlock().getRelative(BlockFace.DOWN).getType() != Material.AIR) {
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
					Location waterLocs[] = new Location[] {
							player.getLocation().add(1, 0, 0), player.getLocation().add(2, 0, 0),
							player.getLocation().add(-1, 0, 0), player.getLocation().add(-2, 0, 0),
							player.getLocation().add(0, 0, -1), player.getLocation().add(0, 0, -2),
							player.getLocation().add(0, 0, 1), player.getLocation().add(0, 0, 2),
							player.getLocation().add(1, 0, 1), player.getLocation().add(1, 0, -1),
							player.getLocation().add(-1, 0, 1), player.getLocation().add(-1, 0, -1)
					};
						
					for (Location waterLoc : waterLocs ) {
						if (waterLoc.getBlock().getType() == Material.AIR && waterLoc.getBlock().getRelative(BlockFace.DOWN).getType() != Material.AIR) {
							waterLoc.getBlock().setType(Material.WATER);
						}
					}
				}
			}
		}
	}
}
