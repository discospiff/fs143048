package com.plantplaces.plantplaces14fs;

import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class PlantPlacesActivity extends Activity {

	public PlantPlacesActivity() {
		super();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.gpsaplant, menu);
		return true;
	}

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