package com.plantplaces.plantplaces14fs;

import java.util.List;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.plantplaces.plantplaces14fs.dto.Plant;
import com.plantplaces.plantplaces14fs.service.IPlantService;
import com.plantplaces.plantplaces14fs.service.PlantServiceStub;

public class PlantResultsActivity extends ListActivity {

	IPlantService plantService;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		// instantiate our PlantService.
		plantService = new PlantServiceStub();
		
		// get the plant name from the calling screen.
		String plantName = this.getIntent().getStringExtra("PLANT_NAME");
		
		// search for the plant by name
		List<Plant> plants = plantService.fetchPlants(plantName);

		// make the list available to be shown on the screen.
		ArrayAdapter<Plant> plantAdapter = new ArrayAdapter<Plant>(this, android.R.layout.simple_list_item_1, plants);
		
		// show the list on the screen.
		setListAdapter(plantAdapter);
	}
	
}
