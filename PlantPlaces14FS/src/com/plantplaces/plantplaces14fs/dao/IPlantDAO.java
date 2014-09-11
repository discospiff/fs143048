package com.plantplaces.plantplaces14fs.dao;

import java.util.List;

import com.plantplaces.plantplaces14fs.dto.Plant;

public interface IPlantDAO {

	/**
	 * Return a collection of plants that contain the search term provided.
	 * @param searchTerm a word that we will use to filter a collection of plants.
	 * @return the matching collection of plants.
	 */
	public abstract List<Plant> fetchPlants(String searchTerm);

}