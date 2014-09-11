package com.plantplaces.plantplaces14fs.dao;

import java.util.ArrayList;
import java.util.List;

import com.plantplaces.plantplaces14fs.dto.Plant;

/**
 * This class stubs out interaction with a data store.
 * We are just returing some predictable, static data.
 * @author jonesbr
 *
 */
public class PlantDAOStub {

		/**
		 * Return a collection of plants that contain the search term provided.
		 * @param searchTerm a word that we will use to filter a collection of plants.
		 * @return the matching collection of plants.
		 */
		public List<Plant> fetchPlants(String searchTerm) {
			// declare our return variable.
			List<Plant> allPlants = new ArrayList<Plant>();
			
			// Create a monkeyPuzzle
			Plant monkeyPuzzle = new Plant();
			monkeyPuzzle.setGenus("Aurucaria");
			monkeyPuzzle.setSpecies("araucana");
			monkeyPuzzle.setCommon("Monkey Puzzle");
			
			// add to collection.
			allPlants.add(monkeyPuzzle);
			
			// create a Redbud.
			Plant redbud = new Plant();
			redbud.setGenus("Cercis");
			redbud.setSpecies("canadensis");
			redbud.setCommon("Redbud");
			
			// add to collection
			allPlants.add(redbud);
			
			// return our return variable.
			return allPlants;
		}
	
}
