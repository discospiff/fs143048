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
public class PlantDAOStub implements IPlantDAO {

	/* (non-Javadoc)
	 * @see com.plantplaces.plantplaces14fs.dao.IPlantDAO#fetchPlants(java.lang.String)
	 */
	@Override
	public List<Plant> fetchPlants(String searchTerm) {
		// declare our return variable.
		List<Plant> allPlants = new ArrayList<Plant>();

		if (searchTerm.contains("Monkey")) {
			// Create a monkeyPuzzle
			Plant monkeyPuzzle = new Plant();
			monkeyPuzzle.setGenus("Aurucaria");
			monkeyPuzzle.setSpecies("araucana");
			monkeyPuzzle.setCommon("Monkey Puzzle");

			// add to collection.
			allPlants.add(monkeyPuzzle);
		}

		if (searchTerm.contains("Redbud")) {
			// create a Redbud.
			Plant redbud = new Plant();
			redbud.setGenus("Cercis");
			redbud.setSpecies("canadensis");
			redbud.setCommon("Redbud");

			// add to collection
			allPlants.add(redbud);
		}

		// return our return variable.
		return allPlants;
	}

}
