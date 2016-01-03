package com.sb.pathfinder.kingdom;

import java.util.LinkedList;

public class Settlement {

    private String name;
    
    private final Tile TILE;
    
    // TODO find some way to represent the location of buildings toward one another
    private LinkedList<Building> buildings;
    private int availableLots;
    private int nDistricts;
    
    private int corruption;
    private int criminality;
    private int law;
    private int lore;
    private int productivity;
    private int society;
    private int defense;

    private int population;

    public Settlement(String name, Tile tile) {
	this.name = name;
	TILE = tile;
	buildings = new LinkedList<Building>();
    }
    
    /**
     * Returns the corruption.
     * @return the corruption
     */
    public int getCorruption() {
        return corruption;
    }

    /**
     * Sets the value of corruption to that of the parameter.
     * @param corruption the corruption to set
     */
    public void setCorruption(int corruption) {
        this.corruption = corruption;
    }

    /**
     * Adds the mod to the corruption.
     * @param mod to add to the corruption.
     */
    public void modCorruption(int mod) {
	this.corruption += mod;
    }
    
    /**
     * Returns the criminality.
     * @return the criminality
     */
    public int getCriminality() {
        return criminality;
    }

    /**
     * Sets the value of criminality to that of the parameter.
     * @param criminality the criminality to set
     */
    public void setCriminality(int criminality) {
        this.criminality = criminality;
    }

    /**
     * Adds the mod to the criminatlity.
     * @param mod to add to the criminality.
     */
    public void modCriminality(int mod) {
	this.criminality += mod;
    }
    
    /**
     * Returns the law.
     * @return the law
     */
    public int getLaw() {
        return law;
    }

    /**
     * Sets the value of law to that of the parameter.
     * @param law the law to set
     */
    public void setLaw(int law) {
        this.law = law;
    }

    /**
     * Adds the mod to the law.
     * @param mod to add to the law.
     */
    public void modLaw(int mod) {
	this.law += mod;
    }
    
    /**
     * Returns the lore.
     * @return the lore
     */
    public int getLore() {
        return lore;
    }

    /**
     * Sets the value of lore to that of the parameter.
     * @param lore the lore to set
     */
    public void setLore(int lore) {
        this.lore = lore;
    }

    /**
     * Adds the mod to the lore.
     * @param mod to add to the lore.
     */
    public void modLore(int mod) {
	this.lore += mod;
    }
    
    /**
     * Returns the productivity.
     * @return the productivity
     */
    public int getProductivity() {
        return productivity;
    }

    /**
     * Sets the value of productivity to that of the parameter.
     * @param productivity the productivity to set
     */
    public void setProductivity(int productivity) {
        this.productivity = productivity;
    }

    /**
     * Adds the mod to the productivity.
     * @param mod to add to the productivity.
     */
    public void modProductivity(int mod) {
	this.productivity += mod;
    }
    
    /**
     * Returns the society.
     * @return the society
     */
    public int getSociety() {
        return society;
    }

    /**
     * Sets the value of society to that of the parameter.
     * @param society the society to set
     */
    public void setSociety(int society) {
        this.society = society;
    }

    /**
     * Adds the mod to the society.
     * @param mod to add to the society.
     */
    public void modSociety(int mod) {
	this.society += mod;
    }

    /**
     * Returns the defense.
     * @return the defense
     */
    public int getDefense() {
	return defense;
    }

    /**
     * Sets the value of defense to that of the parameter.
     * @param defense the defense to set
     */
    public void setDefense(int defense) {
	this.defense = defense;
    }
    
    /**
     * Adds the mod to the defense.
     * @param mod to add to the defense.
     */
    public void modDefense(int mod) {
	this.defense += mod;
    }

    /**
     * Returns the population
     * @return the population
     */
    public int getPopulation() {
	return population;
    }

    /**
     * Sets the value of population to that of the parameter.
     * @param population the population to set
     */
    public void setPopulation(int population) {
	this.population = population;
    }
    
    /**
     * Adds the mod to the population.
     * @param mod to add to the population.
     */
    public void modPopulation(int mod) {
	this.population += mod;
    }
}
