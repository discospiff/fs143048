package com.plantplaces.plantplaces14fs;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

public class GPSAPlantActivity extends PlantPlacesActivity {

	private AutoCompleteTextView actPlantName;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gpsaplant);
		
		TextView txtLongitudeValue = (TextView) findViewById(R.id.txtLongitudeValue);
		txtLongitudeValue.setText("1");
	
		// this will give us access to widgets that are on our form
		actPlantName = (AutoCompleteTextView) findViewById(R.id.actPlantName);
	
	}

	/**
	 * This method will be invoked when the search button is clicked.
	 * This will handle searching for the given plant
	 * @param v
	 */
	public void btnSearchClicked(View v) {
		// get the text that the user entered into the auto complete text.
		String plantName = actPlantName.getText().toString();
		
		// make a popup
		// Toast.makeText(this, plantName, Toast.LENGTH_LONG).show();
		
		Intent plantResults = new Intent(this, PlantResultsActivity.class);
		plantResults.putExtra("PLANT_NAME", plantName);
		startActivity(plantResults);
	}

	@Override
	public int getCurrentMenuID() {
		// TODO Auto-generated method stub
		return R.id.gpsAPlant;
	}

}
