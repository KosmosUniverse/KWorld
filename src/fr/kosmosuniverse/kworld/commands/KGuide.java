package fr.kosmosuniverse.kworld.commands;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

//import fr.kosmosuniverse.kworld.KWorldMain;

public class KGuide implements CommandExecutor {

	//private KWorldMain main;
	
	public KGuide(/*KWorldMain main*/) {
		//this.main = main;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		
		if (!(sender instanceof Player))
			return false;
		
		Player player = (Player) sender;
		
		if (!checkSpace(player)) {
			player.sendMessage("§3[KWorld] : Please free at least one slot of your inventory.");
			return false;
		}
		
		ItemStack book = new ItemStack(Material.ENCHANTED_BOOK);
		ItemMeta bookM = book.getItemMeta();
		bookM.setDisplayName("§6§l§nKWorld Guide");
		bookM.setLore(Arrays.asList("You can use it to see : ", "  - Recipes", "  - Items", "  - And more content ..."));
		
		book.setItemMeta(bookM);
		
		player.getInventory().addItem(book);
		player.updateInventory();
		
		return true;
	}
	
	private boolean checkSpace(Player player) {
		for (ItemStack it : player.getInventory().getStorageContents()) {
			if (it == null)
				return true;
		}
		return false;
	}

}
