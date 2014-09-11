package com.plantplaces.plantplaces14fs;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class GPSAPlantActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gpsaplant);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.gpsaplant, menu);
		return true;
	}

}
