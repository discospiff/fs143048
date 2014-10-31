package com.plantplaces.plantplaces14fs.service;

import java.util.List;

import com.plantplaces.plantplaces14fs.dao.IPlantDAO;
import com.plantplaces.plantplaces14fs.dao.PlantDAO;
import com.plantplaces.plantplaces14fs.dto.Plant;

public class PlantService implements IPlantService {

	IPlantDAO plantDAO;
	
	public PlantService() {
		plantDAO = new PlantDAO();
	}
	
	@Override
	public List<Plant> fetchPlants(String searchTerm) {
		// TODO Auto-generated method stub
		return plantDAO.fetchPlants(searchTerm);
	}

}
