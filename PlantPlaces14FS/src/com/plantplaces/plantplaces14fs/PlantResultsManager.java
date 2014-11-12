package com.plantplaces.plantplaces14fs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class PlantResultsManager extends Activity implements PlantResultsFragment.Callback {

	public static final String GUID2 = "GUID";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		// set our layout
		setContentView(R.layout.plantresultsmanager);
	}

	@Override
	public void plantSelected(int guid) {
		// invoke the details with an explit intent.
		Intent intent = new Intent(this, PlantDetailManager.class);
		intent.putExtra(GUID2, guid);
		startActivity(intent);
	}
	
}
