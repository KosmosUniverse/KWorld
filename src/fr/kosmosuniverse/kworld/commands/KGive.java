package fr.kosmosuniverse.kworld.commands;

import java.util.HashMap;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import fr.kosmosuniverse.kworld.KWorldMain;

public class KGive implements CommandExecutor {

	private KWorldMain main;
	private HashMap<String, ItemStack> itemMap;
	
	public KGive(KWorldMain main, HashMap<String, ItemStack> funMap, HashMap<String, ItemStack> chimMap) {
		
		this.main = main;
		this.itemMap = new HashMap<String, ItemStack>();
		
		boolean KFun = this.main.getConfig().getBoolean("general.plugin.KFun");
		boolean KChim = this.main.getConfig().getBoolean("general.plugin.KChim");

		
		if (KFun) {
			for (String key : funMap.keySet()) {
				this.itemMap.put(key, funMap.get(key));
			}
		}
		if (KChim) {
			for (String key : chimMap.keySet()) {
				this.itemMap.put(key, chimMap.get(key));
			}
		}
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player))
			return false;
		
		Player player = (Player) sender;
		
		if (args == null || args.length == 0 || args.length > 2) {
			player.sendMessage("§3[KWorld] : §c/kgive <item> [0 < number <= 64]");
			return false;
		}
		
		if (!checkSpace(player)) {
			player.sendMessage("§3[KWorld] : §fPlease free at least one slot of your inventory.");
			return false;
		}
		
		if (!itemMap.containsKey(args[0])) {
			player.sendMessage("§3[KWolrd] : /kgive " + args[0] + " = invalid argument");
			return false;
		}

		if (args.length == 1)
			player.getInventory().addItem(itemMap.get(args[0]));
		else if (args.length == 2) {
			if (!(Integer.parseInt(args[1]) > 0 && Integer.parseInt(args[1]) < 65)) {
				player.sendMessage("§3[KWolrd] : /kgive " + args[0] + " " + args[1] + " invalid number (0 < num <= 64)");
				return false;
			}
			player.getInventory().addItem(itemMultiplier(itemMap.get(args[0]), Integer.parseInt(args[1])));
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
	
	private ItemStack itemMultiplier(ItemStack item, int multi) {
		ItemStack it = new ItemStack(item.getType(), multi);
		
		it.setItemMeta(item.getItemMeta());
		item = it;
		return item;
	}
}
