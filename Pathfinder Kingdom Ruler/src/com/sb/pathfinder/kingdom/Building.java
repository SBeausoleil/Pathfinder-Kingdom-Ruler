package com.sb.pathfinder.kingdom;

import java.io.Serializable;

public abstract class Building implements KingdomModifier, SettlementModifier, Serializable {
    private static final long serialVersionUID = 7926242229024942097L;
    
    protected final String NAME;
    public final int USED_LOTS;
    
    public Building(String name, int usedLots) {
	NAME = name;
	USED_LOTS = usedLots;
    }

    /**
     * Returns the name.
     * @return the name
     */
    public String getName() {
        return NAME;
    }

    /**
     * Returns the number of used lots.
     * @return the number of used lots
     */
    public int getUsedLots() {
        return USED_LOTS;
    }
}
