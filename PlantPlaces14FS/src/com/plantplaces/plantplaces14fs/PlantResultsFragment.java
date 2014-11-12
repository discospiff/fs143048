package com.plantplaces.plantplaces14fs;

import java.util.List;

import com.plantplaces.plantplaces14fs.PlantResultsActivity.PlantSearchTask;
import com.plantplaces.plantplaces14fs.dto.Plant;
import com.plantplaces.plantplaces14fs.service.IPlantService;
import com.plantplaces.plantplaces14fs.service.PlantService;

import android.app.ListFragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class PlantResultsFragment extends ListFragment {
	
	IPlantService plantService;
	
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
