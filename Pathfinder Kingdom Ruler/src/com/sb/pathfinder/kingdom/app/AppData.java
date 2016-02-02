package com.sb.pathfinder.kingdom.app;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.LinkedList;
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

    private Collection<Building> buildings;

    private Collection<Kingdom> kingdoms;
    
    private Set<RPGCharacter> characters;

    public AppData() {
	buildings = new LinkedList<Building>();
	kingdoms = new LinkedList<Kingdom>();
	characters = new LinkedHashSet<RPGCharacter>();
    }

    /**
     * Returns the buildings.
     * @return the buildings
     */
    public Collection<Building> getBuildings() {
        return buildings;
    }

    /**
     * Sets the value of buildings to that of the parameter.
     * @param buildings the buildings to set
     */
    public void setBuildings(Collection<Building> buildings) {
        this.buildings = buildings;
    }

    /**
     * Returns the kingdoms.
     * @return the kingdoms
     */
    public Collection<Kingdom> getKingdoms() {
        return kingdoms;
    }

    /**
     * Sets the value of kingdoms to that of the parameter.
     * @param kingdoms the kingdoms to set
     */
    public void setKingdoms(Collection<Kingdom> kingdoms) {
        this.kingdoms = kingdoms;
    }

    /**
     * Returns the characters.
     * @return the characters
     */
    public Set<RPGCharacter> getCharacters() {
        return characters;
    }

    /**
     * Sets the value of characters to that of the parameter.
     * @param characters the characters to set
     */
    public void setCharacters(Set<RPGCharacter> characters) {
        this.characters = characters;
    }
    
}
