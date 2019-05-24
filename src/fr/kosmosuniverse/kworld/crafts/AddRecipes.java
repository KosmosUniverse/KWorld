package fr.kosmosuniverse.kworld.crafts;

import java.util.ArrayList;

import org.bukkit.inventory.ShapedRecipe;

import fr.kosmosuniverse.kworld.KWorldMain;
import fr.kosmosuniverse.kworld.crafts.chim.ChimActivator;

public class AddRecipes {
	private KWorldMain main;
	private ArrayList<ShapedRecipe> recs;
	
	public AddRecipes(KWorldMain main, ArrayList<ShapedRecipe> recs) {
		this.main = main;
		this.recs = recs;
	}
	
	public void addAll() {
		boolean KFun = this.main.getConfig().getBoolean("general.plugin.KFun");
		boolean KChim = this.main.getConfig().getBoolean("general.plugin.KChim");
		
		if (KFun) {			
			for (ShapedRecipe s : recs) {
				main.getServer().addRecipe(s);
			}
		}
		if (KChim) {
			main.getServer().addRecipe(new ChimActivator(main).getActivator());
		}
	}
}
