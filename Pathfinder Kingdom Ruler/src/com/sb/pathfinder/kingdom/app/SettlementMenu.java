package com.sb.pathfinder.kingdom.app;

import com.sb.menu.OptionsMenu;
import com.sb.menu.Selector;
import com.sb.pathfinder.kingdom.BuildingDisplay;
import com.sb.pathfinder.kingdom.Kingdom;
import com.sb.pathfinder.kingdom.Settlement;

public class SettlementMenu extends OptionsMenu {

    private static final long serialVersionUID = -6129354761891933095L;
    
    private Settlement settlement;

    public SettlementMenu(Settlement settlement) {
	this.settlement = settlement;
	
	buildMenu();
    }

    @Override
    public void open() {
	new SettlementStateDisplay(settlement).open();
	super.open();
    }

    private void buildMenu() {
	// List buildings
	register("List buildings", () -> BuildingDisplay.display(settlement.getBuildings(), false));
	// Manage building
	register("Manage buildings", new BuildingsManager(null, settlement));
	// Change owning kingdom
	register("Change owning kingdom", this::selectKingdom);
	// Change population
	register("Manage population", this::managePopulation);
    }

    /**
     * Returns the settlement.
     * @return the settlement
     */
    public Settlement getSettlement() {
        return settlement;
    }

    /**
     * Sets the value of settlement to that of the parameter.
     * @param settlement the settlement to set
     */
    public void setSettlement(Settlement settlement) {
        this.settlement = settlement;
    }

    public void selectKingdom() {
	Selector<Kingdom> kingdoms = new Selector<>(true);
	for (Kingdom kingdom : AppData.getInstance().getKingdoms())
	    kingdoms.register(kingdom.getName(), kingdom);
	kingdoms.register("None", null);
	
	Kingdom selection = kingdoms.select();
	if (selection != Selector.SELECTION_CANCELLED)
	    settlement.setKingdom(selection);
    }
    
    public void managePopulation() {
	System.out.println("Settlement population: " + settlement.getPopulation());
	System.out.println("Available prefixes: -<x> (reduces the population), +<x> (increases population)");
	
    }
}
