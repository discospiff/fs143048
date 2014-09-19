package com.plantplaces.plantplaces14fs;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;

public class GPSAPlantActivity extends Activity {

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

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.gpsaplant, menu);
		return true;
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
		Toast.makeText(this, plantName, Toast.LENGTH_LONG).show();
	}

}
