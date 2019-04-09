package fr.kosmosuniverse.kworld.crafts;

import fr.kosmosuniverse.kworld.KWorldMain;

public class AddRecipes {
	private KWorldMain main;
	
	public AddRecipes(KWorldMain main) {
		this.main = main;
	}
	
	public void addAll() {
		main.getServer().addRecipe(new ExpBottle(main).getBottleCoal());
		main.getServer().addRecipe(new ExpBottle(main).getBottleRed());
		main.getServer().addRecipe(new ExpBottle(main).getBottleLap());
		main.getServer().addRecipe(new ExpBottle(main).getBottleDiam());
		main.getServer().addRecipe(new FireStick(main).getFireStickTierI());
		main.getServer().addRecipe(new FireStick(main).getFireStickTierII());
		main.getServer().addRecipe(new FireStick(main).getFireStickTierIII());
	}
}
