package com.plantplaces.plantplaces14fs;

import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public abstract class PlantPlacesActivity extends Activity {

	public PlantPlacesActivity() {
		super();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.gpsaplant, menu);
		// remove the menu for the current screen, via an Abstract Method.
		menu.removeItem(getCurrentMenuID());
		return true;
	}

	/**
	 * The menu ID of the current screen.  
	 * This will be defined by the superclass, which will know its menu ID.
	 * @return
	 */
	public abstract int getCurrentMenuID();

	/**
	 * Handle plant search method.
	 * @param menu
	 */
	public void plantSearchClicked(Menu menu) {
		Intent plantSearch = new Intent(this, PlantSearchActivity.class);
		startActivity(plantSearch);
		
	}

	/** 
	 * Handle GPS a plant menu method.
	 * @param menu
	 */
	public void gpsAPlantClicked(Menu menu) {
		Intent gpsAPlant = new Intent(this, GPSAPlantActivity.class);
		startActivity(gpsAPlant);		
	}
	
	

}