package com.plantplaces.plantplaces14fs;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;

public class PlantDetailManager extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.plantdetailfragment);
		
		if (savedInstanceState == null) {
			// instantiate our PlantDetailFragment.
			PlantDetailFragment pdf = new PlantDetailFragment();
			
			// get the GUID from the calling activity.
			int guid = getIntent().getIntExtra(PlantResultsManager.GUID2, 1);
			
			// pass the GUID to the fragment.
			Bundle extras = new Bundle();
			extras.putInt(PlantResultsManager.GUID2, guid);
			pdf.setArguments(extras);
			
			// swap the fragment.
			FragmentTransaction transaction = getFragmentManager().beginTransaction();
			transaction.add(R.id.plantDetailWebView, pdf);
			transaction.commit();
		}
	}
	
}
