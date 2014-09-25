package com.plantplaces.plantplaces14fs.dto;

/**
 * This DTO describes a plant.
 * @author jonesbr
 *
 */
public class Plant {
	
	// global unique ID is unique across all devices.
	private int guid;
	// ID is unique only to this device.
	private int id;
	private String genus;
	private String species;
	private String cultivar;
	private String common;
	
	public int getGuid() {
		return guid;
	}
	public void setGuid(int guid) {
		this.guid = guid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGenus() {
		return genus;
	}
	public void setGenus(String genus) {
		this.genus = genus;
	}
	public String getSpecies() {
		return species;
	}
	public void setSpecies(String species) {
		this.species = species;
	}
	public String getCultivar() {
		return cultivar;
	}
	public void setCultivar(String cultivar) {
		this.cultivar = cultivar;
	}
	public String getCommon() {
		return common;
	}
	public void setCommon(String common) {
		this.common = common;
	}
	
	@Override
	public String toString() {
		return genus + " " + species + " " + common;
	}

}
