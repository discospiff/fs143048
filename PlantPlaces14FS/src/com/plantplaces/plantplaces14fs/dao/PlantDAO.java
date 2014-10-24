package com.plantplaces.plantplaces14fs.dao;

import java.util.List;

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
		String uri = "http://www.plantplaces.com/perl/mobile/viewplantsjson.pl?Common=" + searchTerm;
		
		NetworkDAO networkDAO = new NetworkDAO();
		try {
			plantData = networkDAO.fetch(uri);
			// anything that is dependent on the line above executing successfully 
			// (NOT throwing an exception) belongs here, and not after the catch
			// block.
			JSONObject jsonObject = new JSONObject(plantData);
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// TODO Auto-generated method stub
		return null;
	}

}
