package com.sb.pathfinder.kingdom.app;

import com.sb.menu.MenuElement;
import com.sb.pathfinder.kingdom.Kingdom;

public class KingdomStateDisplay implements MenuElement, KingdomDependant {
    
    private static final long serialVersionUID = -9209212603894469432L;
    
    private Kingdom currentKingdom;
    
    public KingdomStateDisplay(Kingdom kingdom) {
	this.currentKingdom = kingdom;
    }
    
    @Override
    public void open() {
	display(currentKingdom);
    }

    public static void display(Kingdom kingdom) {
	if (kingdom == null) {
	    System.out.println("No kingdom is set to be seen.");
	    return;
	}
	
	System.out.println("===================================================");
	System.out.println("Name: " + kingdom.getName());
	System.out.println("Alignment: " + kingdom.getLawAlignment().name() + " " + kingdom.getMoralAlignment().name());
	System.out.println("Population: " + kingdom.getPopulation());
	System.out.println("Number of settlements: " + kingdom.getNumberOfSettlements());
	System.out.println("Number of hexes: " + kingdom.getSize());
	System.out.println("Unrest: " + kingdom.getUnrest());
	System.out.println("===================================================");
	System.out.println("Construction Points (CP): " + kingdom.getConstructionPoints());
	System.out.println("Consumption:              " + kingdom.getConsumption());
	System.out.println("===================================================");
	System.out.println("Economy:   " + kingdom.getEconomy());
	System.out.println("Loyalty:   " + kingdom.getLoyalty());
	System.out.println("Stability: " + kingdom.getStability());
	System.out.println("===================================================");
	System.out.println("Glory:  " + kingdom.getGlory());
	System.out.println("Infamy: " + kingdom.getInfamy());
    }

    /**
     * Returns the kingdom.
     * @return the kingdom
     */
    @Override
    public Kingdom getCurrentKingdom() {
        return currentKingdom;
    }

    /**
     * Sets the value of kingdom to that of the parameter.
     * @param kingdom the kingdom to set
     */
    @Override
    public void setCurrentKingdom(Kingdom kingdom) {
        this.currentKingdom = kingdom;
    }

}
