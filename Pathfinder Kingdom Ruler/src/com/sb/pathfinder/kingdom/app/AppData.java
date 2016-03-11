package com.sb.pathfinder.kingdom.app;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import com.sb.pathfinder.kingdom.Building;
import com.sb.pathfinder.kingdom.Kingdom;
import com.sb.rpg.RPGCharacter;

/**
 * Stores general data to be accessed through the KingdomManager application.
 * 
 * @author Samuel Beausoleil
 */
public class AppData implements Serializable {

    private static final long serialVersionUID = 7689478362186488340L;

    public static final String FILE_EXTENSION = "kmad";
    
    private List<Building> buildings;

    private Set<Kingdom> kingdoms;

    private Set<RPGCharacter> characters;

    private static AppData instance;

    private AppData() {
	buildings = new LinkedList<Building>();
	kingdoms = new LinkedHashSet<Kingdom>();
	characters = new LinkedHashSet<RPGCharacter>();
    }

    public AppData(List<Building> buildings, Set<Kingdom> kingdoms, Set<RPGCharacter> characters)
	    throws AlreadyInstancedException {
	if (instance != null)
	    throw new AlreadyInstancedException(AppData.class);
	this.buildings = buildings;
	this.kingdoms = kingdoms;
	this.characters = characters;
	AppData.instance = this;
    }

    /**
     * Returns the buildings.
     * 
     * @return the buildings
     */
    public List<Building> getBuildings() {
	return buildings;
    }

    /**
     * Sets the value of buildings to that of the parameter.
     * 
     * @param buildings
     *            the buildings to set
     */
    public void setBuildings(List<Building> buildings) {
	this.buildings = buildings;
    }

    /**
     * Returns the kingdoms.
     * 
     * @return the kingdoms
     */
    public Set<Kingdom> getKingdoms() {
	return kingdoms;
    }

    /**
     * Sets the value of kingdoms to that of the parameter.
     * 
     * @param kingdoms
     *            the kingdoms to set
     */
    public void setKingdoms(Set<Kingdom> kingdoms) {
	this.kingdoms = kingdoms;
    }

    /**
     * Returns the characters.
     * 
     * @return the characters
     */
    public Set<RPGCharacter> getCharacters() {
	return characters;
    }

    /**
     * Sets the value of characters to that of the parameter.
     * 
     * @param characters
     *            the characters to set
     */
    public void setCharacters(Set<RPGCharacter> characters) {
	this.characters = characters;
    }

    /**
     * Returns the instance.
     * 
     * @return the instance
     */
    public static AppData getInstance() {
	if (instance == null)
	    AppData.instance = new AppData();
	return instance;
    }

    /**
     * Sets the value of instance to that of the parameter.
     * 
     * @param instance
     *            the instance to set
     * @throws AlreadyInstancedException
     *             if an instance of AppData already exists
     */
    public static void setInstance(AppData instance) throws AlreadyInstancedException {
	if (instance != null)
	    throw new AlreadyInstancedException(AppData.class);
	AppData.instance = instance;
    }
}
