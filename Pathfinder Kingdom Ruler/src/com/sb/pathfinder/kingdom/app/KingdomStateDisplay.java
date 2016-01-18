package com.sb.pathfinder.kingdom.app;

import com.sb.menu.MenuElement;
import com.sb.pathfinder.kingdom.Kingdom;

public class KingdomStateDisplay implements MenuElement {
    
    private static final long serialVersionUID = -9209212603894469432L;
    
    private String name;
    
    private Kingdom kingdom;
    
    public KingdomStateDisplay(String name) {
	this.setName(name);
    }
    
    public KingdomStateDisplay(String name, Kingdom kingdom) {
	this.name = name;
	this.kingdom = kingdom;
    }
    
    @Override
    public void open() {
	display(kingdom);
    }

    public static void display(Kingdom kingdom) {
	System.out.println("===================================================");
	System.out.println("Name: " + kingdom.getName());
	System.out.println("Alignment: " + kingdom.getLawAlignment().name() + " " + kingdom.getMoralAlignment().name());
	System.out.println("Population: " + kingdom.getPopulation());
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

    @Override
    public String getName() {
	return name;
    }

    /**
     * Sets the value of name to that of the parameter.
     * @param name the name to set
     */
    public void setName(String name) {
	this.name = name;
    }

    /**
     * Returns the kingdom.
     * @return the kingdom
     */
    public Kingdom getKingdom() {
        return kingdom;
    }

    /**
     * Sets the value of kingdom to that of the parameter.
     * @param kingdom the kingdom to set
     */
    public void setKingdom(Kingdom kingdom) {
        this.kingdom = kingdom;
    }

}
