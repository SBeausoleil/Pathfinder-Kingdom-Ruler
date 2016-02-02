package com.sb.pathfinder.kingdom.app;

import com.sb.menu.MenuUtil;
import com.sb.menu.OptionsMenu;
import com.sb.pathfinder.kingdom.Kingdom;
import com.sb.pathfinder.kingdom.Settlement;
import com.sb.util.IntBracket;

public class SettlementAccessor extends OptionsMenu {

    private static final long serialVersionUID = 2262689565707952941L;

    private Kingdom kingdom;

    public SettlementAccessor(Kingdom kingdom) {
	this.kingdom = kingdom;
    }
    
    @Override
    public void open() {
	// List settlements
	int i = 1;
	for (Settlement settlement : kingdom.getSettlements())
	    System.out.println(i++ + ") " + settlement.getName());
	
	// Ask the index of the desired settlement
	int index = MenuUtil.requestInt("Enter the number of the desired settlement: ", new IntBracket(1, i),
		"Error: the value entered is not valid");
	
	// Get the matching settlement
	i = 1;
	Settlement desiredSettlement = null;
	for (Settlement settlement : kingdom.getSettlements())
	    if (i++ == index) {
		desiredSettlement = settlement;
		break;
	    }
	
	// Make a SettlementMenu for this settlement
	SettlementMenu menu = new SettlementMenu(desiredSettlement);
	
	// Open that SettlementMenu
	menu.open();
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
