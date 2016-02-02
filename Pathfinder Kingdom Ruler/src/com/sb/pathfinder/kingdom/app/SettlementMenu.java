package com.sb.pathfinder.kingdom.app;

import com.sb.menu.OptionsMenu;
import com.sb.pathfinder.kingdom.Settlement;

public class SettlementMenu extends OptionsMenu {

    private static final long serialVersionUID = -6129354761891933095L;
    
    private Settlement settlement;
    private SettlementStateDisplay display;

    public SettlementMenu(Settlement settlement) {
	this.settlement = settlement;
	display = new SettlementStateDisplay(settlement);
	
	buildMenu();
    }

    @Override
    public void open() {
	display.open();
	super.open();
    }

    private void buildMenu() { // TODO
	// List buildings
	// Manage building
	register("Manage buildings", new BuildingsManager(settlement.getKingdom(), settlement, null));
	// Change owning kingdom // Will reqiore saving kingdoms somewhere
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
        display.setSettlement(settlement);
    }

    public void managePopulation() {
	System.out.println("Settlement population: " + settlement.getPopulation());
	System.out.println("Available prefixes: -<x> (reduces the population), +<x> (increases population)");
	
    }
}
