package com.sb.pathfinder.kingdom.app;

import com.sb.menu.OptionsMenu;
import com.sb.menu.Selector;
import com.sb.pathfinder.kingdom.Kingdom;
import com.sb.pathfinder.kingdom.Settlement;

public class SettlementAccessor extends OptionsMenu implements KingdomDependant {

    private static final long serialVersionUID = 2262689565707952941L;

    private Kingdom currentKingdom;

    public SettlementAccessor(Kingdom kingdom) {
	this.currentKingdom = kingdom;
    }

    @Override
    public void open() {
	if (currentKingdom == null) {
	    System.out.println("You need to select a kingdom before accessing a settlement.");
	    return;
	}
	
	Selector<Settlement> settlements = new Selector<>();
	settlements.register(currentKingdom.getSettlements(), Settlement::getName);

	Settlement desiredSettlement = settlements.select();
	if (desiredSettlement != Selector.SELECTION_CANCELLED) {
	    SettlementMenu menu = new SettlementMenu(desiredSettlement);
	    menu.open();
	}
    }

    /**
     * Returns the kingdom.
     * 
     * @return the kingdom
     */
    @Override
    public Kingdom getCurrentKingdom() {
	return currentKingdom;
    }

    /**
     * Sets the value of kingdom to that of the parameter.
     * 
     * @param kingdom
     *            the kingdom to set
     */
    @Override
    public void setCurrentKingdom(Kingdom kingdom) {
	this.currentKingdom = kingdom;
    }
}
