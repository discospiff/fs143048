package com.plantplaces.plantplaces14fs;

import java.util.List;

import com.plantplaces.plantplaces14fs.PlantResultsActivity.PlantSearchTask;
import com.plantplaces.plantplaces14fs.dto.Plant;
import com.plantplaces.plantplaces14fs.service.IPlantService;
import com.plantplaces.plantplaces14fs.service.PlantService;

import android.app.Activity;
import android.app.ListFragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class PlantResultsFragment extends ListFragment {
	
	IPlantService plantService;
	Callback managingActivity;
	
	
	/**
	 * A callback interface that will allow this fragment to communicate with its managing activity.
	 * @author jonesb
	 *
	 */
	interface Callback {
		/**
		 * This method will be invoked when the user selects a plant.
		 * @param guid The PlantPlaces.com Global Unique Identifier which is used to render the correct web page for this plant
		 * 
		 */
		public void plantSelected(int guid);
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		// instantiate our PlantService.
		plantService = new PlantService();
		
		
		// get the plant name from the calling screen.
		String plantName = this.getActivity().getIntent().getStringExtra("PLANT_NAME");
		
		// make an object of the inner class.
		PlantSearchTask pst = new PlantSearchTask();
		// execute will:
		// 1) Create a new thread.
		// 2) invoke the doInBackground in that new thread.
		// 3) Pass the search term to the doInBackground.
		pst.execute(plantName);
	}
	
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		
		// We are getting the Plant that the user selected from the list, and storing it in the variable
		// named plant.
		Plant plant = (Plant) l.getItemAtPosition(position);
		// get the global unique identifier for this plant.
		int guid = plant.getGuid();
		
		// inform our managing activity that this plant has been selected.
		if (managingActivity != null) {
			managingActivity.plantSelected(guid);
		}
		
	}
	
	/**
	 * This method is invoked when a managing activity attaches to this fragment.
	 */
	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
		
		// see if our mananging activity implements Callback.  If so, cast it.
		if (activity instanceof Callback) {
			Callback callback = (Callback) activity;
			// we know that the managing activity implements our callback interface, so assign it.
			managingActivity = callback;
		}
	}
	
	
	@Override
	public void onDetach() {
		// TODO Auto-generated method stub
		super.onDetach();
		
		// set the callback to null, so that it won't be invoked again.
		managingActivity = null;
	}
	
	/**
	 * An inner class to make threading happen.
	 * @author jonesbr
	 *
	 */
	class PlantSearchTask extends AsyncTask<String, Integer, List<Plant>> {

		@Override
		protected void onPostExecute(List<Plant> plants) {

			// make the list available to be shown on the screen.
			ArrayAdapter<Plant> plantAdapter = new ArrayAdapter<Plant>(PlantResultsFragment.this.getActivity(), android.R.layout.simple_list_item_1, plants);
			
			// show the list on the screen.
			setListAdapter(plantAdapter);

			
		}
		
		/**
		 * This is the method that will be run in a new thread.
		 */
		@Override
		protected List<Plant> doInBackground(String... plantNames) {
			
			// search for the plant by name
			List<Plant> plants = plantService.fetchPlants(plantNames[0]);
			
			return plants;
		}
		
	}

	
}
