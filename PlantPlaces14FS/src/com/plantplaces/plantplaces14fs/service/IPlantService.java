package com.plantplaces.plantplaces14fs.service;

import java.util.List;

import com.plantplaces.plantplaces14fs.dto.Plant;

public interface IPlantService {

	public abstract List<Plant> fetchPlants(String searchTerm);

}