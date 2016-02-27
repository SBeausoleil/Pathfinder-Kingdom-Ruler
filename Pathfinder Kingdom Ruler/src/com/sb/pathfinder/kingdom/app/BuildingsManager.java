package com.sb.pathfinder.kingdom.app;

import com.sb.menu.MenuUtil;
import com.sb.menu.OptionsMenu;
import com.sb.menu.Selector;
import com.sb.pathfinder.kingdom.Building;
import com.sb.pathfinder.kingdom.BuildingDisplay;
import com.sb.pathfinder.kingdom.Settlement;

public class BuildingsManager extends OptionsMenu {

    private static final long serialVersionUID = 1515216141443940212L;

    public static enum EditLevel {
	GLOBAL, KINGDOM, SETTLEMENT, UNIQUE;
    };

    private Settlement settlement;

    public BuildingsManager(Settlement settlement) {
	this.settlement = settlement;

	buildMenu();
    }

    private void buildMenu() {
	// Manage existing buildings
	register("Manage existing buildings", this::manageExistingBuildings);
	// Add a building to the settlement
	register("Add a building to the settlement", this::addBuilding);
    }

    public void manageExistingBuildings() {
	// List the buildings in the settlement
	BuildingDisplay.display(settlement.getBuildings(), false);
	// Display the building management menu
	Building building = queryBuilding(settlement.getBuildings());
	if (building != null)
	    manage(building);
    }

    public static Building queryBuilding(Iterable<Building> buildings) {
	Selector<Building> selector = new Selector<>();
	selector.register(buildings, Building::getName);
	return selector.select();
    }

    private void manage(Building building) {
	OptionsMenu menu = new OptionsMenu();
	// Change the building's properties
	menu.register("Edit properties", () -> editProperties(building));
	// Remove the building
	menu.register("Remove from the settlement", () -> settlement.removeBuilding(building));
	menu.open();
    }

    private void editProperties(Building originalBuilding) {
	/*
	 * Ask on which level shall the changes take place:
	 * - Global (change directly the properties of the building)
	 * - Kingdom (edit a clone (same for next options))
	 * - Settlement
	 * - Unique
	 */
	Selector<EditLevel> menu = new Selector<>();
	menu.register("Global", EditLevel.GLOBAL);
	menu.register("Kingdom", EditLevel.KINGDOM);
	menu.register("Settlement", EditLevel.SETTLEMENT);
	menu.register("Unique", EditLevel.UNIQUE);

	EditLevel level = menu.select();
	if (level != Selector.SELECTION_CANCELLED)
	    editProperties(originalBuilding, level);
    }

    private void editProperties(Building originalBuilding, EditLevel level) {
	System.out.println("Enter the new value for the following properties (leave empty to not change):");

	Building building;
	if (level == EditLevel.GLOBAL)
	    building = originalBuilding;
	else
	    building = originalBuilding.clone();

	BuildingMaker.editBuilding(building, nameHint(level));

	if (level == EditLevel.UNIQUE)
	    settlement.replace(originalBuilding, building);
	else if (level == EditLevel.SETTLEMENT)
	    settlement.replaceAll(originalBuilding, building);
	else if (level == EditLevel.KINGDOM)
	    settlement.getKingdom().replaceAll(originalBuilding, building);
    }

    private String nameHint(EditLevel level) {
	switch (level) {
	case GLOBAL:
	    return null;
	case KINGDOM:
	    return settlement.getKingdom().getName();
	case SETTLEMENT:
	    return settlement.getName();
	case UNIQUE:
	    return "Unique";
	default:
	    return null;
	}
    }

    /**
     * Adds a building to the settlement.
     */
    public void addBuilding() {
	Building building = queryBuilding(AppData.getInstance().getBuildings());
	if (building != null) {
	    if (settlement.getKingdom().getConstructionPoints() < building.getConstructionCost()) {
		// Confirm construction
		if (MenuUtil.requestYesNo(
			"The kingdom does not have enough construction points ("
				+ settlement.getKingdom().getConstructionPoints()
				+ ") to build the building. Proceed anyway?")) {
		    // 	Ask how much construction points to spend
		    addBuildingToSettlement(building, MenuUtil.requestInt("Enter the new cost of the building:"));
		}
	    } else {
		addBuildingToSettlement(building, building.getConstructionCost());
	    }
	}
    }

    private void addBuildingToSettlement(Building building, int cost) {
	if (settlement.addBuilding(building))
	    settlement.getKingdom().modConstructionPoints(-cost);
	else
	    System.out.println(
		    "Error: There is no place in the settlement for the building. Build a new district first.");
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

}
