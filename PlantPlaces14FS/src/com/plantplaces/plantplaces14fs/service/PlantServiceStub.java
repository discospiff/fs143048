package com.plantplaces.plantplaces14fs.service;

import java.util.List;

import com.plantplaces.plantplaces14fs.dao.IPlantDAO;
import com.plantplaces.plantplaces14fs.dao.PlantDAOStub;
import com.plantplaces.plantplaces14fs.dto.Plant;

/**
 * Business and integration logic for our plant service.
 * @author jonesbr
 *
 */
public class PlantServiceStub implements IPlantService {

	// the variable type is the interface
	IPlantDAO plantDAO;
	
	public PlantServiceStub() {
		// the object type is the implementing class.
		plantDAO = new PlantDAOStub();
	}
	
	/**
	 * Return a list of plants that match the search term.
	 * @param searchTerm the word that we're looking for in the plant.
	 * @return a matching list of plants.
	 */
	@Override
	public List<Plant> fetchPlants(String searchTerm) {
		return plantDAO.fetchPlants(searchTerm);
	}
	
}
