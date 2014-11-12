package com.plantplaces.plantplaces14fs.dao;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.plantplaces.plantplaces14fs.dto.Plant;

/**
 * This class will receive a String search term, will run a web query that returns
 * JSON, will parse the JSON, and will return the result as a List of Plant DTO objects.
 * @author jonesbr
 *
 */
public class PlantDAO implements IPlantDAO {

	private String plantData;

	@Override
	public List<Plant> fetchPlants(String searchTerm) {
		// declare the return type
		List<Plant> allPlants = new ArrayList<Plant>();
		
		// assemble the URI that will provide us with data.
		String uri = "http://www.plantplaces.com/perl/mobile/viewplantsjson.pl?Common=" + searchTerm;
		
		// the low level network DAO will do the GET request.
		NetworkDAO networkDAO = new NetworkDAO();
		try {
			plantData = networkDAO.fetch(uri);
			// anything that is dependent on the line above executing successfully 
			// (NOT throwing an exception) belongs here, and not after the catch
			// block.
			JSONObject jsonObject = new JSONObject(plantData);
				
			// get the array out.
			JSONArray plantsArray = jsonObject.getJSONArray("plants");
			
			
			
			// iterate over each item in the array.
			for (int i = 0; i < plantsArray.length(); i++) {
				Plant plant = new Plant();
				
				// get out the plant object for this iteration.
				JSONObject jsonPlant = plantsArray.getJSONObject(i);
				int id = jsonPlant.getInt("id");
				String genus = jsonPlant.getString("genus");
				String species = jsonPlant.getString("species");
				String cultivar = jsonPlant.getString("cultivar");
				String common = jsonPlant.getString("common");
				
				// populate the plant.
				plant.setGuid(id);
				plant.setGenus(genus);
				plant.setSpecies(species);
				plant.setCultivar(cultivar);
				plant.setCommon(common);
				
				// add the plant to the collection that will get returned.
				allPlants.add(plant);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// TODO Auto-generated method stub
		return allPlants;
	}

}
