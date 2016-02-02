package com.sb.pathfinder.kingdom.app;

import java.util.Collection;
import java.util.Iterator;

import com.sb.menu.MenuUtil;
import com.sb.menu.OptionsMenu;
import com.sb.pathfinder.kingdom.Building;
import com.sb.pathfinder.kingdom.BuildingDisplay;
import com.sb.pathfinder.kingdom.Kingdom;
import com.sb.pathfinder.kingdom.Settlement;

public class BuildingsManager extends OptionsMenu {

    private static final long serialVersionUID = 1515216141443940212L;

    private Kingdom		 kingdom;
    private Settlement		 settlement;
    private Collection<Building> availableConstructions;
    
    public BuildingsManager(Kingdom kingdom, Settlement settlement,
	    Collection<Building> availableConstructions) {
	this.kingdom = kingdom;
	this.settlement = settlement;
	this.availableConstructions = availableConstructions;

	buildMenu();
    }

    private void buildMenu() {
	// Manage existing buildings
	register("Manage existing buildings", this::manageExistingBuildings);
	// Add a building to the settlement
	// TODO
    }

    public void manageExistingBuildings() {
	// List the buildings in the settlement
	BuildingDisplay.display(settlement.getBuildings(), false);
	// Query the user for the building to edit's name
	Building building;
	seeker: while (true) {
	    System.out.println("Enter the name of the building to manage ((!) to go back):");
	    String input = MenuUtil.keyboard.nextLine();
	    // Search the buildings to find the name
	    Iterator<Building> buildings = settlement.getBuildings().iterator();
	    while (buildings.hasNext()) {
		building = buildings.next();
		if (building.getName().equals(input))
		    break seeker;
	    }
	}
	// Display the building management menu
	manage(building);
    }

    public void manage(Building building) {
	OptionsMenu menu = new OptionsMenu();
	// Change the building's properties
	menu.register("Edit properties", () -> editProperties(building));
	// Remove the building
	menu.register("Remove from the settlement", () -> settlement.removeBuilding(building));
    }

    public void editProperties(Building building) {
	System.out.println("Enter the new value for the following properties (leave empty to not change):");
	MenuUtil.requestInt("Economy (" + building.getEconomy() + "): ", null, null)
    }

    /**
     * Returns the settlement.
     * 
     * @return the settlement
     */
    public Settlement getSettlement() {
	return settlement;
    }

    /**
     * Sets the value of settlement to that of the parameter.
     * 
     * @param settlement
     *            the settlement to set
     */
    public void setSettlement(Settlement settlement) {
	this.settlement = settlement;
    }

    /**
     * Returns the collection of available constructions.
     * 
     * @return the availableConstructions collection.
     */
    public Collection<Building> getAvailableConstructions() {
	return availableConstructions;
    }

    /**
     * Sets the value of availableConstructions to that of the parameter.
     * 
     * @param availableConstructions
     *            the availableConstructions to set
     */
    public void setAvailableConstructions(Collection<Building> availableConstructions) {
	this.availableConstructions = availableConstructions;
    }

    /**
     * Returns the kingdom.
     * 
     * @return the kingdom
     */
    public Kingdom getKingdom() {
	return kingdom;
    }

    /**
     * Sets the value of kingdom to that of the parameter.
     * 
     * @param kingdom
     *            the kingdom to set
     */
    public void setKingdom(Kingdom kingdom) {
	this.kingdom = kingdom;
    }

}
