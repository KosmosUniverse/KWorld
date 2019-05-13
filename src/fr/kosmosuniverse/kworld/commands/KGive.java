package fr.kosmosuniverse.kworld.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import fr.kosmosuniverse.kworld.crafts.stick.EarthStick;
import fr.kosmosuniverse.kworld.crafts.stick.FireStick;
import fr.kosmosuniverse.kworld.crafts.stick.WaterStick;
import fr.kosmosuniverse.kworld.crafts.stick.WindStick;
import fr.kosmosuniverse.kworld.crafts.xp.XpStorage;

//import fr.kosmosuniverse.kworld.KWorldMain;

public class KGive implements CommandExecutor {

	//private KWorldMain main;
	
	/*public KGive(KWorldMain main) {
		this.main = main;
	}*/

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player))
			return false;
		
		Player player = (Player) sender;
		
		if (args == null || args.length == 0 || args.length > 2) {
			player.sendMessage("§3[KWorld] : §c/kgive <item> [number <= 64]");
			return false;
		}
		
		if (!checkSpace(player)) {
			player.sendMessage("§3[KWorld] : §fPlease free at least one slot of your inventory.");
			return false;
		}
		
		player.sendMessage(Integer.toString(args.length));
		
		ItemStack item;
		
		if ((item = getItemName(args[0])) == null) {
			player.sendMessage("§3[KWolrd] : /kgive " + args[0] + " = invalid argument");
			return false;
		}
		if (args.length == 1)
			player.getInventory().addItem(item);
		else if (args.length == 2) {
			if (!(Integer.parseInt(args[1]) > 0 && Integer.parseInt(args[1]) < 65)) {
				player.sendMessage("§3[KWolrd] : /kgive " + args[0] + " " + args[1] + " invalid number (0 < num < 65)");
				return false;
			}
			player.getInventory().addItem(itemMultiplier(item, Integer.parseInt(args[1])));
		}
		return true;
	}

	private boolean checkSpace(Player player) {
		for (ItemStack it : player.getInventory().getStorageContents()) {
			if (it == null)
				return true;
		}
		return false;
	}
	
	private ItemStack getItemName(String item) {
		switch (item) {
		case "FireStickTierI":
			return FireStick.FireStickBuilder(1);
		case "FireStickTierII":
			return FireStick.FireStickBuilder(2);
		case "FireStickTierIII":
			return FireStick.FireStickBuilder(3);
		case "WindStickTierI":
			return WindStick.WindStickBuilder(1);
		case "WindStickTierII":
			return WindStick.WindStickBuilder(2);
		case "WindStickTierIII":
			return WindStick.WindStickBuilder(3);
		case "EarthStickTierI":
			return EarthStick.EarthStickBuilder(1);
		case "EarthStickTierII":
			return EarthStick.EarthStickBuilder(2);
		case "EarthStickTierIII":
			return EarthStick.EarthStickBuilder(3);
		case "WaterStickTierI":
			return WaterStick.WaterStickBuilder(1);
		case "WaterStickTierII":
			return WaterStick.WaterStickBuilder(2);
		case "WaterStickTierIII":
			return WaterStick.WaterStickBuilder(3);
		case "XpStorageTierI":
			return XpStorage.xpStorageBuilder(1);
		case "XpStorageTierII":
			return XpStorage.xpStorageBuilder(2);
		case "XpStorageTierIII":
			return XpStorage.xpStorageBuilder(3);
		case "XpStorageTierIV":
			return XpStorage.xpStorageBuilder(4);
		case "XpStorageTierV":
			return XpStorage.xpStorageBuilder(5);
		default:
			return null;
		}
	}
	
	private ItemStack itemMultiplier(ItemStack item, int multi) {
		ItemStack it = new ItemStack(item.getType(), multi);
		
		it.setItemMeta(item.getItemMeta());
		item = it;
		return item;
	}
}
