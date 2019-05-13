package fr.kosmosuniverse.kworld.crafts;

import fr.kosmosuniverse.kworld.KWorldMain;
import fr.kosmosuniverse.kworld.crafts.chim.ChimActivator;
import fr.kosmosuniverse.kworld.crafts.stick.EarthStick;
import fr.kosmosuniverse.kworld.crafts.stick.FireStick;
import fr.kosmosuniverse.kworld.crafts.stick.WaterStick;
import fr.kosmosuniverse.kworld.crafts.stick.WindStick;
import fr.kosmosuniverse.kworld.crafts.xp.ExpBottle;
import fr.kosmosuniverse.kworld.crafts.xp.XpStorage;

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
		
		main.getServer().addRecipe(new WindStick(main).getWindStickTierI());
		main.getServer().addRecipe(new WindStick(main).getWindStickTierII());
		main.getServer().addRecipe(new WindStick(main).getWindStickTierIII());
		
		main.getServer().addRecipe(new EarthStick(main).getEarthStickTierI());
		main.getServer().addRecipe(new EarthStick(main).getEarthStickTierII());
		main.getServer().addRecipe(new EarthStick(main).getEarthStickTierIII());
		
		main.getServer().addRecipe(new WaterStick(main).getWaterStickTierI());
		main.getServer().addRecipe(new WaterStick(main).getWaterStickTierII());
		main.getServer().addRecipe(new WaterStick(main).getWaterStickTierIII());
		
		XpStorage xp = new XpStorage(main);
		
		main.getServer().addRecipe(xp.getXpStorageTierI());
		main.getServer().addRecipe(xp.getXpStorageTierII());
		main.getServer().addRecipe(xp.getXpStorageTierIII());
		main.getServer().addRecipe(xp.getXpStorageTierIV());
		main.getServer().addRecipe(xp.getXpStorageTierV());
		
		main.getServer().addRecipe(new ChimActivator(main).getActivator());
	}
}
