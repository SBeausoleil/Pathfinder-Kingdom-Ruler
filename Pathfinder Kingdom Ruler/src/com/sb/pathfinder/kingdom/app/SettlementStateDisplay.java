package com.sb.pathfinder.kingdom.app;

import com.sb.menu.MenuElement;
import com.sb.pathfinder.kingdom.Settlement;

public class SettlementStateDisplay implements MenuElement {

    private static final long serialVersionUID = -2066403384608728855L;
    
    private Settlement settlement;
    
    public SettlementStateDisplay(Settlement settlement) {
	this.settlement = settlement;
    }

    @Override
    public void open() {
	if (settlement == null) {
	    System.out.println("No set settlement.");
	    return;
	}
	
	System.out.println("===================================================");
	System.out.println("Name: " + settlement.getName());
	System.out.println("Population: " + settlement.getPopulation());
	System.out.println("Available lots: " + settlement.getAvailableLots());
	System.out.println("Number of districts: " + settlement.getNumberOfDistricts());
	System.out.println("===================================================");
	System.out.println("Corruption:   " + settlement.getCorruption());
	System.out.println("Criminality:  " + settlement.getCriminality());
	System.out.println("Law:          " + settlement.getLaw());
	System.out.println("Lore:         " + settlement.getLore());
	System.out.println("Productivity: " + settlement.getProductivity());
	System.out.println("Society:      " + settlement.getSociety());
	System.out.println("Defense:      " + settlement.getDefense());
	System.out.println("===================================================");
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

}
