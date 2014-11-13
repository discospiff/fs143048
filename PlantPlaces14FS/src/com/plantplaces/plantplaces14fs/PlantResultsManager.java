package com.plantplaces.plantplaces14fs;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PlantResultsManager extends Activity implements PlantResultsFragment.Callback {

	public static final String GUID2 = "GUID";
	private boolean twoPane;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		// set our layout
		setContentView(R.layout.plantresultsmanager);

		// detailFrame only exists in two pane mode.  If it is not null, then it must exist.
		View detailFrame = findViewById(R.id.plant_detail_container);
		if (detailFrame != null) {
			twoPane = true;
		}
	}

	@Override
	public void plantSelected(int guid) {

		if (twoPane) {
			// instantiate our PlantDetailFragment.
			PlantDetailFragment pdf = new PlantDetailFragment();
					
			// pass the GUID to the fragment.
			Bundle extras = new Bundle();
			extras.putInt(PlantResultsManager.GUID2, guid);
			pdf.setArguments(extras);
			
			// swap the fragment.
			FragmentTransaction transaction = getFragmentManager().beginTransaction();
			transaction.add(R.id.plant_detail_container, pdf);
			transaction.commit();
		} else {
			// the else part will only happen if we are NOT two pane; in other words, if we are single pane
			// invoke the details with an explit intent.
			Intent intent = new Intent(this, PlantDetailManager.class);
			intent.putExtra(GUID2, guid);
			startActivity(intent);
		}
	}

}
