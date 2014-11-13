package com.plantplaces.plantplaces14fs;

import android.app.Activity;
import android.content.Intent;
import android.location.LocationListener;
import android.view.Menu;
import android.view.MenuItem;

public abstract class PlantBaseActivity extends Activity {

	public PlantBaseActivity() {
		super();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		
		getMenuInflater().inflate(R.menu.plantplacesmenu, menu);
		
		// remove the menu ID for the current screen, if it has a menu ID.
		int menuId = getMenuId();
		if (menuId != 0) {
			menu.removeItem(menuId);
		}
		
		return true;
	}

	/**
	 * This method will return the unique menu ID for the specific screen that the subclass defines
	 * @return
	 */
	public abstract int getMenuId();
	
	/**
	 * This method is invoked when the user clicks on the menu option.
	 * @param menuItem
	 */
	public void onMnuGPSAPlantClicked(MenuItem menuItem) {
		Intent intent = new Intent(this, GPSAPlantActivity.class);
		startActivity(intent);
	}

	public void onAdvancedPlantSearchClicked(MenuItem menuItem) {
		Intent intent = new Intent(this, PlantSearchActivity.class) ;
		startActivity(intent);
	}

}